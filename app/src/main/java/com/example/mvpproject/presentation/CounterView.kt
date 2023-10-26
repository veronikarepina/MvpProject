package com.example.mvpproject.presentation

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType


interface CounterView: MvpView {

    @StateStrategyType(AddToEndStrategy::class)
    fun showCount(count: Int)
}