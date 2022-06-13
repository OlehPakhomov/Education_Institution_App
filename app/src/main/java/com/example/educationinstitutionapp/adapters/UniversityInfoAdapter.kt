package com.example.educationinstitutionapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.educationinstitutionapp.R
import com.example.educationinstitutionapp.pojo.UniversityInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_university_info.view.*

class UniversityInfoAdapter(private val context: Context): RecyclerView.Adapter<UniversityInfoAdapter.UniversityInfoViewHolder>() {

    inner class UniversityInfoViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val tvUniversityName = itemView.tvNameUniversity
        val tvUniversityRegistrationYeaar = itemView.tvRegistrationYear
        val tvUniversityRegionName = itemView.tvUniversityRegionName
        val ivLogoUniversity = itemView.ivLogoUniversity
    }

    var onUniversityClickListener: OnUniversityClickListener? = null

    var universityInfoList: List<UniversityInfo> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_university_info, parent, false)
        return  UniversityInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: UniversityInfoViewHolder, position: Int) {
        val university = universityInfoList[position]
        with(holder){
            with(university){
                val universityNameTemplate = context.resources.getString(R.string.university_full_name_template)
                val universityYearTemplate = context.resources.getString(R.string.registration_year_template)
                tvUniversityName.text = String.format(universityNameTemplate, universityName, universityShortName)
                tvUniversityRegionName.text = regionName
                tvUniversityRegistrationYeaar.text = String.format(universityYearTemplate, registrationYear)
                Picasso.get().load(getUniversityLogo(universityId)).into(ivLogoUniversity)
                itemView.setOnClickListener{
                    onUniversityClickListener?.onUniversityClick(this)
                }
            }
        }
    }
    
    override fun getItemCount() = universityInfoList.size

    interface OnUniversityClickListener{
        fun onUniversityClick(universityInfo: UniversityInfo)
    }
}