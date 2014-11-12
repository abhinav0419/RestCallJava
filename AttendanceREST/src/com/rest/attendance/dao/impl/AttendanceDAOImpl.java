package com.rest.attendance.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.rest.attendance.constant.QueryConstant;
import com.rest.attendance.dao.AttendanceDAO;
import com.rest.attendance.exception.ApiException;
import com.rest.attendance.json.response.model.AttendanceRestAPIError;
import com.rest.attendance.model.Attendance;
import com.rest.attendance.model.ModelFactory;
import com.rest.attendance.util.QueryUtil;

public class AttendanceDAOImpl extends JdbcDaoSupport implements AttendanceDAO {

    private static final Logger log = Logger.getLogger(AttendanceDAOImpl.class);

    @Override
    public Attendance fetchCheckInTime(String userId, String logDate) {

        try {

            PreparedStatement statement = getJdbcTemplate().getDataSource().getConnection()
                    .prepareStatement(QueryUtil.get(QueryConstant.CHECKIN_TIME_QUERY));

            statement.setString(1, userId);
            statement.setString(2, logDate);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {

                do {
                    Attendance attendance = ModelFactory.getInstance().createAttendance(resultSet.getInt("deviceLogId"),
                            resultSet.getTimestamp("downloadDate"),
                            resultSet.getInt("deviceId"), resultSet.getString("userId"),
                            resultSet.getTimestamp("logDate"));

                    return attendance;
                } while (resultSet.next());

            }
            else {
                throw new ApiException(400, AttendanceRestAPIError.NoDataFound.getMessage(),
                        AttendanceRestAPIError.NoDataFound.getType());
            }
        } catch (ApiException apiExc) {
            throw apiExc;
        } catch (Exception exc) {
            log.error("Error occurred in fetchCheckInTime.", exc);
            throw new ApiException(400, AttendanceRestAPIError.DataBaseError.getMessage(),
                    AttendanceRestAPIError.DataBaseError.getType());
        }
    }

    @Override
    public Attendance fetchCheckOutTime(String userId, String logDate) {

        try {

            PreparedStatement statement = getJdbcTemplate().getDataSource().getConnection().
                    prepareStatement(QueryUtil.get(QueryConstant.CHECKOUT_TIME_QUERY));

            statement.setString(1, userId);
            statement.setString(2, logDate);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet != null && resultSet.next()) {
                do
                {
                    Attendance attendance = ModelFactory.getInstance().createAttendance(resultSet.getInt("deviceLogId"),
                            resultSet.getTimestamp("downloadDate"),
                            resultSet.getInt("deviceId"), resultSet.getString("userId"),
                            resultSet.getTimestamp("logDate"));

                    return attendance;
                } while (resultSet.next());
            }
            else {
                throw new ApiException(400, AttendanceRestAPIError.NoDataFound.getMessage(),
                        AttendanceRestAPIError.NoDataFound.getType());
            }
        } catch (ApiException apiExc) {
            throw apiExc;
        } catch (Exception exc) {
            log.error("Error occurred in fetchCheckOutTime.", exc);
            throw new ApiException(400, AttendanceRestAPIError.DataBaseError.getMessage(),
                    AttendanceRestAPIError.DataBaseError.getType());
        }
    }

    @Override
    public List<Attendance> fetchAttendanceBetweenDates(String userId, String strFromDate, String strToDate) {

        try {
            List<Attendance> attendanceList = new ArrayList<Attendance>();
            PreparedStatement statement = getJdbcTemplate().getDataSource().getConnection().
                    prepareStatement(QueryUtil.get(QueryConstant.ATTENDANCE_BETWEEN_DATES_QUERY));

            String fromDate = strFromDate.concat(" 00:00:00");
            String toDate = strToDate.concat(" 23:59:59");

            statement.setString(1, userId);
            statement.setString(2, fromDate);
            statement.setString(3, toDate);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet != null && resultSet.next())
            {
                do
                {
                    Attendance attendance = ModelFactory.getInstance().createAttendance(resultSet.getString("userid"),
                            resultSet.getTimestamp("min_logDate"), resultSet.getTimestamp("max_logDate"));

                    attendanceList.add(attendance);

                } while (resultSet.next());
                return attendanceList;
            }
            else {
                throw new ApiException(400, AttendanceRestAPIError.NoDataFound.getMessage(),
                        AttendanceRestAPIError.NoDataFound.getType());
            }
        } catch (ApiException apiExc) {
            throw apiExc;
        } catch (Exception exc) {
            log.error("Error occurred in fetchAttendanceBetweenDates.", exc);
            throw new ApiException(400, AttendanceRestAPIError.DataBaseError.getMessage(),
                    AttendanceRestAPIError.DataBaseError.getType());
        }
    }

    @Override
    public List<Attendance> fetchAttendanceBetweenDates(String strFromDate, String strToDate) {

        try {
            List<Attendance> attendanceList = new ArrayList<Attendance>();
            PreparedStatement statement = getJdbcTemplate().getDataSource().getConnection().
                    prepareStatement(QueryUtil.get(QueryConstant.ATTENDANCE_DATES_QUERY));

            String fromDate = strFromDate.concat(" 00:00:00");
            String toDate = strToDate.concat(" 23:59:59");

            statement.setString(1, fromDate);
            statement.setString(2, toDate);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet != null && resultSet.next())
            {
                do
                {
                    Attendance attendance = ModelFactory.getInstance().createAttendance(resultSet.getString("userid"),
                            resultSet.getTimestamp("min_logDate"), resultSet.getTimestamp("max_logDate"));

                    attendanceList.add(attendance);

                } while (resultSet.next());
                return attendanceList;
            }
            else {
                throw new ApiException(400, AttendanceRestAPIError.NoDataFound.getMessage(),
                        AttendanceRestAPIError.NoDataFound.getType());
            }
        } catch (ApiException apiExc) {
            throw apiExc;
        } catch (Exception exc) {
            log.error("Error occurred in fetchAttendanceBetweenDates.", exc);
            throw new ApiException(400, AttendanceRestAPIError.DataBaseError.getMessage(),
                    AttendanceRestAPIError.DataBaseError.getType());
        }
    }

}
