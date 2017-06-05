package cn.flylinran.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.flylinran.vo.Msg;

import javax.servlet.http.HttpServletRequest;

/**
 * author: huzunrong
 * date: 2017/6/5
 * description:
 * version: 1.0
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Msg defaultErrorHandler(HttpServletRequest request, Exception ex) {
        System.out.println(ex.getMessage());
        return Msg.fail().add("ex", ex.getMessage());
    }

}
