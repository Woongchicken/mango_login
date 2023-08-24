package com.bokchi.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bokchi.mango_contents.databinding.ActivityMainBinding
import com.bokchi.mango_contents.databinding.ActivityViewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityViewBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val imageUrl = intent.getStringExtra("imageUrl").toString()

        binding.webView.loadUrl(url)

        auth = Firebase.auth
        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref").child(auth.currentUser!!.uid)

        // 북마크 저장 (Realtime Database 저장하기)
        binding.saveText.setOnClickListener {
            val contentsModel = ContentsModel(url,imageUrl,title)
            myBookmarkRef
                .push()                     // 중복 데이터 삽입 가능
                .setValue(contentsModel)
            Toast.makeText(this,"${title} 북마크 저장 완료", Toast.LENGTH_SHORT).show()
        }
    }
}