package com.tdb.core.dao;

import java.util.List;
import java.util.Map;

/**
 * ClassName: IAccountDao
 * Description:
 * Author: Tandingbo
 * Date: 2015/9/18 16:00
 */
public interface IAccountDao {
    List<Map<String,Object>> listMapPage();
}
