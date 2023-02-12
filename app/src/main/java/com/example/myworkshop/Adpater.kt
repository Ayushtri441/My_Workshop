package com.example.myworkshop

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adpater : RecyclerView.Adapter<Adpater.Holder>() {
        var list : ArrayList<Model> = ArrayList()
    fun addItems(item: ArrayList<Model>){
        this.list = item
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
      LayoutInflater.from(parent.context).inflate(R.layout.fragment_dashboard,parent,false)
    )


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val std = list[position]
        holder.bindView(std)
    }


    override fun getItemCount(): Int {
      return list.size
    }

    class Holder(var view : View) : RecyclerView.ViewHolder(view){
        var name = view.findViewById<TextView>(R.id.name)

        fun bindView(std : Model){
            name.text = std.name
        }
    }
}