package com.tdb.base.commons.web.resolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;

import com.zjhc.commons.utils.ObjectUtil;
import com.zjhc.commons.utils.converter.StringToStringURLConverter;

/**
 * @description
 * 创建日期：2013-2-19
 * @author wangk
 * @since trse-commons
 */
public class CascadeParamMethodArgumentResolverWK extends
		AbstractNamedValueMethodArgumentResolver {

	public CascadeParamMethodArgumentResolverWK(){
		super(null);
	}
	
	public CascadeParamMethodArgumentResolverWK(
			ConfigurableBeanFactory beanFactory) {
		super(beanFactory);
	}

	/** 
	 * @see org.springframework.web.method.support.HandlerMethodArgumentResolver#supportsParameter(MethodParameter)
	 * 创建日期：2013-2-19
	 * 修改说明：
	 * @author wangk
	 */
	@Override
	public boolean supportsParameter(MethodParameter methodparameter) {
		return methodparameter.hasParameterAnnotation(CascadeParam.class);
	}

	/** 
	 * @see AbstractNamedValueMethodArgumentResolver#createNamedValueInfo(MethodParameter)
	 * 创建日期：2013-2-19
	 * 修改说明：
	 * @author wangk
	 */
	@Override
	protected NamedValueInfo createNamedValueInfo(
			MethodParameter methodparameter) {
		final class CascadeParamNamedValueInfo extends NamedValueInfo{

			public CascadeParamNamedValueInfo(String name, boolean flag,
					String defaultValue) {
				super(name, flag, defaultValue);
			}
			
		}
		return new CascadeParamNamedValueInfo("", false, "");
	}

	/** 
	 * @see AbstractNamedValueMethodArgumentResolver#handleMissingValue(String, MethodParameter)
	 * 创建日期：2013-2-19
	 * 修改说明：
	 * @author wangk
	 */
	@Override
	protected void handleMissingValue(String name, MethodParameter methodparameter)
			throws ServletException {
		throw new MissingServletRequestParameterException(name, methodparameter.getParameterType().getName());
	}

	/** 
	 * @see AbstractNamedValueMethodArgumentResolver#resolveName(String, MethodParameter, NativeWebRequest)
	 * 创建日期：2013-2-19
	 * 修改说明：
	 * @author wangk
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Object resolveName(String name, MethodParameter methodparameter,
			NativeWebRequest nativewebrequest) throws Exception {
		Set<String> keys = nativewebrequest.getParameterMap().keySet();
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<String> iterable = nativewebrequest.getHeaderNames();
		while(iterable.hasNext()){
			System.out.println(iterable.next());
		}
		for (String key : keys) {
			if(key.matches("^" + name + "[\\.\\[].*$")){
				Object value = null;
				String[] values = nativewebrequest.getParameterValues(key);
				for (int i = 0; i<values.length; i++) {
					values[i] = new StringToStringURLConverter().convert(values[i]);
				}
				if(values.length == 1){
					value = values[0];
				}else if(values.length>1){
					value = Arrays.asList(values);
				}
				key = key.replace("[", ".").replace("]", "");
				String[] subKeys = key.split("\\.");
				Map<String, Object> oldMap = map;
				for (int i = 1; i<subKeys.length; i++) {
					if(isValidKey(subKeys[i])){
						if(i == subKeys.length-1){
							oldMap.put(subKeys[i], value);
						}else{
							Map<String, Object> newMap = (Map<String, Object>)oldMap.get(subKeys[i]);
							if(newMap == null) {
								newMap = new HashMap<String, Object>();
								oldMap.put(subKeys[i], newMap);
							}
							oldMap = newMap;
						}
					}
				}
			}
		}
//		JSONObject jsonObject = JSONObject.fromObject(map);
//		return JSONObject.toBean(jsonObject, methodparameter.getParameterType());
		return ObjectUtil.parse(map, methodparameter.getParameterType());
	}
	
	private boolean isValidKey(String key){
		return key.matches("^[A-Za-z_].*$");
	}
	
}
