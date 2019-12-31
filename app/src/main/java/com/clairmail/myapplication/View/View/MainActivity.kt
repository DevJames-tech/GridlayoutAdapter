package com.clairmail.myapplication.View.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.clairmail.myapplication.R
import com.clairmail.myapplication.View.ViewModel.MainActivityViewModel
import com.clairmail.myapplication.View.model.Adapters.GridlayoutAdapter
import com.clairmail.myapplication.View.model.OnItemClickListener
import com.clairmail.myapplication.View.model.Network.FlickerApiResponse
import com.clairmail.myapplication.View.model.dataclass.Photo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val gridLayoutAdapter = GridlayoutAdapter();

    private lateinit var viewModel: MainActivityViewModel
    private val flickerApiResponse = FlickerApiResponse()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)



        setGridManager()
        watchData() //setting observer
        flickerApiResponse.setFlickerResponseData(this)//making api call

    }

    private fun setGridManager(){



       recyclerView.adapter = gridLayoutAdapter

        recyclerView.adapter = gridLayoutAdapter
        recyclerView.layoutManager =  GridLayoutManager(
            this, 3)
        //spanCount is number of rows or columns depending on the direction of the layout



    }

    fun watchData(){
        //Live data here helps makes an async call
        flickerApiResponse.getApirResponse()?.observe(this,
            Observer { Photos ->  // Arguments lambda
                gridLayoutAdapter.setListOfPhotos(Photos) //statements for lambda
        })
    }

    fun initActivity(){

        val photo = Photo()
        val photoBundle = Bundle()
        val intent = Intent(this, DetailActivity::class.java)


        intent.putExtras(photoBundle)
        photoBundle.putParcelable(Photo.BUNDLE_TAG, photo)

        this.startActivity(intent)
    }

    override fun onClick(position: Int) {
        super.onClick(position)

        initActivity()
    }

////

    
}
