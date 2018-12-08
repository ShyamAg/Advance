package shyam.ram.advance.model.download;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

public class CustomerLocation {

    private String userid;
    private String Status;
    private String ReffreshTime;
    private String CustomerCount;
    private List<CustomerMasterBean> CustomerMaster;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getReffreshTime() {
        return ReffreshTime;
    }

    public void setReffreshTime(String ReffreshTime) {
        this.ReffreshTime = ReffreshTime;
    }

    public String getCustomerCount() {
        return CustomerCount;
    }

    public void setCustomerCount(String CustomerCount) {
        this.CustomerCount = CustomerCount;
    }

    public List<CustomerMasterBean> getCustomerMaster() {
        return CustomerMaster;
    }

    public void setCustomerMaster(List<CustomerMasterBean> CustomerMaster) {
        this.CustomerMaster = CustomerMaster;
    }

    public static class CustomerMasterBean {

        private String customerId;
        private String customerName;
        private String categoryId;
        private String typeId;
        private String salesPersonId;
        private String areaId;
        private String createdOn;
        private String createdBy;
        private String autoId;
        private String modifyBy;
        private String modifyDate;
        private String Status;
        private String statusId;
        private String colorId;
        private Object remark;
        private List<LocationMasterBean> LocationMaster;
        private List<PointOfContactsBean> PointOfContacts;
        private List<DynamicDetailCustomerBean> DynamicDetail_Customer;
        private List<?> DynamicDataCollection_Detail;
        private List<?> SecondaryFormDetail;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getSalesPersonId() {
            return salesPersonId;
        }

