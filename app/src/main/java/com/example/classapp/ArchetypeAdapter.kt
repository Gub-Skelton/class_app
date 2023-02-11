package com.example.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classapp.ui.ArchetypeDetailFragment

class ArchetypeAdapter(private val archetypes: List<Archetype>) :
    RecyclerView.Adapter<ArchetypeAdapter.ArchetypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchetypeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.archetype_card_view, parent, false)
        return ArchetypeViewHolder(view) { position ->
            val archetype = archetypes[position]

            val bundle = bundleOf(
                "archetypeName" to archetype.archetypeName,
                "damageType" to archetype.damageType,
                "archetypeHealthDie" to archetype.healthDie,
                "archetypeImage" to archetype.image,
                "archetypePosition" to archetype.position,
                "archetypeFunLevel" to archetype.funLevel,
                "archetypeComplexity" to archetype.complexity,
                "archetypePlayable" to archetype.playable,
                "archetypeDescription" to archetype.description
            )
            val detailFragment = ArchetypeDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = archetypes.size

    override fun onBindViewHolder(holder: ArchetypeViewHolder, position: Int) {
        val archetype = archetypes[position]
        //holder.archetypeImage.setImageResource(archetype.image)
        Glide.with(holder.itemView)
            .load(archetype.image)
            .into(holder.archetypeImage)
        holder.archetypeName.text = archetype.archetypeName
        holder.archetypeDamageType.text = archetype.damageType
        holder.archetypeHealthDie.text = archetype.healthDie.toString()
//        holder.archetypePosition.text = archetype.position
//        holder.archetypeFunLevel.text = archetype.funLevel.toString()
//        holder.archetypeComplexity.text = archetype.complexity
//        holder.archetypePlayable.text = archetype.playable.toString()
    }

    inner class ArchetypeViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val archetypeImage: ImageView = itemView.findViewById(R.id.archetype_image)
        val archetypeName: TextView = itemView.findViewById(R.id.archetype_name)
        val archetypeDamageType: TextView = itemView.findViewById(R.id.archetype_damage_type)
        val archetypeHealthDie: TextView = itemView.findViewById(R.id.archetype_health_die)
//        val archetypePosition: TextView = itemView.findViewById(R.id.archetype_position)
//        val archetypeFunLevel: TextView = itemView.findViewById(R.id.archetype_fun_level)
//        val archetypeComplexity: TextView = itemView.findViewById(R.id.archetype_complexity)
//        val archetypePlayable: TextView = itemView.findViewById(R.id.archetype_playable)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }
}
