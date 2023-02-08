package com.example.classapp;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class ArchetypeAdapter(private val archetypes: List<Archetype>) : RecyclerView.Adapter<ArchetypeAdapter.ArchetypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchetypeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.archetype_card_view, parent, false)
        return ArchetypeViewHolder(view)
    }

    override fun getItemCount() = archetypes.size

    override fun onBindViewHolder(holder: ArchetypeViewHolder, position: Int) {
        val archetype = archetypes[position]
        holder.archetypeImage.setImageResource(archetype.image)
        holder.archetypeName.text = archetype.archetypeName
        holder.archetypeDamageType.text = archetype.damageType
        holder.archetypeHealthDie.text = archetype.healthDie.toString()
        holder.archetypePosition.text = archetype.position
        holder.archetypeFunLevel.text = archetype.funLevel.toString()
        holder.archetypeComplexity.text = archetype.complexity
    }

    class ArchetypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val archetypeImage: ImageView = itemView.findViewById(R.id.archetype_image)
        val archetypeName: TextView = itemView.findViewById(R.id.archetype_name)
        val archetypeDamageType: TextView = itemView.findViewById(R.id.archetype_damage_type)
        val archetypeHealthDie: TextView = itemView.findViewById(R.id.archetype_health_die)
        val archetypePosition: TextView = itemView.findViewById(R.id.archetype_position)
        val archetypeFunLevel: TextView = itemView.findViewById(R.id.archetype_fun_level)
        val archetypeComplexity: TextView = itemView.findViewById(R.id.archetype_complexity)
    }
}
