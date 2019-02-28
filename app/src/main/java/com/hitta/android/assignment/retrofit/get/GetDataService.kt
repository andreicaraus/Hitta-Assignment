package com.hitta.android.assignment.retrofit.get

import com.hitta.android.assignment.utils.Constants
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET(Constants.GET_PATH_URL)
    fun getCompanyNames(): Call<GetJsonResponse>
}