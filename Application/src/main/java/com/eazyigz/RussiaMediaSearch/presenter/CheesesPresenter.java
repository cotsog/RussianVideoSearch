package com.eazyigz.RussiaMediaSearch.presenter;

import com.eazyigz.RussiaMediaSearch.model.Cheese;
import com.eazyigz.RussiaMediaSearch.view.CheesesView;

import java.util.List;

import rx.Observable;
import rx.Observer;


/**
 * Created by Igor on 6/17/2015.
 */
public class CheesesPresenter implements Observer<List<Cheese>> {
    private final CheesesView<Cheese> view;

    public CheesesPresenter(final CheesesView cheesesView) {
        this.view = cheesesView;
    }

    public void loadCheeses() {
        Observable<List<Cheese>> observable = null; //=
//                LocationService.getInstance(DrNowApp.getInstance()).getLastKnownLocationObservable()
//                        .flatMap(location -> providersApi
//                                        .getProvidersNear(location.getLatitude(),location.getLongitude())
//                                        .getProvidersNear(29.763638,-95.461874)
//                                        .doOnNext(list -> Collections.sort(list, new PersonComparator()))
//                        );
//        observable.subscribe();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        view.showError();
    }

    @Override
    public void onNext(List<Cheese> cheeses) {
        this.view.clearItems();
        this.view.addItems(cheeses);
    }

}