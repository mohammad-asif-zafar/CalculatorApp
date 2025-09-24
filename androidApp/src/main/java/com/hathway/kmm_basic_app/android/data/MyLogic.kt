package com.hathway.kmm_basic_app.android.data

class MyLogic {

    fun addNumbers(par1: Int, par2: Int): Int {
        return add(par1, par2)
    }

    private fun add(par1: Int, par2: Int): Int {
        return par1 + par2
    }

    fun difference(par1: Int, par2: Int): Int {
        return sub(par1, par2)
    }

    private fun sub(par1: Int, par2: Int): Int {
        return if (par1 > par2) return par1 - par2
        else par2 - par1
    }
}