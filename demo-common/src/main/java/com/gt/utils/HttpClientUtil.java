package com.gt.utils;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


@SuppressWarnings("deprecation")
public class HttpClientUtil {

	/**
	 * 发送get请求，获取返回内容
	 * @param url
	 * @param cookie
	 * @return
	 * @throws Exception
	 */
	public static String httpGet(String url,String cookie) throws Exception{  

        String result=""; //返回信息
        //创建一个httpGet请求
        HttpGet request=new HttpGet(url);
        //创建一个htt客户端
        @SuppressWarnings("resource")
        HttpClient httpClient=new DefaultHttpClient();
		//添加cookie到头文件
        request.addHeader("Cookie", cookie);
        //接受客户端发回的响应
        HttpResponse httpResponse=httpClient.execute(request);
       //获取返回状态
        int statusCode=httpResponse.getStatusLine().getStatusCode();
        if(statusCode== HttpStatus.SC_OK){
            //得到客户段响应的实体内容
            HttpEntity responseHttpEntity=httpResponse.getEntity();
            //得到输入流
            InputStream in=responseHttpEntity.getContent();
            //得到输入流的内容
            result=getData(in);
        }
        //Log.d(TAG, statusCode+"");
        return result;
    }
	
	
	/**
	 * 发送get请求，获取返回头文件header的值
	 * @param cookie 请求cookie
	 * @param header 返回头文件某值
	 * @return
	 * @throws Exception
	 */
	public static String httpGetHead(String url,String cookie,String header) throws Exception{  
        //get请求返回头文件
        String strResult = "";
        //创建一个httpGet请求
        HttpGet request=new HttpGet(url);
        //创建一个htt客户端
        @SuppressWarnings("resource")
        HttpClient httpClient=new DefaultHttpClient();
		//添加cookie到头文件
        request.addHeader("Cookie", cookie);
        //接受客户端发回的响应
        HttpResponse httpResponse=httpClient.execute(request);
        //获取返回状态
        int statusCode=httpResponse.getStatusLine().getStatusCode();
        if(statusCode== HttpStatus.SC_OK){
        	//取头文件信息
        	strResult=httpResponse.getHeaders(header)[0].getValue().toString();
//        	Header[] headers = httpResponse.getAllHeaders();//返回的HTTP头信息
//            for (int i=0; i<headers.length; i++) {
//            	System.out.println(headers[i]);
//            }
        }
        return strResult;
    }
	
	
	/**
     * 读取返回的信息
     * @param in
     * @return
     */
    private static String getData(InputStream in) {
        String result="";
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                //result = result + line;
                sb.append(line);
            }
            br.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    } 
    
    
    /**
     * 输入流转换成字符串
     * @param is: 输入流
     * @return 字符串对象
     */
    @SuppressWarnings("unused")
	private static String InputStreamToString(InputStream is){
        BufferedReader reader = null;
        StringBuffer responseText = null;
        String readerText = null;
        try {
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            responseText = new StringBuffer();
            readerText = reader.readLine();
            while(readerText != null){
                responseText.append(readerText);
                responseText.append(System.getProperty("line.separator"));
                readerText = reader.readLine();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseText.toString();
    }
    
    
    /**
     * 发送post请求，获取返回内容
     * @param url 请求地址
     * @param map 请求参数，map格式
     * @param cookie 请求cookie
     * @return
     */
    public static String httpPost(String url,Map<String,String> map,String cookie) {
    	//返回body
    	String body = "";  
        //1、创建一个htt客户端
        @SuppressWarnings("resource")
        HttpClient httpClient=new DefaultHttpClient();
        //2、创建一个HttpPost请求
        HttpPost response=new HttpPost(url);
        
        //3、设置参数
        //建立一个NameValuePair数组，用于存储欲传送的参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if(map!=null){  
            for (Entry<String, String> entry : map.entrySet()) {  
            	//添加参数
            	params.add( new BasicNameValuePair(entry.getKey(),entry.getValue()) );
            }         
        }      
        //4、设置参数到请求对象中  
        try {
			response.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}   
        System.out.println("请求地址："+url);  
        System.out.println("请求参数："+params.toString());  
		//5、设置header信息  
        response.setHeader("Accept", "text/html, application/xhtml+xml, */*"); 
        response.setHeader("Content-Type", "application/x-www-form-urlencoded");
        response.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))"); 
        //添加cookie到头文件
        response.setHeader("Cookie", cookie);
        
        //6、设置编码
        //response.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));      
        //7、执行post请求操作，并拿到结果（同步阻塞）  
        CloseableHttpResponse httpResponse;
		try {
			httpResponse = (CloseableHttpResponse) httpClient.execute(response);
			//获取结果实体  
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {  
				//按指定编码转换结果实体为String类型				
				body = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
        //释放链接  
        httpResponse.close();          
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return body;  
    }
    
    /**
     * post请求获取头文件信息
     * @param url 访问地址
     * @param map  请求参数
     * @param cookie  请求cookie 
     * @param headers 获取头文件headers的值
     * @return
     */
    public static String httpPostHead(String url,Map<String,String> map,String cookie,String headers) {   	
    	//返回header
    	String head = "";  
        //1、创建一个htt客户端
        @SuppressWarnings("resource")
        CloseableHttpClient httpClient=new DefaultHttpClient();
        //2、创建一个HttpPost请求
        HttpPost response=new HttpPost(url);
        
        //3、设置参数
        //建立一个NameValuePair数组，用于存储欲传送的参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if(map!=null){  
            for (Entry<String, String> entry : map.entrySet()) {  
            	//添加参数
            	params.add( new BasicNameValuePair(entry.getKey(),entry.getValue()) );
            }         
        }       
        //4、设置参数到请求对象中  
        try {
			response.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}  
       
		//5、设置header信息  
        response.setHeader("Content-type", "application/x-www-form-urlencoded");  
        response.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
        //添加cookie到头文件
        response.addHeader("Cookie", cookie);
        
        //6、设置编码
        //response.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));      
        //7、执行post请求操作，并拿到结果（同步阻塞）  
        CloseableHttpResponse httpResponse;
		try {
			httpResponse = (CloseableHttpResponse) httpClient.execute(response);
	        //获取返回状态
	        int statusCode=httpResponse.getStatusLine().getStatusCode();
	        if(statusCode == HttpStatus.SC_OK){
			//取头信息
	        head = httpResponse.getHeaders(headers)[0].getValue().toString();
	        }		
        //释放链接  
        httpResponse.close();          
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return head;  
    }
}
    

