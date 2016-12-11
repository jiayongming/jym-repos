package test;

import java.io.IOException;

public class Snippet {
	
	static ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	static ThreadLocal<String> stringLocal = new ThreadLocal<String>();
	
	public static void main(String[] args) throws IOException {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
		long currentTimeMillis = System.currentTimeMillis();
		String tests = tests();
		try {
			tool.WriteExcel.writeTxtFile(tests+(System.currentTimeMillis()-currentTimeMillis));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String tests() throws IOException {
		
		tool.WriteExcel.writeTxtFile("tests start");
		
		new Runnable() {
			
			public void run() {
				
				for (int i = 0; i < 100; i++) {
					try {
						tool.WriteExcel.writeTxtFile(i+"");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		}.run() ;
		return "------------------" ;

	}

}

