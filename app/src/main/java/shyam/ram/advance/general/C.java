package shyam.ram.advance.general;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.widget.Toast;

public class C {

    public static String s;

    public static boolean isConnected(Context _context) {
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivity != null;
        NetworkInfo[] info = connectivity.getAllNetworkInfo();
        for (NetworkInfo anInfo : info) {
            if (anInfo != null && anInfo.isConnected())
                return true;
        }
        Toast.makeText(_context, "No Connection", Toast.LENGTH_SHORT).show();
        return false;
    }

    public static String type(Context _context) {
        String type = "";
        final ConnectivityManager connMgr = (ConnectivityManager)
                _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connMgr != null;
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                type = "WIFI";
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                type = "Data";
            }
        } else {
            type = "No N/W";
        }
        return type;
    }

    public static String battery(Context context) {
        context.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                s = String.valueOf(intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0));
            }
        }, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        return s;
    }

}