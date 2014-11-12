package com.rest.attendance.dao;

import java.util.List;

import com.rest.attendance.model.Attendance;

public interface AttendanceDAO {

    // return least check in time
    Attendance fetchCheckInTime(String userId, String logDate);

    // return highest check out time
    Attendance fetchCheckOutTime(String userId, String logDate);

    // return attendance list between fromDate and toDate of particular employee
    List<Attendance> fetchAttendanceBetweenDates(String userId, String fromDate, String toDate);
    
    //return attendance list of all employees between fromDate and toDate
    List<Attendance> fetchAttendanceBetweenDates(String fromDate, String toDate);
}

