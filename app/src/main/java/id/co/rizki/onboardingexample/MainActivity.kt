package id.co.rizki.onboardingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager
    lateinit var dotIndicator : DotsIndicator
    lateinit var imgNext : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        dotIndicator = findViewById(R.id.dots_indicator)
        imgNext = findViewById(R.id.img_next)

        viewPager.adapter = SimpleViewPagerAdapter(supportFragmentManager)
        dotIndicator.setViewPager(viewPager)

        imgNext.setOnClickListener {
            val currentIndex = viewPager.currentItem
            viewPager.currentItem = currentIndex+1
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if(position == 1 || position == 0) imgNext.visibility = View.VISIBLE
                else imgNext.visibility = View.GONE
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }


    private inner class SimpleViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment = when (position) {
            0 -> OnBoardImageOneFragment()
            1 -> OnBoardImageTwoFragment()
            else -> OnBoardLoginFragment()
        }


    }
}