package com.clairmail.myapplication.View.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.clairmail.myapplication.View.model.Network.FlickerRepository
import com.clairmail.myapplication.View.model.dataclass.Photo

class MainActivityViewModel: ViewModel() {

    private  var setFlickerLiveData: LiveData<List<Photo>>? = null

     fun getRespositoryData(): LiveData<List<Photo>>? {

        setFlickerLiveData = FlickerRepository.getFlickerData()

         return setFlickerLiveData
    }
}