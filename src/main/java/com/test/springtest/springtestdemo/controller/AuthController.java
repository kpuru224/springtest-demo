package com.test.springtest.springtestdemo.controller;

import com.test.springtest.springtestdemo.request.LoginRequest;
import com.test.springtest.springtestdemo.response.LoginResponse;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/test")
public class AuthController {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    @PostMapping(value = "/authenticate", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponses(value = {@ApiResponse(code = 401, message = "UNAUTHORIZED", response = LoginResponse.class),
            @ApiResponse(code = 200, message = "OK", response = LoginResponse.class)
    })
    public ResponseEntity<Object> authenticate(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest)
            throws IOException, IllegalArgumentException, URISyntaxException {
        logger.info("message = Calling FSAPI to validate login");
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setResponseCode("00");
        loginResponse.setResponseMsg("Successful12");
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

}
