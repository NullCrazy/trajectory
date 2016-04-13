package com.bronze.me.absbase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * All fragment must extend this fragment.
 */
public abstract class MvpBaseFragment<P extends MvpPresenter> extends Fragment implements MvpView {

    protected P presenter;

    protected abstract P createPresenter();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
            if (presenter == null) {
                throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
            }
        }
        presenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView(getRetainInstance());
    }
}
