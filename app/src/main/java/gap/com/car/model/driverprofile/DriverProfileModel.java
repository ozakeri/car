
package gap.com.car.model.driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverProfileModel {

    @SerializedName("SUCCESS")
    @Expose
    private String sUCCESS;
    @SerializedName("RESULT")
    @Expose
    private RESULTBean rESULT;

    public String getsUCCESS() {
        return sUCCESS;
    }

    public void setsUCCESS(String sUCCESS) {
        this.sUCCESS = sUCCESS;
    }

    public RESULTBean getrESULT() {
        return rESULT;
    }

    public void setrESULT(RESULTBean rESULT) {
        this.rESULT = rESULT;
    }
}
