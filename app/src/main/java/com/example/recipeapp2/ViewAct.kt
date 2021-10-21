package com.example.recipeapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_view.*
import kotlinx.android.synthetic.main.activity_view.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewAct : AppCompatActivity() {
    val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
    private lateinit var messages: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        messages = arrayListOf()

        val myRV=findViewById<RecyclerView>(R.id.rvMain)
        myRV.adapter=RVAdapter(messages)
        myRV.layoutManager= LinearLayoutManager(this)

        apiInterface?.getmem()?.enqueue(object : Callback<ArrayList<recipePost.recipe>> {
            override fun onResponse(
                call: Call<ArrayList<recipePost.recipe>>,
                response: Response<ArrayList<recipePost.recipe>>
            ) {

                var usersData: String = ""
                for (User in response.body()!!) {
                    usersData=usersData+User.title + "\n" + User.author + "\n" + User.ingredients +"\n" + User.instructions +"\n"+"\n"


                }
                messages.add(usersData)
                myRV.adapter?.notifyDataSetChanged()


            }


            override fun onFailure(call: Call<ArrayList<recipePost.recipe>>, t: Throwable) {
                Toast.makeText(applicationContext, "" + t.message, Toast.LENGTH_SHORT).show()
            }
        })



    }
}