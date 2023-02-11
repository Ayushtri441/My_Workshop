package com.example.myworkshop

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class signup : Fragment() {
    private lateinit var uname :EditText
    private lateinit var pass :EditText
    private lateinit var redirect :TextView
    private lateinit var cpass :EditText
    private lateinit var btn: Button
    private lateinit var db : DBhelper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup,null)
    }
    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        db = DBhelper(activity)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uname = view.findViewById(R.id.signup_user)
        pass = view.findViewById(R.id.password)
        redirect= view.findViewById(R.id.loginRedirectText)
        cpass = view.findViewById(R.id.c_password)
        btn = view.findViewById(R.id.signup_button)
        btn.setOnClickListener{
            val username = uname.text.toString()
            val userpass = pass.text.toString()
            val usercpass = cpass.text.toString()
            val savedata = db.insertdata(username,userpass)
            if(TextUtils.isEmpty(username) || TextUtils.isEmpty(usercpass) || TextUtils.isEmpty(userpass)){
                Toast.makeText(activity, "Add valid Username and Password ",Toast.LENGTH_LONG).show()
            }
            else if(!usercpass.equals(userpass)){
                Toast.makeText(activity,"Password and confirm password and not same",Toast.LENGTH_LONG).show()
            }
            else {
                if(savedata==true){
                    Toast.makeText(activity,"Login uscessful",Toast.LENGTH_LONG).show()
                    val i = Intent(activity,Login::class.java)
                    activity?.startActivity(i)
                    activity?.finish()

                }
                else {
                    Toast.makeText(activity,"User Exits try different Username",Toast.LENGTH_LONG).show()
                }
            }
        }
        redirect.setOnClickListener{
            val i = Intent(activity,Login::class.java)
            startActivity(i)
            activity?.finish()
        }
    }
}