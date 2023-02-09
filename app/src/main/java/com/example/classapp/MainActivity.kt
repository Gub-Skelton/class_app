package com.example.classapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.archetype_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val archetypes = mutableListOf<Archetype>()

        for(i in 0 ..  30){
            archetypes.add(createArchetypes())
        }
        val adapter = ArchetypeAdapter(archetypes)
        recyclerView.adapter = adapter
    }

    private fun createArchetypes() = Archetype(
        archetypeName = "Greg",
        damageType = "Physical",
        image = R.drawable.cat,
        healthDie = Random.nextInt(1,12),
        position = "Frontline",
        funLevel = Random.nextInt(1, 10),
        complexity = "Easy",
        playable = true,
    )

}