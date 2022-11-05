package com.aman.tutorialscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DotsAdapter(var context: Context, var size: Int) : RecyclerView.Adapter<DotsAdapter.ViewHolder>() {
    var currentPosition: Int = 0
    inner  class  ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        var image : ImageView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_dot, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(position == currentPosition){
            holder.image.setBackgroundColor(ContextCompat.getColor(context, R.color.purple_200))
        }
        else{
            holder.image.setBackgroundColor(ContextCompat.getColor(context, R.color.teal_200))

        }
    }

    override fun getItemCount(): Int {
        return size
    }

    fun updatePosition( color: Int){
        currentPosition = color
        notifyDataSetChanged()
    }

}