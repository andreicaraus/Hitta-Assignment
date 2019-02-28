package com.hitta.android.assignment.data.source.remote

import android.util.Log
import com.hitta.android.assignment.data.Review
import com.hitta.android.assignment.data.source.ReviewsDataSource
import com.hitta.android.assignment.data.source.ReviewsDataSource.GetCompanyListener
import com.hitta.android.assignment.data.source.ReviewsDataSource.GetReviewListener
import com.hitta.android.assignment.retrofit.RetrofitClientInstance
import com.hitta.android.assignment.retrofit.get.GetDataService
import com.hitta.android.assignment.retrofit.get.GetJsonResponse
import com.hitta.android.assignment.retrofit.post.PostDataService
import com.hitta.android.assignment.utils.Constants
import com.hitta.android.assignment.utils.JsonUtils
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Implementation of data source that uses Retrofit to make the necessary requests
 */
class ReviewsRemoteDataSource private constructor() : ReviewsDataSource {

    override fun getReviewById(id: Int, listener: GetReviewListener) {
        //no implementation needed
    }

    override fun saveReview(review: Review) {
        Log.d(TAG, "saveReview")
        val postDataRetrofit = RetrofitClientInstance.getInstance(Constants.POST_BASE_URL).create(PostDataService::class.java)
        val data = postDataRetrofit.saveReview(
                review.rateScore.toInt(),
                Constants.MOCK_COMPANY_ID,
                review.comment ?: "",
                review.reviewerName ?: "")
        data.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d(TAG, "saveReview - onResponse is successful ? ${response.isSuccessful}")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d(TAG, "saveReview - onFailure")
            }
        })
    }

    override fun getCompanyName(listener: GetCompanyListener) {
        Log.d(TAG, "getCompanyName")
        val getDataRetrofit = RetrofitClientInstance.getInstance(Constants.GET_BASE_URL).create(GetDataService::class.java)
        val data = getDataRetrofit.getCompanyNames()
        data.enqueue(object : Callback<GetJsonResponse> {
            override fun onResponse(call: Call<GetJsonResponse>, response: Response<GetJsonResponse>) {
                Log.d(TAG, "getCompanyName - onResponse")
                handleGetCompanyResponse(response, listener)
            }

            override fun onFailure(call: Call<GetJsonResponse>, t: Throwable) {
                Log.d(TAG, "getCompanyName - onFailure")
                listener.onNoDataAvailable()
            }
        })
    }

    private fun handleGetCompanyResponse(response: Response<GetJsonResponse>, listener: GetCompanyListener) {
        Log.d(TAG, "handleGetCompanyResponse - response is successful ? ${response.isSuccessful}")
        if (!response.isSuccessful) {
            listener.onNoDataAvailable()
            return
        }
        val companyNames = JsonUtils.getCompanyNames(response.body())
        if (!companyNames.isEmpty()) {
            listener.onReviewLoadCompleted(companyNames[0])
        } else {
            listener.onNoDataAvailable()
        }
    }

    companion object {

        private var TAG = ReviewsRemoteDataSource::class.java.simpleName

        @Volatile
        private var instance: ReviewsRemoteDataSource? = null

        fun getInstance(): ReviewsRemoteDataSource =
                instance ?: synchronized(ReviewsRemoteDataSource::class.java) {
                    instance ?: ReviewsRemoteDataSource().apply { instance = this }
                }
    }
}