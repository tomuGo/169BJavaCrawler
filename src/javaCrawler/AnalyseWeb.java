package javaCrawler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AnalyseWeb {
	// 爬取日期页内容
	public static  List<String> analyseDate(String url,Date date ){
		//url中时间处理
		Calendar calendar=Calendar.getInstance(); 
		//calendar.setTime(dateMin);
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd");
		String dateMinString=sdf.format(date);
		url=url+""+dateMinString+"/";
		List<String>srcList=new ArrayList<String>();
		StringBuffer content=GetWebContent.getWebContent(url);
		srcList=match(content.toString(),"a","href");
		
		if(srcList==null||srcList.size()==1||srcList.size()==0){
			Go.goon();
			return null;
		}
		//去掉第一个返回上层
		srcList.remove(0);
		//CreateJpg createJpg=new CreateJpg();
		List<String>srcList2=new ArrayList<String>();
		for(int num=0;num<srcList.size();num++){
			String picUrl=url+srcList.get(num);
			srcList2.add(picUrl);
		}
		NumberFlag.a=srcList2.size();
		return srcList2;
//		JpgThread jpgThread = new JpgThread(srcList2);
//		new Thread(jpgThread, "img1").start();
//		new Thread(jpgThread, "img2").start();
//		new Thread(jpgThread, "img3").start();
		//return srcList2;
	}
//	//爬取图片地址
//	public static String analysePage(String url){
//		//StringBuffer buff=GetWebContent.getWebContent(url);
//		List <String> picRes=match(url,"img","src");
//		if(picRes!=null&&picRes.size()==1){
//			return picRes.get(0);
//		}
//		return "";
//	}
	 public static List<String> match(String source, String element, String attr) {  
	        List<String> result = new ArrayList<String>();  
	        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";  
	        Matcher m = Pattern.compile(reg).matcher(source);  
	        while (m.find()) {  
	            String r = m.group(1);  
	            result.add(r);  
	        }  
	        System.out.println(result);
	        return result;  
	 }  
}
