package com.example.recyclerviewscaling

import android.animation.LayoutTransition
import android.os.Build
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.TranslateAnimation
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AudioChatFragment : Fragment() {

    companion object {
        const val TAG = "AudioChatFragment"

        fun newInstance(): AudioChatFragment {
            return AudioChatFragment()
        }

    }


    private var audioChatAdapter: AudioChatAdapter? = null

    var spanCount = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_audio_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {
//        (view?.findViewById<RecyclerView>(R.id.audio_chat_slots) as? ViewGroup)?.layoutTransition?.enableTransitionType(
//            LayoutTransition.CHANGING
//        )
//
//        (view?.findViewById<RecyclerView>(R.id.audio_chat_slots) as? ViewGroup)?.layoutTransition?.setDuration(
//            2000
//        )

        val layoutManager1 = object : GridLayoutManager(context, spanCount) {
            override fun supportsPredictiveItemAnimations(): Boolean {
                return false
            }
        }

        audioChatAdapter = AudioChatAdapter(8, layoutManager1)
        view?.findViewById<RecyclerView>(R.id.audio_chat_slots)?.apply {
            setHasFixedSize(true)
            layoutManager = layoutManager1
            adapter = audioChatAdapter
            itemAnimator?.changeDuration = 400
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun onButtonClick() {
        changeSpan()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun changeSpan() {
        (view as? ViewGroup)?.let {
            TransitionManager.beginDelayedTransition(it)
        }
        if (spanCount == 4) {
            spanCount = 8
            (view?.findViewById<RecyclerView>(R.id.audio_chat_slots)?.layoutManager as? GridLayoutManager)?.spanCount =
                spanCount

        } else {
            spanCount = 4
            (view?.findViewById<RecyclerView>(R.id.audio_chat_slots)?.layoutManager as? GridLayoutManager)?.spanCount =
                spanCount
        }
        audioChatAdapter?.notifyItemRangeChanged(0, 8)
    }

    fun changeRV() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.audio_chat_slots)
        val fromY = recyclerView?.y ?: 0
        val fromX = recyclerView?.x ?: 0


        val toY = recyclerView?.y ?: 0

        val fadeOut: Animation =
            TranslateAnimation(fromX.toFloat(), fromX.toFloat(), fromY.toFloat(), toY.toFloat())
        fadeOut.interpolator = DecelerateInterpolator()
        fadeOut.duration = 1000
        view?.findViewById<RecyclerView>(R.id.audio_chat_slots)?.startAnimation(fadeOut)
        //recyclerView?.requestLayout()

    }
}
