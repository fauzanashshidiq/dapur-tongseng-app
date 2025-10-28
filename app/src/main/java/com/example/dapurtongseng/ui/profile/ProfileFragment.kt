package com.example.dapurtongseng.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.dapurtongseng.SharedViewModel
import com.example.dapurtongseng.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.fullName.observe(viewLifecycleOwner) { name ->
            binding.textProfile.text = if (!name.isNullOrEmpty()) "Nama Pengguna: $name" else "Nama Pengguna: Pelanggan"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
