package com.books.form;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.form.BookStore.java
 * BookStoreのメインクラス
 *
 * 更新日付     更新者              内容
 * -------------------------------------------------------------------------
 * 2014/01/21   チョ   			新規作成
 * </pre>
 *
 * @author チョ
 * @version 1.00
 * @since 2014/01/21
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class BookStore extends JFrame{
	private JMenuBar mBar = new JMenuBar();
	
	private JMenu mFile = new JMenu("File");	
	private JMenu listItem = new JMenu("List");
	private JRadioButtonMenuItem booksList = new JRadioButtonMenuItem("Books");
	private JRadioButtonMenuItem customerOrderList = new JRadioButtonMenuItem("Customers Orders");
	private JRadioButtonMenuItem userList = new JRadioButtonMenuItem("Users");
	private JMenuItem exitItem = new JMenuItem("Exit");
	
	private JMenu mEntry = new JMenu("Entry");
	private JMenuItem bookEntry = new JMenuItem("BookEntry");
	private JMenuItem customerEntry = new JMenuItem("CustomerOrder");
	private JMenuItem userEntry = new JMenuItem("UserEntry");
	
	private JMenu mHelp = new JMenu("Help");
	private JMenuItem about = new JMenuItem("About");
	private JMenuItem calc = new JMenuItem("Calculator");
	
	private JLabel weLabel;
	private JLabel vaLabel;
	private JLabel mtLabel;
	private JPanel mainpanel;
	
	public BookStore(){
		/** タイトル表示 */
		setTitle("BOOK STORE");
		/** 画面のサイズ設定 */
		setBounds(300,300,600,400);
		/** 初期表示ポジション設定 */
		setLocation(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/** メイン表示エリア */
		mainpanel=new JPanel();
		weLabel=new JLabel("Welcome to Book Store");
		weLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		vaLabel=new JLabel("Visit at: esmyanmar.blogspot.com");
		vaLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		mtLabel=new JLabel("Mail to: book2order@neteazy.net");
		mtLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		mainpanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.anchor=GridBagConstraints.LINE_START;
		/** 表示エリアに項目を追加 */
		add(mainpanel,weLabel,gbc,0,1,1,1);
		add(mainpanel,vaLabel,gbc,0,2,1,1);
		add(mainpanel,mtLabel,gbc,0,3,1,1);
		
		/** メイン表示エリア情報を画面に追加 */
		Container contentpane=getContentPane();
		contentpane.add(mainpanel);
		
		/** メニューを作成 */
		mBar.add(mFile);
		mBar.add(mEntry);
		mBar.add(mHelp);
		
		/** サブメニューを作成 */
		mFile.add(listItem);
		mFile.add(exitItem);
		
		//ボタングループを作成
		ButtonGroup bGp = new ButtonGroup();
		bGp.add(booksList);
		bGp.add(customerOrderList);
		bGp.add(userList);
		/** ListItemメニューに項目を追加 */
		listItem.add(booksList);
		listItem.add(customerOrderList);
		listItem.add(userList);
		/** Entryメニューに項目を追加 */
		mEntry.add(bookEntry);
		mEntry.add(customerEntry);
		mEntry.add(userEntry);
		/** Helpメニューに項目を追加 */
		mHelp.add(about);
		mHelp.add(calc);
		
		/** 画面にメニューを追加 */
		setJMenuBar(mBar);
		setVisible(true);
		
		/** Book Entryメニュー押下*/
		bookEntry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new BookRegistrationFrame();
			}	
		});
		
		/** User Entryメニュー押下*/
		userEntry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new UserRegistrationFrame();
			}	
		});
		
		/** Customer Entryメニュー押下*/
		customerEntry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new CustomerOrderFrame();
			}	
		});
		
		/** Exitメニュー押下*/
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}	
		});
		
		/** User Listメニュー押下*/
		userList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UserListForm ulform=new UserListForm();
				ulform.createDatabase();
			}	
		});
		
		/** Books Listメニュー押下*/
		booksList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BookListForm blform=new BookListForm();
				blform.createDatabase();
			}	
		});
		
		/** Customer Order Listメニュー押下*/
		customerOrderList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				OrderListForm oform=new OrderListForm();
				oform.createDatabase();
			}	
		});
		
		/** Aboutメニュー押下*/
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new JFrmAbout();
			}	
		});
		
		/** Calculatorメニュー押下*/
		calc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new CalculatorFrame();
			}	
		});
		
	}
	
	/**
	 * 
	 * パネルに項目を追加
	 * 
	 * @param pan
	 * @param p
	 * @param s
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void add(JPanel pan,Component p,GridBagConstraints s,int x,int y,int w,int h)
	{
		s.gridwidth=w;
		s.gridheight=h;
		s.gridx=x;
		s.gridy=y;
		pan.add(p,s);
	}
	
	/**
	 * メイン
	 * @param args
	 */
	public static void main(String[] args){
		new BookStore();
	}	
}
