package com.rest.attendance.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rest.attendance.context.ApplicationContextProvider;
import com.rest.attendance.json.request.model.AttendanceRequest;
import com.rest.attendance.json.response.model.AttendanceResponse;
import com.rest.attendance.service.AttendanceService;
import com.rest.attendance.validation.AttendanceRequestValidator;

@Component("attendanceEndPoint")
@Scope("singleton")
@Path("/1.0/attendance")
@Produces(value = { MediaType.APPLICATION_JSON })
@Consumes(value = { MediaType.APPLICATION_JSON })
public class AttendanceController {

    @GET
    @Path("/echo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testMsg() {

        String output = "Attendance REST service is up.";

        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/checkin")
    public AttendanceResponse fetchCheckInTime(AttendanceRequest attendanceRequest) {

        AttendanceRequestValidator.validate(attendanceRequest);
        AttendanceService attendanceService = ApplicationContextProvider.getApplicationContext().getBean(AttendanceService.class);
        AttendanceResponse response = attendanceService.CheckInTime(attendanceRequest.getUserId(),
                attendanceRequest.getLogDate());
        return response;
    }

    @POST
    @Path("/checkout")
    public AttendanceResponse fetchCheckOutTime(AttendanceRequest attendanceRequest) {

        AttendanceRequestValidator.validate(attendanceRequest);
        AttendanceService attendanceService = ApplicationContextProvider.getApplicationContext().getBean(AttendanceService.class);
        AttendanceResponse response = attendanceService.CheckOutTime(attendanceRequest.getUserId(),
                attendanceRequest.getLogDate());

        return response;

    }

    @POST
    @Path("/filterbydates")
    public List<AttendanceResponse> fetchAttendanceBetweenDates(AttendanceRequest attendanceRequest) {

        AttendanceRequestValidator.validateWithFilterDate(attendanceRequest);
        AttendanceService attendanceService = ApplicationContextProvider.getApplicationContext().getBean(AttendanceService.class);
        List<AttendanceResponse> response = attendanceService.AttendanceBetweenDates(attendanceRequest.getUserId(), attendanceRequest.getFromLogDate(), attendanceRequest.getToLogDate());

        return response;
    }
    
    @POST
    @Path("/attendancedates")
    public List<AttendanceResponse> fetchAttendanceDates(AttendanceRequest attendanceRequest) {

        AttendanceRequestValidator.validateWithDate(attendanceRequest);
        AttendanceService attendanceService = ApplicationContextProvider.getApplicationContext().getBean(AttendanceService.class);
        List<AttendanceResponse> response = attendanceService.AttendanceBetweenDates(attendanceRequest.getFromLogDate(), attendanceRequest.getToLogDate());

        return response;
    }

}
