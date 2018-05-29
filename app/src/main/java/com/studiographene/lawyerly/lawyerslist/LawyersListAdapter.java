package com.studiographene.lawyerly.lawyerslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;


import com.studiographene.lawyerly.basecode.common.BaseBindingAdapter;
import com.studiographene.lawyerly.databinding.ListItemLawyerBinding;

import java.util.List;


public class LawyersListAdapter extends BaseBindingAdapter<ListItemLawyerBinding, Lawyer> {

    private final String TAG = this.getClass().getSimpleName();
    int mode = -1;

    public LawyersListAdapter(Context context, List<Lawyer> list, BaseBindingAdapter.Listener listener) {
        super(context, list, listener);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemLawyerBinding binding = ListItemLawyerBinding.inflate(mInflater, parent, false);
        return new LawyersListViewHolder(binding, listener);
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    protected String getPrimaryId(Lawyer item) {
        return null;
    }

    public class LawyersListViewHolder extends BaseViewHolder<ListItemLawyerBinding, Lawyer> {

        public LawyersListViewHolder(ListItemLawyerBinding binding, Listener l) {
            super(binding, l);
        }

        @Override
        public void bind(Lawyer model, int mode) {

            binding.setModel(model);
            binding.setListener(listener);

            Log.d(TAG, "bind: " + mode);

            if (getMode() != -1) {
                mode = getMode();
            }
            binding.setMode(mode);


        }
    }


}