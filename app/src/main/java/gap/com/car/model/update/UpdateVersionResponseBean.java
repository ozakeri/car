
package gap.com.car.model.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateVersionResponseBean {

    @SerializedName("SUCCESS")
    @Expose
    private String sUCCESS;
    @SerializedName("RESULT")
    @Expose
    private RESULT rESULT;


    public String getsUCCESS() {
        return sUCCESS;
    }

    public void setsUCCESS(String sUCCESS) {
        this.sUCCESS = sUCCESS;
    }

    public RESULT getrESULT() {
        return rESULT;
    }

    public void setrESULT(RESULT rESULT) {
        this.rESULT = rESULT;
    }
}
