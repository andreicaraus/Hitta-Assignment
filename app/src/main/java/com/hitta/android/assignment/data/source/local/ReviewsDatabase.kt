package com.hitta.android.assignment.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hitta.android.assignment.data.Review

/**
 * Room Database which contains the Review table
 */
@Database(entities = [Review::class], version = ReviewsDatabase.DATABASE_VERSION, exportSchema = false)
abstract class ReviewsDatabase : RoomDatabase() {

    companion object {

        internal const val DATABASE_VERSION = 1

        private const val DATABASE_NAME = "Reviews.db"

        private val lock = Any()

        private var instance: ReviewsDatabase? = null

        fun getInstance(context: Context): ReviewsDatabase =
                instance ?: synchronized(lock) {
                    instance ?: Room.databaseBuilder(context, ReviewsDatabase::class.java, DATABASE_NAME)
                            .build().apply { instance = this }
                }
    }

    abstract fun reviewsDao(): ReviewsDao
}