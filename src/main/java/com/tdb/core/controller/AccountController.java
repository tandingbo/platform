package com.tdb.core.controller;

import com.tdb.base.controller.BaseController;
import com.tdb.base.page.Pager;
import com.tdb.core.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
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
    public ModelAndView listMapAccount() {
        List<Map<String, Object>> listMap = accountService.listMapPage();


        int totalCount = listMap.size();
        Pager pager = new Pager(totalCount, 1);
        pager.setList(listMap);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("page", pager);
        return new ModelAndView("", model);
    }
}
