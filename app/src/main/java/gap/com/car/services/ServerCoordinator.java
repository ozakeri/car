package gap.com.car.services;

import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.Response;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import gap.com.car.app.CarApplication;
import gap.com.car.common.Constants;
import gap.com.car.model.DriverProfileResponseBean;
import gap.com.car.model.SalaryAttributeResponseBean;
import gap.com.car.model.SavedPersonTimeOffResponseBean;
import gap.com.car.model.SendCommentResponseBean;
import gap.com.car.model.ServerDateTimeResponseBean;
import gap.com.car.model.SuccessResponseBean;
import gap.com.car.model.VerifyCodeResponseBean;
import gap.com.car.model.carinvoice.SuccessResponseCarInvoice;
import gap.com.car.model.carprofile.CarProfileResultBean;
import gap.com.car.model.driverprofile.DriverProfileModel;
import gap.com.car.model.update.ReportListResponseBean;
import gap.com.car.model.update.UpdateVersionResponseBean;
import gap.com.car.util.GsonRequest;
import gap.com.car.util.RestClient;
import gap.com.car.util.Util;
import gap.com.car.util.Utils;

/**
 * Created by GapCom on 07/29/2018.
 */

public class ServerCoordinator {
    private static ServerCoordinator instance = null;

    public static synchronized ServerCoordinator getInstance() {
        if (instance == null)
            instance = new ServerCoordinator();
        return instance;
    }

    private ServerCoordinator() {

    }


