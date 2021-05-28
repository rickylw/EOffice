package com.example.eoffice.view.activity.letter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.eoffice.R
import com.example.eoffice.databinding.ActivityDetailLetterBinding

class DetailLetterActivity : AppCompatActivity() {

    private var mBinding: ActivityDetailLetterBinding? = null

    private var type = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailLetterBinding.inflate(layoutInflater)
        setContentView(mBinding!!.root)

        if(intent.hasExtra("type")){
            type = intent.getStringExtra("type")!!
        }

        if(type == "out"){
            mBinding!!.llPembatas2.visibility = View.GONE
            mBinding!!.llAction.visibility = View.GONE
            mBinding!!.ivStarred.visibility = View.GONE

            mBinding!!.tvTitlePengirim.text = "Tujuan"
            mBinding!!.llReceiver.visibility = View.VISIBLE
            mBinding!!.tvPengirim.visibility = View.GONE
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}