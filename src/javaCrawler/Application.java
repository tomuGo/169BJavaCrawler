package javaCrawler;

import java.util.List;

public class Application implements Runnable{
	 List<String> urlList;
	public Application(List<String>list){
		this.urlList=list;
	}
	
	@Override
	public void run() {
		synchronized (this){
			if(urlList!=null&&urlList.size()>0){
				int a=0;
				for(int n=0;n<urlList.size();n++){
					a++;
					CreateJpg.createJpg(urlList.get(n));
					if(a % 10 ==1){
						System.out.println( "休息5秒" );
	                    try{
	                        Thread.sleep( 5000 );
	                    } catch( InterruptedException e )
	                    {
	                        e.printStackTrace();
	                    }
		                System.out.println("爬----come on!!!!");
					}
					
				}
			}
		}
	}
}
