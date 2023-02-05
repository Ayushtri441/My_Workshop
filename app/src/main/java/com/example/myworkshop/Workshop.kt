package com.example.myworkshop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView

class Workshop : Fragment() {

    lateinit var and: CardView
    lateinit var machine: CardView
    lateinit var dsa: CardView
    lateinit var data: CardView
    lateinit var react: CardView
    lateinit var cloud: CardView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_workshop,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        and = view.findViewById(R.id.android1)!!
        machine = view.findViewById(R.id.machine1)!!
        dsa = view.findViewById(R.id.dsa1)!!
        data = view.findViewById(R.id.data1)!!
        react = view.findViewById(R.id.react1)!!
        cloud = view.findViewById(R.id.cloud1)!!
        and.setOnClickListener{
            val intent = Intent (this.context, Android::class.java)
            getActivity()?.startActivity(intent)
        }
        data.setOnClickListener{
            val intent = Intent (getActivity(), data::class.java)
            getActivity()?.startActivity(intent)
        }
        machine.setOnClickListener{
            val intent = Intent (getActivity(), Machine::class.java)
            getActivity()?.startActivity(intent)
        }
        dsa.setOnClickListener{
            val intent = Intent (getActivity(), Dsa::class.java)
            getActivity()?.startActivity(intent)
        }
        react.setOnClickListener{
            val intent = Intent (getActivity(), react::class.java)
            getActivity()?.startActivity(intent)
        }
        cloud.setOnClickListener{
            val intent = Intent (getActivity(), Cloud::class.java)
            getActivity()?.startActivity(intent)
        }



    }
}