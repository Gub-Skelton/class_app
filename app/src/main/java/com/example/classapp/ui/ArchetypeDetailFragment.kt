package com.example.classapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.classapp.databinding.FragmentArchetypeDetailBinding
import com.example.classapp.viewmodel.ArchetypeDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ArchetypeDetailFragment(index: String) : Fragment() {
    private var _binding: FragmentArchetypeDetailBinding? = null
    private val binding get() = _binding!!
    private val archetypeDetailViewModel: ArchetypeDetailViewModel by activityViewModels()
    private val archetypeIndex = index

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArchetypeDetailBinding.inflate(inflater, container, false)

        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        archetypeDetailViewModel.fillDataDetail(archetypeIndex)
    }

    companion object {
        private const val BUNDLE_ID = "id"
        fun newInstance(index : String): ArchetypeDetailFragment {
            val detailFragment = ArchetypeDetailFragment(index)
            detailFragment.arguments = bundleOf(BUNDLE_ID to index)
            return detailFragment
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupObservers() {
        lifecycleScope.launch {
            archetypeDetailViewModel.archetype.collect { event ->
                when (event) {
                    ArchetypeDetailViewModel.DnDEventDetail.Failure -> {
                        binding.progressBar.isGone = true
                        Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
                    }
                    ArchetypeDetailViewModel.DnDEventDetail.Loading -> {
                        binding.progressBar.isVisible = true
                        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    }
                    is ArchetypeDetailViewModel.DnDEventDetail.Success -> {
                        binding.progressBar.isGone = true
                        val archetype = event.archetype.body()
                        if (archetype != null) {

                            binding.archetypeName.text = archetype.name
                            binding.hitDie.text = archetype.hitDie.toString()

                            var temp = ""
                            binding.proficiencies.text = ""
                            for (i in archetype.proficiencies) {
                                temp = binding.proficiencies.text.toString()
                                binding.proficiencies.text = temp + i.name + "\n"
                            }

                            binding.subclasses.text = ""
                            for (i in archetype.subclasses) {
                                temp = binding.subclasses.text.toString()
                                binding.subclasses.text = temp + i.name + "\n"
                            }
                        }
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

