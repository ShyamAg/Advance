package shyam.ram.advance.general;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private static SharedPreferences sharedPreferences;
    private static SharedPreference sharedPreference;
    //    private SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;
//    SharedPreference sharedPreference;

    private SharedPreference(Context context) {
        sharedPreferences = context.getSharedPreferences("ADDU", Context.MODE_PRIVATE);
    }

    public static SharedPreference instance(Context context) {
        if (sharedPreference == null) {
            return sharedPreference = new SharedPreference(context.getApplicationContext());
        }
        return sharedPreference;
    }

    public static SharedPreferences.Editor edit(Context context) {
        if (instance(context) != null)
            editor = sharedPreferences.edit();
        return editor;
    }

    public static void setLogin(Context context, boolean b) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(CONS.ISLOGIN, b).apply();
    }

    public static boolean isLogin(Context context) {
        return sharedPreferences.getBoolean(CONS.ISLOGIN, false);
    }

    public static String getUserId() {
        return sharedPreferences.getString(CONS.USERID, "");
    }
//
//    public SharedPreferences.Editor Editor(Context context) {
//        if (editor == null) {
//            if (sharedPreferences != null) {
//                return sharedPreferences
//            }
//        }
//    }
}
