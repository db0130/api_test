package com.jsb.api.utils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpUtils {

	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    //连接超时时间，默认30秒
    private static int connectTimeout = 30*1000;
    
    //数据传输超时时间，默认30秒
    private static int socketTimeout = 30*1000;
    
    public static  String  postRequest(String urlAndParameter){
    	 CloseableHttpClient httpClient = HttpClients.custom().build();
    	 logger.debug("=================【http请求】urlAndParameter={}", urlAndParameter);
   	     HttpPost httpPost = new HttpPost(urlAndParameter);
   	     //设置请求器的配置
         RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();          
         httpPost.setConfig(requestConfig);
         String result = null;
         try {       	 
             HttpResponse response = httpClient.execute(httpPost);
             HttpEntity entity = response.getEntity();
             if(entity!=null && response.getStatusLine().getStatusCode()==200){
           	     result = EntityUtils.toString(entity, "UTF-8");
             }            
         } catch (ConnectionPoolTimeoutException e) {
              logger.error("http连接超时,url="+urlAndParameter,e);
         } catch (ConnectTimeoutException e) {
       	      logger.error("http连接超时,url="+urlAndParameter,e);
         } catch (SocketTimeoutException e) {
       	     logger.error("http读取数据超时,url="+urlAndParameter,e);
         } catch (Exception e) {
       	     logger.error("http请求其它错误,url="+urlAndParameter,e);
         } 
         finally {
       	    if(httpClient!=null){
       		      try {	 httpClient.close();  } catch ( IOException e ) {	}
       	    }        	  
         }
         logger.debug("=================【http返回】result={}", result);
         return result;
    }
    
    public  static String  postRequest(String url, Map<String, String> parameterMap, String encoding){
   	     CloseableHttpClient httpClient = HttpClients.custom().build();
   	     logger.debug("=================【http请求】url={}, parameterMap={}", url, parameterMap);
  	     HttpPost httpPost = new HttpPost(url);
  	     //httpPost.seth
  	     //设置请求器的配置
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();          
        httpPost.setConfig(requestConfig);
        String result = null;
        try {  
        	List<BasicNameValuePair> parameterList = new ArrayList<BasicNameValuePair>();
        	Set<Entry<String,String>> entrySet = parameterMap.entrySet();
        	for(Iterator<Entry<String,String>> it = entrySet.iterator(); it.hasNext(); ){
        		Entry<String,String> entry = it.next();
        		parameterList.add( new BasicNameValuePair(entry.getKey(), entry.getValue() ) );
        	}        	
        	HttpEntity formEntity = new UrlEncodedFormEntity(parameterList, encoding);
        	httpPost.setEntity(formEntity);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if(entity!=null && response.getStatusLine().getStatusCode()==200){
          	     result = EntityUtils.toString(entity, "UTF-8");
            }            
        } catch (ConnectionPoolTimeoutException e) {
             logger.error("http连接超时,url="+url,e);
        } catch (ConnectTimeoutException e) {
      	      logger.error("http连接超时,url="+url,e);
        } catch (SocketTimeoutException e) {
      	     logger.error("http读取数据超时,url="+url,e);
        } catch (Exception e) {
      	     logger.error("http请求其它错误,url="+url,e);
        } 
        finally {
      	    if(httpClient!=null){
      		      try {	 httpClient.close();  } catch ( IOException e ) {	}
      	    }        	  
        }
        logger.debug("=================【http返回】result={}", result);
        return result;
   }
    
    
    public  static String  postRequestDown(String url, String encoding){
  	     CloseableHttpClient httpClient = HttpClients.custom().build();
 	     HttpPost httpPost = new HttpPost(url);
 	     //httpPost.seth
 	     //设置请求器的配置
       RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();          
       httpPost.setConfig(requestConfig);
       String result = null;
       try {  
     //  	List<BasicNameValuePair> parameterList = new ArrayList<BasicNameValuePair>();
       	/*Set<Entry<String,String>> entrySet = parameterMap.entrySet();
       	for(Iterator<Entry<String,String>> it = entrySet.iterator(); it.hasNext(); ){
       		Entry<String,String> entry = it.next();
       		parameterList.add( new BasicNameValuePair(entry.getKey(), entry.getValue() ) );
       	}  */      	
       /*	HttpEntity formEntity = new UrlEncodedFormEntity(parameterList, encoding);
       	httpPost.setEntity(formEntity);*/
    	   
    	   
    	   httpPost.addHeader("Referer", "http://www.gzweix.com/soft/softdown.asp");
           HttpResponse response = httpClient.execute(httpPost);
           Header head[] = response.getAllHeaders();
           for(Header item :head){
        	   System.out.println(item.getName()+"="+item.getValue());
           }
           HttpEntity entity = response.getEntity();
           if(entity!=null && response.getStatusLine().getStatusCode()==200){
         	     result = EntityUtils.toString(entity, "UTF-8");
           }            
       } catch (ConnectionPoolTimeoutException e) {
            logger.error("http连接超时,url="+url,e);
       } catch (ConnectTimeoutException e) {
     	      logger.error("http连接超时,url="+url,e);
       } catch (SocketTimeoutException e) {
     	     logger.error("http读取数据超时,url="+url,e);
       } catch (Exception e) {
     	     logger.error("http请求其它错误,url="+url,e);
       } 
       finally {
     	    if(httpClient!=null){
     		      try {	 httpClient.close();  } catch ( IOException e ) {	}
     	    }        	  
       }
       logger.debug("=================【http返回】result={}", result);
       return result;
  }
    
   public static  String  getRequest(String urlAndParameter){
   	     CloseableHttpClient httpClient = HttpClients.custom().build();
   	     logger.debug("=================【http请求】urlAndParameter={}", urlAndParameter);
  	     HttpGet httpGet = new HttpGet(urlAndParameter);
  	     //设置请求器的配置
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();          
        httpGet.setConfig(requestConfig);
        String result = null;
        try {       	 
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity!=null && response.getStatusLine().getStatusCode()==200){
          	     result = EntityUtils.toString(entity, "UTF-8");
            }            
        } catch (ConnectionPoolTimeoutException e) {
             logger.error("http连接超时,url="+urlAndParameter,e);
        } catch (ConnectTimeoutException e) {
      	      logger.error("http连接超时,url="+urlAndParameter,e);
        } catch (SocketTimeoutException e) {
      	     logger.error("http读取数据超时,url="+urlAndParameter,e);
        } catch (Exception e) {
      	     logger.error("http请求其它错误,url="+urlAndParameter,e);
        } 
        finally {
      	    if(httpClient!=null){
      		      try {	 httpClient.close();  } catch ( IOException e ) {	}
      	    }        	  
        }
        logger.debug("=================【http返回】result={}", result);
        return result;
   }
    
    
   public static void main(String[] args){
	  
	   String result = HttpUtils.postRequestDown("http://www.gzweix.com/soft/download.asp?softid=74254&downid=8&id=74061","UTF-8");
	   System.out.println(result);
   }
    
}
