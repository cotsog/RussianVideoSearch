package com.eazyigz.RussiaMediaSearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.eazyigz.RussiaMediaSearch.dagger.CheeseModule;
import com.eazyigz.RussiaMediaSearch.dagger.CheesesComponent;
import com.eazyigz.RussiaMediaSearch.dagger.DaggerCheesesComponent;
import com.eazyigz.RussiaMediaSearch.model.Cheese;
import com.eazyigz.RussiaMediaSearch.model.CheesesAdapter;
import com.eazyigz.RussiaMediaSearch.presenter.CheesesPresenter;
import com.eazyigz.RussiaMediaSearch.view.CheesesView;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import java.util.List;

import butterknife.InjectView;

/**
 * Created by Igor on 6/14/2015.
 */
public class CheesesFragment extends MvpFragment<CheesesView, CheesesPresenter> implements CheesesView {
    @InjectView(R.id.cheeseRecyclerview) RecyclerView recyclerView;
    @InjectView(R.id.empty) TextView empty;

    private CheesesAdapter mAdapter;
    private CheesesComponent mCheesesComponent;

    @Override
    protected void injectDependencies() {
        mCheesesComponent = DaggerCheesesComponent.builder().cheeseModule(new CheeseModule()).build();
        mCheesesComponent.inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_cheese_list;
    }

    @Override
    public CheesesPresenter createPresenter() {
        return mCheesesComponent.cheesesPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

        // Setup recycler view
        mAdapter = new CheesesAdapter(empty);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showContent() {
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
    }

    @Override
    public void setData(List<Cheese> data) {
        mAdapter.addItems(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadCheeses();
    }
}
