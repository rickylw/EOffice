package com.example.eoffice.view.fragment.disposition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eoffice.R
import com.example.eoffice.databinding.FragmentAddDispositionBinding
import com.example.eoffice.view.fragment.ReceiverLetterFragment

class AddDispositionFragment : Fragment() {

    private var mBinding: FragmentAddDispositionBinding? = null

    private lateinit var receiverLetterFragment: ReceiverLetterFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAddDispositionBinding.inflate(layoutInflater, container, false)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listenerPickDate()
    }

    private fun listenerPickDate() {
        mBinding!!.btnTambahPenerimaDinas.setOnClickListener{
            receiverLetterFragment = ReceiverLetterFragment(1)
            receiverLetterFragment.isCancelable = false
            receiverLetterFragment.show(
                childFragmentManager,
                receiverLetterFragment.tag
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}