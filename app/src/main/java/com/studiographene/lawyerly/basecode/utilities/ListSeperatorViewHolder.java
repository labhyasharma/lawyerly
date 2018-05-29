package com.studiographene.lawyerly.basecode.utilities;


import com.studiographene.lawyerly.basecode.common.BaseBindingAdapter;
import com.studiographene.lawyerly.databinding.ListSeperatorBinding;

/**
 * Created by ashu on 11/05/17.
 */

public class ListSeperatorViewHolder<J extends LineSeperator> extends BaseBindingAdapter.BaseViewHolder<ListSeperatorBinding, J > {



    BaseBindingAdapter.Listener listener;


    public ListSeperatorViewHolder(ListSeperatorBinding binding, BaseBindingAdapter.Listener l) {
        super(binding, l);
    }


    @Override
    public void bind(J model, int mode) {
       // binding.setVariable(BR.model,model);
    }
}
