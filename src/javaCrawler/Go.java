package javaCrawler;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Go {
	static String url = "http://s1.169b.com/uploads/allimg/";

	public static Date dateMin = new Date(2015, 8, 27); // 时间起点
	public static Date dateMax =new Date(2017,7,13);
	Calendar cal1=Calendar.getInstance();
	
	public static void main(String[] args) {
		
		CreateJpg.createFolder("F:\\sprider\\169b",dateMin);
		List<String>list=AnalyseWeb.analyseDate(url, dateMin);
		if(dateMin.before(dateMax)){
				if(NumberFlag.a>0){
					if(list.size()>0&&list!=null){
						Application thread = new Application(list);
						new Thread(thread, "thread1").start();
					}else{
						Go.goon();
					}
				}
//				else{
//					Calendar cal=Calendar.getInstance();
//					cal.setTime(dateMin);
//					cal.add(Calendar.DATE, 1);
//					dateMax=cal.getTime();
//				}
			
		}
	}
	public static void goon(){
		Calendar cal=Calendar.getInstance();
		cal.setTime(dateMin);
		cal.add(Calendar.DATE, 1);
		dateMin=cal.getTime();
		CreateJpg.createFolder("F:\\sprider\\169b",dateMin);
		List<String>list=AnalyseWeb.analyseDate(url, dateMin);
		if(dateMin.before(dateMax)){
			if(NumberFlag.a>0){
				if(list.size()>0&&list!=null){
					Application thread = new Application(list);
					new Thread(thread, "thread1").start();
				}
			}
		}
	}
}
