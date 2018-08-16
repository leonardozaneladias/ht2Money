package ht2ml.com.br.ht2money;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration rc = new RealmConfiguration.Builder().name("ht2money.realm").build();
        Realm.deleteRealm(rc);
        Realm.setDefaultConfiguration(rc);
    }
}