        public void setSalesPersonId(String salesPersonId) {
            this.salesPersonId = salesPersonId;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getCreatedOn() {
            return createdOn;
        }

        public void setCreatedOn(String createdOn) {
            this.createdOn = createdOn;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getAutoId() {
            return autoId;
        }

        public void setAutoId(String autoId) {
            this.autoId = autoId;
        }

        public String getModifyBy() {
            return modifyBy;
        }

        public void setModifyBy(String modifyBy) {
            this.modifyBy = modifyBy;
        }

        public String getModifyDate() {
            return modifyDate;
        }

        public void setModifyDate(String modifyDate) {
            this.modifyDate = modifyDate;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getStatusId() {
            return statusId;
        }

        public void setStatusId(String statusId) {
            this.statusId = statusId;
        }

        public String getColorId() {
            return colorId;
        }

        public void setColorId(String colorId) {
            this.colorId = colorId;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public List<LocationMasterBean> getLocationMaster() {
            return LocationMaster;
        }

        public void setLocationMaster(List<LocationMasterBean> LocationMaster) {
            this.LocationMaster = LocationMaster;
        }

        public List<PointOfContactsBean> getPointOfContacts() {
            return PointOfContacts;
        }

        public void setPointOfContacts(List<PointOfContactsBean> PointOfContacts) {
            this.PointOfContacts = PointOfContacts;
        }

        public List<DynamicDetailCustomerBean> getDynamicDetail_Customer() {
            return DynamicDetail_Customer;
        }

        public void setDynamicDetail_Customer(List<DynamicDetailCustomerBean> DynamicDetail_Customer) {
            this.DynamicDetail_Customer = DynamicDetail_Customer;
        }

        public List<?> getDynamicDataCollection_Detail() {
            return DynamicDataCollection_Detail;
        }

        public void setDynamicDataCollection_Detail(List<?> DynamicDataCollection_Detail) {
            this.DynamicDataCollection_Detail = DynamicDataCollection_Detail;
        }

        public List<?> getSecondaryFormDetail() {
            return SecondaryFormDetail;
        }

        public void setSecondaryFormDetail(List<?> SecondaryFormDetail) {
            this.SecondaryFormDetail = SecondaryFormDetail;
        }

        @Entity
        public static class LocationMasterBean {

            @PrimaryKey
            @NonNull
            private String locationId;
            @ColumnInfo
            private String customerId;
            @ColumnInfo
            private String locationName;
            @ColumnInfo
            private String latitude;
            @ColumnInfo
            private String longitude;
            @ColumnInfo
            private String status;
            @ColumnInfo
            private String contactNumber;
            @ColumnInfo
            private String faxNumber;
            @ColumnInfo
            private String createdBy;
            @ColumnInfo
            private String createdDate;
            @ColumnInfo
            private String image;
            @ColumnInfo
            private String modifyBy;
            @ColumnInfo
            private String modifyDate;
            @ColumnInfo
            private String completeAddress;
//            @ColumnInfo
//            private String CompleteLocationAddress;

            public String getLocationId() {
                return locationId;
            }

            public void setLocationId(String locationId) {
                this.locationId = locationId;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getLocationName() {
                return locationName;
            }

            public void setLocationName(String locationName) {
                this.locationName = locationName;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getContactNumber() {
                return contactNumber;
            }

            public void setContactNumber(String contactNumber) {
                this.contactNumber = contactNumber;
            }

            public String getFaxNumber() {
                return faxNumber;
            }

            public void setFaxNumber(String faxNumber) {
                this.faxNumber = faxNumber;
            }

            public String getCreatedBy() {
                return createdBy;
            }

            public void setCreatedBy(String createdBy) {
                this.createdBy = createdBy;
            }

            public String getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(String createdDate) {
                this.createdDate = createdDate;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getModifyBy() {
                return modifyBy;
            }

            public void setModifyBy(String modifyBy) {
                this.modifyBy = modifyBy;
            }

            public String getModifyDate() {
                return modifyDate;
            }

            public void setModifyDate(String modifyDate) {
                this.modifyDate = modifyDate;
            }

            public String getCompleteAddress() {
                return completeAddress;
            }

            public void setCompleteAddress(String completeAddress) {
                this.completeAddress = completeAddress;
            }

//            public String getCompleteLocationAddress() {
//                return CompleteLocationAddress;
//            }
//
//            public void setCompleteLocationAddress(CompleteLocationAddressBean CompleteLocationAddress) {
//                this.CompleteLocationAddress = CompleteLocationAddress.toString();
//            }

            public static class CompleteLocationAddressBean {
                /**
                 * postalCode : NA
                 * country : NA
                 * state :
                 * city :
                 * locality :
                 * streetName :
                 */

                private String postalCode;
                private String country;
                private String state;
                private String city;
                private String locality;
                private String streetName;

                public String getPostalCode() {
                    return postalCode;
                }

                public void setPostalCode(String postalCode) {
                    this.postalCode = postalCode;
                }

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getLocality() {
                    return locality;
                }

                public void setLocality(String locality) {
                    this.locality = locality;
                }

                public String getStreetName() {
                    return streetName;
                }

                public void setStreetName(String streetName) {
                    this.streetName = streetName;
                }
            }
        }

        public static class PointOfContactsBean {
            /**
             * pocId : P190365M1010
             * customerId : C190365M1006
             * pocName : gwha h
             * designation : NA
             * email : NA
             * contactNo : 0
             * createdBy : 190365
             * createdDate : 2017-12-28 16:15:08.000
             * modifyBy : 30018
             * modifyDate : 2018-08-16 14:06:50.000
             * activeStatus : N
             */

            private String pocId;
            private String customerId;
            private String pocName;
            private String designation;
            private String email;
            private String contactNo;
            private String createdBy;
            private String createdDate;
            private String modifyBy;
            private String modifyDate;
            private String activeStatus;

            public String getPocId() {
                return pocId;
            }

            public void setPocId(String pocId) {
                this.pocId = pocId;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getPocName() {
                return pocName;
            }

            public void setPocName(String pocName) {
                this.pocName = pocName;
            }

            public String getDesignation() {
                return designation;
            }

            public void setDesignation(String designation) {
                this.designation = designation;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getContactNo() {
                return contactNo;
            }

            public void setContactNo(String contactNo) {
                this.contactNo = contactNo;
            }

            public String getCreatedBy() {
                return createdBy;
            }

            public void setCreatedBy(String createdBy) {
                this.createdBy = createdBy;
            }

            public String getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(String createdDate) {
                this.createdDate = createdDate;
            }

            public String getModifyBy() {
                return modifyBy;
            }

            public void setModifyBy(String modifyBy) {
                this.modifyBy = modifyBy;
            }

            public String getModifyDate() {
                return modifyDate;
            }

            public void setModifyDate(String modifyDate) {
                this.modifyDate = modifyDate;
            }

            public String getActiveStatus() {
                return activeStatus;
            }

            public void setActiveStatus(String activeStatus) {
                this.activeStatus = activeStatus;
            }
        }

        public static class DynamicDetailCustomerBean {
            /**
             * fieldId : F17
             * customerId : C190365M1006
             * value : daf
             */

            private String fieldId;
            private String customerId;
            private String value;

            public String getFieldId() {
                return fieldId;
            }

            public void setFieldId(String fieldId) {
                this.fieldId = fieldId;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
