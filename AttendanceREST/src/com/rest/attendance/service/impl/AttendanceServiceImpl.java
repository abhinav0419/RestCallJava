package com.rest.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.attendance.dao.AttendanceDAO;
import com.rest.attendance.json.response.mapper.AttendanceMapper;
import com.rest.attendance.json.response.model.AttendanceResponse;
import com.rest.attendance.model.Attendance;
import com.rest.attendance.service.AttendanceService;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {

    private AttendanceDAO attendanceDao;

    @Autowired
    public AttendanceServiceImpl(AttendanceDAO attendanceDao) {
        this.attendanceDao = attendanceDao;
    }

    @Override
    public AttendanceResponse CheckInTime(String userId, String logDate) {

        Attendance attendance = attendanceDao.fetchCheckInTime(userId, logDate);
        return AttendanceMapper.mapToAttendanceResponse(attendance);
    }

    @Override
    public AttendanceResponse CheckOutTime(String userId, String logDate) {

        Attendance attendance = attendanceDao.fetchCheckOutTime(userId, logDate);
        return AttendanceMapper.mapToAttendanceResponse(attendance);
    }

    @Override
    public List<AttendanceResponse> AttendanceBetweenDates(String userId, String fromDate, String toDate) {

        List<Attendance> attendances = attendanceDao.fetchAttendanceBetweenDates(userId, fromDate, toDate);
        return AttendanceMapper.mapToListOfAttendanceResponse(attendances);
    }

    @Override
    public List<AttendanceResponse> AttendanceBetweenDates(String fromDate, String toDate) {
       
        List<Attendance> attendances = attendanceDao.fetchAttendanceBetweenDates(fromDate, toDate);
        return AttendanceMapper.mapToListOfAttendanceResponse(attendances);
    }

}
