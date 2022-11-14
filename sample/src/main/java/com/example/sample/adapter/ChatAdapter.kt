package com.example.sample.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sample.data.model.ChatMessage
import com.example.sample.databinding.ChatMessageBinding

class ChatAdapter(private val dataSet: MutableList<ChatMessage>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    /* view holder */
    class ChatViewHolder(val binding: ChatMessageBinding) : RecyclerView.ViewHolder(binding.root)

    /* get item count */
    override fun getItemCount(): Int = dataSet.size

    /* create and inflates view and return Chat ViewHolder */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder = ChatViewHolder(
        ChatMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    /* Gets current messages and use it to bind view */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ChatViewHolder).binding
        binding.chatText.text = dataSet[position].text.toString()
        binding.chatTime.text = dataSet[position].time.toString()
        binding.chatMember.text = dataSet[position].user.toString()
    }
}