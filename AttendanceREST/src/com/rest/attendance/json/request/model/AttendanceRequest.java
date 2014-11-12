package com.rest.attendance.json.request.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AttendanceRequest")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class AttendanceRequest {

    @XmlElement(name = "userId") private String userId;
    @XmlElement(name = "logDate") private String logDate;
    @XmlElement(name = "fromLogDate") private String fromLogDate;
    @XmlElement(name = "toLogDate") private String toLogDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromLogDate() {
        return fromLogDate;
    }

    public void setFromLogDate(String fromLogDate) {
        this.fromLogDate = fromLogDate;
    }

    public String getToLogDate() {
        return toLogDate;
    }

    public void setToLogDate(String toLogDate) {
        this.toLogDate = toLogDate;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

}
