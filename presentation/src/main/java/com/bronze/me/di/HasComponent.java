package com.bronze.me.di;

/**
 * 为依赖注入组件注入提供注入接口。
 */
public interface HasComponent<C> {
    C getComponent();
}
