package com.eazyigz.RussiaMediaSearch.presenter;

import com.eazyigz.RussiaMediaSearch.model.Cheese;
import com.eazyigz.RussiaMediaSearch.view.CheesesView;
import com.hannesdorfmann.mosby.mvp.rx.lce.MvpLceRxPresenter;
import com.hannesdorfmann.mosby.mvp.rx.scheduler.SchedulerTransformer;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;


/**
 * Created by Igor on 6/17/2015.
 */
public class CheesesPresenter extends MvpLceRxPresenter<CheesesView, List<Cheese>> {
    SchedulerTransformer transformer;

    @Inject
    public CheesesPresenter(SchedulerTransformer transformer) {
        this.transformer = transformer;
    }

    public void loadCheeses() {
        Observable<List<Cheese>> observable = null; //=
//                LocationService.getInstance(DrNowApp.getInstance()).getLastKnownLocationObservable()
//                        .flatMap(location -> providersApi
//                                        .getProvidersNear(location.getLatitude(),location.getLongitude())
//                                        .getProvidersNear(29.763638,-95.461874)
//                                        .doOnNext(list -> Collections.sort(list, new PersonComparator()))
//                        );
        subscribe(observable, false);
    }

}