package gap.com.car.util;

import android.graphics.Bitmap;

import org.json.JSONArray;

import gap.com.car.model.DriverProfileResponseBean;
import gap.com.car.model.carinvoice.CarDailyInfo;

/**
 * Created by GapCom on 01/17/2018.
 */

public class Globals {
    private String selectedMenuItem;
    private String gridOnClick;
    private String selectCustomDate;
    private String dayMenuTitle;
    private String weekMenuTitle;
    private String monthMenuTitle;
    private String salaryListItemId;
    private String dayMenuDate;
    private String weekMenuDate;
    private String monthMenuDate;
    private int day;
    private int month;
    private int year;
    private boolean status;
    private JSONArray pictureByte;
    private String name;
    private String companyName;
    private int siftType;
    private String carName;
    private String liceName;
    private int liceType;
    private String dateOne;
    private String dateTwo;
    private boolean getTextClick;
    private boolean checkOp;
    private String mobileNo;
    private DriverProfileResponseBean response;
    private CarDailyInfo carDailyInfo;
    private boolean loginIs;
    private boolean isLeavePage = false;
    private boolean isMonthlyPage = false;
    private boolean isCurrentDate;
    private int currentDay;
    private String propertyCode;
    private String carInfo;
    private Bitmap bitmap;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSiftType() {
        return siftType;
    }

    public void setSiftType(int siftType) {
        this.siftType = siftType;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getLiceName() {
        return liceName;
    }

    public void setLiceName(String liceName) {
        this.liceName = liceName;
    }

    public int getLiceType() {
        return liceType;
    }

    public void setLiceType(int liceType) {
        this.liceType = liceType;
    }

    private static Globals instance = new Globals();

    // Getter-Setters
    public static Globals getInstance() {
        return instance;
    }

    public static void setInstance(Globals instance) {
        Globals.instance = instance;
    }

    private Globals() {

    }

    public String getSelectedMenuItem() {
        return selectedMenuItem;
    }

    public void setSelectedMenuItem(String selectedMenuItem) {
        this.selectedMenuItem = selectedMenuItem;
    }

    public String getGridOnClick() {
        return gridOnClick;
    }

    public void setGridOnClick(String gridOnClick) {
        this.gridOnClick = gridOnClick;
    }

    public String getSelectCustomDate() {
        return selectCustomDate;
    }

    public void setSelectCustomDate(String selectCustomDate) {
        this.selectCustomDate = selectCustomDate;
    }

    public String getDayMenuTitle() {
        return dayMenuTitle;
    }

    public void setDayMenuTitle(String dayMenuTitle) {
        this.dayMenuTitle = dayMenuTitle;
    }

    public String getWeekMenuTitle() {
        return weekMenuTitle;
    }

    public void setWeekMenuTitle(String weekMenuTitle) {
        this.weekMenuTitle = weekMenuTitle;
    }

    public String getMonthMenuTitle() {
        return monthMenuTitle;
    }

    public void setMonthMenuTitle(String monthMenuTitle) {
        this.monthMenuTitle = monthMenuTitle;
    }

    public String getDayMenuDate() {
        return dayMenuDate;
    }

    public void setDayMenuDate(String dayMenuDate) {
        this.dayMenuDate = dayMenuDate;
    }

    public String getWeekMenuDate() {
        return weekMenuDate;
    }

    public void setWeekMenuDate(String weekMenuDate) {
        this.weekMenuDate = weekMenuDate;
    }

    public String getMonthMenuDate() {
        return monthMenuDate;
    }

    public void setMonthMenuDate(String monthMenuDate) {
        this.monthMenuDate = monthMenuDate;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSalaryListItemId() {
        return salaryListItemId;
    }

    public void setSalaryListItemId(String salaryListItemId) {
        this.salaryListItemId = salaryListItemId;
    }

    public JSONArray getPictureByte() {
        return pictureByte;
    }

    public void setPictureByte(JSONArray pictureByte) {
        this.pictureByte = pictureByte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOne() {
        return dateOne;
    }

    public void setDateOne(String dateOne) {
        this.dateOne = dateOne;
    }

    public String getDateTwo() {
        return dateTwo;
    }

    public void setDateTwo(String dateTwo) {
        this.dateTwo = dateTwo;
    }

    public boolean isGetTextClick() {
        return getTextClick;
    }

    public void setGetTextClick(boolean getTextClick) {
        this.getTextClick = getTextClick;
    }

    public boolean isCheckOp() {
        return checkOp;
    }

    public void setCheckOp(boolean checkOp) {
        this.checkOp = checkOp;
    }

    public DriverProfileResponseBean getResponse() {
        return response;
    }

    public void setResponse(DriverProfileResponseBean response) {
        this.response = response;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public boolean isLoginIs() {
        return loginIs;
    }

    public void setLoginIs(boolean loginIs) {
        this.loginIs = loginIs;
    }

    public boolean isLeavePage() {
        return isLeavePage;
    }

    public void setLeavePage(boolean leavePage) {
        isLeavePage = leavePage;
    }

    public boolean isMonthlyPage() {
        return isMonthlyPage;
    }

    public void setMonthlyPage(boolean monthlyPage) {
        isMonthlyPage = monthlyPage;
    }

    public boolean isCurrentDate() {
        return isCurrentDate;
    }

    public void setCurrentDate(boolean currentDate) {
        isCurrentDate = currentDate;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public CarDailyInfo getCarDailyInfo() {
        return carDailyInfo;
    }

    public void setCarDailyInfo(CarDailyInfo carDailyInfo) {
        this.carDailyInfo = carDailyInfo;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
