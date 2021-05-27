package com.example.eoffice.view.fragment.letter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.util.Pair
import com.example.eoffice.R
import com.example.eoffice.databinding.FragmentAddLetterBinding
import com.example.eoffice.view.fragment.ReceiverLetterFragment
import com.google.android.material.datepicker.MaterialCalendar.newInstance
import com.google.android.material.datepicker.MaterialDatePicker
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import net.dankito.richtexteditor.android.toolbar.AllCommandsEditorToolbar
import net.dankito.richtexteditor.command.CommandName
import java.util.*

class AddLetterFragment : Fragment() {

    private var mBinding: FragmentAddLetterBinding? = null

    private lateinit var receiverLetterFragment: ReceiverLetterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAddLetterBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initEditor()
        listenerExternalLetter()
        listenerPickDate()
        listenerPickReceiver()
    }

    private fun listenerPickReceiver() {
        mBinding!!.btnTambahPenerimaDinas.setOnClickListener{
            receiverLetterFragment = ReceiverLetterFragment(1)
            receiverLetterFragment.isCancelable = false
            receiverLetterFragment.show(
                childFragmentManager,
                receiverLetterFragment.tag
            )
        }

        mBinding!!.btnTambahPenerimaDinasAdministrator.setOnClickListener{
            receiverLetterFragment = ReceiverLetterFragment(0)
            receiverLetterFragment.isCancelable = false
            receiverLetterFragment.show(
                childFragmentManager,
                receiverLetterFragment.tag
            )
        }
    }

    private fun listenerPickDate() {
        mBinding!!.etTanggalSurat.setOnClickListener{
            val now = Calendar.getInstance()
            val currentYear = now.get(Calendar.YEAR)
            val currentMonth = now.get(Calendar.MONTH)
            val currentDay = now.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog.newInstance({ view, year, monthOfYear, dayOfMonth ->
                mBinding!!.etTanggalSurat.setText("${year}-${monthOfYear}-${dayOfMonth}")
            }, currentYear, currentMonth, currentDay)
            datePickerDialog.show(childFragmentManager, "Date Picker")
        }

        mBinding!!.etTanggalTerima.setOnClickListener{
            val now = Calendar.getInstance()
            val currentYear = now.get(Calendar.YEAR)
            val currentMonth = now.get(Calendar.MONTH)
            val currentDay = now.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog.newInstance({ view, year, monthOfYear, dayOfMonth ->
                mBinding!!.etTanggalTerima.setText("${year}-${monthOfYear}-${dayOfMonth}")
            }, currentYear, currentMonth, currentDay)

            datePickerDialog.show(childFragmentManager, "Date Picker")
        }
    }

    private fun listenerExternalLetter() {
        mBinding!!.cbSuratEksternal.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                mBinding!!.llSuratEksternal.visibility = View.VISIBLE
            }
            else{
                mBinding!!.llSuratEksternal.visibility = View.GONE
            }
        }
    }

    private fun initEditor() {
        mBinding!!.editor.setPadding(10)
        mBinding!!.editorToolbar.editor = mBinding!!.editor
        mBinding!!.editorToolbar.removeCommand(CommandName.BLOCKQUOTE)
        mBinding!!.editorToolbar.removeCommand(CommandName.FONTNAME)
        mBinding!!.editorToolbar.removeCommand(CommandName.FORMATBLOCK)
        mBinding!!.editorToolbar.removeCommand(CommandName.FONTSIZE)
        mBinding!!.editorToolbar.removeCommand(CommandName.BACKCOLOR)
        mBinding!!.editorToolbar.removeCommand(CommandName.FORECOLOR)
        mBinding!!.editorToolbar.removeCommand(CommandName.JUSTIFYLEFT)
        mBinding!!.editorToolbar.removeCommand(CommandName.JUSTIFYCENTER)
        mBinding!!.editorToolbar.removeCommand(CommandName.JUSTIFYRIGHT)
        mBinding!!.editorToolbar.removeCommand(CommandName.JUSTIFYFULL)
        mBinding!!.editorToolbar.removeCommand(CommandName.INSERTORDEREDLIST)
        mBinding!!.editorToolbar.removeCommand(CommandName.INSERTUNORDEREDLIST)
        mBinding!!.editorToolbar.removeCommand(CommandName.INSERTLINK)
        mBinding!!.editorToolbar.removeCommand(CommandName.INSERTIMAGE)
        mBinding!!.editorToolbar.removeCommand(CommandName.INSERTCHECKBOX)
        mBinding!!.editorToolbar.removeCommand(CommandName.BACKCOLOR)
        mBinding!!.editorToolbar.removeCommand(CommandName.FORECOLOR)
        mBinding!!.editorToolbar.removeSearchView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}