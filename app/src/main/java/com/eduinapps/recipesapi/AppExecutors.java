package com.eduinapps.recipesapi;

import android.os.Handler;
import android.os.Looper;


import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private static com.eduinapps.recipesapi.AppExecutors instance;

    public static com.eduinapps.recipesapi.AppExecutors getInstance() {
        if (instance == null) {
            instance = new com.eduinapps.recipesapi.AppExecutors();
        }
        return instance;
    }

    private final Executor mDiskIO = Executors.newSingleThreadExecutor();

    private final Executor mMainThreadExecutor = new MainThreadExecutor();

    public Executor diskIO() {
        return mDiskIO;
    }

    public Executor mainThread() {
        return mMainThreadExecutor;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable runnable) {
            mainThreadHandler.post(runnable);
        }
    }
}
