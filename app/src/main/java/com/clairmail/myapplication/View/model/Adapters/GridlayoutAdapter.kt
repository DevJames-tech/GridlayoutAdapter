package com.clairmail.myapplication.View.model.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clairmail.myapplication.View.model.dataclass.Photo
import com.squareup.picasso.Picasso
import android.widget.ImageView
import android.widget.TextView

import com.clairmail.myapplication.R
import com.clairmail.myapplication.View.View.MainActivity
import com.clairmail.myapplication.View.model.OnItemClickListener

//static belongs to class
//static methods can be called with needing to called without referencing the class
//static has memory allocated only once, during runtime


class GridlayoutAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<GridlayoutAdapter.ViewHolder>() {


    // only put data here to keep the code decoupled only pass raw data
    private var itemList: List<Photo> = mutableListOf() // creates emptyList


    fun setListOfPhotos(getItemList: List<Photo>){

        this.itemList = getItemList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.gridlayout_items, parent, false)

        return ViewHolder(view, listener )
    }

    override fun getItemCount(): Int { return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = itemList.get(position)

        Picasso.get().load(item.downloadUrl).resize(200,
            200).centerCrop().into(holder.imageView);
        holder.textView.text = item?.author
    }


    inner class ViewHolder(itemView: View, private val itemListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener{ itemListener.onItemClick(adapterPosition)} //lambda that directly calls and passes value to
            //on click method
        }



        val imageView: ImageView = itemView.findViewById(R.id.image)
        val textView: TextView = itemView.findViewById(R.id.title)


    }
        //
        //test setting width and height of image. To check to see if it fills the width of the screen [150 X 150]

// different approach on talking to the main activity with the gridlayout adapter. Callback to invoke this method in the activity

    }


