package com.eazyigz.RussiaMediaSearch;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Igor on 7/1/2015.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
