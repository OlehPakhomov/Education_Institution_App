package com.example.educationinstitutionapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_university_detail.*

class UniversityDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: UniversityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university_detail)
        viewModel = ViewModelProvider(this)[UniversityViewModel::class.java]
        if(!intent.hasExtra(EXTRA_FROM_ID)){
            finish()
            return
        }
        val idUniversity = intent.getStringExtra(EXTRA_FROM_ID)
        viewModel.getDetailInfo(idUniversity).observe(this, Observer {
            Picasso.get().load(it.getUniversityLogo(idUniversity)).into(ivDetailLogoUniversity)
            tvDetailUniversityName.text = it.universityName
            tvShortName.text = it.universityShortName
        })
    }
    companion object{
        private const val EXTRA_FROM_ID = "id"
        fun newIntent(context: Context, universityId: String): Intent{
            val intent = Intent(context, UniversityDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_ID, universityId)
            return  intent
        }
    }
}