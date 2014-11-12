package com.rest.attendance.model;

import java.util.Date;

public class Attendance {

    private Integer deviceLogId;
    private Date downloadDate;
    private Integer deviceId;
    private String userId;
    private Date logDate;
    private Date minLogDate;
    private Date maxLogDate;

    private String direction;

    public Integer getDeviceLogId() {
        return deviceLogId;
    }

    public void setDeviceLogId(Integer deviceLogId) {
        this.deviceLogId = deviceLogId;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Date getMinLogDate() {
        return minLogDate;
    }

    public void setMinLogDate(Date minLogDate) {
        this.minLogDate = minLogDate;
    }

    public Date getMaxLogDate() {
        return maxLogDate;
    }

    public void setMaxLogDate(Date maxLogDate) {
        this.maxLogDate = maxLogDate;
    }

}
