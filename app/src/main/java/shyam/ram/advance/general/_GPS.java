package shyam.ram.advance.general;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;

/**
 * Created by Ndm-PC on 12/19/2015.
 */
public class _GPS
{
   static Context context;
    public static boolean canGetLocation(Context mcontext)
    {

        context=mcontext;
        boolean result = true;
        LocationManager lm=null;
        boolean gps_enabled = false;
        boolean network_enabled = false;
        if (lm == null)

            lm = (LocationManager)mcontext.getSystemService(Context.LOCATION_SERVICE);

        // exceptions will be thrown if provider is not permitted.
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        }
        catch (Exception ex)
        {

        }
//        try {
//            network_enabled = lm
//                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//        } catch (Exception ex) {
//        }
        result = gps_enabled;

        return result;
    }


    public static void showSettingsAlert()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        // Setting Dialog Title
        alertDialog.setTitle("Location Services Disabled");

        // Setting Dialog Message
        alertDialog.setMessage("Please enable location services. ");

        // On pressing Settings button
        alertDialog.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        ((Activity) context).finish();
                        Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        context. startActivity(intent);


                    }
                }

                 );

                    alertDialog.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener()

                            {
                                public void onClick(DialogInterface dialog, int which) {

                                    ((Activity) context).finish();
                                }
                            }

                    );

                    alertDialog.show();
       }





    public static void showSettingsAlertOnDUty()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        // Setting Dialog Title
        alertDialog.setTitle("Location Services Disabled");

        // Setting Dialog Message
        alertDialog.setMessage("Please enable location services. ");

        // On pressing Settings button
        alertDialog.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //((Activity) context).finish();
                        Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        context. startActivity(intent);


                    }
                }

        );

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener()

                {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                        //((Activity) context).finish();
                    }
                }

        );

        alertDialog.show();
    }

    }
