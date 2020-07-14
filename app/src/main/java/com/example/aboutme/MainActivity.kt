package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    private val MyName: MyName = MyName("Bill Gates")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName= MyName
        binding.doneButton.setOnClickListener()
        {
            addComment(it)
        }
    }

    private fun addComment(view: View)
    {
        val cmntEditText = findViewById<EditText>(R.id.comment_editText)
        val cmntText = findViewById<TextView>(R.id.comment_textView)

        binding.apply {
            myName?.comment= cmntEditText.text.toString()
            invalidateAll()
            cmntEditText.visibility = View.GONE
            view.visibility = View.GONE
            cmntText.visibility = VISIBLE
        }


        // hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }
}
