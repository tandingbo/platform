package com.tdb.base.commons.utils.dbupdate.service;

import com.tdb.base.commons.exception.ServiceAccessException;
import org.springframework.core.Ordered;

/**
 * ClassName: DbUpdateService
 * Description: 定义一数据库升级服务接口
 * Author: Tandingbo
 * Date: 2015/9/18 16:02
 */
public interface DbUpdateService extends Ordered {
    /**
     * 检查数据库是否需要升级，如果需要升级则启动数据库升级程序
     *
     * @throws ServiceAccessException
     */
    public void checkDbUpdate() throws ServiceAccessException;
}
