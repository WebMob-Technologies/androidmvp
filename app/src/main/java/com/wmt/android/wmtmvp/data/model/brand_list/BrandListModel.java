
package com.wmt.android.wmtmvp.data.model.brand_list;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BrandListModel implements Parcelable
{

    @SerializedName("error_code")
    @Expose
    private int errorCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("brand_list")
    @Expose
    private List<BrandList> brandList = null;
    public final static Creator<BrandListModel> CREATOR = new Creator<BrandListModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BrandListModel createFromParcel(Parcel in) {
            return new BrandListModel(in);
        }

        public BrandListModel[] newArray(int size) {
            return (new BrandListModel[size]);
        }

    }
    ;

    protected BrandListModel(Parcel in) {
        this.errorCode = ((int) in.readValue((int.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.brandList, (BrandList.class.getClassLoader()));
    }

    public BrandListModel() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BrandList> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandList> brandList) {
        this.brandList = brandList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(errorCode);
        dest.writeValue(message);
        dest.writeList(brandList);
    }

    public int describeContents() {
        return  0;
    }

}
