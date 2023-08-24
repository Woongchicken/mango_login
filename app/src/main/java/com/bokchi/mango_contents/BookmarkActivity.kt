package com.bokchi.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.bokchi.mango_contents.databinding.ActivityBookmarkBinding
import com.bokchi.mango_contents.databinding.ActivityViewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {
    private val contentModels = mutableListOf<ContentsModel>()

    private val binding by lazy {
        ActivityBookmarkBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref").child(Firebase.auth.currentUser!!.uid)

        val dataModelListAdapter = RVAdapter(contentModels)
        binding.rv.adapter = dataModelListAdapter
        binding.rv.layoutManager = GridLayoutManager(this, 2)

        // 북마크 불러오기 (Realtime Database 불러오기)
        myBookmarkRef
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    contentModels.clear()
                    for (dataModel in snapshot.children) {
                        Log.d("Datamodel",dataModel.toString())
                        contentModels.add(dataModel.getValue(ContentsModel::class.java)!!)
                    }
                    dataModelListAdapter.notifyDataSetChanged()
                    Log.d("contentModels",contentModels.toString())
                }
                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark","dbError")
                }
            })
    }
}