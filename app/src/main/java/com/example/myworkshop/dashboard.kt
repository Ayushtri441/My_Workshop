package com.example.myworkshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class dashboard : Fragment() {
    lateinit var name: TextView
    lateinit var info:TextView
    lateinit var rating :TextView
    lateinit var workshopd: WorkshopdB
    lateinit var recyclerView: RecyclerView
    lateinit var adpater: Adpater
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = view.findViewById(R.id.name)
        info = view.findViewById(R.id.info)
        rating = view.findViewById(R.id.rating)
        workshopd  = WorkshopdB(context)
        recyclerView = view.findViewById(R.id.recycle)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adpater = Adpater()
        recyclerView.adapter= adpater
        val list = workshopd.getAllCourses()
        adpater?.addItems(list)


    }


}