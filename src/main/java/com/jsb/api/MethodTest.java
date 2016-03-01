package com.jsb.api;

import java.io.IOException;

import com.jsb.api.utils.HttpUtils;

 

public class MethodTest {

	//private static String POST_URL = "http://openapi.openoo.com/forward/api/rest/router";
	//private static String POST_URL = "http://119.96.122.133:81/forward/api/rest/router";
	//private static String POST_URL = "https://192.168.1.16/forward/api/rest/router";
	//private static String POST_URL = "http://192.168.1.110:8080/scan/api/rest/router";
	//private static String POST_URL = "http://182.92.116.107:80/forward/api/rest/router";
	private static String secretKey = "5b69a9a677fb4bf9aed57c543a9c8e3e";
	//
	//private static String POST_URL = "http://scan.daboowifi.net/forward/api/rest/router";
	private static String POST_URL = "http://192.168.0.254:9090/jsb-router/api/rest/router";
	
	public static void main(String[] args) {
		String aa = "";
		try {
			//user_login_m = new MethodModel("jsb.api.getDictByKey");
			
			//user_login_m.getParamMap().put("key", "parts");
			//MethodModel.Builder
			String resultJson = HttpUtils.postRequest(POST_URL,new MethodModel.Builder().build().getParamMap() , "utf-8");
			//System.out.println(resultJson);
			//aa = MethodTest.doPost(POST_URL, MethodConstant.user_login_m.getParamMap(), MethodConstant.user_login_m.getParamFileMap(), 300000, 1500000, null, secretKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(aa);
		//pushNew();
	}
	
}
