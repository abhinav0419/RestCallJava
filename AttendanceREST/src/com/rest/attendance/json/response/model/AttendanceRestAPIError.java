package com.rest.attendance.json.response.model;

public enum AttendanceRestAPIError {

    UnknowError("UnknownError", "Unknown error occurred."),
    NoDataFound("NoDataFound", "No data found."),
    UserIdIsNull("UserIdIsNull", "UserId is missing."),
    LogDateIsNull("LogDateIsNull", "LogDate is missing."),
    FromLogDateIsNull("FromLogDateIsNull", "FromLogDate is missing."),
    ToLogDateIsNull("ToLogDateIsNull", "ToLogDate is missing."),
    DataBaseError("DataBaseError", "Sorry, Some database error occured. Please try after some time."),
    InvalidRequest("InvalidRequest","Invalid request sent");
    
    private String errorType;
    private String errorMessage;

    AttendanceRestAPIError(final String type, final String message) {
        this.errorType = type;
        this.errorMessage = message;
    }

    public String getMessage() {
        return errorMessage;
    }

    public String getType() {
        return errorType;
    }

}
