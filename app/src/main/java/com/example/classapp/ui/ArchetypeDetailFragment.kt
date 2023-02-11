package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import com.bumptech.glide.Glide
import com.example.classapp.R

class ArchetypeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_archetype_detail, container, false)

        if (arguments != null) {
            val archetypeName = requireArguments().getString("archetypeName")
            val damageType = requireArguments().getString("damageType")
            val archetypeHealthDie = requireArguments().getInt("archetypeHealthDie")
            val archetypePosition = requireArguments().getString("archetypePosition")
            val archetypeFunLevel = requireArguments().getInt("archetypeFunLevel")
            val archetypeComplexity = requireArguments().getString("archetypeComplexity")
            val archetypePlayable = requireArguments().getBoolean("archetypePlayable")
            val archetypeDescription = requireArguments().getString("archetypeDescription")
            val archetypeImage = requireArguments().getString("archetypeImage")



            view.findViewById<TextView>(R.id.archetype_name).text = archetypeName
            view.findViewById<TextView>(R.id.archetype_damage_type).text = damageType
            view.findViewById<TextView>(R.id.archetype_health_die).text =
                archetypeHealthDie.toString()
            view.findViewById<TextView>(R.id.archetype_position).text = archetypePosition
            view.findViewById<TextView>(R.id.archetype_fun_level).text =
                archetypeFunLevel.toString()
            view.findViewById<TextView>(R.id.archetype_complexity).text = archetypeComplexity
            view.findViewById<TextView>(R.id.archetype_playable).text = archetypePlayable.toString()
            view.findViewById<TextView>(R.id.archetype_description).text = archetypeDescription
            Glide.with(view)
                .load(archetypeImage)
                .into(view.findViewById<ImageView>(R.id.archetype_image))
        }
        return view
    }
}