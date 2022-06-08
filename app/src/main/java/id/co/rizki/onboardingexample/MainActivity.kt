package id.co.rizki.onboardingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = SimpleViewPagerAdapter(supportFragmentManager)
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