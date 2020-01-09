package com.clairmail.myapplication.View.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clairmail.myapplication.R
import com.clairmail.myapplication.View.ViewModel.MainActivityViewModel
import com.clairmail.myapplication.View.model.Adapters.GridlayoutAdapter
import com.clairmail.myapplication.View.model.OnItemClickListener
import com.clairmail.myapplication.View.model.Network.FlickerApiResponse
import com.clairmail.myapplication.View.model.dataclass.Photo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var  gridLayoutAdapter: GridlayoutAdapter

    private lateinit var viewModel: MainActivityViewModel
    private val flickerApiResponse = FlickerApiResponse()
    private var holdsPhotoList = ArrayList<Photo>() // to hold the list of photo from the api response


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        gridLayoutAdapter = GridlayoutAdapter(this) // sets the adapter using the activity which implements a listener

        setGridManager()
        watchData() //setting observer

        flickerApiResponse.setFlickerResponseData(this)//making api call

    }

    private fun setGridManager(){

       recyclerView.adapter = gridLayoutAdapter

        recyclerView.adapter = gridLayoutAdapter
        recyclerView.layoutManager = GridLayoutManager(
            this, 2)
        //spanCount is number of rows or columns depending on the direction of the layout



    }

    private fun watchData(){
        //Live data here helps makes an async call
        flickerApiResponse.getApirResponse()?.observe(this,
            Observer { photos ->  holdsPhotoList.addAll(photos) // Arguments lambda
                gridLayoutAdapter.setListOfPhotos(photos) //statements for lambda
        })
    }

    private fun initActivity(position: Int){

        val photo = Photo()
        val photoBundle = Bundle()
        val intent = Intent(this, DetailActivity::class.java)


        intent.putExtra(Photo.BUNDLE_TAG, holdsPhotoList[position])
        photoBundle.putParcelable(Photo.BUNDLE_TAG, photo)
        this.startActivity(intent)
    }

    override fun onItemClick(position: Int) {

        initActivity(position)
    }

////

    
}
