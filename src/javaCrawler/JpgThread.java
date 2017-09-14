package javaCrawler;

import java.util.List;

public class JpgThread implements Runnable{
	int i = 0;
	List<String> urlList;
	public JpgThread(List<String> list) {
		this.urlList = list;
	}
	@Override
	public void run() {
		while (i < urlList.size()) {
			NumberFlag.a=urlList.size();
			synchronized (this) {
				if (i == urlList.size())
					break;
				CreateJpg.createJpg(urlList.get(i));
				i++;
			}
		}
	}
}
