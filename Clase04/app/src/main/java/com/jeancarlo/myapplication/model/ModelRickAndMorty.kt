package com.jeancarlo.myapplication.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RickAndMorthyRspn (
    @SerialName("results" ) var results : ArrayList<Results> = arrayListOf()
)

@Serializable
data class Results (

    @SerialName("id"       ) var id       : Int?              = null,
    @SerialName("name"     ) var name     : String?           = null,
    @SerialName("status"   ) var status   : String?           = null,
    @SerialName("image"    ) var image    : String?           = null

)