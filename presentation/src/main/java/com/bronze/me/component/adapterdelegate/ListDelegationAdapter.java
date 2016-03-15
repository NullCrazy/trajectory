package com.bronze.me.component.adapterdelegate;

import java.util.List;

/**
 * 针对集合数据源做的简单封装
 * */
public class ListDelegationAdapter<T extends List<?>> extends AbsDelegationAdapter<T> {

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

}
