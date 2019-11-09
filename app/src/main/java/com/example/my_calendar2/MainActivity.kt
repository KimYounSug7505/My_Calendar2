package com.example.my_calendar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.NonNull
import com.google.android.material.bottomnavigation.BottomNavigationView

open class MainActivity : AppCompatActivity() {

    internal lateinit var fragment1: SettingFragment//먼슬리 아직 클래스 안 옮김
    internal lateinit var fragment2:Fragment2//week
    internal lateinit var fragment3: Fragment3 //세팅

    override protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment1 = SettingFragment()
        fragment2=Fragment2()
        fragment3 = Fragment3()

        supportFragmentManager.beginTransaction().replace(R.id.container, fragment1).commit()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.tab1 -> {
                        Toast.makeText(applicationContext, "첫 번째 탭 선택됨", Toast.LENGTH_LONG).show()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, fragment1).commit()
                        return true
                    }
                    R.id.tab2->{
                        Toast.makeText(applicationContext, "두 번째 탭 선택됨", Toast.LENGTH_LONG).show()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, fragment2).commit()
                        return true
                    }
                    R.id.tab3 -> {
                        Toast.makeText(applicationContext, "세 번째 탭 선택됨", Toast.LENGTH_LONG).show()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, fragment3).commit()

                        return true
                    }
                }

                return false
            }
        })
    }
}