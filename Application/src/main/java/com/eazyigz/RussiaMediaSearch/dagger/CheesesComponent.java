package com.eazyigz.RussiaMediaSearch.dagger;

import com.eazyigz.RussiaMediaSearch.presenter.CheesesPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Igor on 6/29/2015.
 */
@Singleton
@Component(modules = CheeseModule.class)
public interface CheesesComponent {
    void inject(CheesesPresenter presenter);

}
