package com.example.classapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classapp.Archetype
import com.example.classapp.R
import com.example.classapp.ArchetypeAdapter
import kotlin.random.Random

class ArchetypeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_archetype_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.archetype_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val archetypes = mutableListOf<Archetype>()

        createAllArchetypes(archetypes)

        val adapter = ArchetypeAdapter(archetypes)
        recyclerView.adapter = adapter

        return view
    }
    //Creates each archetype with basic properties
    private fun createAllArchetypes(archetypes: MutableList<Archetype>) {
        archetypes.add(
            Archetype(
                archetypeName = "Barbarian",
                damageType = "Physical",
                image = "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/a314a7114066983.60345f2b97724.png",
                healthDie = Random.nextInt(100, 1000),
                position = "Frontline",
                funLevel = Random.nextInt(10, 20),
                complexity = "Easy",
                playable = true,
                description = "A fierce powerful warrior of primitive background who enters the battle in a fit of rage. The best in my opinion."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Bard",
                damageType = "Magical",
                image = "https://media.istockphoto.com/id/1300717634/vector/mandolin-vintage-engraved-illustration-stylized-graphic-arts-hand-drawn-vector-sketch.jpg?s=612x612&w=0&k=20&c=qXJheU5ItQufi-0MRbJpQ6M1ecGJgI2CI2Eb0-UVZnU=",
                healthDie = Random.nextInt(10, 100),
                position = "Backline",
                funLevel = Random.nextInt(1, 20),
                complexity = "Complex",
                playable = true,
                description = "An inspiring muscician whose power echoes through the power of music and creation."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Cleric",
                damageType = "Magical",
                image = "https://oldschool.runescape.wiki/images/thumb/Holy_symbol_detail.png/800px-Holy_symbol_detail.png?dae8d",
                healthDie = Random.nextInt(50, 300),
                position = "Middle-line",
                funLevel = Random.nextInt(5, 20),
                complexity = "Medium",
                playable = true,
                description = "A priest champion who wields divine magic in service of a higher power."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Druid",
                damageType = "Magical",
                image = "https://img.freepik.com/premium-vector/wooden-staff-magical-stick-doodle-isolated-icon-sketch-druid-sorcerer-staff-comic-style-image-hand-drawn-isolated-lineart-image-prints-designs-cards-books-stickers-posters_44769-2841.jpg?w=2000",
                healthDie = Random.nextInt(50, 200),
                position = "Middle-line",
                funLevel = Random.nextInt(1, 20),
                complexity = "Complex",
                playable = true,
                description = "A priest of the old faith, wielding powers powers of nature and adopting animal forms."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Fighter",
                damageType = "Physical",
                image = "https://media.istockphoto.com/id/1282748614/vector/sword-vector-illustration-icon-crossed-swords-military-or-heraldry-symbol-protection-and.jpg?s=1024x1024&w=is&k=20&c=8ByTGdVKg66CyN3BbLYXYkhhMd1idFnX_uNe7uGMYAs=",
                healthDie = Random.nextInt(100, 500),
                position = "Frontline",
                funLevel = Random.nextInt(5, 20),
                complexity = "Easy",
                playable = true,
                description = "A master of martial combat, skilled with a wide variety of weapons and fighting styles."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Monk",
                damageType = "Physical",
                image = "https://static.vecteezy.com/system/resources/previews/007/506/316/original/illustration-of-punch-and-fist-free-vector.jpg",
                healthDie = Random.nextInt(100, 300),
                position = "Frontline",
                funLevel = Random.nextInt(5, 20),
                complexity = "Medium",
                playable = true,
                description = "A master of martial arts, harnessing the power of the body in pursuit of physical and spiritual perfection"
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Paladin",
                damageType = "Physical/Magical",
                image = "https://www.nicepng.com/png/detail/27-279498_shield-free-to-use-clip-art-dibujo-de.png",
                healthDie = Random.nextInt(100, 500),
                position = "Frontline",
                funLevel = Random.nextInt(5, 20),
                complexity = "Medium",
                playable = true,
                description = "A holy warrior bound to a sacred oath, whatever that oath may be. Smite thine enemies."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Ranger",
                damageType = "Physical/Magical",
                image = "https://w7.pngwing.com/pngs/592/347/png-transparent-bow-and-arrow-bow-and-arrow-drawing-line-art-arrow-bow-angle-leaf-branch.png",
                healthDie = Random.nextInt(10, 100),
                position = "Backline",
                funLevel = Random.nextInt(1, 10),
                complexity = "Complex",
                playable = true,
                description = "A warrior who combats threats on the edge of civilization. Utilizes special tactics and magics."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Rogue",
                damageType = "Physical",
                image = "https://as2.ftcdn.net/v2/jpg/01/87/91/59/1000_F_187915962_1t6XA5xTmISJ5I36v4naY3YFADLuqX5i.jpg",
                healthDie = Random.nextInt(10, 100),
                position = "Middle-line",
                funLevel = Random.nextInt(1, 15),
                complexity = "Medium",
                playable = true,
                description = "A scoundrel who uses stealth and trickery to overcome obstacles and enemies."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Sorcerer",
                damageType = "Magical",
                image = "https://www.clipartmax.com/png/middle/25-259888_fireball-cliparts-fire-ball-clip-art.png",
                healthDie = Random.nextInt(10, 100),
                position = "Backline",
                funLevel = Random.nextInt(1, 15),
                complexity = "Very Complex",
                playable = true,
                description = "A spellcaster who draws on inherent magic from some great gift or bloodline."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Warlock",
                damageType = "Magical",
                image = "https://thumbs.dreamstime.com/b/monster-eye-creepy-eyeball-scary-green-yellow-iris-staring-you-full-veins-isolated-white-background-halloween-46290666.jpg",
                healthDie = Random.nextInt(1, 100),
                position = "Backline",
                funLevel = Random.nextInt(5, 20),
                complexity = "Very Complex",
                playable = true,
                description = "A wielder of magic that originates from a spooky otherworldly entity."
            )
        )
        archetypes.add(
            Archetype(
                archetypeName = "Wizard",
                damageType = "Magical",
                image = "https://img.freepik.com/free-vector/book-magic-spells-witchcraft_105738-600.jpg?w=360",
                healthDie = Random.nextInt(1, 50),
                position = "Backline",
                funLevel = Random.nextInt(1, 20),
                complexity = "Complex",
                playable = true,
                description = "A scholarly magic-user capable of manipulating the structures of reality"
            )
        )
    }
}