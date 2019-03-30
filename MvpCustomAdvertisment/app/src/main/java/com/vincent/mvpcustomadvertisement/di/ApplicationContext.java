package com.vincent.mvpcustomadvertisement.di;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：20:37
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {
}
