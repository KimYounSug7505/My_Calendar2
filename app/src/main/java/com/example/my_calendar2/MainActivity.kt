package com.example.my_calendar2


import android.content.Context
import android.content.Intent
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

open class MainActivity : AppCompatActivity() {

    lateinit var scheduleRecyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    fun initView() {

        scheduleRecyclerViewAdapter = RecyclerViewAdapter(this)
//////////////////////////////////////////////////////////////////////////////
        rv_schedule.layoutManager =  GridLayoutManager(this, Module_Base.DAYS_OF_WEEK)
        rv_schedule.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        rv_schedule.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
//////////////////////////////////////////////////////////////////////////////////////////////////


        rv_schedule.setOnClickListener{
            val nextIntent=Intent(this,input_diary::class.java)
            startActivity(nextIntent)
        }

        tv_prev_month.setOnClickListener {
            scheduleRecyclerViewAdapter.changeToPrevMonth()
        }

        tv_next_month.setOnClickListener {
            scheduleRecyclerViewAdapter.changeToNextMonth()
        }
        tv_weekly.setOnClickListener{
            var nextIntent:Intent= Intent(this,WeeklyCalendar::class.java)
            startActivity(nextIntent)
        }

    }

    fun refreshCurrentMonth(calendar: Calendar) {
        val sdf = SimpleDateFormat("yyyy MM", Locale.KOREAN)
        tv_current_month.text = sdf.format(calendar.time)
    }
}