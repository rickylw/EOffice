package com.example.eoffice.view.activity.disposition

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.eoffice.R
import com.example.eoffice.databinding.ActivityDetailDispositionBinding
import com.example.eoffice.databinding.CustomDialogLampiranTerkaitBinding
import com.example.eoffice.util.Utilities
import java.util.*

class DetailDispositionActivity : AppCompatActivity() {

    private var mBinding: ActivityDetailDispositionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailDispositionBinding.inflate(layoutInflater)
        setContentView(mBinding!!.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_disposition_in, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_lampiran_terkait -> {
                showRelatedAttachments()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun showRelatedAttachments() {
        val binding: CustomDialogLampiranTerkaitBinding = CustomDialogLampiranTerkaitBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this)
            .setView(binding.root)

        binding.btnPrintLampiranSurat.setOnClickListener{
            Utilities.showToast(this, "Print Lampiran Surat")
        }

        binding.btnPrintLembarDisposisi.setOnClickListener{
            Utilities.showToast(this, "Print Lembar Disposisi")
        }

        builder.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}