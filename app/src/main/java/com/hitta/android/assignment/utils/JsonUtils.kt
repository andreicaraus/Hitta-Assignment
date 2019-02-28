package com.hitta.android.assignment.utils

import com.hitta.android.assignment.retrofit.get.CompanyNameJsonResponse
import com.hitta.android.assignment.retrofit.get.GetJsonResponse

object JsonUtils {

    fun getCompanyNames(getJsonResponse: GetJsonResponse?): List<String> {
        if (getJsonResponse?.jsonResponse == null)
            return emptyList()
        val companyNames = mutableListOf<String>()
        for (item: CompanyNameJsonResponse in getJsonResponse.jsonResponse.companiesJsonResponse.companyList) {
            companyNames.add(item.name)
        }
        return companyNames
    }
}