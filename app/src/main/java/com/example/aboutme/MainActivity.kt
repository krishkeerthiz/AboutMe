package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener()
        {
            addComment(it)
        }
    }

    private fun addComment(view: View)
    {
        val cmntEditText = findViewById<EditText>(R.id.comment_editText)
        val cmntText = findViewById<TextView>(R.id.comment_textView)

        cmntText.text = cmntEditText.text
        cmntEditText.visibility = View.GONE
        view.visibility = View.GONE
        cmntText.visibility = VISIBLE

        // hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }
}
