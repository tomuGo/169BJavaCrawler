package javaCrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class GetWebContent {

	public static StringBuffer getWebContent(String url){
		HttpGet get = new HttpGet(url);
		get.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
		get.addHeader("Cookie","_gat=1; nsfw-click-load=off; gif-click-load=on; _ga=GA1.2.1861846600.1423061484");
		get.addHeader("Referer","http://www.169b.com/");
		get.addHeader("Content-Type","image/jpeg; charset=gb2312");		
		CloseableHttpClient http = HttpClients.createDefault();
		StringBuffer sb=new StringBuffer();
		AnalyseWeb aw=new AnalyseWeb();
		try {
			HttpResponse response = http.execute(get);
			if (response!=null&&response.getStatusLine().getStatusCode() == 200) {  
			    HttpEntity entity = response.getEntity();  
			    InputStream in = entity.getContent(); 
			    sb=readResponse(in);
			}	
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return sb; 
	}
	
	public static StringBuffer readResponse(InputStream in) throws UnsupportedEncodingException {  
	    BufferedReader reader;
	    StringBuffer buffer=new StringBuffer();
			reader = new BufferedReader(new InputStreamReader(in));
			 String line = null;  
			    try {
					while ((line = reader.readLine()) != null) {  
						buffer.append(line+"\n");
						
					}
					System.out.println("读取内容完毕:"+buffer.toString()); 
				} catch (IOException e) {
					e.printStackTrace();
				}  finally{  
					//关闭输入流  输出流
					if(reader != null)
						try {
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						} 
					if(in !=null){
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
							return null;
						}
					}
				} 
		 
		//			    catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//			return null;
//		}  
		 return buffer;
	}

}
