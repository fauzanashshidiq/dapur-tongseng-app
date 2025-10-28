package com.example.dapurtongseng.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.dapurtongseng.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dapurtongseng.databinding.FragmentOrderBinding
import com.example.dapurtongseng.SharedViewModel

class OrderFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
private var _binding: FragmentOrderBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val orderViewModel =
            ViewModelProvider(this).get(OrderViewModel::class.java)

    _binding = FragmentOrderBinding.inflate(inflater, container, false)
    val root: View = binding.root

      sharedViewModel.fullName.observe(viewLifecycleOwner) { name ->
          binding.tvOrderGreeting.text = if (!name.isNullOrEmpty()) "Halo, $name!" else "Halo, Pelanggan!"
      }

      binding.btnAddOrder.setOnClickListener {
          findNavController().navigate(R.id.navigation_home)
      }

      return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}