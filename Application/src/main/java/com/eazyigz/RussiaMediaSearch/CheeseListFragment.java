package com.eazyigz.RussiaMediaSearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eazyigz.RussiaMediaSearch.model.CheesesAdapter;
import com.eazyigz.RussiaMediaSearch.presenter.CheesesPresenter;
import com.eazyigz.RussiaMediaSearch.view.CheesesView;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import butterknife.InjectView;

/**
 * Created by Igor on 6/14/2015.
 */
public class CheeseListFragment extends MvpFragment<CheesesView, CheesesPresenter>
        implements CheesesView, SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.layout.fragment_cheese_list) RecyclerView recyclerView;
    @InjectView(R.id.empty) TextView empty;

    CheesesAdapter mAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_cheese_list;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView.setHasFixedSize(true);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    @Override
    public CheesesPresenter createPresenter() {
        return new CheesesPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

        // Setup recycler view
        mAdapter = new CheesesAdapter(empty);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        presenter.loadCheeses(false);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {

    }

}
