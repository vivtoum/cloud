package com.kwdz.files.system.config;

import com.kwdz.commons.util.ResultModel;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author vedyou
 * @version 0.0.1
 * @date: 2019/5/15 19:55
 */
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)
            throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", ResultModel.of(e.getMessage(), false, "EXCEPTION"));
        mv.setViewName(DEFAULT_ERROR_VIEW);
        return mv;
    }
}
