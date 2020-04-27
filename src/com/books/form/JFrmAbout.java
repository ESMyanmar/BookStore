package com.books.form;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.form.JFrmAbout.java
 * App案内のクラス
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrmAbout extends JDialog implements ActionListener {
	//<!-- DECLARE_CONTROLS
	JPanel jpnlMain  = new JPanel();
	private static JLabel jlblImage;
	JLabel jlblDesc  = new JLabel();
	JLabel jlblDesc1 = new JLabel();
	JLabel jlblDesc2 = new JLabel();
	JLabel jlblDesc3 = new JLabel();
	JButton jbtnOK   = new JButton();
	//-->
	
	/**
	 * コンストラクタ
	 */
	public JFrmAbout() {
		/** 画面のサイズ */
		setSize(357,250);
		setVisible(true);
		/** 画面のタイトル */
		setTitle("CFTech Book Store - About...");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getWidth())/2,
						(Toolkit.getDefaultToolkit().getScreenSize().height - getHeight())/2);

		/** パネルにレイアウトを追加 */
		getContentPane().add(BorderLayout.CENTER, jpnlMain);
		jpnlMain.setBackground(Color.white);
		jpnlMain.setLayout(null);
		
		jlblDesc.setHorizontalAlignment(SwingConstants.CENTER);
		jlblDesc.setText("CFTech Book Store");
		jlblDesc.setForeground(Color.black);
		jlblDesc.setBounds(0,74,357,20);
		jpnlMain.add(jlblDesc);

		jlblDesc1.setHorizontalAlignment(SwingConstants.CENTER);
		jlblDesc1.setText("Version: 1.0");
		jlblDesc1.setForeground(Color.black);
		jlblDesc1.setBounds(0,90,357,20);
		jpnlMain.add(jlblDesc1);

		jlblDesc2.setHorizontalAlignment(SwingConstants.CENTER);
		jlblDesc2.setText("Created by: Kyaw Myat Moe");
		jlblDesc2.setForeground(Color.black);
		jlblDesc2.setFont(new Font("Dialog", Font.PLAIN, 11));
		jlblDesc2.setBounds(0,112,357,20);
		jpnlMain.add(jlblDesc2);

		jlblDesc3.setHorizontalAlignment(SwingConstants.CENTER);
		jlblDesc3.setText("Copyright @ 2013-2014 Kyaw Myat Moe");
		jlblDesc3.setForeground(Color.black);
		jlblDesc3.setFont(new Font("Dialog", Font.PLAIN, 11));
		jlblDesc3.setBounds(0,127,357,20);
		jpnlMain.add(jlblDesc3);

		jbtnOK.setText("OK");
		jbtnOK.setMnemonic((int)'O');
		jbtnOK.setFont(new Font("Dialog", Font.PLAIN, 11));
		jbtnOK.setBounds(240,180,100,24);
		jpnlMain.add(jbtnOK);
		//-->

		//<!-- REGISTER_LISTENERS
		jbtnOK.addActionListener(this);
      //-->
	}

	/**
	 * 閉じるボタン押下
	 */
	public void actionPerformed(ActionEvent event) {
		setVisible(false);
		dispose();
	}

}
