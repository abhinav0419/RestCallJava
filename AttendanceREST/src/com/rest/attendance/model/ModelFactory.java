package com.rest.attendance.model;

import java.util.Date;

public class ModelFactory {

    private static ModelFactory instance;

    public static ModelFactory getInstance()
    {
        if (instance == null)
        {
            instance = new ModelFactory();
        }
        return instance;
    }

    public Attendance createAttendance(int deviceLogId, Date downloadDate, int deviceId,
            String userId, Date logDate) {

        Attendance attendance = new Attendance();
        attendance.setDeviceLogId(deviceLogId);
        attendance.setDownloadDate(downloadDate);
        attendance.setDeviceId(deviceId);
        attendance.setUserId(userId);
        attendance.setLogDate(logDate);

        return attendance;
    }

    public Attendance createAttendance(String userId, Date minLogDate, Date maxLogDate) {

        Attendance attendance = new Attendance();
        attendance.setUserId(userId);
        attendance.setMinLogDate(minLogDate);
        attendance.setMaxLogDate(maxLogDate);

        return attendance;
    }

    public Attendance createAttendance() {
        return new Attendance();
    }
}
