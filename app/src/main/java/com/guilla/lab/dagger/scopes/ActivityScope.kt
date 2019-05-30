package com.guilla.lab.dagger.scopes

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Scope

/**
 * @author Koc
 * ivan.kocijan@infinum.hr
 * @since 21/11/15
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope
