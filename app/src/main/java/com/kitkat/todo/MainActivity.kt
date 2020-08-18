package com.kitkat.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager
    lateinit var roundedSolid: RelativeLayout
    lateinit var bar: RelativeLayout
    private var isLogin = true
    private val mCurrentSelectedScreen = 0
    private var mNextSelectedScreen = 0
    lateinit var txtsignup: TextView
    lateinit var txtlogin: TextView
    private var distance: Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roundedSolid = findViewById(R.id.roundedsolid)
        txtsignup = findViewById(R.id.txtsignup)
        txtlogin = findViewById(R.id.txtlogin)
        bar = findViewById(R.id.bar)

        bar.setOnClickListener{
            if (isLogin) {
                Handler().post {
                    //  mPager.setCurrentItem(2); //Where "2" is the position you want to go
                    viewPager.currentItem = getItem(+1) //getItem(-1) for previous
                }


            } else {
                Handler().post {
                    //  mPager.setCurrentItem(2); //Where "2" is the position you want to go
                    viewPager.currentItem = getItem(-1) //getItem(-1) for previous
                }
            }
        }

        distance = resources.getDimensionPixelSize(R.dimen.distance).toFloat()

        viewPager = findViewById<View>(R.id.pager) as ViewPager
        viewPager.adapter = CustomPagerAdapter(this)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                if (position == mCurrentSelectedScreen) {
                    // We are moving to next screen on right side
                    if (positionOffset > 0.5) {
                        // Closer to next screen than to current
                        if (position + 1 != mNextSelectedScreen) {
                            mNextSelectedScreen = position + 1
                            //  updateStaticViewsForScreen( mNextSelectedScreen );
                            barmovementController()
                        }
                    } else {
                        // Closer to current screen than to next
                        if (position != mNextSelectedScreen) {
                            mNextSelectedScreen = position
                            //updateStaticViewsForScreen( mNextSelectedScreen );
                            barmovementController()

                        }
                    }
                } else {
                    // We are moving to next screen left side
                    if (positionOffset > 0.5) {
                        // Closer to current screen than to next
                        if (position + 1 != mNextSelectedScreen) {
                            mNextSelectedScreen = position + 1
                            //    updateStaticViewsForScreen( mNextSelectedScreen );
                            barmovementController()
                        }
                    } else {
                        // Closer to next screen than to current
                        if (position != mNextSelectedScreen) {
                            mNextSelectedScreen = position
                            //updateStaticViewsForScreen( mNextSelectedScreen );
                            barmovementController()
                        }
                    }
                }

            }

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageSelected(position: Int) {
            }

        })
    }

    private fun getItem(i: Int): Int {
        return viewPager.currentItem + i
    }

    private fun barmovementController() {
        if (isLogin) {
            roundedSolid.animate().translationX(distance)
            isLogin = false
            txtsignup.setTextColor(resources.getColor(R.color.white))
            txtlogin.setTextColor(resources.getColor(R.color.colorPrimary))
            viewPager.arrowScroll(ViewPager.FOCUS_RIGHT)
        } else {
            roundedSolid.animate().translationX(0f)
            isLogin = true
            txtlogin.setTextColor(resources.getColor(R.color.white))
            txtsignup.setTextColor(resources.getColor(R.color.colorPrimary))
            viewPager.arrowScroll(ViewPager.FOCUS_LEFT)
        }
    }
}