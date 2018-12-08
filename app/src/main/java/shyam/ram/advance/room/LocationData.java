package shyam.ram.advance.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import shyam.ram.advance.model.download.CustomerLocation;

@Dao
public interface LocationData {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inLocation(List<CustomerLocation.
            CustomerMasterBean.LocationMasterBean> locationMasterBeans);
    @Query("Select * from LocationMasterBean")
    List<CustomerLocation.
            CustomerMasterBean.LocationMasterBean> getLocationList();
}
