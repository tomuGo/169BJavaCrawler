package javaCrawler;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class test1 {

	public static void main(String[] args) throws IOException {
//		String url="http://s1.169b.com/uploads/allimg/150925/1-150925144218-50.jpg";
//		HttpGet get = new HttpGet(url);
//		get.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
//		get.addHeader("Cookie","_gat=1; nsfw-click-load=off; gif-click-load=on; _ga=GA1.2.1861846600.1423061484");
//		get.addHeader("Referer","http://www.169b.com/");
//		get.addHeader("Content-Type","image/jpeg; charset=gb2312");		
//		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();  
////	        System.out.println(httpGet.getRequestLine());  
//	        InputStream in = null;
//	        FileOutputStream FOS = null;
//	        File Path=new File("F:\\q.jpg");
//	        try {  
//	            HttpResponse httpResponse = closeableHttpClient.execute(get);  
//	            HttpEntity entity = httpResponse.getEntity();  
////	            System.out.println("status:" + httpResponse.getStatusLine());  
//	            if(httpResponse.getStatusLine().getStatusCode()!=200){
//	            	return;
//	            }
//	            if (entity != null) {  
//	            	in = entity.getContent();
//	            }
//	            FOS= new FileOutputStream(Path);
//	            byte[] buf = new byte[1024];
//	            for(int i=0;(i=in.read(buf))!=-1;)
//	            {
//	            	FOS.write(buf, 0, i);
//	            }
//	            
//	        } catch (ConnectTimeoutException e) {
//	        	System.out.println("time out");
//			}catch (IOException e) {  
//	        	e.printStackTrace();  
//	        } finally {  
//	            try {  
//		            if(FOS!=null)
//		            {
//		            	FOS.close();
//		            }
//		            if(in!=null)
//		            {
//		            	in.close();
//		            }
//		            closeableHttpClient.close();  
//		        } catch (IOException e) {  
//		            e.printStackTrace();  
//		        }  
//	        }
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date1=new Date(2017,7,30);
		String date=sdf.format(date1);
		Calendar cal=Calendar.getInstance();
		cal.setTime(date1);
		cal.add(Calendar.DATE,1);
		System.out.println(cal);
	}
}