package com.example.dapurtongseng.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurtongseng.ListMenuAdapter
import com.example.dapurtongseng.Menu
import com.example.dapurtongseng.OrderActivity
import com.example.dapurtongseng.R
import com.example.dapurtongseng.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val list = ArrayList<Menu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        list.addAll(getListMenu())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fullName = arguments?.getString("FULL_NAME")

        if (fullName != null && fullName.isNotEmpty()) {
            binding.tvWelcomeName.text = "Selamat Datang, $fullName!"
        } else {
            binding.tvWelcomeName.text = "Selamat Datang di Dapur Tongseng!"
        }

        val rvMenu: RecyclerView = binding.rvMenu
        rvMenu.setHasFixedSize(true)

        showRecyclerList(rvMenu)
    }

    private fun getListMenu(): ArrayList<Menu> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listMenu = ArrayList<Menu>()
        for (i in dataName.indices) {
            val menu = Menu(dataName[i], dataDescription[i], dataPhoto[i])
            listMenu.add(menu)
        }
        return listMenu
    }

    private fun showRecyclerList(rvMenu: RecyclerView) {
        rvMenu.layoutManager = LinearLayoutManager(context)
        val listMenuAdapter = ListMenuAdapter(list)
        rvMenu.adapter = listMenuAdapter

        listMenuAdapter.setOnItemClickCallback(object : ListMenuAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Menu) {
                showSelectedMenu(data)
            }
        })
    }

    private fun showSelectedMenu(menu: Menu) {
        val intent = Intent(requireContext(), OrderActivity::class.java)
        intent.putExtra("FULL_NAME", arguments?.getString("FULL_NAME"))
        intent.putExtra("MENU_NAME", menu.name)
        intent.putExtra("MENU_DESC", menu.description)
        intent.putExtra("MENU_PHOTO", menu.photo)
        startActivity(intent)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}