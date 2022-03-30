package org.techtown.aq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<UserData>()
        list.add(UserData(ContextCompat.getDrawable(this, R.drawable.user)!!, "1", "name 1"))
        list.add(UserData(ContextCompat.getDrawable(this, R.drawable.user)!!, "2", "name 2"))
        list.add(UserData(ContextCompat.getDrawable(this, R.drawable.user)!!, "3", "name 3"))

        val adapter = RecyclerUserAdapter(list)
        lstUser.adapter = adapter
    }
}