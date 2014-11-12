package com.rest.attendance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.attendance.json.response.model.AttendanceResponse;

@Service
public interface AttendanceService {

    //return least check in time
    AttendanceResponse CheckInTime(String userId, String logDate);

    //return highest check out time
    AttendanceResponse CheckOutTime(String userId, String logDate);

    //return attendance list between date1 and date2
    List<AttendanceResponse> AttendanceBetweenDates(String userId, String fromDate, String toDate);

    //return attendance list of all employees between fromDate and toDate
    List<AttendanceResponse> AttendanceBetweenDates(String fromDate, String toDate);
}
