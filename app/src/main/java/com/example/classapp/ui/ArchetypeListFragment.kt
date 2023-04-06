package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.manager.LifecycleListener
import com.example.classapp.R
import com.example.classapp.ui.adapter.ArchetypeAdapter
import com.example.classapp.databinding.FragmentArchetypeListBinding
import com.example.classapp.viewmodel.ArchetypeViewModel
import com.example.classapp.viewmodel.ArchetypeViewModelOld
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ArchetypeListFragment : Fragment() {

    private var _binding: FragmentArchetypeListBinding? = null
    private val binding get() = _binding!!
    private val archetypeViewModel: ArchetypeViewModel by activityViewModels()

    private val archetypeAdapter = ArchetypeAdapter { archetype, _ ->
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container_view,
                ArchetypeDetailFragment.newInstance(archetype.index),
            )
            addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArchetypeListBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.archetypeRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = archetypeAdapter
        }
        archetypeViewModel.fillData()
    }

private fun setupObservers() {
    lifecycleScope.launch {
        archetypeViewModel.archetypes.collect { event ->
            when (event) {
                ArchetypeViewModel.DnDEvent.Failure -> {
                    binding.progressBar.isGone = true
                    binding.archetypeRecyclerView.isGone = true
                    Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
                }
                ArchetypeViewModel.DnDEvent.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.archetypeRecyclerView.isGone = true
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                }
                is ArchetypeViewModel.DnDEvent.Success -> {
                    archetypeAdapter.refreshData(event.archetypes)
                    binding.progressBar.isGone = true
                    binding.archetypeRecyclerView.isVisible = true
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

override fun onDestroy() {
    super.onDestroy()
    _binding = null
}
}