package com.clairmail.myapplication.View.model.Network


import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.clairmail.myapplication.View.View.MainActivity
import com.clairmail.myapplication.View.model.dataclass.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlickerApiResponse {

    private val setRetrofitService = RetrofitClient().getRetrofitClientInstance()
    private val retrofitCall = setRetrofitService.getFlickerResponse()
    private  var flickerResponse: MutableLiveData<List<Photo>> = MutableLiveData()

    //elvis operator stops app from crashing if null
    fun getApirResponse(): LiveData<List<Photo>> { return flickerResponse}

     fun setFlickerResponseData(activity: MainActivity) {

        retrofitCall.enqueue(object : Callback<List<Photo>>{

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {

                Toast.makeText(activity, "Failed ",Toast.LENGTH_SHORT).show()

                Log.d("James", "Error: "+ t.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<Photo>>, response: Response<List<Photo>>) {

                Toast.makeText(activity, "success", Toast.LENGTH_SHORT).show()

                if (response.isSuccessful && response.body() != null) {
                    Log.d("james", response.body().toString())
                    flickerResponse?.postValue(response.body())
                }

            }

        })
    }
}