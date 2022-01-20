package com.juarez.androidhilt.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.juarez.androidhilt.data.adapters.UsersAdapter
import com.juarez.androidhilt.databinding.FragmentUsersBinding
import com.juarez.androidhilt.data.models.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment() {
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UsersViewModel by viewModels()

    private val usersAdapter = UsersAdapter(arrayListOf()) {
        Toast.makeText(requireContext(), it.id.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        arguments?.getInt("id")?.let {
            binding.txtValue.text = it.toString()
        }

        binding.recyclerUsers.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = usersAdapter
        }
        binding.btnAddUser.setOnClickListener {
            viewModel.saveUser(User(name = "Jose"))
        }
        binding.btnDeleteAll.setOnClickListener {
            viewModel.deleteUsers()
        }

        viewModel.users.observe(viewLifecycleOwner, {
            usersAdapter.updateData(it)
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}