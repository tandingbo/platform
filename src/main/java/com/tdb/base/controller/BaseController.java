package com.tdb.base.controller;

import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BaseController
 * Description:
 * Author: Tandingbo
 * Date: 2015/9/18 15:46
 */
public class BaseController {

    public Map<String, Object> result(Object data) {
        return result("", "", data);
    }

    public Map<String, Object> result(String code, String message) {
        return result(code, message, "");
    }

    public Map<String, Object> result(String code, String message, Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(code)) {
            code = "200";
        }
        if (StringUtils.isBlank(message)) {
            message = "";
        }
        map.put("code", code);
        map.put("message", message);
        map.put("data", data);
        return map;
    }
}
