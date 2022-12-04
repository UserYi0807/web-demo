package cn.ctbu.demo.aspect;

import cn.ctbu.demo.exception.REnum;
import cn.ctbu.demo.exception.RException;
import cn.ctbu.demo.helper.RUtil;
import cn.ctbu.demo.vo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public R handle(Exception e) {
        if (e instanceof RException) {
            RException rException = (RException) e;
            return RUtil.error(rException.getCode(), rException.getMessage());
        }

        return RUtil.error(REnum.UNKNOWN_ERR);
    }
}
