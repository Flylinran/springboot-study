package cn.flylinran.handle;

import cn.flylinran.vo.Msg;
import cn.flylinran.exception.BusinessException;
import cn.flylinran.exception.ExceptionCode;
import cn.flylinran.exception.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description: 异常处理
 * version: 1.0
 */
@ControllerAdvice
public class ExceptionHandle {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 基于@ExceptionHandler异常处理
     *
     * @param ex 捕获的异常
     * @return 自定义响应实体 {@link Msg}
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Msg exp(Exception ex) {
        logger.info("异常信息 -> {}", ex.getMessage());
        ex.printStackTrace();
        if (ex instanceof BusinessException) {
            return Msg.fail()
                    .setCode(((BusinessException) ex).getCode())
                    .setMessage(ex.getMessage());
        } else if (ex instanceof ParameterException) {
            return Msg.fail()
                    .setCode(ExceptionCode.EX_10001.getCode())
                    .setMessage(ex.getMessage());
        }
        return Msg.fail()
                .setCode(ExceptionCode.EX_10002.getCode())
                .setMessage(ExceptionCode.EX_10002.getMessage());
    }
}
