package com.project.randomimagegenerator.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.randomimagegenerator.data.local.RandomImageGenDao
import com.project.randomimagegenerator.data.model.RandomImageGenEntity

/**
 * The main database class for the application.
 *
 * This class defines the Room database and serves as the access point
 * for the database connection.
 *
 * @see RoomDatabase
 */

@Database(entities = [RandomImageGenEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun randomImageGenDao(): RandomImageGenDao
}