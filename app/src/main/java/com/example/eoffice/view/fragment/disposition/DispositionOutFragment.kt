package com.example.eoffice.view.fragment.disposition

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.eoffice.R
import com.example.eoffice.databinding.FragmentDispositionOutBinding
import com.example.eoffice.util.Utilities

class DispositionOutFragment : Fragment() {

    private var mBinding: FragmentDispositionOutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDispositionOutBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return mBinding!!.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_inbox, menu)

        menu.findItem(R.id.filter).isVisible = false
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}