package com.clairmail.myapplication.View.model.Network

import androidx.lifecycle.LiveData
import com.clairmail.myapplication.View.model.dataclass.Photo

object FlickerRepository {


    fun getFlickerData(): LiveData<List<Photo>>? { return setFlickerData() }

     private fun setFlickerData(): LiveData<List<Photo>>? {


         val flickerResponse = FlickerApiResponse()

         return flickerResponse.getApirResponse()


     }
}