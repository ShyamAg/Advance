package shyam.ram.advance.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

import shyam.ram.advance.model.download.CustomerDetailMaster;

@Dao
public interface UserDataBase {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inStatus(List<CustomerDetailMaster.StatusMaster> statusMaster);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inCategory(List<CustomerDetailMaster.CustCategoryMasterBean> custCategoryMasterBeans);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inType(List<CustomerDetailMaster.CustTypeMasterBean> custTypeMasterBeans);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inTask(List<CustomerDetailMaster.TaskMasterBean> taskMasterBeans);
}
