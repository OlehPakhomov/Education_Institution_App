package com.example.educationinstitutionapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.educationinstitutionapp.utils.loadUniversityLogos
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.rxjava3.annotations.NonNull

@Entity(tableName = "university_list_info")
data class UniversityInfo(

    @SerializedName("university_name")
    @Expose
    val universityName: String? = null,

    @NonNull
    @PrimaryKey
    @SerializedName("university_id")
    @Expose
    val universityId: String,

    @SerializedName("university_parent_id")
    @Expose
    val universityParentId: String? = null,

    @SerializedName("university_short_name")
    @Expose
    val universityShortName: String? = null,

    @SerializedName("university_name_en")
    @Expose
    val universityNameEn: String? = null,

    @SerializedName("is_from_crimea")
    @Expose
    val isFromCrimea: String? = null,

    @SerializedName("registration_year")
    @Expose
    val registrationYear: String? = null,

    @SerializedName("university_edrpou")
    @Expose
    val universityEdrpou: String? = null,

    @SerializedName("university_type_name")
    @Expose
    val universityTypeName: String? = null,

    @SerializedName("university_financing_type_name")
    @Expose
    val universityFinancingTypeName: String? = null,

    @SerializedName("university_governance_type_name")
    @Expose
    val universityGovernanceTypeName: String? = null,

    @SerializedName("post_index")
    @Expose
    val postIndex: String? = null,

    @SerializedName("koatuu_id")
    @Expose
    val koatuuId: String? = null,

    @SerializedName("region_name")
    @Expose
    val regionName: String? = null,

    @SerializedName("koatuu_name")
    @Expose
    val koatuuName: String? = null,

    @SerializedName("university_address")
    @Expose
    val universityAddress: String? = null,

    @SerializedName("post_index_u")
    @Expose
    val postIndexU: String? = null,

    @SerializedName("koatuu_id_u")
    @Expose
    val koatuuIdU: String? = null,

    @SerializedName("region_name_u")
    @Expose
    val regionNameU: String? = null,

    @SerializedName("koatuu_name_u")
    @Expose
    val koatuuNameU: String? = null,

    @SerializedName("university_address_u")
    @Expose
    val universityAddressU: String? = null,

    @SerializedName("university_phone")
    @Expose
    val universityPhone: String? = null,

    @SerializedName("university_email")
    @Expose
    val universityEmail: String? = null,

    @SerializedName("university_site")
    @Expose
    val universitySite: String? = null,

    @SerializedName("university_director_post")
    @Expose
    val universityDirectorPost: String? = null,

    @SerializedName("university_director_fio")
    @Expose
    val universityDirectorFio: String? = null,

    @SerializedName("close_date")
    @Expose
    val closeDate: String? = null,

    @SerializedName("primitki")
    @Expose
    val primitki: String? = null
){
    fun getUniversityLogo(universityId: String?): Int{
        val listLogo: List<UniversityLogo> = loadUniversityLogos()
        val logoId = listLogo.find { it.stringResourceId == universityId }
        return logoId?.imageResourceId ?: listLogo[0].imageResourceId
    }
}