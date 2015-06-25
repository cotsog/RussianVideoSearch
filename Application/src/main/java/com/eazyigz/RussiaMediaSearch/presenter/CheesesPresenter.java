package com.eazyigz.RussiaMediaSearch.presenter;

import com.eazyigz.RussiaMediaSearch.view.Cheese;
import com.eazyigz.RussiaMediaSearch.view.CheesesView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;


/**
 * Created by Igor on 6/17/2015.
 */
public class CheesesPresenter extends MvpBasePresenter<CheesesView> {
    private static final String TAG = CheesesPresenter.class.getCanonicalName();

    @Inject
    public CheesesPresenter() {
    }

    public void loadCheeses(final boolean pullToRefresh) {
        long userId;
        int limit = 100;
        int offset = 0;

        Observable<List<Cheese>> observable;
    }

}