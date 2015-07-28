package com.eazyigz.RussiaMediaSearch.model;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eazyigz.RussiaMediaSearch.R;
import com.eazyigz.RussiaMediaSearch.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 6/22/2015.
 */
public class CheesesAdapter extends RecyclerView.Adapter<CheesesAdapter.ViewHolder> {
    private final TypedValue mTypedValue = new TypedValue();
    private final View empty;
    @NonNull private List<Cheese> mCheeses = new ArrayList<>();
    private int mBackground;


    public CheesesAdapter(@NonNull Context context, List<Cheese> items, final View empty) {
        this.empty = empty;
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        addItems(items);
    }

    @NonNull
    @Override
    public CheesesAdapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final ListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false);
        View view = binding.getRoot();
        view.setBackgroundResource(mBackground);

        return new ViewHolder(view, binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Cheese cheese = this.mCheeses.get(position);
        holder.bind(cheese);
    }

    @Override
    public int getItemCount() {
        return mCheeses.size();
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }

    private void dataSetChanged() {
        this.notifyDataSetChanged();
        this.empty.setVisibility(this.getItemCount() == 0 ? View.VISIBLE : View.GONE);
    }

    @UiThread
    public void addItem(final Cheese cheese) {
        this.mCheeses.add(cheese);
        this.dataSetChanged();
    }

    @UiThread
    public void addItems(@NonNull final List<Cheese> cheeses) {
        this.mCheeses.addAll(cheeses);
        this.dataSetChanged();
    }

    @UiThread
    public void clearItems() {
        this.mCheeses.clear();
        this.dataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding binding;

        public ViewHolder(@NonNull final View view, final ListItemBinding binding) {
            super(view);
            this.binding = binding;
        }

        @UiThread
        public void bind(final Cheese cheese) {
            this.binding.setCheese(cheese);
        }
    }
}