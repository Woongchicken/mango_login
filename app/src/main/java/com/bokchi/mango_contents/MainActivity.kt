package com.bokchi.mango_contents

import android.content.ContentValues
import android.content.Intent
import android.graphics.Paint.Join
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.mango_contents.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val items = mutableListOf<ContentsModel>()

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth

        // 로그아웃 버튼 클릭
        binding.logoutBtn.setOnClickListener {
            /** 로그아웃 */
            auth.signOut()
            Toast.makeText(this,"로그아웃 성공", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }

        // 북마크 버튼 클릭
        binding.bookmarkBtn.setOnClickListener {
            val intent = Intent(this,BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/zWVgSFqWIQrj",
            "https://mp-seoul-image-production-s3.mangoplate.com/781488_1507727492501116.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "풍년 닭도리탕"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/OJgUhmMaJOPI",
                "https://mp-seoul-image-production-s3.mangoplate.com/685796_1593936482131893.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "만가타"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Jpan4MocWZP2",
                "https://mp-seoul-image-production-s3.mangoplate.com/1610691_1626248381943852.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오스테리아밀즈"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/woOChljkSNyQ",
                "https://mp-seoul-image-production-s3.mangoplate.com/1743214_1630982062735459.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "다동 황소막창"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/zWVgSFqWIQrj",
                "https://mp-seoul-image-production-s3.mangoplate.com/781488_1507727492501116.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "풍년 닭도리탕"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/OJgUhmMaJOPI",
                "https://mp-seoul-image-production-s3.mangoplate.com/685796_1593936482131893.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "만가타"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Jpan4MocWZP2",
                "https://mp-seoul-image-production-s3.mangoplate.com/1610691_1626248381943852.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오스테리아밀즈"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/woOChljkSNyQ",
                "https://mp-seoul-image-production-s3.mangoplate.com/1743214_1630982062735459.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "다동 황소막창"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/zWVgSFqWIQrj",
                "https://mp-seoul-image-production-s3.mangoplate.com/781488_1507727492501116.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "풍년 닭도리탕"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/OJgUhmMaJOPI",
                "https://mp-seoul-image-production-s3.mangoplate.com/685796_1593936482131893.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "만가타"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Jpan4MocWZP2",
                "https://mp-seoul-image-production-s3.mangoplate.com/1610691_1626248381943852.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오스테리아밀즈"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/woOChljkSNyQ",
                "https://mp-seoul-image-production-s3.mangoplate.com/1743214_1630982062735459.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "다동 황소막창"
            )
        )

        binding.rv.adapter = RVAdapter(items)
        binding.rv.layoutManager = GridLayoutManager(this, 2)

    }
}