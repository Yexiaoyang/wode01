package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
//function:comepare,return:confidence;
public class Compare {
    public static void main(String[] args) throws Exception {
//      ������ַ
        String url = "https://api-cn.faceplusplus.com/facepp/v3/compare";
//        ������������    
        List<BasicNameValuePair> formparams = new ArrayList<>();  
        formparams.add(new BasicNameValuePair("api_key", "oSmo_Zm-pEwPy895GkD0GdjOAlcgqJ_C"));  
        formparams.add(new BasicNameValuePair("api_secret", "86Ujr5lbZEH3s8B_771n_R23n_NaXCUp"));  
        formparams.add(new BasicNameValuePair("face_token1", "d6f392bff003883759017093f96c5c9b"));  
        formparams.add(new BasicNameValuePair("face_token2", "46707707187b6c5a44d433a22efdc6ad"));  
//      ��������
        post(formparams,url);
    }

    /** 
     * ���� post������ʱ���Ӧ�ò����ݴ��ݲ�����ͬ���ز�ͬ��� 
     */  
    public static void post(List<BasicNameValuePair> formparams,String url) {  
        // ����Ĭ�ϵ�httpClientʵ��.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // ����httppost    
        HttpPost httppost = new HttpPost(url);  
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                    System.out.println("--------------------------------------");  
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                    System.out.println("--------------------------------------");  
                }  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // �ر�����,�ͷ���Դ    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }
   
}
