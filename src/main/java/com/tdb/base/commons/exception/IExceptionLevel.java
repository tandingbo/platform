package com.tdb.base.commons.exception;

import com.zjhc.commons.exception.enums.ExceptionLevel;

/**
 * 异常级别接口
 *
 * 创建日期：2012-12-18
 * @author wangk
 */
public interface IExceptionLevel {
	
	/**
	 * 获得异常对象的日志级别
	 *
	 * @return
	 * 创建日期：2012-12-18
	 * 修改说明：
	 * @author wangk
	 */
	ExceptionLevel getLevel();
}
