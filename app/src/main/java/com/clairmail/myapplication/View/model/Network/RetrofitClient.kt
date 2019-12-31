package com.clairmail.myapplication.View.model.Network

import com.clairmail.myapplication.View.model.UrlConstants.APIURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    fun getRetrofitClientInstance(): RetrofitService{

        return retrofitClient().create(RetrofitService::class.java)
    }

    private fun retrofitClient(): Retrofit {

        return Retrofit.Builder().baseUrl(APIURL).addConverterFactory(GsonConverterFactory.create()).build()
    }


}