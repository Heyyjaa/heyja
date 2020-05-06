package com.s.smkcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val intendData= intent.extras
        val namaUser = intendData?.getString("nama")
        val emailUser = intendData?.getString("email")
        val umur = intendData?.getString("umur")
        val telp = intendData?.getString("telp")
        val alamat  = intendData?.getString("alamat")

        txtNama.setText(namaUser)
        txtEmail.setText(emailUser)
        txtage.setText(umur)
        txtnotelepon.setText(telp)
        txtalamat.setText(alamat)

    }
}
