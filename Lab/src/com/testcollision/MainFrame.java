package com.testcollision;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	MainPanel panel;
	JButton round,rect,pause,penta,clear;
	public MainFrame() {
		panel = new MainPanel();
		this.setTitle("Åö×²¼ì²â");
		this.setBounds(100, 50, 840, 610);
		this.setVisible(true);
		this.setLayout(null);
//		this.setResizable(false);
		initLayout();
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void initLayout(){
		round = new JButton("+Ô²");
		Font font = new Font("SansSerif",ABORT ,10);
		round.setFont(font);
		round.setLocation(10, 520);
		round.setSize(50, 30);
		round.addActionListener(this);
		this.add(round);
		
		rect = new JButton("+¾Ø");
		rect.setFont(font);
		rect.setLocation(70, 520);
		rect.setSize(50, 30);
		rect.addActionListener(this);
		this.add(rect);
		
		penta = new JButton("+Áù");
		penta.setFont(font);
		penta.setLocation(130, 520);
		penta.setSize(50, 30);
		penta.addActionListener(this);
		this.add(penta);
		
		pause = new JButton("ÔÝÍ£");
		pause.setFont(font);
		pause.setLocation(650, 520);
		pause.setSize(70, 30);
		pause.addActionListener(this);
		this.add(pause);
		
		clear = new JButton("clear");
		clear.setFont(font);
		clear.setLocation(740, 520);
		clear.setSize(70, 30);
		clear.addActionListener(this);
		this.add(clear);
	}

	public static void main(String[] args) {
		new MainFrame();
//		for(int i=0;i<10;i++){
//			for(int j=0;j<10;j++){
//				int width = (int)(Math.random()*10);
//				System.out.print(width+" ");
//			}
//			System.out.println("");
//		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==round){
			System.out.println("Ôö¼ÓÔ²");
			for(int i=0;i<2;i++)
				new Round(panel);
			int s = MainPanel.moveObjectList.size();
			System.out.println(s);
		}else if(e.getSource()==rect){
			System.out.println("Ôö¼Ó¾ØÐÎ");
			for(int i=0;i<1;i++){
				new Rectangular(panel);
			}
		}else if(e.getSource()==pause){
			if(MainPanel.pause)
				MainPanel.pause = false;
			else
				MainPanel.pause = true;
		}else if(e.getSource()==penta){
			System.out.println("Ôö¼ÓÁù±ßÐÎ");
			for(int i=0;i<1;i++){
				new Pentagon(panel);
			}
		}
		else if(e.getSource()==clear){
			for(int i=0;i<MainPanel.moveObjectList.size();i++){
				panel.deleteObject(0);
			}
		}
		
	}

}
