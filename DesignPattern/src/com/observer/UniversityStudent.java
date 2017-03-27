package com.observer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UniversityStudent implements Observer {
	Subject subject;
	File myFile;
	public UniversityStudent(Subject subject,String filename) {
		this.subject = subject;
		subject.addObserver(this);
		myFile = new File(filename);
	}
	@Override
	public void hearTelephone(String heardMess) {
		try {
			FileOutputStream out = new FileOutputStream(myFile,true);
			System.out.println("@@@@@@@@@@@");
			byte[] b = heardMess.getBytes();
			out.write(b);
			System.out.print("����һ����ѧ����");
			System.out.println("�����ļ�"+myFile.getName());
			System.out.println(heardMess);
			out.close();
		} catch (IOException exp) {
			System.out.println(exp.toString());
		}
	}

}
