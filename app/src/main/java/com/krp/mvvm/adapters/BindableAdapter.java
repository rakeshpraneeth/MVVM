package com.krp.mvvm.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.krp.mvvm.BR;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * Class used to build the adapters for RecyclerView.
 * Extend the CustomAdapter class with Bindable adapter and pass ViewModel which extends RowViewModel that contains data.
 *
 */

public abstract class BindableAdapter extends RecyclerView.Adapter<BindableAdapter.BindingViewHolder> {

    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new BindingViewHolder(binding);
    }

    public void onBindViewHolder(BindingViewHolder holder, int position){
        Object obj = getObjForPosition(position);
        holder.bind(obj);
    }

    @Override
    public int getItemViewType(int position){
        return  getLayoutIdForPosition(position);
    }

    protected abstract Object getObjForPosition(int position);

    protected abstract int getLayoutIdForPosition(int position);

    public static class BindingViewHolder extends RecyclerView.ViewHolder{
        private final ViewDataBinding binding;

        public BindingViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object item){
            binding.setVariable(BR.item, item);
            binding.executePendingBindings();
        }
    }
}