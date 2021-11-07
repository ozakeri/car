package gap.com.car.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import gap.com.car.model.driverprofile.DriverProfile;
import gap.com.car.model.driverprofile.DriverProfileVO;

public class DriverBean implements Parcelable {

    private String driverId;
    private String alreadyRegistered;
    private String companyName;
    private String name;
    private String family;
    private String username;
    private String password;
    private int driverCode;
    private DriverProfile driverProfile;
    private List<Integer> pictureBytes = null;
    private DriverProfileVO driverProfileVO;
    private String carId;
    private String licenceNo;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getAlreadyRegistered() {
        return alreadyRegistered;
    }

    public void setAlreadyRegistered(String alreadyRegistered) {
        this.alreadyRegistered = alreadyRegistered;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(int driverCode) {
        this.driverCode = driverCode;
    }

    public DriverProfile getDriverProfile() {
        return driverProfile;
    }

    public void setDriverProfile(DriverProfile driverProfile) {
        this.driverProfile = driverProfile;
    }

    public List<Integer> getPictureBytes() {
        return pictureBytes;
    }

    public void setPictureBytes(List<Integer> pictureBytes) {
        this.pictureBytes = pictureBytes;
    }

    public DriverProfileVO getDriverProfileVO() {
        return driverProfileVO;
    }

    public void setDriverProfileVO(DriverProfileVO driverProfileVO) {
        this.driverProfileVO = driverProfileVO;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
