package com.juarez.androidhilt.ui.characters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.juarez.androidhilt.R
import com.juarez.androidhilt.data.adapters.CharactersAdapter
import com.juarez.androidhilt.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {
    private val viewModel: CharactersViewModel by viewModels()
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!
    private val charactersAdapter = CharactersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        Log.d("lifecycle", "onCreateView")

        binding.btnNavigate.setOnClickListener { onClick() }
        binding.recyclerCharacters.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = charactersAdapter
        }
        viewModel.getCharacters()
        viewModel.characters.observe(viewLifecycleOwner, {
            charactersAdapter.submitList(it)
        })
        viewModel.loading.observe(viewLifecycleOwner, {
            binding.progressCharacters.isVisible = it
        })
        return binding.root
    }

    private fun onClick() {
        findNavController().navigate(
            R.id.action_charactersFragment_to_usersFragment,
            bundleOf("id" to 1995)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("lifecycle", "onDestroyView")
    }
}