package shyam.ram.advance.api;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import shyam.ram.advance.model.ServerResponse;
import shyam.ram.advance.model.download.CustomerDetailMaster;
import shyam.ram.advance.model.download.CustomerLocation;
import shyam.ram.advance.model.download.FirstLogin;
import shyam.ram.advance.model.upload.LoginDetail;

public interface ApiConfig {
    @Multipart
    @POST("Pages/UploadScheduleTaskImagesMp.aspx")
    Call<ServerResponse> uploadFile(@Part MultipartBody.Part file,
                                    @Part("file") RequestBody name);

    @Headers("Content-Type: application/json")
    @POST("Pages/DownloadWebViewDashboardInfo.aspx")
    Call<ServerResponse> getUrl(@Query("userid") String body);


    @POST("Login/CerrebroServiceLogin.aspx")
    Call<FirstLogin> loginRequest(@Body LoginDetail loginDetail);

    @POST("Login/DownloadCustomerMasterData.aspx")
    Call<CustomerDetailMaster> getCustomerMaster(@Query("userid") String userid);

    @POST("Pages/DownloadCustomerList.aspx")
    Call<CustomerLocation> getCustomerLocation(@Query("userid") String body, @Query("notificationDate") String dateTime);

    @POST("Login/DownloadCustomerAdditionalInfoMaster.aspx")
    Call<ServerResponse> getCustomerAdditionalInfoMaster(@Query("userid") String body);

    @POST("Login/DownloadDynamicDataCollectionMaster.aspx")
    Call<ServerResponse> getDynamicDataCollectionMaster(@Query("userid") String body);

    @POST("Login/DownloadCountryStateData.aspx")
    Call<ServerResponse> getCountryStateMaster(@Query("userid") String body);

    @POST("Login/DownloadExpanceMaster.aspx")
    Call<ServerResponse> getExpanseMaster(@Query("userid") String body);

    @POST("Login/DownloadLeadAdditionalInfoMaster.aspx")
    Call<ServerResponse> getLeadAdditionalInfoMaster(@Query("userid") String body);

    @POST("Login/DownloadLeadMasterData.aspx")
    Call<ServerResponse> getLeadMaster(@Query("userid") String body);

    @POST("Login/DownloadLeadProductandServiceMaster.aspx")
    Call<ServerResponse> getLeadProductandServiceMaster(@Query("userid") String body);


//    @Headers("Content-Type: application/json")
//    @POST("Pages/Downloadopportunity.aspx")
//    Call<OpportunityObject> getOpportunity(@Query("userid") String body, @Query("notificationDate") String dateTime);
//
//    @POST("Pages/DownloadCurrencyMaster.aspx")
//    Call<ExpenseObject> getCurrency(@Query("userid") String body);
//
//    @POST("Pages/DownloadContactActionMaster.aspx")
//    Call<ContactActionDaysObject> getContactActionDays(@Query("userid") String body);
//
//    @POST("Pages/DownloadUMmaster.aspx")
//    Call<UMMaster> getUM(@Query("userid") String body);
//
//    @POST("Pages/DownloadStatusMasterOpportunity.aspx")
//    Call<OStatusMaster> getOStatusMaster(@Query("userid") String body);
//
//    @POST("Pages/DownloadLoginUpdate.aspx")
//    Call<LoginUpdateResponse> getLoginUpdate(@Query("userid") String body);
//
//    @Headers("Content-Type: application/json")
//    @POST("Pages/UserDeviceVerification.aspx")
//    Call<ServerResponse> getUrl(@QueryMap Map<String, String> options);
//
//    @Headers("Content-Type: application/json")
//    @POST("Pages/DeactivateDeviceID.aspx")
//    Call<ServerResponse> getStatus(@Body HashMap<String, String> options);
//
//    @POST("Pages/CompanyNaming.aspx")
//    Call<CompanyPeople> getCompanyPeople(@Query("userid") String body);
//
//    @POST("Pages/DownloadExecutionRemark.aspx")
//    Call<ExecutionRemarkResponse> getExecutionRemark(@Query("userid") String body);
//
//    @POST("Pages/UploadOpportunity.aspx")
//    Call<ServerResponse> uploadOpportunity(@Body UploadOpportunity uploadOpportunity);
}
