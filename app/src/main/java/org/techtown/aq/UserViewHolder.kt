package org.techtown.aq

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.prefs.NodeChangeListener

class UserViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    // private val view: View
    fun bind(listener: (item: UserData) -> Unit, item: UserData) {
        view.findViewById<TextView>(R.id.txtUser_id).text = item.id
        view.findViewById<TextView>(R.id.txtUser_name).text = item.name
        view.setOnClickListener{
            listener(item)
        // 이름과 아이디를 가져와서 보여주는 것
        }
    }
}