package com.eazyigz.RussiaMediaSearch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eazyigz.RussiaMediaSearch.databinding.FragmentCheeseListBinding;
import com.eazyigz.RussiaMediaSearch.model.Cheese;
import com.eazyigz.RussiaMediaSearch.model.Cheeses;
import com.eazyigz.RussiaMediaSearch.model.CheesesAdapter;
import com.eazyigz.RussiaMediaSearch.presenter.CheesesPresenter;
import com.eazyigz.RussiaMediaSearch.view.CheesesView;
import com.squareup.leakcanary.RefWatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        mAdapter = new CheesesAdapter(
                getActivity(), getRandomSublist(Cheeses.sCheeseStrings, 30), binding.empty);
        binding.cheeseRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.cheeseRecyclerview.setHasFixedSize(true);
        binding.cheeseRecyclerview.setAdapter(mAdapter);
    }

    @NonNull
    private List<Cheese> getRandomSublist(@NonNull String[] array, int amount) {
        List<Cheese> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount) {
            Cheese cheese = new Cheese();
            cheese.setName(array[random.nextInt(array.length)]);
            list.add(cheese);
        }
        return list;
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApp.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }

}
