package com.hitta.android.assignment.retrofit.post

import com.hitta.android.assignment.utils.Constants
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface PostDataService {
    @POST(Constants.POST_PATH_URL)
    @FormUrlEncoded
    @Headers(Constants.POST_HEADER_DEVICE_NAME, Constants.POST_HEADER_IDENTIFIER)
    fun saveReview(@Field("score") score: Int,
                   @Field("companyId") companyId: String,
                   @Field("comment") comment: String,
                   @Field("userName") userName: String): Call<ResponseBody>
}