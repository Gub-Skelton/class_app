package com.example.classapp.model


import com.squareup.moshi.Json

data class DnDClassDetails(
    @Json(name = "class_levels")
    val classLevels: String,
    @Json(name = "index")
    val index: String,
    @Json(name = "hit_die")
    val hitDie: Int,
    @Json(name = "multi_classing")
    val multiClassing: MultiClassing,
    @Json(name = "name")
    val name: String,
    @Json(name = "proficiencies")
    val proficiencies: List<Proficiency>,
    @Json(name = "proficiency_choices")
    val proficiencyChoices: List<ProficiencyChoice>,
    @Json(name = "saving_throws")
    val savingThrows: List<SavingThrow>,
    @Json(name = "starting_equipment")
    val startingEquipment: List<StartingEquipment>,
    @Json(name = "starting_equipment_options")
    val startingEquipmentOptions: List<StartingEquipmentOption>,
    @Json(name = "subclasses")
    val subclasses: List<Subclasse>,
    @Json(name = "url")
    val url: String
) {
    data class MultiClassing(
        @Json(name = "prerequisites")
        val prerequisites: List<Prerequisite>,
        @Json(name = "proficiencies")
        val proficiencies: List<Proficiency>,
        @Json(name = "proficiency_choices")
        val proficiencyChoices: List<Any>
    ) {
        data class Prerequisite(
            @Json(name = "ability_score")
            val abilityScore: AbilityScore,
            @Json(name = "minimum_score")
            val minimumScore: Int
        ) {
            data class AbilityScore(
                @Json(name = "index")
                val index: String,
                @Json(name = "name")
                val name: String,
                @Json(name = "url")
                val url: String
            )
        }

        data class Proficiency(
            @Json(name = "index")
            val index: String,
            @Json(name = "name")
            val name: String,
            @Json(name = "url")
            val url: String
        )
    }

    data class Proficiency(
        @Json(name = "index")
        val index: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "url")
        val url: String
    )

    data class ProficiencyChoice(
        @Json(name = "choose")
        val choose: Int,
        @Json(name = "desc")
        val desc: String,
        @Json(name = "from")
        val from: From,
        @Json(name = "type")
        val type: String
    ) {
        data class From(
            @Json(name = "option_set_type")
            val optionSetType: String,
            @Json(name = "options")
            val options: List<Option>
        ) {
            data class Option(
                @Json(name = "item")
                val item: Item,
                @Json(name = "option_type")
                val optionType: String
            ) {
                data class Item(
                    @Json(name = "index")
                    val index: String,
                    @Json(name = "name")
                    val name: String,
                    @Json(name = "url")
                    val url: String
                )
            }
        }
    }

    data class SavingThrow(
        @Json(name = "index")
        val index: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "url")
        val url: String
    )

    data class StartingEquipment(
        @Json(name = "equipment")
        val equipment: Equipment,
        @Json(name = "quantity")
        val quantity: Int
    ) {
        data class Equipment(
            @Json(name = "index")
            val index: String,
            @Json(name = "name")
            val name: String,
            @Json(name = "url")
            val url: String
        )
    }

    data class StartingEquipmentOption(
        @Json(name = "choose")
        val choose: Int,
        @Json(name = "desc")
        val desc: String,
        @Json(name = "from")
        val from: From,
        @Json(name = "type")
        val type: String
    ) {
        data class From(
            @Json(name = "option_set_type")
            val optionSetType: String,
            @Json(name = "options")
            val options: List<Option>
        ) {
            data class Option(
                @Json(name = "choice")
                val choice: Choice?,
                @Json(name = "count")
                val count: Int?,
                @Json(name = "of")
                val of: Of?,
                @Json(name = "option_type")
                val optionType: String
            ) {
                data class Choice(
                    @Json(name = "choose")
                    val choose: Int,
                    @Json(name = "desc")
                    val desc: String,
                    @Json(name = "from")
                    val from: From,
                    @Json(name = "type")
                    val type: String
                ) {
                    data class From(
                        @Json(name = "equipment_category")
                        val equipmentCategory: EquipmentCategory,
                        @Json(name = "option_set_type")
                        val optionSetType: String
                    ) {
                        data class EquipmentCategory(
                            @Json(name = "index")
                            val index: String,
                            @Json(name = "name")
                            val name: String,
                            @Json(name = "url")
                            val url: String
                        )
                    }
                }

                data class Of(
                    @Json(name = "index")
                    val index: String,
                    @Json(name = "name")
                    val name: String,
                    @Json(name = "url")
                    val url: String
                )
            }
        }
    }

    data class Subclasse(
        @Json(name = "index")
        val index: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "url")
        val url: String
    )
}
