package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classapp.model.Archetype
import com.example.classapp.R
import com.example.classapp.ui.adapter.ArchetypeAdapter
import com.example.classapp.databinding.FragmentArchetypeListBinding
import com.example.classapp.viewmodel.ArchetypeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random
@AndroidEntryPoint
class ArchetypeListFragment : Fragment() {

    private val archetypeViewModel: ArchetypeViewModel by activityViewModels()

    private var _binding: FragmentArchetypeListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArchetypeListBinding.inflate(inflater, container, false)

        binding.archetypeRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val archetypes = archetypeViewModel.fillData()

        val adapter = ArchetypeAdapter(archetypes){position ->
            val archetype = archetypes[position]

            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, ArchetypeDetailFragment.newInstance(archetype.id))
                addToBackStack(null)
            }
        }
        binding.archetypeRecyclerView.adapter = adapter
        //recyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}