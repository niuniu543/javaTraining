package com.geettime.work02;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {

    public static void main(String[] arges){
        try{
            String httpGet = httpGet("https://www.baidu.com");
            System.out.println("httpGet"+httpGet);
        }catch (Exception e){
          System.out.println("HJJJJJ");
        }


    }

    public static String httpGet(String url) throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            String strResult = EntityUtils.toString(entity);
            return strResult;
        } finally {
            response.close();
        }
    }
}
