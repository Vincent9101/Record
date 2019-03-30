package com.vincent.mvpcustomadvertisement.util.rx;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by IDEA on 2019/3/25
 * User: Vincent
 * Time：11:15
 */
public class RxTimer {

    public static void interval(Long period, TimeUnit timeUnit,
                                final String logTag,
                                Long initialDelay,
                                final Action action,
                                final CompositeDisposable compositeDisposable) {
        Disposable disposable = Observable.interval(initialDelay, period, timeUnit)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(final Long aLong) throws Exception {
                        //TODO:设置只有晚上12点才进行更新
                        action.action(aLong);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(logTag, throwable.getMessage());
                    }
                });
        compositeDisposable.add(disposable);
    }

    public static void interval(Long period, TimeUnit timeUnit,
                                final String logTag,
                                final Action action,
                                final CompositeDisposable compositeDisposable) {
        interval(period, timeUnit, logTag, 0L, action, compositeDisposable);
    }


    public static interface Action {
        public void action(Long timeNumber);
    }
}
