package com.example.eoffice.view.fragment.disposition

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.eoffice.R
import com.example.eoffice.databinding.FragmentDispositionOutBinding
import com.example.eoffice.util.Utilities
import com.example.eoffice.view.activity.disposition.DetailDispositionActivity

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding!!.rlMessage.setOnClickListener{
            val intent = Intent(requireContext(), DetailDispositionActivity::class.java)
            intent.putExtra("type", "out")
            startActivity(intent)
        }
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