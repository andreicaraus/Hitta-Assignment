package com.hitta.android.assignment.retrofit.get

import com.google.gson.annotations.SerializedName

data class GetJsonResponse(@SerializedName("result") val jsonResponse: ResultJsonResponse)

data class ResultJsonResponse(@SerializedName("companies") val companiesJsonResponse: CompaniesJsonResponse)

data class CompaniesJsonResponse(@SerializedName("company") val companyList: List<CompanyNameJsonResponse>)

data class CompanyNameJsonResponse(@SerializedName("displayName") val name: String)