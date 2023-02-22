package www.iesmurgi.consultas_api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("inmuebles")
    fun addUser(@Body inmueble: Inmueble): Call<Inmueble>

    @DELETE("inmuebles/{idInmueble}")
    fun deleteInmueble(@Path("idInmueble") id: Int): Call<Inmueble>
}

object utiles{
    val BASE_URL="http://10.10.30.91:8080/api/"

    val apiService:ApiService
        get() = RetrofitClient.getClient(BASE_URL)!!.create(ApiService::class.java)
}