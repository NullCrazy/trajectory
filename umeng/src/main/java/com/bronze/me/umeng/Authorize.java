package com.bronze.me.umeng;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by lxg on 2016/4/10.
 */
public interface Authorize {
    void verify(Activity activity);

    void authorizeCallBack(int requestCode, int resultCode, Intent data);
}
