package shyam.ram.advance.model.upload;

public class LoginDetail {
    private String userName, password, applicationId,
            deviceId, Status, mobileFirstLogin;

    public LoginDetail(String userName, String password, String applicationId
            , String deviceId, String status, String mobileFirstLogin) {
        this.userName = userName;
        this.password = password;
        this.applicationId = applicationId;
        this.deviceId = deviceId;
        Status = status;
        this.mobileFirstLogin = mobileFirstLogin;
    }
}

