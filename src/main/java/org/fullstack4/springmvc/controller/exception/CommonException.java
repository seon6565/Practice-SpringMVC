package org.fullstack4.springmvc.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@Log4j2
@ControllerAdvice
public class CommonException {
    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptNumber(NumberFormatException numberFormatException){
        log.info("============================");
        log.info(numberFormatException.getMessage());
        log.info("============================");
        return "Number format Exception";
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String except(Exception exception){
//        log.info("============================");
//        log.info(exception.getMessage());
//        StringBuffer sb = new StringBuffer("<ul>");
//        sb.append("<li>"+ exception.getMessage()+"</li>");
//        Arrays.stream(exception.getStackTrace()).forEach(el->{sb.append("<li>"+el+"</li>");});
//        sb.append("</ul>");
//        log.info("============================");
//        return sb.toString();
        return "/error/Exception";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "/error/404Exception";
    }

}
