package com.vincent.mvpcustomadvertisement.ui.base;

import com.androidnetworking.error.ANError;

/**
 * Created by IDEA on 2019/3/22
 * User: Vincent
 * Time：14:07
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    /**
     * description:  handle error
     *
     * @param error
     */
    void handleApiError(ANError error);

}
