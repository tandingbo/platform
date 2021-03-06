package com.tdb.core.service.impl;

import com.tdb.core.dao.IAccountDao;
import com.tdb.core.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: AccountServiceImpl
 * Description:
 * Author: Tandingbo
 * Date: 2015/9/18 16:01
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public List<Map<String, Object>> listMapPage() {
        return accountDao.listMapPage();
    }
}
