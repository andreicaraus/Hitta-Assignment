package com.hitta.android.assignment.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Model class for a review
 */
@Entity(tableName = "reviews")
data class Review(@PrimaryKey @ColumnInfo(name = "review_id") var id: Int,
                  @ColumnInfo(name = "company_name") var companyName: String?,
                  @ColumnInfo(name = "rate_score") var rateScore: Float,
                  @ColumnInfo(name = "reviewer_name") var reviewerName: String?,
                  @ColumnInfo var comment: String?,
                  @ColumnInfo var timestamp: Long)