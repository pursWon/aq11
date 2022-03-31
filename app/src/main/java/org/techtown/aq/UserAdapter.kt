package org.techtown.aq

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private val userList = mutableListOf<UserData>()

    private lateinit var listener: (item: UserData) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return UserViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holderUser: UserViewHolder, position: Int) {
        holderUser.bind(listener, userList[position])
    }

    override fun getItemCount(): Int = userList.size

    fun addList(list: List<UserData>) {
        userList.addAll(list)
    }

    fun setOnItemClickListener(itemClickListener: (item: UserData)->Unit) {
        listener = itemClickListener
    }

}