package com.example.recyclerviewscaling

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AudioChatProfileSlotViewHolder(private val audioChatSlotView: View) :
    RecyclerView.ViewHolder(audioChatSlotView) {

    fun bindTo(data: Int) {
        (audioChatSlotView as? AudioChatProfileView)?.setChatRoomProfile(data)
        (audioChatSlotView as? AudioChatProfileViewSmall)?.setChatRoomProfile(data)
    }
}
