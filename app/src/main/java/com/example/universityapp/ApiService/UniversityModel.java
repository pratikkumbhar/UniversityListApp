
package com.example.universityapp.ApiService;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "usertable")
public class UniversityModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    @SerializedName("alpha_two_code")
    private String mAlphaTwoCode;
    @ColumnInfo
    @SerializedName("country")
    private String mCountry;
    @ColumnInfo
    @SerializedName("domains")
    private List<String> mDomains;
    @ColumnInfo
    @SerializedName("name")
    private String mName;
    @ColumnInfo
    @SerializedName("state-province")
    private String mStateProvince;
    @ColumnInfo
    @SerializedName("web_pages")
    private List<String> mWebPages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlphaTwoCode() {
        return mAlphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        mAlphaTwoCode = alphaTwoCode;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public List<String> getDomains() {
        return mDomains;
    }

    public void setDomains(List<String> domains) {
        mDomains = domains;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getStateProvince() {
        return mStateProvince;
    }

    public void setStateProvince(String stateProvince) {
        mStateProvince = stateProvince;
    }

    public List<String> getWebPages() {
        return mWebPages;
    }

    public void setWebPages(List<String> webPages) {
        mWebPages = webPages;
    }

}
