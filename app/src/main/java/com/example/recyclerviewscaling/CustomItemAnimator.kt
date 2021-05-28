package androidx.recyclerview.widget;

import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator

class CustomItemAnimator : DefaultItemAnimator() {

    private fun resetAnimation(holder: RecyclerView.ViewHolder) {
        holder.itemView.animate().interpolator = OvershootInterpolator()
        endAnimation(holder)
    }

    override fun animateChange(
        oldHolder: RecyclerView.ViewHolder?,
        newHolder: RecyclerView.ViewHolder?,
        fromX: Int,
        fromY: Int,
        toX: Int,
        toY: Int
    ): Boolean {
        return super.animateChange(oldHolder, newHolder, fromX, fromY, toX, toY)
    }
}