package com.example.eoffice.view.activity.letter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eoffice.R
import com.example.eoffice.databinding.ActivityDetailLetterBinding

class DetailLetterActivity : AppCompatActivity() {

    private var mBinding: ActivityDetailLetterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailLetterBinding.inflate(layoutInflater)
        setContentView(mBinding!!.root)

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