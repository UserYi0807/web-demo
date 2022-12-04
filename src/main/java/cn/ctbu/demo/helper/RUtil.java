package cn.ctbu.demo.helper;

import cn.ctbu.demo.exception.REnum;
import cn.ctbu.demo.vo.R;

import javax.persistence.criteria.CriteriaBuilder;

public class RUtil {
    public static R success(Object object) {
        R result = new R();
        result.setCode(1);
        result.setData(object);
        result.setMsg("成功执行");

        return result;
    }

    public static R success() {
        return success(null);
    }

    public static R error(Integer code, String msg) {
        R result = new R();
        result.setCode(code);
        result.setData(null);
        result.setMsg(msg);

        return result;
    }

    public static R error(REnum rEnum) {
        return error(rEnum.getCode(), rEnum.getMsg());
    }
}
