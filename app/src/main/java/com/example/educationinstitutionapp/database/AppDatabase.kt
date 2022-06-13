package com.example.educationinstitutionapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.educationinstitutionapp.pojo.UniversityInfo

@Database(entities = [UniversityInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    companion object{
        private var database: AppDatabase? = null
        private val LOCK = Any()
        private const val DATABASE_NAME = "main.db"

        fun getInstance(context: Context): AppDatabase{
            synchronized(LOCK){
                database?.let{return  it}
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
                database = instance
                return  instance
            }
        }
    }
    abstract fun universityDetailDao(): UniversityDetailDao
}