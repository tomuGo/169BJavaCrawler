package javaCrawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CreateJpg  {
	public static int num=0;
	static String spath;
	public static boolean createFolder(String path,Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd");
		String title=sdf.format(date);
		File file = new File(path+"\\"+title);
		setSpath(path+"\\"+title);
		if (!file.exists()){
			file.mkdirs();
			System.out.println("Create file " + path + " is success!");
			return true;
		}
		return false;
	}
	
	public static String createCatalog(Date date){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE,1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd");
		String newDate=sdf.format(cal);
		return newDate;
	}
	public static void createJpg(String url){
		//String url="http://s1.169b.com/uploads/allimg/150925/1-150925144218-50.jpg";
		HttpGet get = new HttpGet(url);
		get.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
		get.addHeader("Cookie","_gat=1; nsfw-click-load=off; gif-click-load=on; _ga=GA1.2.1861846600.1423061484");
		get.addHeader("Referer","http://www.169b.com/");
		get.addHeader("Content-Type","image/jpeg; charset=gb2312");		
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();  
        InputStream in = null;
        FileOutputStream FOS = null;
        String title=url.substring(url.length()-17, url.length()-4);
        File Path=new File(spath+"/"+title+".jpg");
        try {  
            HttpResponse httpResponse = closeableHttpClient.execute(get);  
            HttpEntity entity = httpResponse.getEntity();  
            if(httpResponse.getStatusLine().getStatusCode()!=200){
            	return;
            }
            if (entity != null) {  
            	in = entity.getContent();
            }
            FOS= new FileOutputStream(Path);
            byte[] buf = new byte[1024];
            for(int i=0;(i=in.read(buf))!=-1;){
            	FOS.write(buf, 0, i);
            }
            num++;
            System.out.println("下载已完成："+title+".jpg");
            System.out.println("总共完成："+num);
            
        } catch (ConnectTimeoutException e) {
        	System.out.println("超时");
		}catch (IOException e) {  
        	e.printStackTrace();  
        } finally { 
        	NumberFlag.a--;
        	if(NumberFlag.a<=0){
        		Go.goon();
        	}
            try {  
	            if(FOS!=null)
	            {
	            	FOS.close();
	            }
	            if(in!=null)
	            {
	            	in.close();
	            }
	            closeableHttpClient.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
        }
	}

	public static String getSpath() {
		return spath;
	}

	public static void setSpath(String spath) {
		CreateJpg.spath = spath;
	}


}
