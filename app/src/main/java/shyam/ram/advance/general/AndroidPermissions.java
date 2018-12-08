package shyam.ram.advance.general;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;

/**
 * Created by Ndm-PC on 4/22/2016.
 */
public class AndroidPermissions
{

   public static void permissions(Context mContext)
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {

            if (!android.provider.Settings.System.canWrite(mContext))
            {
                ((Activity)mContext).requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE
                        , android.Manifest.permission.CAMERA}, 4);

            }

        }
    }



    public  static void LocationPermission(Context mContext)
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {

            if (!android.provider.Settings.System.canWrite(mContext))
            {
                ((Activity)mContext).requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION}, 4);

            }

        }
    }



    public  static void CameraPermission(Context mContext)
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {

            if (!android.provider.Settings.System.canWrite(mContext))
            {
                ((Activity)mContext).requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 4);

            }

        }
    }




    public static  boolean checkLocationPermission(Context mContext)
    {
        int permissionCheck = ContextCompat.checkSelfPermission(mContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION);


        //Toast.makeText(mContext,permissionCheck+"",Toast.LENGTH_LONG).show();

        if(permissionCheck==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean checkFilePermission(Context mContext)
    {
        int permissionCheckw = ContextCompat.checkSelfPermission(mContext,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        int permissionCheckr = ContextCompat.checkSelfPermission(mContext,
                android.Manifest.permission.READ_EXTERNAL_STORAGE);


        if(permissionCheckw==0  && permissionCheckr==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public static  boolean checkCameraPermission(Context mContext)
    {
        int permissionCheck = ContextCompat.checkSelfPermission(mContext,
                android.Manifest.permission.CAMERA);


        if(permissionCheck==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
