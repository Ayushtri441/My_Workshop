package com.example.myworkshop

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myworkshop.MainActivity.Companion.globalVar
class dashboard : Fragment() {
    lateinit var workshopd: WorkshopdB
    lateinit var list : ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard,null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(globalVar.equals("") ){
            Toast.makeText(activity,"Please Login to View DashBoard", Toast.LENGTH_LONG).show()
        }
        else {
            list = view.findViewById(R.id.listview)
            workshopd = WorkshopdB(context)
            val name = workshopd.getAllCourses(globalVar)
            list.adapter =
                activity?.let {
                    ArrayAdapter(
                        it,
                        android.R.layout.simple_spinner_dropdown_item,
                        name
                    )
                }
            (list.adapter as ArrayAdapter<String>?)?.notifyDataSetChanged()
            list.invalidateViews()

        }




    }


}