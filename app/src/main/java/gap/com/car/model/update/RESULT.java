
package gap.com.car.model.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RESULT {

    @SerializedName("document")
    @Expose
    private Document document;

    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;

    @SerializedName("timeSeriesList")
    @Expose
    public List<TimeSeriesList> timeSeriesList = null;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public List<TimeSeriesList> getTimeSeriesList() {
        return timeSeriesList;
    }

    public void setTimeSeriesList(List<TimeSeriesList> timeSeriesList) {
        this.timeSeriesList = timeSeriesList;
    }
}
