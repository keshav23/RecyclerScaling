package com.example.recyclerviewscaling

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class AudioChatProfileViewSmall @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attributeSet) {
    private val profilePicView: ImageView
    private val lockView: ImageView
    private val hostProfilePicTranslucentView: ImageView
    private val profilePicBorderView: ImageView
    private val hostFrameView: ImageView
    private val userLevelView: ImageView
    private val profileNameView: TextView

    init {
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE).apply {
            inflate(context, R.layout.audio_chat_profile_small, this@AudioChatProfileViewSmall)
        }
        profilePicView = findViewById<ImageView>(R.id.audio_profile_user_view_small)
        profilePicBorderView = findViewById<ImageView>(R.id.audio_profile_user_border_view_small)
        profileNameView = findViewById<TextView>(R.id.audio_chat_profile_name_small)
        hostFrameView = findViewById<ImageView>(R.id.audio_profile_host_frame_small)
        userLevelView = findViewById<ImageView>(R.id.audio_chat_user_level_small)
        hostProfilePicTranslucentView =
            findViewById<ImageView>(R.id.audio_profile_host_greyed_view_small)
        lockView = findViewById<ImageView>(R.id.audio_profile_lock_view_small)
    }

    fun setChatRoomProfile(slotData: Int) {
        lockView.visibility = GONE
        hostProfilePicTranslucentView.visibility = GONE
        if (slotData == 0) {
            setEmptyHost()
            return
        }

        handleHostFrame(slotData)
        showProfilePic(slotData)
        profileNameView.text = "Test$slotData"

        userLevelView.visibility = GONE
    }


    private fun showProfilePic(slotUserData: Int) {
        val borderSize = 4
        profilePicView.loadProfilePic("https://cdn.sharechat.com/fcb9c33_1621941065921_sc.jpeg")
        profilePicView.setPadding(borderSize, borderSize, borderSize, borderSize)

        if (slotUserData == 1) {
            profilePicBorderView.setImageResource(R.drawable.ic_audio_host_profile_stroke)
        } else {
            val borderDrawable = GradientDrawable()
            borderDrawable.setColor(ContextCompat.getColor(context, R.color.white))
            borderDrawable.shape = GradientDrawable.OVAL
            borderDrawable.setStroke(borderSize, ContextCompat.getColor(context, R.color.white))
            profilePicBorderView.setImageDrawable(borderDrawable)
        }
    }

    private fun handleHostFrame(userData: Int) {
        if (userData == 1) {
            hostFrameView.setImageResource(R.drawable.host)
            hostFrameView.visibility = VISIBLE
        } else {
            hostFrameView.visibility = GONE
        }
    }

    private fun setEmptyHost() {
        hostFrameView.setImageResource(R.drawable.host)
        profilePicBorderView.setImageResource(R.drawable.ic_audio_host_profile_stroke)
        hostFrameView.visibility = VISIBLE
        profilePicView.setImageResource(R.drawable.ic_audio_chat_creator_join)
        profileNameView.text = "JOIN"
    }
}