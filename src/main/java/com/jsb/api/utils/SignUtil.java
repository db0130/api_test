package com.jsb.api.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;



public class SignUtil {

	
	public static String   getSignString(Map<String, String> paramMap,String sceretKey){
		// 验证sign、对参数进行排序
		TreeMap<String, String> paramTreeMap = new TreeMap<String, String>();
		Iterator<Entry<String, String>> entryIterator = paramMap.entrySet().iterator();
		while (entryIterator.hasNext()) {
				Entry<String, String> entry = entryIterator.next();
				String keyStr = entry.getKey();
				String value = entry.getValue();
				// sign参数不参与计算
				if (!"sign".equals(keyStr)) {
					paramTreeMap.put(keyStr, value);
				}
		}
		String sign = Md5Util.md5Signature(paramTreeMap, sceretKey);
		return sign;
	}
}
