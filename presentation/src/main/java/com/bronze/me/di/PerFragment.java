package com.bronze.me.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义的范围注解，作用是允许对象被记录在正确的组件中，当然这些对象的生命周期应该遵循Fragment的生命周期
 */
@Scope
@Retention(RUNTIME)
public @interface PerFragment {
}
