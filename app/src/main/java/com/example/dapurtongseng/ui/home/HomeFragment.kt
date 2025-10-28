package com.example.dapurtongseng.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurtongseng.ListMenuAdapter
import com.example.dapurtongseng.Menu
import com.example.dapurtongseng.OrderActivity
import com.example.dapurtongseng.SharedViewModel
import com.example.dapurtongseng.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.fullName.observe(viewLifecycleOwner) { name ->
            binding.tvWelcomeName.text = if (!name.isNullOrEmpty()) "Selamat Datang, $name!" else "Selamat Datang di Dapur Tongseng!"
        }

        val rvMenu: RecyclerView = binding.rvMenu
        rvMenu.layoutManager = LinearLayoutManager(context)
        rvMenu.setHasFixedSize(true)

        val listMenuAdapter = ListMenuAdapter(arrayListOf())
        rvMenu.adapter = listMenuAdapter

        // Ambil data dari ViewModel
        homeViewModel.loadMenu(requireContext())

        // Observe LiveData dari ViewModel
        homeViewModel.menuList.observe(viewLifecycleOwner) { menuList ->
            listMenuAdapter.updateData(menuList)
        }

        // Event klik item menu
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
