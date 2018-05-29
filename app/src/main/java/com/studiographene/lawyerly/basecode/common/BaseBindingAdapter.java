package com.studiographene.lawyerly.basecode.common;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.studiographene.lawyerly.basecode.utilities.ListSeperatorViewHolder;
import com.studiographene.lawyerly.databinding.ListSeperatorBinding;

import java.util.List;

import static android.content.ContentValues.TAG;

public abstract class BaseBindingAdapter<I extends ViewDataBinding, J> extends BaseDiffAdapter<J> implements BaseDiffCallback.Listener<J> {


    public interface Listener<J>{
        public void onItemClick(View view, J item, int clickType);
    }

    protected   Listener listener;

    protected final LayoutInflater mInflater;

    public BaseBindingAdapter(Context context , List<J> list , Listener listener){
        mInflater = LayoutInflater.from(context);
        this.list = list;
        this.listener = listener;
        checkItems();


    }


    @Override
    public void onViewDetachedFromWindow(final RecyclerView.ViewHolder holder)
    {
        ((BaseViewHolder)holder).clearAnimation();
    }


    @Override
    protected DiffUtil.Callback getCallback(List actors) {
        return new BaseDiffCallback<J>(this.list,actors,this);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ListSeperatorBinding binding = ListSeperatorBinding.inflate(mInflater, parent, false);
        return new ListSeperatorViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: "+this.itemsPendingRemovalId.contains(this.getPrimaryId(list.get(position))));

        if(this.itemsPendingRemovalId.contains(this.getPrimaryId(list.get(position))) ){
            ((BaseViewHolder)holder).bind(list.get(position),1);
        }else {
            ((BaseViewHolder)holder).bind(list.get(position),0);
        }

    }



    @Override
    public boolean areItemAreSame(J oldItem, J newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(J oldItem, J newItem) {
        return true;
    }

    @Override
    protected String getPrimaryId(J item) {
        return null;
    }

    public static abstract class BaseViewHolder<I extends ViewDataBinding , J> extends RecyclerView.ViewHolder {


        private J mCurrentItem;

        protected I binding;
        protected Listener listener;
        public BaseViewHolder(I binding , Listener l ) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = l;

        }


        public void clearAnimation()
        {
            binding.getRoot().clearAnimation();
        }


        public abstract void bind(J chat , int action);

    }


}
