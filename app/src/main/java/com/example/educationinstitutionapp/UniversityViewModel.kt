package com.example.educationinstitutionapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.educationinstitutionapp.api.ApiFactory
import com.example.educationinstitutionapp.database.AppDatabase
import com.example.educationinstitutionapp.pojo.UniversityInfo
import com.example.educationinstitutionapp.pojo.UniversityLogo
import com.example.educationinstitutionapp.utils.loadUniversityLogos
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class UniversityViewModel(application: Application): AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val universityList = db.universityDetailDao().getUniversityList()

    init {
        loadData()
    }

    fun getDetailInfo(id: String?): LiveData<UniversityInfo>{
        return db.universityDetailDao().getUniversityInfo(id)
    }

    private fun loadData(){
        val disposable = ApiFactory.apiService.getAllUniversityList()
            .subscribeOn(Schedulers.io())
            .delaySubscription(5, TimeUnit.SECONDS)
            .repeat()
            .retry()
            .subscribe({
                db.universityDetailDao().insetUniversity(it)
                Log.d("TEST_OF_LOADING_DATA", "Success $it")
            },{
                Log.d("TEST_OF_LOADING_DATA", "Failure ${it.message}")
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}