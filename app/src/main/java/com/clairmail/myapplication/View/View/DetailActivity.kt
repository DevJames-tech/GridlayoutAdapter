package com.clairmail.myapplication.View.View

import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.parseUri
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.clairmail.myapplication.R
import com.clairmail.myapplication.View.model.dataclass.Photo
import com.squareup.picasso.Picasso

class DetailActivity: AppCompatActivity() {

    private lateinit var listOPhotos: ArrayList<Photo>
    private var bundle = Bundle()
    private val imageHolder: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getFullSizedImage()

    }


        fun getFullSizedImage(){


        if(intent.extras != null){ bundle = intent.extras!! }

            val  photo = bundle.getParcelable<Photo>(Photo.BUNDLE_TAG)

        Picasso.get().load(photo?.downloadUrl).into(imageHolder)
    }

}