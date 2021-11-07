
package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalaryAttributeResponseBean implements Parcelable
{

    @SerializedName("SUCCESS")
    @Expose
    private String sUCCESS;
    @SerializedName("salaryAttribute")
    @Expose
    private SalaryAttribute salaryAttribute;
    public final static Creator<SalaryAttributeResponseBean> CREATOR = new Creator<SalaryAttributeResponseBean>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SalaryAttributeResponseBean createFromParcel(Parcel in) {
            return new SalaryAttributeResponseBean(in);
        }

        public SalaryAttributeResponseBean[] newArray(int size) {
            return (new SalaryAttributeResponseBean[size]);
        }

    }
    ;

    protected SalaryAttributeResponseBean(Parcel in) {
        this.sUCCESS = ((String) in.readValue((String.class.getClassLoader())));
        this.salaryAttribute = ((SalaryAttribute) in.readValue((SalaryAttribute.class.getClassLoader())));
    }

    public SalaryAttributeResponseBean() {
    }

    public String getSUCCESS() {
        return sUCCESS;
    }

    public void setSUCCESS(String sUCCESS) {
        this.sUCCESS = sUCCESS;
    }

    public SalaryAttribute getSalaryAttribute() {
        return salaryAttribute;
    }

    public void setSalaryAttribute(SalaryAttribute salaryAttribute) {
        this.salaryAttribute = salaryAttribute;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sUCCESS);
        dest.writeValue(salaryAttribute);
    }

    public int describeContents() {
        return  0;
    }

}
