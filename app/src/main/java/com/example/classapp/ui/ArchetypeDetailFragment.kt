package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.classapp.R
import com.example.classapp.databinding.FragmentArchetypeDetailBinding
import com.example.classapp.databinding.FragmentArchetypeListBinding
import com.example.classapp.viewmodel.ArchetypeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArchetypeDetailFragment : Fragment() {
    private var _binding: FragmentArchetypeDetailBinding? = null
    private val binding get() = _binding!!

    private val archetypeViewModel: ArchetypeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArchetypeDetailBinding.inflate(inflater, container, false)

        val archetype = archetypeViewModel.fetchById(requireArguments().getInt(BUNDLE_ID))

        binding.archetypeName.text = archetype.archetypeName
        binding.archetypeDamageType.text = archetype.damageType
        binding.archetypeHealthDie.text = archetype.healthDie.toString()
        binding.archetypePosition.text = archetype.position
        binding.archetypeFunLevel.text = archetype.funLevel.toString()
        binding.archetypeComplexity.text = archetype.complexity
        binding.archetypePlayable.text = archetype.playable.toString()
        binding.archetypeDescription.text = archetype.description
        Glide.with(binding.root)
                .load(archetype.image)
                .into(binding.archetypeImage)

//        if (arguments != null) {
//            val archetypeName = requireArguments().getString("archetypeName")
//            val damageType = requireArguments().getString("damageType")
//            val archetypeHealthDie = requireArguments().getInt("archetypeHealthDie")
//            val archetypePosition = requireArguments().getString("archetypePosition")
//            val archetypeFunLevel = requireArguments().getInt("archetypeFunLevel")
//            val archetypeComplexity = requireArguments().getString("archetypeComplexity")
//            val archetypePlayable = requireArguments().getBoolean("archetypePlayable")
//            val archetypeDescription = requireArguments().getString("archetypeDescription")
//            val archetypeImage = requireArguments().getString("archetypeImage")
//
//            binding.archetypeName.text = archetypeName
//            binding.archetypeDamageType.text = damageType
//            binding.archetypeHealthDie.text = archetypeHealthDie.toString()
//            binding.archetypePosition.text = archetypePosition
//            binding.archetypeFunLevel.text = archetypeFunLevel.toString()
//            binding.archetypeComplexity.text = archetypeComplexity
//            binding.archetypePlayable.text = archetypePlayable.toString()
//            binding.archetypeDescription.text = archetypeDescription
//
//            Glide.with(binding.root)
//                .load(archetypeImage)
//                .into(binding.archetypeImage)
//
//
//        }
        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "id"
        fun newInstance(id: Int): ArchetypeDetailFragment {
            val detailFragment = ArchetypeDetailFragment()
            detailFragment.arguments = bundleOf(BUNDLE_ID to id)
            return detailFragment
        }
    }

}