package com.example.recyclerviewscaling

import android.animation.LayoutTransition
import android.animation.TimeInterpolator
import android.os.Bundle
import android.view.ViewGroup
import android.view.animation.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (findViewById<ConstraintLayout>(R.id.audio_chat_fragment_container) as? ViewGroup)?.layoutTransition?.enableTransitionType(
            LayoutTransition.CHANGING
        )

        (findViewById<ConstraintLayout>(R.id.audio_chat_fragment_container) as? ViewGroup)?.layoutTransition?.setInterpolator(LayoutTransition.CHANGING, LinearInterpolator())

        val audioChatFragment = AudioChatFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.audio_chat_fragment_container,
            audioChatFragment,
            AudioChatFragment.TAG
        )
        transaction.commit()

        findViewById<Button>(R.id.magic).setOnClickListener {
            audioChatFragment.onButtonClick()
        }
    }
}