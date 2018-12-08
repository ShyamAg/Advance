package shyam.ram.advance.model.download;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

public class CustomerDetailMaster {

    private String Status;
    private Object MobileFirstLogin;
    private List<CustCategoryMasterBean> CustCategoryMaster;
    private List<CustTypeMasterBean> CustTypeMaster;
    private List<TaskMasterBean> TaskMaster;
    private List<StatusMaster> Status_MasterCustomer;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Object getMobileFirstLogin() {
        return MobileFirstLogin;
    }

    public void setMobileFirstLogin(Object MobileFirstLogin) {
        this.MobileFirstLogin = MobileFirstLogin;
    }

    public List<CustCategoryMasterBean> getCustCategoryMaster() {
        return CustCategoryMaster;
    }

    public void setCustCategoryMaster(List<CustCategoryMasterBean> CustCategoryMaster) {
        this.CustCategoryMaster = CustCategoryMaster;
    }

    public List<CustTypeMasterBean> getCustTypeMaster() {
        return CustTypeMaster;
    }

    public void setCustTypeMaster(List<CustTypeMasterBean> CustTypeMaster) {
        this.CustTypeMaster = CustTypeMaster;
    }

    public List<TaskMasterBean> getTaskMaster() {
        return TaskMaster;
    }

    public void setTaskMaster(List<TaskMasterBean> TaskMaster) {
        this.TaskMaster = TaskMaster;
    }

    public List<StatusMaster> getStatus_MasterCustomer() {
        return Status_MasterCustomer;
    }

    public void setStatus_MasterCustomer(List<StatusMaster> Status_MasterCustomer) {
        this.Status_MasterCustomer = Status_MasterCustomer;
    }

    @Entity
    public static class CustCategoryMasterBean {
        /**
         * AutoId : 30006
         * CatagoryId : 2
         * Value : Focus Client
         * Status : Y
         */
        @PrimaryKey@NonNull
        private String AutoId;
        @ColumnInfo
        private String CatagoryId;
        @ColumnInfo
        private String Value;
        @ColumnInfo
        private String Status;

        public String getAutoId() {
            return AutoId;
        }

        public void setAutoId(String AutoId) {
            this.AutoId = AutoId;
        }

        public String getCatagoryId() {
            return CatagoryId;
        }

        public void setCatagoryId(String CatagoryId) {
            this.CatagoryId = CatagoryId;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }
    }

    @Entity
    public static class CustTypeMasterBean {
        /**
         * AutoId : 40014
         * TypeId : 1
         * Value : Financial Services
         * Status : Y
         */
        @PrimaryKey@NonNull
        private String AutoId;
        @ColumnInfo
        private String TypeId;
        @ColumnInfo
        private String Value;
        @ColumnInfo
        private String Status;

        public String getAutoId() {
            return AutoId;
        }

        public void setAutoId(String AutoId) {
            this.AutoId = AutoId;
        }

        public String getTypeId() {
            return TypeId;
        }

        public void setTypeId(String TypeId) {
            this.TypeId = TypeId;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }
    }

    @Entity
    public static class TaskMasterBean {
        /**
         * autoId : 2
         * TaskValue : Breakdown Maintenance
         * CreatedBy : 30018
         * CreatedOn : 21/06/2017
         * Status : A
         * TaskID : 10003
         */
        @PrimaryKey@NonNull
        private String autoId;
        @ColumnInfo
        private String TaskValue;
        @ColumnInfo
        private String CreatedBy;
        @ColumnInfo
        private String CreatedOn;
        @ColumnInfo
        private String Status;
        @ColumnInfo
        private String TaskID;

        public String getAutoId() {
            return autoId;
        }

        public void setAutoId(String autoId) {
            this.autoId = autoId;
        }

        public String getTaskValue() {
            return TaskValue;
        }

        public void setTaskValue(String TaskValue) {
            this.TaskValue = TaskValue;
        }

        public String getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(String CreatedBy) {
            this.CreatedBy = CreatedBy;
        }

        public String getCreatedOn() {
            return CreatedOn;
        }

        public void setCreatedOn(String CreatedOn) {
            this.CreatedOn = CreatedOn;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getTaskID() {
            return TaskID;
        }

        public void setTaskID(String TaskID) {
            this.TaskID = TaskID;
        }
    }

    @Entity
    public static class StatusMaster {
        /**
         * status_Id : 1
         * status_Name : Implementation
         * status_color : #FFA500
         * active_status : Y
         * isActiveItself : Y
         */
        @PrimaryKey@NonNull
        private String status_Id;
        @ColumnInfo
        private String status_Name;
        @ColumnInfo
        private String status_color;
        @ColumnInfo
        private String active_status;
        @ColumnInfo
        private String isActiveItself;

        public String getStatus_Id() {
            return status_Id;
        }

        public void setStatus_Id(String status_Id) {
            this.status_Id = status_Id;
        }

        public String getStatus_Name() {
            return status_Name;
        }

        public void setStatus_Name(String status_Name) {
            this.status_Name = status_Name;
        }

        public String getStatus_color() {
            return status_color;
        }

        public void setStatus_color(String status_color) {
            this.status_color = status_color;
        }

        public String getActive_status() {
            return active_status;
        }

        public void setActive_status(String active_status) {
            this.active_status = active_status;
        }

        public String getIsActiveItself() {
            return isActiveItself;
        }

        public void setIsActiveItself(String isActiveItself) {
            this.isActiveItself = isActiveItself;
        }
    }
}
