package com.example.eoffice

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.eoffice.databinding.ActivityMainBinding
import com.example.eoffice.util.Utilities
import com.example.eoffice.view.fragment.disposition.AddDispositionFragment
import com.example.eoffice.view.fragment.disposition.DispositionInFragment
import com.example.eoffice.view.fragment.letter.AddLetterFragment
import com.example.eoffice.view.fragment.letter.InboxFragment
import com.example.eoffice.view.fragment.letter.OutboxFragment

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding!!.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.primaryColor)))
        this.title = "EOffice"

        toggle = ActionBarDrawerToggle(this, mBinding!!.drawerLayout, R.string.open, R.string.close)
        mBinding!!.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        changeFragment(DispositionInFragment())
        mBinding!!.navigationView.menu.getItem(1).isChecked = true

        mBinding!!.navigationView.setNavigationItemSelectedListener {
            mBinding!!.drawerLayout.closeDrawer(GravityCompat.START)
            when(it.itemId){
                R.id.action_add_letter -> {
                    changeFragment(AddLetterFragment())
                }
                R.id.action_inbox -> {
                    changeFragment(InboxFragment())
                }
                R.id.action_outbox -> {
                    changeFragment(OutboxFragment())
                }
                R.id.action_archive -> {
//                    changeFragment(ArchiveLetterFragment())
                    Utilities.showToast(this, "ArchiveLetterFragment")
                }
                R.id.action_add_disposition -> {
                    changeFragment(AddDispositionFragment())
                }
                R.id.action_disposition_in -> {
                    changeFragment(DispositionInFragment())
                }
                R.id.action_disposition_out -> {
//                    changeFragment(DispositionOutFragment())
                    Utilities.showToast(this, "DispositionOutFragment")
                }
                R.id.action_logout -> {
                    Utilities.showToast(this, "Logout")
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.rl_content, fragment)
        fragmentTransaction.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}