package com.eazyigz.RussiaMediaSearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eazyigz.RussiaMediaSearch.databinding.FragmentCheeseListBinding;
import com.eazyigz.RussiaMediaSearch.model.Cheese;
import com.eazyigz.RussiaMediaSearch.model.CheesesAdapter;
import com.eazyigz.RussiaMediaSearch.presenter.CheesesPresenter;
import com.eazyigz.RussiaMediaSearch.view.CheesesView;

import java.util.List;

/**
 * Created by Igor on 6/14/2015.
 */
public class CheesesFragment extends Fragment implements CheesesView<Cheese> {

    private CheesesAdapter mAdapter;
    private CheesesPresenter mCheesesPresenter;
    private FragmentCheeseListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCheesesPresenter = new CheesesPresenter(this);
        mCheesesPresenter.loadCheeses();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cheese_list, container, false);
        binding = FragmentCheeseListBinding.bind(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        // Setup recycler view
        mAdapter = new CheesesAdapter();
        binding.cheeseRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.cheeseRecyclerview.setHasFixedSize(true);
        binding.cheeseRecyclerview.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mAdapter.getItemCount() == 0) {
            binding.empty.setVisibility(View.VISIBLE);
        } else {
            binding.empty.setVisibility(View.GONE);
        }
    }

    @Override
    public void addItem(final Cheese cheese) {
        mAdapter.addItem(cheese);
    }

    @Override
    public void addItems(final List<Cheese> cheeses) {
        mAdapter.addItems(cheeses);
    }

    @Override
    public void clearItems() {
        mAdapter.clearItems();
    }

    @Override
    public void showError() {
        binding.errorView.setVisibility(View.VISIBLE);
    }

}
