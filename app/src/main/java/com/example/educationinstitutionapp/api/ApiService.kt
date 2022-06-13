package com.example.educationinstitutionapp.api

import com.example.educationinstitutionapp.pojo.UniversityInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/universities/")
    fun getAllUniversityList(
        @Query(QUERY_PARAM_UT) ut: Int = 1,
        @Query(QUERY_PARAM_LC) lc: Int = 0,
        @Query(QUERY_PARAM_EXP) exp: String = TYPE_EXPR
    ): Single<List<UniversityInfo>>

    companion object{
        private const val QUERY_PARAM_UT = "ut"
        private const val QUERY_PARAM_LC = "lc"
        private const val QUERY_PARAM_EXP = "exp"
        private const val TYPE_EXPR = "json"
    }
}