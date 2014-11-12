package com.rest.attendance.json.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AttendanceResponse")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class AttendanceResponse {

    @XmlElement(name = "deviceLogId") private String deviceLogId;
    @XmlElement(name = "deviceId") private String deviceId;
    @XmlElement(name = "userId") private String userId;
    @XmlElement(name = "logDate") private String logDate;
    @XmlElement(name = "minLogDate") private String minLogDate;
    @XmlElement(name = "maxLogDate") private String maxLogDate;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getMinLogDate() {
        return minLogDate;
    }

    public void setMinLogDate(String minLogDate) {
        this.minLogDate = minLogDate;
    }

    public String getMaxLogDate() {
        return maxLogDate;
    }

    public void setMaxLogDate(String maxLogDate) {
        this.maxLogDate = maxLogDate;
    }

    public String getDeviceLogId() {
        return deviceLogId;
    }

    public void setDeviceLogId(String deviceLogId) {
        this.deviceLogId = deviceLogId;
    }

}
