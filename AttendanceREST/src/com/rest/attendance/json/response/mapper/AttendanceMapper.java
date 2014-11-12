package com.rest.attendance.json.response.mapper;

import java.util.ArrayList;
import java.util.List;

import com.rest.attendance.json.response.model.AttendanceResponse;
import com.rest.attendance.model.Attendance;
import com.rest.attendance.util.DateUtil;

public class AttendanceMapper {

    public static AttendanceResponse mapToAttendanceResponse(Attendance attendance)
    {
        AttendanceResponse attendanceResponse = new AttendanceResponse();
        
        attendanceResponse.setUserId(attendance.getUserId());
        attendanceResponse.setDeviceId(String.valueOf(attendance.getDeviceId()));
        attendanceResponse.setDeviceLogId(attendance.getDeviceLogId().toString());
        attendanceResponse.setLogDate(DateUtil.formatDateDDMMYYYYHHMMSS(attendance.getLogDate()));
        
        return attendanceResponse;

    }
    
    public static List<AttendanceResponse> mapToListOfAttendanceResponse(List<Attendance> attendanceList)
    {
        List<AttendanceResponse> attendanceResList = new ArrayList<AttendanceResponse>();
        
        for (Attendance attendance : attendanceList) {
            AttendanceResponse attendanceResponse = new AttendanceResponse();
            
            attendanceResponse.setUserId(attendance.getUserId());
            
           // attendanceResponse.setDeviceLogId(null);
           // attendanceResponse.setDeviceId(null);
            
            attendanceResponse.setMinLogDate(DateUtil.formatDateDDMMYYYYHHMMSS(attendance.getMinLogDate()));
            attendanceResponse.setMaxLogDate(DateUtil.formatDateDDMMYYYYHHMMSS(attendance.getMaxLogDate()));

            attendanceResList.add(attendanceResponse);
        }
        return attendanceResList;
    }
}
