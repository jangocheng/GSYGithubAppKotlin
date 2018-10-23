package com.shuyu.github.kotlin.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.webkit.WebView

/**
 * Created by guoshuyu
 * Date: 2018-10-23
 */
class GSYWebView : WebView {


    private var startX: Float = 0.0f
    private var startY: Float = 0.0f
    private var offsetX: Float = 0.0f
    private var offsetY: Float = 0.0f

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                parent.requestDisallowInterceptTouchEvent(true)
                startX = event.x
                startY = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                offsetX = Math.abs(event.getX() - startX);
                offsetY = Math.abs(event.getY() - startY);
                if (offsetX > offsetY) {
                    parent.requestDisallowInterceptTouchEvent(true)
                } else {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
        }
        return super.onTouchEvent(event)
    }
}