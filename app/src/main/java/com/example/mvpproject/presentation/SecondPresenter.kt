package com.example.mvpproject.presentation

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SecondPresenter: MvpPresenter<CounterView>() {

    private var count = 0

    fun onPlusClick() {
        count++
        viewState.showCount(count)
    }

    fun onMinusClick() {
        if (count > 0) {
            count--
            viewState.showCount(count)
        }
    }
}