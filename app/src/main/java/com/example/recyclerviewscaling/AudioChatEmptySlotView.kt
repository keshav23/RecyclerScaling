package com.example.recyclerviewscaling

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView

class AudioChatEmptySlotView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attributeSet) {
    private val audioEmptyView: ImageView
    private val strokeView: ImageView

    init {
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE).apply {
            inflate(context, R.layout.audio_chat_empty_slot, this@AudioChatEmptySlotView)
        }
        audioEmptyView = findViewById<ImageView>(R.id.audio_chat_empty_slot_view)
        strokeView = findViewById<ImageView>(R.id.audio_chat_stroke_view)
    }

    fun setLockedView() {
        strokeView.visibility = VISIBLE
        audioEmptyView.visibility = GONE
    }

    fun setEmptyView() {
        strokeView.visibility = GONE
        audioEmptyView.visibility = VISIBLE
    }
}