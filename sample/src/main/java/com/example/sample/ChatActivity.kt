package com.example.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.sample.adapter.ChatAdapter
import com.example.sample.databinding.ActivityChatBinding
import com.example.sample.databinding.ChatMessageBinding
import com.example.sample.data.model.ChatMessage


class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val messageSet = mutableListOf<ChatMessage>()
        messageSet.add(ChatMessage("User", "2022.11.14", "body"))
        messageSet.add(ChatMessage("User", "2022.11.14", "body"))
        messageSet.add(ChatMessage("User", "2022.11.14", "body"))


        val chatBinding = ChatMessageBinding.inflate(layoutInflater)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = ChatAdapter(messageSet)
    }
}