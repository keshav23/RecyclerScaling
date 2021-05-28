package com.example.recyclerviewscaling

import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AudioChatAdapter(
    private val slotCount: Int = 8,
    private val layoutManager: GridLayoutManager
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_EMPTY_SLOT = 0
    private val TYPE_USER_SLOT = 1
    private val TYPE_REQUESTS_SLOT = 2
    private val TYPE_EMPTY_SLOT_SMALL = 3
    private val TYPE_USER_SLOT_SMALL = 4
    private val TYPE_REQUESTS_SLOT_SMALL = 5

    private val slotData = arrayListOf<Int>()

    init {
        slotData.clear()
        slotData.addAll(getInitialSlotData())
    }

    private fun getInitialSlotData(): ArrayList<Int> {
        val slotData = arrayListOf<Int>()
        for (i in 0 until slotCount) slotData.add(i)
        return slotData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_REQUESTS_SLOT -> AudioRequestsSlotViewHolder(
                AudioChatRequestsSlotView(parent.context)
            )
            TYPE_REQUESTS_SLOT_SMALL -> AudioEmptySlotViewHolder(
                AudioChatRequestsSlotViewSmall(parent.context)
            )

            TYPE_USER_SLOT -> AudioChatProfileSlotViewHolder(
                AudioChatProfileView(parent.context)
            )
            TYPE_USER_SLOT_SMALL -> AudioChatProfileSlotViewHolder(
                AudioChatProfileViewSmall(parent.context)
            )

            TYPE_EMPTY_SLOT -> AudioEmptySlotViewHolder(
                AudioChatEmptySlotView(parent.context)
            )
            TYPE_EMPTY_SLOT_SMALL -> AudioRequestsSlotViewHolder(
                AudioChatEmptySlotViewSmall(parent.context)
            )


            else -> throw IllegalStateException("Not a valid view type")
        }
    }

    override fun getItemCount(): Int = slotCount

    override fun getItemViewType(position: Int): Int {
        return if (layoutManager.spanCount == 4) {
            when (slotData[position]) {
                0 -> TYPE_USER_SLOT
                in 1..2 -> TYPE_EMPTY_SLOT
                in 3..5 -> TYPE_USER_SLOT
                else -> TYPE_REQUESTS_SLOT
            }
        } else {
            when (slotData[position]) {
                0 -> TYPE_USER_SLOT_SMALL
                in 1..2 -> TYPE_EMPTY_SLOT_SMALL
                in 3..5 -> TYPE_USER_SLOT_SMALL
                else -> TYPE_REQUESTS_SLOT_SMALL
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AudioChatProfileSlotViewHolder -> holder.bindTo(position)
        }
    }
}
