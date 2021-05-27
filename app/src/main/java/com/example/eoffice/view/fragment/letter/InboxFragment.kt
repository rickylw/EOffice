package com.example.eoffice.view.fragment.letter

import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eoffice.R
import com.example.eoffice.databinding.FragmentInboxBinding
import com.example.eoffice.util.Utilities
import com.example.eoffice.view.adapter.InboxAdapter

class InboxFragment : Fragment() {

    private var mBinding: FragmentInboxBinding? = null

    private val data: ArrayList<Array<String>> = arrayListOf()

    private lateinit var adapter: InboxAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentInboxBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListInbox()

        mBinding!!.srlInbox.setOnRefreshListener {
            Handler().postDelayed({
                if(mBinding!!.srlInbox.isRefreshing){
                    adapter.setData(data)
                    mBinding!!.rvInbox.adapter = adapter
                    mBinding!!.srlInbox.isRefreshing = false
                }
            }, 2000)
        }
    }

    private fun initListInbox() {
        adapter = InboxAdapter(requireActivity())

        data.add(arrayOf("Administrator", "admin bermasalah", "2 mei 2020", "ini pesan admin yang bermasalah"))
        data.add(arrayOf("Karyawan", "laporan karyawan tahunan", "1 mei 2020", "laporan terlampir"))

        mBinding!!.rvInbox.layoutManager = LinearLayoutManager(requireContext())
        adapter.setData(data)

        mBinding!!.rvInbox.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_inbox, menu)

        val subMenu = menu.findItem(R.id.filter_dinas).subMenu
        val dinasMenu = arrayOf("Semua", "Administrator", "Dinas Kelautan dan Perikanan")

        subMenu.clear()
        for (item in dinasMenu) {
            subMenu.add(0, 1, Menu.NONE, item).setOnMenuItemClickListener {
                menu.findItem(R.id.filter_dinas).title = "Dinas (${item})"
                Utilities.showToast(requireContext(), item)
                true
            }
        }
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
            R.id.filter_starred -> {
                Utilities.showToast(requireContext(), "Starred")
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