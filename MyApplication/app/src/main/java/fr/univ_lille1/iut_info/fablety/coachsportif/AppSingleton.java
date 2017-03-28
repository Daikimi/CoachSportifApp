package fr.univ_lille1.iut_info.fablety.coachsportif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by fablety on 27/03/17.
 */



public class AppSingleton {

    private static AppSingleton mAppSingletonInstance;
    private static User user;

    private AppSingleton(User user) {
        this.user=user;
    }

    public static synchronized AppSingleton getInstance(User user) {
        if (mAppSingletonInstance == null) {
            mAppSingletonInstance = new AppSingleton(user);
        }
        return mAppSingletonInstance;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        AppSingleton.user = user;
    }
}