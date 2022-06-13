package com.example.educationinstitutionapp.utils

import com.example.educationinstitutionapp.R
import com.example.educationinstitutionapp.pojo.UniversityLogo

fun loadUniversityLogos(): List<UniversityLogo> {
    return listOf<UniversityLogo>(
        UniversityLogo("0", R.drawable.logo_university),
        UniversityLogo("127", R.drawable.logo_university_127),
        UniversityLogo("308", R.drawable.logo_university_308),
        UniversityLogo("566", R.drawable.logo_university_566),
        UniversityLogo("53", R.drawable.logo_university_53),
        UniversityLogo("6468", R.drawable.logo_university_6468),
        UniversityLogo("865", R.drawable.logo_university_865),
        UniversityLogo("866", R.drawable.logo_university_866),
    )
}