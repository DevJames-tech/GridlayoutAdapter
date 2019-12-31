package com.clairmail.myapplication.View.model.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clairmail.myapplication.View.model.dataclass.Photo
import com.squareup.picasso.Picasso
import android.util.Log
import com.clairmail.myapplication.R
import com.clairmail.myapplication.View.View.MainActivity
import com.clairmail.myapplication.View.model.OnItemClickListener

//static belongs to class
//static methods can be called with needing to called without referencing the class
//static has memory allocated only once, during runtime


class GridlayoutAdapter() :
    RecyclerView.Adapter<GridlayoutAdapter.ViewHolder>() {

    // only put data here to keep the code decoupled only pass raw data
    private var itemList: List<Photo> = mutableListOf() // creates emptyList
    private var onItemClickListener: OnItemClickListener = object: OnItemClickListener

    constructor(itemListener: OnItemClickListener): this(){

        this.onItemClickListener = itemListener
    }

    fun setListOfPhotos(getItemList: List<Photo>){

        this.onItemClickListener
        this.itemList = getItemList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.gridlayout_items, parent, false)

        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int { return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = itemList.get(position)

        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.imageView);
        holder.textView.text = item?.author
    }


    inner class ViewHolder(itemView: View,  itemListener: OnItemClickListener)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var itemClickListener = object: OnItemClickListener
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val textView: TextView = itemView.findViewById(R.id.title)

        init {
            // init can be used
            this.itemClickListener = itemListener
            imageView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            itemClickListener.onClick(adapterPosition)
            val item = itemList[layoutPosition] //contains int postion of clicked Item
            Log.d("james", itemList[layoutPosition].toString())

            val main = MainActivity()

            item.downloadUrl?.let { main.initActivity() }
        }
        //
        //test setting width and height of image. To check to see if it fills the width of the screen [150 X 150]

// different approach on talking to the main activity with the gridlayout adapter. Callback to invoke this method in the activity

    }


}