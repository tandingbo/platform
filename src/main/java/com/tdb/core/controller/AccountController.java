package com.tdb.core.controller;

import com.tdb.base.controller.BaseController;
import com.tdb.core.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: AccountController
 * Description:
 * Author: Tandingbo
 * Date: 2015/9/18 15:59
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> listMapAccount(){
        Map<String, Object> result = new HashMap<String, Object>();
        return result;
    }
}
