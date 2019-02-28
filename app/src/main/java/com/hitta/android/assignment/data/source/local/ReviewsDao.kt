package com.hitta.android.assignment.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.hitta.android.assignment.data.Review

@Dao
interface ReviewsDao {

    @Query("SELECT * FROM reviews WHERE review_id = :id")
    fun getReviewById(id: Int): Review?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReview(review: Review)
}