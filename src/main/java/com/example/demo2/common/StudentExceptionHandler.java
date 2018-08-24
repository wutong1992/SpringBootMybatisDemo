package com.example.demo2.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class StudentExceptionHandler {
    public static final String STUDENT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response,
                               Exception e) {
        e.printStackTrace();
        if(isAjax(request)) {
            return response;
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(STUDENT_ERROR_VIEW);
            return mav;
        }
    }

    /**
     * 判断是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }
}