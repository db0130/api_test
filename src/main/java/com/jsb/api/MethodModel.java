package com.jsb.api;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.jsb.api.utils.SignUtil;

public class MethodModel {

	/**
	 * 加密Key
	 */
	String sessionKey = "54205c2a76c35bccc802d0e6a2ca2c4e";

	public static String secretKey = "5b69a9a677fb4bf9aed57c543a9c8e3e";
	/**
	 * 方法参数
	 */
	private Map<String, String> paramMap;
	/**
	 * 方法参数
	 */
	private Map<String, File> paramFileMap;

	/**
	 * 构造函数
	 */
	private MethodModel() {
		paramMap = new HashMap<String, String>();
		paramFileMap = new HashMap<String, File>();
		// Date currentTime = new Date();
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss");
		// String timestamp = format.format(currentTime);
		// paramMap.put("timestamp", timestamp);
		paramMap.put("appKey", "jsb_0b0c8368c3054d1c898c23a20c10c7f6");
		// paramMap.put("sessionKey", sessionKey);
		paramMap.put("format", "json");

		paramMap.put("ver", "2.0");
	}

	public static class Builder {
		private MethodModel methodModel = new MethodModel();

		public Builder method(String method) {
			methodModel.paramMap.put("method", method);
			return this;
		}

		public Builder appKey(String appKey) {
			methodModel.paramMap.put("appKey", appKey);
			return this;
		}

		public Builder sessionKey(String sessionKey) {
			methodModel.paramMap.put("sessionKey", sessionKey);
			return this;
		}

		public Builder version(String version) {
			methodModel.paramMap.put("ver", version);
			return this;
		}

		public Builder put(String key, String value) {
			methodModel.paramMap.put(key, value);
			return this;
		}

		public Builder putMap(Map<String, String> param) {
			methodModel.paramMap.putAll(param);
			return this;
		}

		public MethodModel build() {
			methodModel.paramMap.put("sign", SignUtil.getSignString(methodModel.paramMap, secretKey));
			return methodModel;
		}
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public Map<String, File> getParamFileMap() {
		return paramFileMap;
	}

	public void setParamFileMap(Map<String, File> paramFileMap) {
		this.paramFileMap = paramFileMap;
	}
}