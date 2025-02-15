package com.project.randomimagegenerator.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity class representing a randomly generated image in the Room database.
 *
 * This table stores image URLs with an auto-generated primary key to uniquely
 * identify each entry.
 *
 * @property id Auto-generated unique identifier for each image entry.
 * @property imageUrl The URL of the randomly generated image.
 */

@Entity(tableName = "RandomImageGenerator")
data class RandomImageGenEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val imageUrl: String? = null
)
