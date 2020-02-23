package com.data.api

import com.google.gson.annotations.SerializedName

data class Record<T>(
    @SerializedName("records", alternate = ["record"]) val records: T)