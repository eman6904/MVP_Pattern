package com.example.architecturepatterns.presenter

import com.example.architecturepatterns.model.Data

class IntermediateClass(private val view: View) : IntermediateInterface {
    override fun calculate(first: Int, second: Int) {
        val sum = first + second
        val sub = first - second
        val data = Data(sum, sub)
        view.getInfo(data)
    }

    interface View {
        fun getInfo(data: Data)
    }
}