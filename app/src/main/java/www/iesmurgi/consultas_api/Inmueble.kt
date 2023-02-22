package www.iesmurgi.consultas_api

import com.google.gson.annotations.SerializedName

data class Inmueble(
    @SerializedName("titulo") val titulo:String,
    @SerializedName("precio") val precio: Double,
    @SerializedName("descripcion") val descripcion:String,
    @SerializedName("metrosConstruidos") val metrosConstruidos: Int,
    @SerializedName("metrosUtiles") val metrosUtiles: Int,
    @SerializedName("ubicacion") val ubicacion: String,
    @SerializedName("zona") val zona:String,
    @SerializedName("fechaPublicacion") val fechaPublicacion:String,
    @SerializedName("habitaciones") val habitaciones:Int,
    @SerializedName("bannos") val bannos:Int,
    @SerializedName("idInmueble") val idInmueble: Int?
)
