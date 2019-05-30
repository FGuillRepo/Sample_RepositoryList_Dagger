package com.guilla.lab.test.helpers

import org.mockito.InOrder

import com.guilla.lab.mvp.views.BaseView

import org.mockito.Mockito.inOrder
import org.mockito.Mockito.timeout
import org.mockito.Mockito.verify

/**
 * Created by dino on 30/06/14.
 */
object TestHelper {

    val CALLBACK_TIMEOUT_MS = 1000

    fun verifyShowHideProgress(baseView: BaseView) {
        verify(baseView, timeout(CALLBACK_TIMEOUT_MS.toLong())).hideProgress()
        val inOrder = inOrder(baseView)
        inOrder.verify(baseView).showProgress()
        inOrder.verify(baseView).hideProgress()
    }

    fun <T> verifyAsync(mock: T): T {
        return verifyAsync(mock, CALLBACK_TIMEOUT_MS.toLong())
    }

    fun <T> verifyAsync(mock: T, timeoutMillis: Long): T {
        return verify(mock, timeout(timeoutMillis))
    }
}
