package com.example.eoffice.view.fragment.letter

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eoffice.R
import com.example.eoffice.databinding.FragmentOutboxBinding
import com.example.eoffice.util.Utilities
import com.example.eoffice.view.adapter.InboxAdapter
import com.example.eoffice.view.adapter.OutboxAdapter

class OutboxFragment : Fragment() {

    private var mBinding: FragmentOutboxBinding? = null

    private val data: ArrayList<Array<String>> = arrayListOf()

    private lateinit var adapter: OutboxAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentOutboxBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListOutbox()

    }

    private fun initListOutbox() {
        adapter = OutboxAdapter(requireActivity())

        data.add(arrayOf("admin bermasalah", "10:30", "ini pesan admin yang bermasalah"))
        data.add(arrayOf("laporan karyawan tahunan", "12:49", "laporan terlampir"))

        mBinding!!.rvOutbox.layoutManager = LinearLayoutManager(requireContext())
        adapter.setData(data)

        mBinding!!.rvOutbox.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_inbox, menu)

        menu.findItem(R.id.filter_read).isVisible = false
        menu.findItem(R.id.filter_unread).isVisible = false
        menu.findItem(R.id.filter_starred).isVisible = false

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