package com.hitta.android.assignment.data

import android.content.Context
import com.hitta.android.assignment.data.source.ReviewsRepository
import com.hitta.android.assignment.data.source.local.ReviewsDatabase
import com.hitta.android.assignment.data.source.local.ReviewsLocalDataSource
import com.hitta.android.assignment.data.source.remote.ReviewsRemoteDataSource
import com.hitta.android.assignment.utils.AppExecutors

object ReviewsRepositoryFactory {
    fun provideReviewsRepository(context: Context): ReviewsRepository =
            ReviewsRepository.getInstance(ReviewsLocalDataSource.getInstance(AppExecutors(), ReviewsDatabase.getInstance(context).reviewsDao()),
                    ReviewsRemoteDataSource.getInstance())
}