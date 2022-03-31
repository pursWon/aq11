package org.techtown.aq

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private val userList = mutableListOf<UserData>() // UserData를 리스트로 가져옴

    private lateinit var listener: (item: UserData) -> Unit // null 값을 사용하지 않고 초기화. var에서만 사용할 수 있음. val에서는 불가능

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflatedView = // inflate는 xml에 적힌 레이아웃들을 메모리에 객체화시키는 행동이다.
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        // LayoutInflater는 xml에 정의된 Resource를 View 객체로 반환해주는 역할을 한다.
        // 따라서 위에 코드는 item_view에 있는 레이아웃을 가져온다. xml 레이아웃 파일에 대한 뷰를 생성할 때
        // Layoutflater를 사용하면 된다.
        // val inflater : LayoutInflater = LayoutInflater.from(context)
        // LayoutInflater 에 static으로 정의되어 있는 LayoutInflater.from()를 이용하여 LayoutInflater를 만든다.
        // 내부적으로 context에서 LayoutInflater를 가져온다.
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
        listener = itemClickListener // setOnItemClickListener는 이벤트 클릭 처리
    }

}