package org.techtown.aq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val userAdapter = UserAdapter() // private은 해당 코틀린에서만 사용가능하다.

    private val userList = mutableListOf<UserData>().apply {
        for (i in 1..3) {
            add(
                UserData(
                    ContextCompat.getDrawable(this@MainActivity, R.drawable.user)!!,
                    "$i",
                    "name $i"
                ) // for i in 1..3은 1~3번까지 나열하는 것이다.
            // ContextCopmpat은 Resource에서 값을 가져오거나 퍼미션을 확인할 때 사용할 때 SDK버전을 고려하지 않아도 되도록 (내부적으로 SDK버전을 처리해둔) 클래스입니다.
            )
        }
    } // ListOf는 리스트를 만들 때 쓰는 함수이다. mutableOf는 변경이 가능하다.
    // var name = mutableListOf<"Kim", "Hong">
    // val name = mutableListOf<"Kim", "Hong">는 val은 name이 불변이지 뒤에 이름은 불변이 아니므로 변경이 가능하다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 액티비티 생성 시 호출, 반드시 구현
        setContentView(R.layout.activity_main) // 레이아웃 지정하여 화면 그리기
        findViewById<RecyclerView>(R.id.lstUser).adapter = userAdapter
        userAdapter.addList(userList) // List의 값을 추가할 땐 add()함수를 사용한다.
        //add() 함수에 값만 넣을 경우 List에 순차적으로 들어간다.
        userAdapter.setOnItemClickListener { item -> //OnClickListener는 사용자가 버튼을 눌렀을 때 반응하는
            // 이벤트 처리를 하기 위해 사용된다.
            Toast.makeText(
                this,
                "Clicked - > ID : ${item.id}, Name : ${item.name}",
                Toast.LENGTH_SHORT
            ).show()
        } // Toast.makeText 메서드를 활용하여 원하는 메세지를 화면에 띄울 수 있다.
        // Toast.LENG_SHORT를 넣게 되면 2초 정도 화면에 나오고
        // Toast.LENG_LONG을 넣게 되면 4초 정도 화면에 나오게 된다.

        }

    }
