package com.example.educationinstitutionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.educationinstitutionapp.pojo.UniversityInfo

@Dao
interface UniversityDetailDao {
    @Query("SELECT * FROM university_list_info ORDER BY universityName")
    fun getUniversityList(): LiveData<List<UniversityInfo>>

    @Query("SELECT * FROM university_list_info WHERE universityId == :id LIMIT 1")
    fun getUniversityInfo(id: String?): LiveData<UniversityInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetUniversity (universityList: List<UniversityInfo>)
}