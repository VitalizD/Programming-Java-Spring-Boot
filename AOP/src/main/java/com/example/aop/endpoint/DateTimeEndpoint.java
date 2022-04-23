package com.example.aop.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Endpoint(id = "dateTime")
public class DateTimeEndpoint {
    private final Logger logger = LoggerFactory.getLogger(DateTimeEndpoint.class);

    @ReadOperation
    public String dateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        var info = "DateTime actuator is called: " + formatter.format(new Date());
        logger.info(info);
        return info;
    }
}
