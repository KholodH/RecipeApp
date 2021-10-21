package com.example.recipeapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var prices: ArrayList<String>

    val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd= findViewById<View>(R.id.btnAdd)as Button
        val btnView= findViewById<View>(R.id.btnView)as Button

        btnAdd.setOnClickListener {
            val f = recipePost.recipe(et1.text.toString(), et2.text.toString(),et3.text.toString(), et4.text.toString())
            addrecpie(f)
        }

        btnView.setOnClickListener {
            intent = Intent(applicationContext, ViewAct::class.java)
            startActivity(intent)
        }
    }
    private fun addrecpie(f:recipePost.recipe){
        if (apiInterface != null) {
            apiInterface.addrecpie(f)
                .enqueue(object : Callback<recipePost.recipe> {
                    override fun onResponse(
                        call: Call<recipePost.recipe>,
                        response:
                        Response<recipePost.recipe>
                    ) {
                        Toast.makeText(this@MainActivity, "recipe Added", Toast.LENGTH_LONG)
                            .show()
                    }

                    override fun onFailure(
                        call: Call<recipePost.recipe>,
                        t: Throwable
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            "Something went wrong",
                            Toast.LENGTH_LONG
                        ).show()
                    }


                })
        }
    }

    }

