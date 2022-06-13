package com.example.educationinstitutionapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.educationinstitutionapp.adapters.UniversityInfoAdapter
import com.example.educationinstitutionapp.pojo.UniversityInfo
import kotlinx.android.synthetic.main.activity_university_list.*

class UniversityListActivity : AppCompatActivity() {
    private lateinit var viewModel: UniversityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university_list)
        val adapter = UniversityInfoAdapter(this)
        adapter.onUniversityClickListener = object : UniversityInfoAdapter.OnUniversityClickListener{
            override fun onUniversityClick(universityInfo: UniversityInfo) {
                val intent = UniversityDetailActivity.newIntent(this@UniversityListActivity, universityInfo.universityId)
                startActivity(intent)
                Log.d("ON_CLICK_TEST", universityInfo.universityName.toString())
            }
        }
        rvUniversityList.adapter = adapter
        viewModel = ViewModelProvider(this)[UniversityViewModel::class.java]
        viewModel.universityList.observe(this, Observer {
            adapter.universityInfoList = it
        })
    }
}
