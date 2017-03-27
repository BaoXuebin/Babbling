package com.observer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HaiGui implements Observer {
	
	Subject subject;
	File myfile;
	public HaiGui(Subject subject,String filename) {
		this.subject = subject;
		subject.addObserver(this);
		myfile = new File(filename);
	}
	@Override
	public void hearTelephone(String heardMess) {
		try {
			boolean boo = heardMess.contains("程序员")||heardMess.contains("软件");
			if(boo){
				FileOutputStream out = new FileOutputStream(myfile,true);
				byte[] b = heardMess.getBytes();
				out.write(b);
				System.out.print("我是海归，");
				System.out.println("我向文件"+myfile.getName()+"写入一下内容：");
				System.out.println(heardMess);
				out.close();
			}
			else{
				System.out.println("没有海归需要的信息！");
			}
		} catch (IOException exp) {
			System.out.println(exp.toString());
		}
	}
}
