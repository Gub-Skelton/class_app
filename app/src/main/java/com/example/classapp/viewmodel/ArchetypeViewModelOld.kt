package com.example.classapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.classapp.model.ArchetypeOld
import kotlin.random.Random

class ArchetypeViewModelOld : ViewModel() {
    private val archetypeOlds = mutableListOf<ArchetypeOld>()

    init {
        createAllArchetypes(archetypeOlds)
    }

    fun fillData() = archetypeOlds.toList()

    fun fetchById(id: Int) = archetypeOlds.first{ it.id == id}

    private fun createAllArchetypes(archetypeOlds: MutableList<ArchetypeOld>) {
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Barbarian",
                damageType = "Physical",
                image = "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/a314a7114066983.60345f2b97724.png",
                healthDie = Random.nextInt(100, 1000),
                position = "Frontline",
                funLevel = Random.nextInt(10, 20),
                complexity = "Easy",
                playable = true,
                id = 1,
                description = "A fierce powerful warrior of primitive background who enters the battle in a fit of rage. The best in my opinion."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Bard",
                damageType = "Magical",
                image = "https://media.istockphoto.com/id/1300717634/vector/mandolin-vintage-engraved-illustration-stylized-graphic-arts-hand-drawn-vector-sketch.jpg?s=612x612&w=0&k=20&c=qXJheU5ItQufi-0MRbJpQ6M1ecGJgI2CI2Eb0-UVZnU=",
                healthDie = Random.nextInt(10, 100),
                position = "Backline",
                funLevel = Random.nextInt(1, 20),
                complexity = "Complex",
                playable = true,
                id = 2,
                description = "An inspiring musician whose power echoes through the power of music and creation."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Cleric",
                damageType = "Magical",
                image = "https://oldschool.runescape.wiki/images/thumb/Holy_symbol_detail.png/800px-Holy_symbol_detail.png?dae8d",
                healthDie = Random.nextInt(50, 300),
                position = "Middle-line",
                funLevel = Random.nextInt(5, 20),
                complexity = "Medium",
                playable = true,
                id = 3,
                description = "A priest champion who wields divine magic in service of a higher power."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Druid",
                damageType = "Magical",
                image = "https://img.freepik.com/premium-vector/wooden-staff-magical-stick-doodle-isolated-icon-sketch-druid-sorcerer-staff-comic-style-image-hand-drawn-isolated-lineart-image-prints-designs-cards-books-stickers-posters_44769-2841.jpg?w=2000",
                healthDie = Random.nextInt(50, 200),
                position = "Middle-line",
                funLevel = Random.nextInt(1, 20),
                complexity = "Complex",
                playable = true,
                id = 4,
                description = "A priest of the old faith, wielding powers powers of nature and adopting animal forms."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Fighter",
                damageType = "Physical",
                image = "https://media.istockphoto.com/id/1282748614/vector/sword-vector-illustration-icon-crossed-swords-military-or-heraldry-symbol-protection-and.jpg?s=1024x1024&w=is&k=20&c=8ByTGdVKg66CyN3BbLYXYkhhMd1idFnX_uNe7uGMYAs=",
                healthDie = Random.nextInt(100, 500),
                position = "Frontline",
                funLevel = Random.nextInt(5, 20),
                complexity = "Easy",
                playable = true,
                id = 5,
                description = "A master of martial combat, skilled with a wide variety of weapons and fighting styles."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Monk",
                damageType = "Physical",
                image = "https://static.vecteezy.com/system/resources/previews/007/506/316/original/illustration-of-punch-and-fist-free-vector.jpg",
                healthDie = Random.nextInt(100, 300),
                position = "Frontline",
                funLevel = Random.nextInt(5, 20),
                complexity = "Medium",
                playable = true,
                id = 6,
                description = "A master of martial arts, harnessing the power of the body in pursuit of physical and spiritual perfection"
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Paladin",
                damageType = "Physical/Magical",
                image = "https://www.nicepng.com/png/detail/27-279498_shield-free-to-use-clip-art-dibujo-de.png",
                healthDie = Random.nextInt(100, 500),
                position = "Frontline",
                funLevel = Random.nextInt(5, 20),
                complexity = "Medium",
                playable = true,
                id = 7,
                description = "A holy warrior bound to a sacred oath, whatever that oath may be. Smite thine enemies."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Ranger",
                damageType = "Physical/Magical",
                image = "https://w7.pngwing.com/pngs/592/347/png-transparent-bow-and-arrow-bow-and-arrow-drawing-line-art-arrow-bow-angle-leaf-branch.png",
                healthDie = Random.nextInt(10, 100),
                position = "Backline",
                funLevel = Random.nextInt(1, 10),
                complexity = "Complex",
                playable = true,
                id = 8,
                description = "A warrior who combats threats on the edge of civilization. Utilizes special tactics and magics."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Rogue",
                damageType = "Physical",
                image = "https://as2.ftcdn.net/v2/jpg/01/87/91/59/1000_F_187915962_1t6XA5xTmISJ5I36v4naY3YFADLuqX5i.jpg",
                healthDie = Random.nextInt(10, 100),
                position = "Middle-line",
                funLevel = Random.nextInt(1, 15),
                complexity = "Medium",
                playable = true,
                id = 9,
                description = "A scoundrel who uses stealth and trickery to overcome obstacles and enemies."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Sorcerer",
                damageType = "Magical",
                image = "https://www.clipartmax.com/png/middle/25-259888_fireball-cliparts-fire-ball-clip-art.png",
                healthDie = Random.nextInt(10, 100),
                position = "Backline",
                funLevel = Random.nextInt(1, 15),
                complexity = "Very Complex",
                playable = true,
                id = 10,
                description = "A spellcaster who draws on inherent magic from some great gift or bloodline."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Warlock",
                damageType = "Magical",
                image = "https://thumbs.dreamstime.com/b/monster-eye-creepy-eyeball-scary-green-yellow-iris-staring-you-full-veins-isolated-white-background-halloween-46290666.jpg",
                healthDie = Random.nextInt(1, 100),
                position = "Backline",
                funLevel = Random.nextInt(5, 20),
                complexity = "Very Complex",
                playable = true,
                id = 11,
                description = "A wielder of magic that originates from a spooky otherworldly entity."
            )
        )
        archetypeOlds.add(
            ArchetypeOld(
                archetypeName = "Wizard",
                damageType = "Magical",
                image = "https://img.freepik.com/free-vector/book-magic-spells-witchcraft_105738-600.jpg?w=360",
                healthDie = Random.nextInt(1, 50),
                position = "Backline",
                funLevel = Random.nextInt(1, 20),
                complexity = "Complex",
                playable = true,
                id = 12,
                description = "A scholarly magic-user capable of manipulating the structures of reality"
            )
        )
    }
}