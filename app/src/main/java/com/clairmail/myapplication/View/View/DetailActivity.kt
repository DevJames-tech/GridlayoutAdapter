package com.clairmail.myapplication.View.View

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.clairmail.myapplication.R
import com.clairmail.myapplication.View.model.dataclass.Photo
import com.squareup.picasso.Picasso

class DetailActivity: AppCompatActivity() {

    private var bundle = Bundle()
    private var imageHolder: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        getFullSizedImage()

    }

    private fun getFullSizedImage(){

        if (imageHolder == null){ imageHolder = findViewById(R.id.image2) }

        if(intent.extras != null){ bundle = intent.extras!! }

        val  photo = bundle.getParcelable<Photo>(Photo.BUNDLE_TAG)

        Picasso.get().load(photo?.downloadUrl).centerInside().resize(3840, 2160).into(imageHolder)
    }

}