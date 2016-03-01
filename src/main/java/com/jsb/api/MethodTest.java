package com.jsb.api;

import java.util.HashMap;
import java.util.Map;

import com.jsb.api.utils.HttpUtils;

public class MethodTest {

	// private static String secretKey = "5b69a9a677fb4bf9aed57c543a9c8e3e";
	//
	private static String POST_URL = "http://localhost:9091/router/api/rest/router";

	public static void main(String[] args) {
		//加载汽车品牌车系部件等基础数据
		Map<String,String> loadCarDictionaries = new HashMap<String,String>();
		loadCarDictionaries.put("method", "jsb.api.loadCarDictionaries");

		//获取部件或者加载热门汽车品牌 
		Map<String,String> getDictByKey = new HashMap<String,String>();
		getDictByKey.put("method", "jsb.api.getDictByKey");
		getDictByKey.put("key", "parts");
		//getDictByKey.put("key", "hotBrand");
		
		
		//获取部件或者加载热门汽车品牌 
		Map<String,String> getNewFileList = new HashMap<String,String>();
		getNewFileList.put("method", "jsb.api.getNewFileList");
		getNewFileList.put("userId", "6");
		getNewFileList.put("sessionKey", "c6a91d6a1480ab5e309043e08e2e5f24");
			
		//资料阅读
		Map<String,String> viewFile = new HashMap<String,String>();
		viewFile.put("method", "jsb.api.viewFile");
		viewFile.put("fileId", "1");
		
		
		//我的上传
		Map<String,String> myFileData = new HashMap<String,String>();
		myFileData.put("method", "jsb.api.myFileData");
		myFileData.put("sessionKey", "c6a91d6a1480ab5e309043e08e2e5f24");
		
		
		String resultJson = HttpUtils.postRequest(POST_URL, new MethodModel.Builder().putMap(myFileData).build().getParamMap(), "utf-8");
		System.out.println(resultJson);
	}

}
