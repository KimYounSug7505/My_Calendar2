package com.example.my_calendar2


import android.app.Activity
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.input_diary.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.content.ContentResolver
import android.content.Intent

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.annotations.NotNull
//import com.pedro.library.AutoPermissions

import kotlinx.android.synthetic.main.input_diary.*
import java.text.SimpleDateFormat
import java.util.*


class InputDiary : MainActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_diary)

        /*val secondintent:Intent=getIntent();

        val YM =secondintent.getIntArrayExtra("YM")
        val pickeddate =secondintent.getIntExtra("picked",0)
        val sdf = SimpleDateFormat("yyyy MM", Locale.KOREAN)
        val sdf1=SimpleDateFormat("zz", Locale.KOREAN)
        current_Month.text = sdf.format(YM)
        picked_date.text=sdf1.format(pickeddate)
*/

        val image = findViewById<Button>(R.id.image)
        val search= findViewById<Button>(R.id.search)
        val inputText  = findViewById<EditText>(R.id.inputText)
        val imageView = findViewById<ImageView>(R.id.imageView)

        val secondintent:Intent=getIntent();

        val pickedYear =secondintent.getIntExtra("Y",0)
        val pick_Y:String=pickedYear.toString()
        current_YEAR.text=pick_Y

        val pickedMonth =secondintent.getIntExtra("M",0)+1
        val pick_M=pickedMonth.toString()
        current_Month.text=pick_M

        val pickeddate =secondintent.getIntExtra("picked",0)
        val pick:String=pickeddate.toString()
        picked_date.text=pick



        image.setOnClickListener {
            openGallery()
          // AutoPermissions.Companion.loadAllPermissions(this, 101);

        }

    }



    fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT // ACTION_GET_CONTENT - 데이터에서 하나의 콘텐트를 선택하여 반환

        startActivityForResult(intent, 101) // 등번호 101번
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101) {
            if (resultCode == Activity.RESULT_OK) {
                val fileUri = data!!.data


                val resolver = contentResolver // 리졸버 획득

                try {
                    val instream = resolver.openInputStream(fileUri!!) // 저장소의 URL에 연결하여 데이터를 가져옴
                    val imgBitmap = BitmapFactory.decodeStream(instream)
                    imageView.setImageBitmap(imgBitmap)

                    instream!!.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }

    fun onDenied(requestCode: Int, permissions: Array<String>) {

    }

    fun onGranted(requestCode: Int, permissions: Array<String>) {
    }


}
