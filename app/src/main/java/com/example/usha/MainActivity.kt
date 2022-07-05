package com.example.usha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.usha.community.CommunityFragment
import com.example.usha.databinding.ActivityMainBinding
import com.example.usha.notification.NotificationFragment
import com.example.usha.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setNAvigation()
        supportFragmentManager.beginTransaction().replace(R.id.linearForFragment,CommunityFragment()).commitAllowingStateLoss()
    }

    fun setNAvigation(){
        binding!!.bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.community -> {
                    supportFragmentManager.beginTransaction().replace(R.id.linearForFragment , CommunityFragment()).commitAllowingStateLoss()
                    true
                }
                R.id.notification -> {
                    supportFragmentManager.beginTransaction().replace(R.id.linearForFragment , NotificationFragment()).commitAllowingStateLoss()
                    true
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.linearForFragment , ProfileFragment()).commitAllowingStateLoss()
                    true
                }
                else -> false
            }
        }
    }
}