package com.example.technicaltest.utils

import com.example.technicaltest.presenter.utlis.NetworkSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class TestNetworkSchedulers : NetworkSchedulers {
    override val io: Scheduler
        get() = Schedulers.trampoline()
    override val main: Scheduler
        get() = Schedulers.trampoline()
}