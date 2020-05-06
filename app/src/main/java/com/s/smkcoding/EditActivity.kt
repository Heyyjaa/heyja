package com.s.smkcoding

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*


class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val intentData = intent.extras
        val namaUser = intentData?.getString("Nama")

        edtEditName.setText(namaUser)

        btnsaveedit.setOnClickListener{saveData()}

    }

    private fun saveData() {
        val namaEdit= edtEditName.text.toString()
        if (!namaEdit.isEmpty()){
            val result = Intent()

            result.putExtra("Nama",namaEdit)
            setResult(Activity.RESULT_OK,result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}



