package com.example.recyclerviewscaling

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

class AudioChatRequestsSlotViewSmall @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attributeSet) {
    private val requestsCountView: TextView
    private val requestsCountBg: ImageView
    private val requestsLabel: TextView

    init {
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE).apply {
            inflate(context, R.layout.audio_chat_request_small, this@AudioChatRequestsSlotViewSmall)
        }
        requestsCountView = findViewById<TextView>(R.id.audio_chat_requests_count_small)
        requestsCountBg = findViewById<ImageView>(R.id.audio_chat_requests_slot_view_small)
        requestsLabel = findViewById<TextView>(R.id.audio_chat_request_label_small)
    }
}