package com.bronze.me.component.adapterdelegate;

import android.support.annotation.NonNull;

/**
 *  借于null-object模式，防止ItemView为null
 */
public abstract class AbsFallbackAdapterDelegate<T> extends AbsAdapterDelegate<T> {

    public AbsFallbackAdapterDelegate() {
        super(Integer.MAX_VALUE - 1);
    }

    @Override
    public boolean isForViewType(@NonNull Object items, int position) {
        return true;
    }

}
