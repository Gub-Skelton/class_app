package com.example.classapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classapp.model.Archetype
import com.example.classapp.databinding.ArchetypeCardViewBinding

class ArchetypeAdapter(
    private val archetypes: List<Archetype>,
    private val onItemClick: (adapterPosition: Int) -> Unit
    ) :
    RecyclerView.Adapter<ArchetypeAdapter.ArchetypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchetypeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ArchetypeCardViewBinding.inflate(layoutInflater, parent, false)
        return ArchetypeViewHolder(binding) { position ->
            onItemClick(position)
        }
    }

    override fun getItemCount() = archetypes.size

    override fun onBindViewHolder(holder: ArchetypeViewHolder, position: Int) {
        val archetype = archetypes[position]
        holder.bind(archetype)
    }

    inner class ArchetypeViewHolder(
        private val binding: ArchetypeCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(archetype: Archetype) {
            Glide.with(binding.root)
                .load(archetype.image)
                .into(binding.archetypeImage)

            binding.archetypeName.text = archetype.archetypeName
            binding.archetypeDamageType.text = archetype.damageType
            binding.archetypeHealthDie.text = archetype.healthDie.toString()
        }
    }
}
