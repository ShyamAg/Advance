package shyam.ram.advance.general;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CreateDummyData {


    public static void exportDB(String SAMPLE_DB_NAME, Context ctx) {
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source = null;
        FileChannel destination = null;

//		StartChanges while publish
//	       String currentDBPath = "/data/"+ "com.ndm.cerrebro" +"/databases/"+SAMPLE_DB_NAME;
        String currentDBPath = "/data/" + "shyam.ram.advance" + "/databases/" + SAMPLE_DB_NAME;
        //		End Changes while publish
//        File currentDB = new File(ctx.getDatabasePath("mydatabase.db").getPath());
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, SAMPLE_DB_NAME);
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
        try {
            source = new FileInputStream(currentDB).getChannel();
            (new File(backupDB.getParent())).mkdirs(); //<<<<<<<<<<<<<< ADDED
            destination = new FileOutputStream(backupDB).getChannel();
            //destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
        } catch(IOException e) {
            e.printStackTrace();
            Toast.makeText(ctx, "Err:"+e, Toast.LENGTH_LONG).show();
        }
        try {
            File sds = Environment.getExternalStorageDirectory();

            if (sds.canWrite()) {
                String currentDBPaths = "/data/data/" + "shyam.ram.advance" + "/databases/syhya";
                String backupDBPaths = "backupname.db";
                File currentDBs = new File(currentDBPaths);
                File backupDBs = new File(sd, backupDBPaths);

                if (currentDBs.exists()) {
                    FileChannel src = new FileInputStream(currentDBs).getChannel();
                    FileChannel dst = new FileOutputStream(backupDBs).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {

        }
    }

}
