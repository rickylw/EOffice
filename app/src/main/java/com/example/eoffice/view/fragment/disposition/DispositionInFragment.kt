package com.example.eoffice.view.fragment.disposition

import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eoffice.R
import com.example.eoffice.databinding.FragmentDispositionInBinding
import com.example.eoffice.util.Utilities
import com.example.eoffice.view.adapter.DispositionInAdapter
import com.example.eoffice.view.adapter.InboxAdapter

class DispositionInFragment : Fragment() {

    private var mBinding: FragmentDispositionInBinding? = null

    private val data: ArrayList<Array<String>> = arrayListOf()

    private lateinit var adapter: DispositionInAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDispositionInBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListInbox()

        mBinding!!.srlDispositionIn.setOnRefreshListener {
            Handler().postDelayed({
                if(mBinding!!.srlDispositionIn.isRefreshing){
                    adapter.setData(data)
                    mBinding!!.rvDispositionIn.adapter = adapter
                    mBinding!!.srlDispositionIn.isRefreshing = false
                }
            }, 2000)
        }
    }

    private fun initListInbox() {
        adapter = DispositionInAdapter(requireActivity())

        data.add(arrayOf("Administrator", "admin bermasalah", "2 mei 2020", "ini pesan admin yang bermasalah"))
        data.add(arrayOf("Karyawan", "laporan karyawan tahunan", "1 mei 2020", "laporan terlampir"))

        mBinding!!.rvDispositionIn.layoutManager = LinearLayoutManager(requireContext())
        adapter.setData(data)

        mBinding!!.rvDispositionIn.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_inbox, menu)

        menu.findItem(R.id.filter_starred).isVisible = false
        menu.findItem(R.id.filter_dinas).isVisible = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.filter_all -> {
                Utilities.showToast(requireContext(), "Semua")
                true
            }
            R.id.filter_read -> {
                Utilities.showToast(requireContext(), "Dibaca")
                true
            }
            R.id.filter_unread -> {
                Utilities.showToast(requireContext(), "Belum dibaca")
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}