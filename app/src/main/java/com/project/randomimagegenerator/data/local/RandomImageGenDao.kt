package com.project.randomimagegenerator.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.project.randomimagegenerator.data.model.RandomImageGenEntity

/**
 * Data Access Object (DAO) for managing image generation records in the Room database.
 *
 * This DAO provides methods to insert, retrieve, and delete images while ensuring
 * that only the latest 20 generated images are retained.
 */
@Dao
interface RandomImageGenDao {

    /**
     * Inserts a new randomly generated image into the database.
     *
     * @param randomImageGenEntity The image entity to be added.
     */
    @Insert
    suspend fun addRandomImageGen(randomImageGenEntity: RandomImageGenEntity)

    /**
     * Retrieves all stored images from the database, ordered by latest first.
     *
     * @return A list of [RandomImageGenEntity] objects sorted in descending order by ID.
     */
    @Query("SELECT * FROM RandomImageGenerator ORDER BY id DESC")
    suspend fun getAllRandomImages(): List<RandomImageGenEntity>

    /**
     * Deletes all images from the database.
     */
    @Query("DELETE FROM RandomImageGenerator")
    suspend fun deleteAllImages()

    /**
     * Ensures only the latest 20 images are kept in the database by deleting older records.
     *
     * This query removes any images whose IDs are not in the most recent 20 entries.
     */
    @Query("DELETE FROM RandomImageGenerator WHERE id NOT IN (SELECT id FROM RandomImageGenerator ORDER BY id DESC LIMIT 20)")
    suspend fun latest20Images()
}