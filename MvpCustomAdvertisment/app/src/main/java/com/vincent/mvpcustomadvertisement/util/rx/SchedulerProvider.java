package com.vincent.mvpcustomadvertisement.util.rx;

import io.reactivex.Scheduler;

/**
 * Created by IDEA on 2019/3/22
 * User: Vincent
 * Time：12:48
 */
public interface SchedulerProvider {
    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
