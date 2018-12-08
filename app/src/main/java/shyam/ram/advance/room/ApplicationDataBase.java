package shyam.ram.advance.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import shyam.ram.advance.model.download.CustomerDetailMaster;
import shyam.ram.advance.model.download.CustomerLocation;

/**
 * Created by SAM on 26-Mar-18.
 */
@Database(entities = {CustomerDetailMaster.StatusMaster.class,
        CustomerDetailMaster.TaskMasterBean.class,
        CustomerDetailMaster.CustTypeMasterBean.class,
        CustomerDetailMaster.CustCategoryMasterBean.class,
        CustomerLocation.
                CustomerMasterBean.LocationMasterBean.class}
        , version = 1, exportSchema = false)
public abstract class ApplicationDataBase extends RoomDatabase {
    public abstract UserDataBase appDetailDao();

    public abstract LocationData locationData();
}
