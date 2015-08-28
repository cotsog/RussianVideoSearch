package com.eazyigz.RussiaMediaSearch.dagger;

import com.eazyigz.RussiaMediaSearch.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A {@link Component} for {@link com.eazyigz.RussiaMediaSearch.dagger.ApiModule}.
 */
@Singleton
@Component(modules = ApiModule.class)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);

}
