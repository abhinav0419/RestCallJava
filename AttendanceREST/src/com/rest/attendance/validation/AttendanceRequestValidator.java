package com.rest.attendance.validation;

import com.rest.attendance.exception.ApiException;
import com.rest.attendance.json.request.model.AttendanceRequest;
import com.rest.attendance.json.response.model.AttendanceRestAPIError;

public class AttendanceRequestValidator {

    public static boolean validate(AttendanceRequest attendanceRequest)
    {
        if (attendanceRequest != null)
        {
            if (isNullOrEmpty(attendanceRequest.getUserId()) && isNullOrEmpty(attendanceRequest.getLogDate()))
            {
                throw new ApiException(400, AttendanceRestAPIError.InvalidRequest.getMessage(),
                        AttendanceRestAPIError.InvalidRequest.getType());
            }
            else if (isNullOrEmpty(attendanceRequest.getUserId()))
            {
                throw new ApiException(400, AttendanceRestAPIError.UserIdIsNull.getMessage(),
                        AttendanceRestAPIError.UserIdIsNull.getType());
            }
            else if (isNullOrEmpty(attendanceRequest.getLogDate()))
            {
                throw new ApiException(400, AttendanceRestAPIError.LogDateIsNull.getMessage(),
                        AttendanceRestAPIError.LogDateIsNull.getType());
            }
            return true;
        }
        else {
            throw new ApiException(400, AttendanceRestAPIError.InvalidRequest.getMessage(),
                    AttendanceRestAPIError.InvalidRequest.getType());
        }
    }

    public static boolean validateWithFilterDate(AttendanceRequest attendanceRequest)
    {
        if (attendanceRequest != null)
        {
            if (isNullOrEmpty(attendanceRequest.getUserId()) && isNullOrEmpty(attendanceRequest.getFromLogDate()) && isNullOrEmpty(attendanceRequest.getToLogDate()))
            {
                throw new ApiException(400, AttendanceRestAPIError.InvalidRequest.getMessage(),
                        AttendanceRestAPIError.InvalidRequest.getType());
            }
            else if (isNullOrEmpty(attendanceRequest.getUserId()))
            {
                throw new ApiException(400, AttendanceRestAPIError.UserIdIsNull.getMessage(),
                        AttendanceRestAPIError.UserIdIsNull.getType());
            }
            else if (isNullOrEmpty(attendanceRequest.getFromLogDate()))
            {
                throw new ApiException(400, AttendanceRestAPIError.FromLogDateIsNull.getMessage(),
                        AttendanceRestAPIError.FromLogDateIsNull.getType());
            }
            else if (isNullOrEmpty(attendanceRequest.getToLogDate()))
            {
                throw new ApiException(400, AttendanceRestAPIError.ToLogDateIsNull.getMessage(),
                        AttendanceRestAPIError.ToLogDateIsNull.getType());
            }
            return true;
        }
        else {
            throw new ApiException(400, AttendanceRestAPIError.InvalidRequest.getMessage(),
                    AttendanceRestAPIError.InvalidRequest.getType());
        }

    }
    
    public static boolean validateWithDate(AttendanceRequest attendanceRequest)
    {
        if (attendanceRequest != null)
        {
            if (isNullOrEmpty(attendanceRequest.getFromLogDate()) && isNullOrEmpty(attendanceRequest.getToLogDate()))
            {
                throw new ApiException(400, AttendanceRestAPIError.InvalidRequest.getMessage(),
                        AttendanceRestAPIError.InvalidRequest.getType());
            }
            else if (isNullOrEmpty(attendanceRequest.getFromLogDate()))
            {
                throw new ApiException(400, AttendanceRestAPIError.FromLogDateIsNull.getMessage(),
                        AttendanceRestAPIError.FromLogDateIsNull.getType());
            }
            else if (isNullOrEmpty(attendanceRequest.getToLogDate()))
            {
                throw new ApiException(400, AttendanceRestAPIError.ToLogDateIsNull.getMessage(),
                        AttendanceRestAPIError.ToLogDateIsNull.getType());
            }
            return true;
        }
        else {
            throw new ApiException(400, AttendanceRestAPIError.InvalidRequest.getMessage(),
                    AttendanceRestAPIError.InvalidRequest.getType());
        }

    }

    private static boolean isNullOrEmpty(String value)
    {
        if (value == null || value.trim().length() == 0)
        {
            return true;
        }

        return false;
    }

}
