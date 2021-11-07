
package gap.com.car.model.driverprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import gap.com.car.model.carprofile.CarSACommentList;

public class RESULTBean {

    @SerializedName("driverProfile")
    @Expose
    private DriverProfile driverProfile;

    @SerializedName("carSACommentList")
    @Expose
    public List<CarSACommentList> driverSACommentList;

    public DriverProfile getDriverProfile() {
        return driverProfile;
    }

    public void setDriverProfile(DriverProfile driverProfile) {
        this.driverProfile = driverProfile;
    }
}
