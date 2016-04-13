package com.bronze.me.absbase;

public interface MvpPresenter<V extends MvpView> {

    void attachView(V view);

    void detachView(boolean retainInstance);
}
