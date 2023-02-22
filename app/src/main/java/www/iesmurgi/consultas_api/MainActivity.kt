package www.iesmurgi.consultas_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var mAPIService: ApiService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eliminar()
    }

    fun añadir() {
        mAPIService = utiles.apiService
        val inmueble = Inmueble(   "playita",
              550.4,
              "pisito en la playa",
              200,
              120,
              "Roquetas de Mar",
              "playa",
              "2022-07-05",
              3,
              2,
              62
        )

        mAPIService!!.addUser(inmueble).enqueue(object : Callback<Inmueble>{
            override fun onResponse(call: Call<Inmueble>, response: Response<Inmueble>) {
                Log.i("", "post submitted to API." + response.body()!!)

                if (response.isSuccessful()) {
                    Log.i("", "post registration to API" + response.body()!!.toString())
                    Log.i("", "post status to API" + response.body()!!.titulo)
                    Log.i("", "post msg to API" + response.body()!!.idInmueble.toString())
                }
            }

            override fun onFailure(call: Call<Inmueble>, t: Throwable) {
                println("jajajajajajajajjajajajajajajajaajjaja")
                call.cancel()
            }
        })
    }

    fun eliminar(){
        mAPIService = utiles.apiService
        mAPIService!!.deleteInmueble(62).enqueue(object : Callback<Inmueble>{
            override fun onResponse(call: Call<Inmueble>, response: Response<Inmueble>) {
                Log.i("", "Inmueble Deleted")
                if (response.isSuccessful()) {
                    Log.i("", "delete registration in API")
                }
            }

            override fun onFailure(call: Call<Inmueble>, t: Throwable) {
                println("jajajajajajajajajajajaja")
                call.cancel()
            }
        })

    }
}