    public void getServerDateTime(Response.Listener listener
            , Response.ErrorListener errorListener)  {

        String ws = Constants.WS + "getServerDateTime";
        ArrayList<Utils.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Utils.WSParameter("getServerDateTime", ""));
        String json = Utils.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Utils.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                ServerDateTimeResponseBean.class,
                listener,
                errorListener,
                false
        );
        RestClient.getInstance().addToRequestQueue(gsonRequest);
    }


    public void getLastDocumentVersion(Response.Listener listener
            , Response.ErrorListener errorListener) {
        String ws = Constants.WS + "getLastDocumentVersion";
        ArrayList<Utils.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Utils.WSParameter("getLastDocumentVersion", ""));
        String json = Utils.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Utils.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                UpdateVersionResponseBean.class,
                listener,
                errorListener,
                false
        );
        RestClient.getInstance().addToRequestQueue(gsonRequest);
    }


    public void saveComplaintReport(String username, String password, String id, String identifier, int entityNameEn, String reportStr, Date reportDate
            , double xLatitude, double yLongitude, Response.Listener listener
            , Response.ErrorListener errorListener) {

        String ws = Constants.WS + "saveComplaintReport";
        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        Map<String, ArrayList<Util.WSParameter>> complaintReportListMap = new HashMap<>();
        //wsParameters.add(new Util.WSParameter("username", username));
        //wsParameters.add(new Util.WSParameter("password", password));
        wsParameters.add(new Util.WSParameter("id", id));
        wsParameters.add(new Util.WSParameter("identifier", identifier));
        wsParameters.add(new Util.WSParameter("entityNameEn", entityNameEn));
        wsParameters.add(new Util.WSParameter("reportStr", reportStr));
        wsParameters.add(new Util.WSParameter("reportDate", reportDate));
        wsParameters.add(new Util.WSParameter("xLatitude", xLatitude));
        wsParameters.add(new Util.WSParameter("yLongitude", yLongitude));
        complaintReportListMap.put("complaintReport", wsParameters);
        String json = Util.createJson(username, password, complaintReportListMap);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Utils.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                UpdateVersionResponseBean.class,
                listener,
                errorListener,
                false
        );
        RestClient.getInstance().addToRequestQueue(gsonRequest);
    }



    public void getDriverProfileInfo(String username, String password,
                                     Response.Listener listener,
                                     Response.ErrorListener errorListener) {
        String ws = Constants.WS + "driverProfileInfo";
        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("username", username));
        wsParameters.add(new Util.WSParameter("password", password));
        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Util.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                DriverProfileResponseBean.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);
    }


    public void getCarInfo(String propertyCode,String username, String password,
                                     Response.Listener listener,
                                     Response.ErrorListener errorListener) {
        String ws = Constants.WS + "getCarInfo";
        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("username", username));
        wsParameters.add(new Util.WSParameter("password", password));
        wsParameters.add(new Util.WSParameter("propertyCode", propertyCode));
        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Util.printLogs("getCarInfo = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                CarProfileResultBean.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);
    }


    public void updateFirebaseTokenId(String token,
                                     Response.Listener listener,
                                     Response.ErrorListener errorListener) {
        String ws = Constants.WS + "updateFirebaseTokenId";
        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("firebaseTokenId", token));
        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Util.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                DriverProfileResponseBean.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);
    }

    public void sendCode(String personalCode,
                         Response.Listener listener,
                         Response.ErrorListener errorListener) {
        String ws = Constants.WS + "mobileNoConfirmation";
        ArrayList<Utils.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Utils.WSParameter("driverCode", personalCode));
        String json = Utils.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Utils.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                SuccessResponseBean.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);
    }


    public void verifyCode(String mobilNo, String activationCode,
                           Response.Listener listener,
                           Response.ErrorListener errorListener) {
        String ws = Constants.WS + "activationCodeValidation";

        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("activationCode", activationCode));

        SharedPreferences sharedPreferences = CarApplication.getInstance().getSharedPreferences();
        wsParameters.add(new Util.WSParameter("mobileNo", mobilNo));
        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Util.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                VerifyCodeResponseBean.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);

    }



    public void getCarInvoice(String username, String password,String carId,String invoiceType,
                                        String fromDate,
                                         Response.Listener listener,
                                         Response.ErrorListener errorListener) {
        String ws = Constants.WS + "getCarInvoice";

        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("username", username));
        wsParameters.add(new Util.WSParameter("password", password));
        wsParameters.add(new Util.WSParameter("carId", carId));
        wsParameters.add(new Util.WSParameter("invoiceType", invoiceType));
        wsParameters.add(new Util.WSParameter("fromDate", fromDate));
        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Util.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                SuccessResponseCarInvoice.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);

    }


    public void getCarDailyInfo(String username, String password,String carId,
                                        String fromDate,
                                         Response.Listener listener,
                                         Response.ErrorListener errorListener) {
        String ws = Constants.WS + "getCarDailyInfo";

        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("username", username));
        wsParameters.add(new Util.WSParameter("password", password));
        wsParameters.add(new Util.WSParameter("carId", carId));
        wsParameters.add(new Util.WSParameter("fromDate", fromDate));
        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Util.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                SuccessResponseCarInvoice.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);

    }


    public void getEtCardDataTranSumStatisticallyReportList(String username, String password,String carId,
                                        String fromDate,
                                         Response.Listener listener,
                                         Response.ErrorListener errorListener) {
        String ws = Constants.WS + "getEtCardDataTranSumStatisticallyReportList";

        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("username", username));
        wsParameters.add(new Util.WSParameter("password", password));
        wsParameters.add(new Util.WSParameter("carId", carId));
        wsParameters.add(new Util.WSParameter("reportDate", fromDate));
        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Util.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                ReportListResponseBean.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);

    }

    public void savePersonTimeOff(String username, String password, String startDate, String finishDate, int type, String description, Response.Listener listener
            , Response.ErrorListener errorListener) {
        String ws = Constants.WS + "savePersonTimeOff";
        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("username", username));
        wsParameters.add(new Util.WSParameter("password", password));
        wsParameters.add(new Util.WSParameter("fromDate", startDate));
        wsParameters.add(new Util.WSParameter("toDate", finishDate));
        wsParameters.add(new Util.WSParameter("leaveType", 0));
        wsParameters.add(new Util.WSParameter("leaveDescription", description));

        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Utils.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                SavedPersonTimeOffResponseBean.class,
                listener,
                errorListener,
                false
        );
        RestClient.getInstance().addToRequestQueue(gsonRequest);
    }


    private String getDate(Calendar calendar) {
        String format = "%02d/%02d/%02d %02d:%02d:%02d";
        Object[] objects = new Object[]{
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND)
        };

        return String.format(Locale.US, format, objects);
    }


    public void sendComment(String username, String password, String comment,
                            int type,
                            Response.Listener listener,
                            Response.ErrorListener errorListener) {
        String ws = Constants.WS + "saveSubscriberComment";

        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("comment", comment));
        wsParameters.add(new Util.WSParameter("complaintType", type));
        wsParameters.add(new Util.WSParameter("username", username));
        wsParameters.add(new Util.WSParameter("password", password));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String date = getDate(calendar);
        wsParameters.add(new Util.WSParameter("commentDate", date));
        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Utils.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                SendCommentResponseBean.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);

    }

    public void saveCarSAComment(String username, String password, int carDailyInfoId, String reportStr, Response.Listener listener
            , Response.ErrorListener errorListener) {

        String ws = Constants.WS + "saveCarSAComment";
        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        Map<String, ArrayList<Util.WSParameter>> complaintReportListMap = new HashMap<>();
        wsParameters.add(new Util.WSParameter("username", username));
        wsParameters.add(new Util.WSParameter("password", password));
        wsParameters.add(new Util.WSParameter("commentText", reportStr));
        wsParameters.add(new Util.WSParameter("carDailyInfoId", carDailyInfoId));
        String json = Util.createJson(wsParameters);
        json = URLEncoder.encode(json);
        ws = ws + "?INPUT_PARAM=" + json;
        Utils.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                UpdateVersionResponseBean.class,
                listener,
                errorListener,
                false
        );
        RestClient.getInstance().addToRequestQueue(gsonRequest);
    }

    public void getCarSACommentList(String username, String password,
                                       String carDailyInfoId,
                                       Response.Listener listener,
                                       Response.ErrorListener errorListener) {
        String ws = Constants.WS + "getCarSACommentList";

        ArrayList<Util.WSParameter> wsParameters = new ArrayList<>();
        wsParameters.add(new Util.WSParameter("username", username));
        wsParameters.add(new Util.WSParameter("password", password));
        wsParameters.add(new Util.WSParameter("carDailyInfoId", carDailyInfoId));
        //wsParameters.add(new Util.WSParameter("toDate", toDate));
        String json = Util.createJson(wsParameters);
        System.out.println("json1111===" + json);
        json = URLEncoder.encode(json);
        System.out.println("json2222===" + json);
        ws = ws + "?INPUT_PARAM=" + json;
        Util.printLogs("ws = " + ws);

        GsonRequest gsonRequest = new GsonRequest<>(
                Request.Method.GET,
                ws,
                DriverProfileModel.class,
                listener,
                errorListener,
                false
        );

        RestClient.getInstance().addToRequestQueue(gsonRequest);

    }

}
