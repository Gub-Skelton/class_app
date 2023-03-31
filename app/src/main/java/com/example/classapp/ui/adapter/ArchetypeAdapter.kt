package com.example.classapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.classapp.databinding.ArchetypeCardViewBinding
import com.example.classapp.model.DnDClass
import com.example.classapp.model.DnDClassDetails

class ArchetypeAdapter(
    private val onItemClick: (archetype: DnDClass, adapterPosition: Int) -> Unit,
) : RecyclerView.Adapter<ArchetypeAdapter.ArchetypeViewHolder>() {
    init {
        setHasStableIds(true)
    }

    private val archetypesList = mutableListOf<DnDClass>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(newArchetypes: List<DnDClass>) {
        archetypesList.clear()
        archetypesList.addAll(newArchetypes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchetypeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ArchetypeCardViewBinding.inflate(layoutInflater, parent, false)
        return ArchetypeViewHolder(binding) { position ->
            onItemClick(archetypesList[position], position)
        }
    }

    override fun getItemCount() = archetypesList.size
    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: ArchetypeViewHolder, position: Int) {
        val archetype = archetypesList[position]

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

        fun bind(archetype: DnDClass) {
            binding.archetypeName.text = archetype.name
        }
//        fun bind(archetype: DnDClassDetails){
//            binding.archetypeName.text = archetype.name
//            binding.hitDie.text = archetype.hitDie
//            binding.proficiencyChoices.text = archetype.proficiencyChoices.toString()
//            binding.savingThrows.text = archetype.savingThrows.toString()
//            binding.subclasses.text = archetype.subclasses.toString()
//
//        }
    }
}
