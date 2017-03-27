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
			boolean boo = heardMess.contains("����Ա")||heardMess.contains("���");
			if(boo){
				FileOutputStream out = new FileOutputStream(myfile,true);
				byte[] b = heardMess.getBytes();
				out.write(b);
				System.out.print("���Ǻ��飬");
				System.out.println("�����ļ�"+myfile.getName()+"д��һ�����ݣ�");
				System.out.println(heardMess);
				out.close();
			}
			else{
				System.out.println("û�к�����Ҫ����Ϣ��");
			}
		} catch (IOException exp) {
			System.out.println(exp.toString());
		}
	}
}
