package com.example.api

import java.util.ServiceLoader

interface Spi {

    fun createApi(): Api

    companion object {
        @JvmStatic
        val instance: Spi by lazy {
            ServiceLoader.load(Spi::class.java).firstOrNull() ?: error("Missing Api provider")
        }
    }
}

interface Api {
    fun querySomething(): String
}
