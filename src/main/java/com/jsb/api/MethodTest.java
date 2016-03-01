package com.jsb.api;

import com.jsb.api.utils.HttpUtils;

public class MethodTest {

	// private static String secretKey = "5b69a9a677fb4bf9aed57c543a9c8e3e";
	//
	private static String POST_URL = "http://192.168.0.254:9090/jsb-router/api/rest/router";

	public static void main(String[] args) {

		String resultJson = HttpUtils.postRequest(POST_URL, new MethodModel.Builder().build().getParamMap(), "utf-8");
		System.out.println(resultJson);
	}

}
