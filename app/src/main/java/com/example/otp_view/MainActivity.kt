package com.example.otp_view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var otp_textbox_one: EditText
    lateinit var otp_textbox_two: EditText
    lateinit var otp_textbox_three: EditText
    lateinit var otp_textbox_four: EditText
    lateinit var verify_otp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        otp_textbox_one = findViewById(R.id.otp_edit_box1);
        otp_textbox_two = findViewById(R.id.otp_edit_box2);
        otp_textbox_three = findViewById(R.id.otp_edit_box3);
        otp_textbox_four = findViewById(R.id.otp_edit_box4);
        verify_otp = findViewById(R.id.verify_otp_btn);


        val edit = arrayOf(otp_textbox_one, otp_textbox_two, otp_textbox_three, otp_textbox_four)

        otp_textbox_one.addTextChangedListener(GenericTextWatcher(otp_textbox_one, edit))
        otp_textbox_two.addTextChangedListener(GenericTextWatcher(otp_textbox_two, edit))
        otp_textbox_three.addTextChangedListener(GenericTextWatcher(otp_textbox_three, edit))
        otp_textbox_four.addTextChangedListener(GenericTextWatcher(otp_textbox_four, edit))

        verify_otp.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Your enter code: ${otp_textbox_one.text}${otp_textbox_two.text}${otp_textbox_three.text}${otp_textbox_four.text}",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

}