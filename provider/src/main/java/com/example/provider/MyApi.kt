package com.example.provider

import com.example.api.Api
import com.example.api.Spi

class MySpi : Spi {

    @Volatile
    private var myApi: Api? = null

    /**
     * Problem: the dex byte code of this method when obfuscated:
     * ```
     * .method public a()Lz/a;
     *     .registers 2
     *
     *     .line 1
     *     const/4 v0, 0x0
     *
     *     .line 2
     *     return-object v0
     * .end method
     * ```
     */
    override fun createApi(): Api {
        return myApi ?: synchronized(this) {
            myApi ?: MyApi().also { myApi = it }
        }
    }
}

class MyApi : Api {
    override fun querySomething(): String {
        return "Hello from MyApi"
    }
}