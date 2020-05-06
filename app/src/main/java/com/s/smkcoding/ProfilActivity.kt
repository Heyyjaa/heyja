package com.s.smkcoding

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*


class ProfilActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        ambilData()

        btnedit.setOnClickListener{ navigasiKeEditProfil()}

        btnpangil.setOnClickListener {  dialPhoneNumber(txtnotelepon.text.toString())  }
        btnabout.setOnClickListener { About() }
    }


    private fun ambilData() {
        val bundle = intent.extras

        val nama = bundle?.getString("Nama")
        val gender= bundle?.getString("Gender")
        val email= bundle?.getString("Email")
        val umur = bundle?.getString("Umur")
        val telp = bundle?.getString("Telepon")
        var alamat = bundle?.getString("Alamat")

        txtNama.text    =   nama
        txtjeniskelamin.text = gender
        txtEmail.text = email
        txtage.text = umur
        txtnotelepon.text = telp
        txtalamat.text = alamat

    }
    companion object {
        val REQUEST_CODE = 100
    }
    private fun navigasiKeEditProfil() {
        val intent = Intent(this,EditActivity::class.java)

        val namaUser = txtNama.text.toString()
        intent.putExtra("Nama",namaUser)

        startActivityForResult(intent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== REQUEST_CODE){
            if(resultCode==Activity.RESULT_OK){

                val result  = data?.getStringExtra("Nama")
                txtNama.text= result
            } else{
                Toast.makeText(this,"Edit Failed",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

private fun About(){
    val intent = Intent(this,AboutActivity::class.java)
    val namaUser=txtNama.text.toString()
    val email=txtEmail.text.toString()
    val umur =  txtage.text.toString()
    val telp    = txtnotelepon.text.toString()
    val alamat = txtalamat.text.toString()
    intent.putExtra("nama",namaUser)
    intent.putExtra("email",email)
    intent.putExtra("umur",umur)
    intent.putExtra("telp",telp)
    intent.putExtra("alamat",alamat)
    startActivity(intent)
}


    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {     data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)     }
            }

    }



