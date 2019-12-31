package com.clairmail.myapplication.View.model.Network

import com.clairmail.myapplication.View.model.UrlConstants.APIPATH
import com.clairmail.myapplication.View.model.dataclass.Photo
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET(APIPATH)

    fun getFlickerResponse(): Call<List<Photo>>


}