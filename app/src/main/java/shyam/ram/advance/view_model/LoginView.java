package shyam.ram.advance.view_model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shyam.ram.advance.R;
import shyam.ram.advance.activity.MainActivity;
import shyam.ram.advance.api.ApiConfig;
import shyam.ram.advance.api.AppConfig;
import shyam.ram.advance.general.CONS;
import shyam.ram.advance.general.SharedPreference;
import shyam.ram.advance.model.Login;
import shyam.ram.advance.model.download.CustomerDetailMaster;
import shyam.ram.advance.model.download.FirstLogin;
import shyam.ram.advance.model.upload.LoginDetail;
import shyam.ram.advance.room.AppDataBase;
import shyam.ram.advance.room.ApplicationDataBase;
import shyam.ram.advance.room.LocationData;
import shyam.ram.advance.room.UserDataBase;

import static android.os.Environment.getDataDirectory;
import static android.os.Environment.getExternalStorageDirectory;

public class LoginView extends BaseObservable {
    private String username, password;
    private String usernameHint;
    private String passwordHint;
    private SharedPreferences.Editor edit;
    private ApplicationDataBase applicationDataBase;
    private UserDataBase userDataBase;
    private LocationData userData;
    SharedPreference sharedPreferences;
    private Context context;

    public LoginView(Login login) {
        this.passwordHint = login.passwordHint;
        this.usernameHint = login.usernameHint;
    }

    public String getUsername() {
        notifyPropertyChanged(R.id.et_name);
        return username;
    }

    public void setUsername(String username) {
        notifyChange();
        notifyPropertyChanged(R.id.et_name);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyChange();
        notifyPropertyChanged(R.id.et_password);
    }

    public String getUsernameHint() {
        return usernameHint;
    }

    public void setUsernameHint(String usernameHint) {
        this.usernameHint = usernameHint;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }


    public boolean loginUpdate(Context _context, String password, String username) {
        this.context = _context;
        sharedPreferences = SharedPreference.instance(context);
        String uniqueID = UUID.randomUUID().toString();
        LoginDetail loginDetail = new LoginDetail(username,
                password, uniqueID
                , "d0323c15c224fbfa"
                , "Request", "True");
        AppConfig.getRetrofit().create(ApiConfig.class).loginRequest(loginDetail).enqueue(new Callback<FirstLogin>() {
            @Override
            public void onResponse(@NonNull Call<FirstLogin> call, @NonNull Response<FirstLogin> response) {
                FirstLogin login = response.body();
                edit = SharedPreference.edit(context);
                assert login != null;
                if (login.getStatus().equalsIgnoreCase("True")) {
                    FirstLogin.ServiceLoginBean serviceLoginBean = login.getServiceLogin().get(0);
                    edit.putString(CONS.USERNAME, serviceLoginBean.getUserName());
                    edit.putString(CONS.USERID, serviceLoginBean.getUserid());
                    edit.putString(CONS.FULLNAME, serviceLoginBean.getFullName());
                    edit.putString(CONS.USERTYPE, serviceLoginBean.getUserType());
                    edit.putString(CONS.LICENSEKEY, serviceLoginBean.getLicenseKey());
                    edit.putBoolean(CONS.ISLOGIN, true);
                    ok = getData();
                    List<FirstLogin.CounterIDBean> counterID = login.getCounterID();
                    for (FirstLogin.CounterIDBean counterIDBean : counterID) {
                        edit.putString(counterIDBean.getCounterName(), counterIDBean.getCounterValue());
                    }
                    edit.apply();
//                    CreateDummyData.exportDB("Shyam",context);
                    Log.e("Data", login.toString());
//                    getCustomerData(serviceLoginBean.getUserid());
                }
            }

            @Override
            public void onFailure(@NonNull Call<FirstLogin> call, @NonNull Throwable t) {
//                Toast.makeText(context, "Error communicating with server.", Toast.LENGTH_SHORT).show();
                ok = false;
            }
        });
        return ok;
    }

    private boolean ok = false;

    private boolean getData() {
        String userId = SharedPreference.getUserId();
        AppConfig.getRetrofit().create(ApiConfig.class).getCustomerMaster(userId).enqueue(new Callback<CustomerDetailMaster>() {
            @Override
            public void onResponse(@NonNull Call<CustomerDetailMaster> call, @NonNull Response<CustomerDetailMaster> response) {
                CustomerDetailMaster login = response.body();
                applicationDataBase = AppDataBase.appDataBaseInstance(context);
                assert login != null;
                userDataBase = applicationDataBase.appDetailDao();
                userDataBase.inStatus(login.getStatus_MasterCustomer());
                userDataBase.inCategory(login.getCustCategoryMaster());
                userDataBase.inTask(login.getTaskMaster());
                userDataBase.inType(login.getCustTypeMaster());
                context.startActivity(new Intent(context, MainActivity.class));
                ok = true;
//                exportDB();
            }

            @Override
            public void onFailure(@NonNull Call<CustomerDetailMaster> call, @NonNull Throwable t) {
//                Toast.makeText(context, "Error communicating with server.", Toast.LENGTH_SHORT).show();
                ok = false;
            }
        });
        return ok;
    }

//    private void getCustomerData(String userId) {
//        AppConfig.getRetrofit().create(ApiConfig.class)
//                .getCustomerLocation(userId, "1900-01-01")
//                .enqueue(new Callback<CustomerLocation>() {
//                    @Override
//                    public void onResponse(@NonNull Call<CustomerLocation> call
//                            , @NonNull Response<CustomerLocation> response) {
//                        CustomerLocation login = response.body();
//                        applicationDataBase = AppDataBase.appDataBaseInstance(context);
//                        assert login != null;
//                        userData = applicationDataBase.locationData();
//                        List<CustomerLocation.
//                                CustomerMasterBean.LocationMasterBean> locationMasterBeans =
//                                new ArrayList<>();
//                        for (CustomerLocation.CustomerMasterBean customerMasterBean :
//                                login.getCustomerMaster()) {
//                            locationMasterBeans.addAll(customerMasterBean.getLocationMaster());
//                        }
//                        userData.inLocation(locationMasterBeans);
////                        context.startActivity(new Intent(context, MainActivity.class));
//                    }
//
//                    @Override
//                    public void onFailure(@NonNull Call<CustomerLocation> call, @NonNull Throwable t) {
//                        Toast.makeText(context, "Error communicating with server.", Toast.LENGTH_SHORT).show();
//                    }
//                });
////        exportDB();
////        exportDB(context);
//    }

    private static void exportDB(Context ctx) {
        File sd = getExternalStorageDirectory();
        File data = getDataDirectory();
        FileChannel source = null;
        FileChannel destination = null;
        String backupDBPath = "SAMPLE_DB_NAME";
        String currentDBPath = "/data/" + "shyam.ram.advance" + "/databases/" + backupDBPath;
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(ctx, "DB Exported!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportDB() {
        // TODO Auto-generated method stub

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//" + "shyam.ram.advance"
                        + "//databases//" + "DatabaseName";
                String backupDBPath = "/BackupFolder/DatabaseName";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(context, backupDB.toString(),
                        Toast.LENGTH_LONG).show();

            }
        } catch (Exception e) {

            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG)
                    .show();

        }
    }
}
