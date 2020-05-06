package com.s.smkcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var namaInput:String=""
    private var emailInput:String=""
    private var umurInput:String=""
    private var telpInput:String=""
    private var alamatInput:String=""
    private var genderInput:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()

        btnsave.setOnClickListener{validasiInput()}
    }
    private fun setDataSpinnerGender(){
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.jenis_kelamin,android.R.layout.simple_spinner_dropdown_item)
        spinnergender.adapter = adapter
    }

    private fun validasiInput(){
            namaInput   = edtName.text.toString()
            emailInput  = edtEmail.text.toString()
            umurInput   = edtAge.text.toString()
            telpInput   = edtNotelp.text.toString()
            alamatInput = edtalamat.text.toString()
            genderInput = spinnergender.selectedItem.toString()
        when{
            namaInput.isEmpty() -> edtName.error="Nama Tidak Boleh Kosong"
            genderInput.equals("Pilih Jenis Kelamin",ignoreCase = true) ->
                tampilToast("Jenis Kelamin harus di pilih")
            emailInput.isEmpty() -> edtEmail.error="Email Tidak Boleh Kosong"
            umurInput.isEmpty() -> edtAge.error="Umur Harus Di isi"
            telpInput.isEmpty() -> edtNotelp.error="Nomor Telepon Harap di Isi"
            alamatInput.isEmpty() -> edtalamat.error="Alamat Harus di isi"

            else -> {
                tampilToast("Navigasi ke Halaman Profil")
               goToProfilActivity()
            }
        }
    }

    private fun tampilToast(Message: String) {
        Toast.makeText(this,Message,Toast.LENGTH_SHORT).show()
    }


    private fun goToProfilActivity() {
        val intent = Intent(this,ProfilActivity::class.java )

        val bundle = Bundle()
        bundle.putString("Nama",namaInput)
        bundle.putString("Gender",genderInput)
        bundle.putString("Email",emailInput)
        bundle.putString("Umur",umurInput)
        bundle.putString("Telepon",telpInput)
        bundle.putString("Alamat",alamatInput)
        intent.putExtras(bundle)

        startActivity(intent)
    }
}
