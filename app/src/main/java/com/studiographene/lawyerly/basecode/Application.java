package com.studiographene.lawyerly.basecode;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDexApplication;

import com.studiographene.lawyerly.basecode.di.components.DaggerMyComponent;
import com.studiographene.lawyerly.basecode.di.components.MyComponent;
import com.studiographene.lawyerly.basecode.di.modules.MyModule;


/**
 * Created by ashu on 16-11-2016.
 */

public class Application extends MultiDexApplication {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "SdL6Mt7haFfjgy4bNes2aOe9G";
    private static final String TWITTER_SECRET = "yG1qJNys9XOLTd42MUC658PVRrD898qf2ab1d8vWM3eqdBYpfk";


    public final static boolean IS_DEBUGGING_ON = false;
    public final static String packName = "com.mswipetech.wisepos.sdk";
    public static final String SERVER_NAME = "Mswipe";
    public static final int PhoneNoLength = 10;
    public static final String Currency_Code = "INR.";
    public static final String smsCode = "+91";
    public static final String mTipRequired = "false";
    public static SharedPreferences appSharedPreferences;
    public static final boolean DEVELOPER_MODE = false;

    private static Application instance;

    private MyComponent netComponent;




    @Override
    public void onCreate() {

//        if (DEVELOPER_MODE) {
//            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                    .detectDiskReads()
//                    .detectDiskWrites()
//                    .detectNetwork()   // or .detectAll() for all detectable problems
//                    .penaltyLog()
//                    .build());
//            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                    .detectLeakedSqlLiteObjects()
//                    .detectLeakedClosableObjects()
//                    .penaltyLog()
//                    .penaltyDeath()
//                    .build());
//        }

//        if (BuildConfig.DEBUG) {
//            AndroidDevMetrics.initWith(this);
//        }

        super.onCreate();

        instance = this;
        netComponent = DaggerMyComponent.builder()
                .myModule(new MyModule(this))
                .build();



//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);


    }
    public static Context _getContext(){
        return instance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public MyComponent getNetComponent(){return  netComponent;}


}
