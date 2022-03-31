package org.techtown.aq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val userAdapter = UserAdapter()

    private val userList = mutableListOf<UserData>().apply {
        for (i in 1..3) {
            add(
                UserData(
                    ContextCompat.getDrawable(this@MainActivity, R.drawable.user)!!,
                    "$i",
                    "name $i"
                )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.lstUser).adapter = userAdapter
        userAdapter.addList(userList)
        userAdapter.setOnItemClickListener { item ->
            Toast.makeText(
                this,
                "Clicked - > ID : ${item.id}, Name : ${item.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        }

    }
