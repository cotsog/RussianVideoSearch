package com.eazyigz.RussiaMediaSearch.dagger;

import com.hannesdorfmann.mosby.mvp.rx.scheduler.AndroidSchedulerTransformer;
import com.hannesdorfmann.mosby.mvp.rx.scheduler.SchedulerTransformer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Igor on 6/29/2015.
 */
@Module()
public class CheeseModule {
    @Provides
    @Singleton
    SchedulerTransformer providesSchedulerTransfomer() {
        return new AndroidSchedulerTransformer();
    }

}
