package testagp87

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.api.Spi

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testApi()
    }

    private fun testApi() {
        val api = Spi.instance.createApi()
        Log.d("MainActivity", "api: $api")
        api.querySomething() // The release build will crash here due to a NPE
    }
}
