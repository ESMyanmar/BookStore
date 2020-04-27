package com.books.form;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.form.UserRegistrationForm.java
 * ユーザーを登録するためのクラス
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
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.text.*;

import com.books.bean.UserRegisterData;

public class UserRegistrationFrame extends JFrame implements ActionListener
{
	JLabel lblfname, lbllogId, lblpw, lbluRight, lblremark, lbllabel;
	JTextField txtfname, txtlogId, txtpw;
	JTextArea txtremark;
	private static JRadioButton rbLimited, rbAdmin;
	JPanel rolepanel, titlepanel, datapanel, buttonpanel, allPanel;
	JButton btnnew, btnsave, btnedit, btndelete, btncancel;
	ButtonGroup bg;
	private static int logid;
	private static String permit;
	private static String str[] = new String[10];

	/**
	 * コンストラクタ
	 */
	public UserRegistrationFrame() {
		/** 画面タイトル */
		setTitle("User Entry");
		/** 画面のサイズ */
		setBounds(300, 300, 800, 600);
		/** 画面を表示するポジション */
		setLocation(150, 150);
		setVisible(true);

		/** パレルを格納 */
		Container contentPane = getContentPane();
		rolepanel = new JPanel();
		titlepanel = new JPanel();
		datapanel = new JPanel();
		buttonpanel = new JPanel();
		allPanel = new JPanel();
		/** 画面項目を格納 */
		lbllabel = new JLabel("User Registration Form");
		btnnew = new JButton("New");
		btnsave = new JButton("Save");
		btnedit = new JButton("Edit");
		btndelete = new JButton("Delete");
		btncancel = new JButton("Cancel");
		/** 画面項目をパネルに追加 */
		titlepanel.add(lbllabel);
		buttonpanel.add(btnnew);
		buttonpanel.add(btnsave);
		buttonpanel.add(btnedit);
		buttonpanel.add(btndelete);
		buttonpanel.add(btncancel);

		lblfname = new JLabel("Full Name:");
		lbllogId = new JLabel("Login Id:");
		lblpw = new JLabel("Password:");
		lbluRight = new JLabel("User Rights:");
		lblremark = new JLabel("Remark:");
		txtfname = new JTextField(20);
		txtlogId = new JTextField(20);
		txtpw = new JTextField(20);
		bg = new ButtonGroup();
		rbLimited = addRadioButton(rolepanel, bg, "Limited user", true);
		rbAdmin = addRadioButton(rolepanel, bg, "Administrator", false);
		Border border = BorderFactory.createTitledBorder("Role");
		rolepanel.setBorder(border);
		txtremark = new JTextArea(10, 20);
		Border border1 = BorderFactory.createLineBorder(Color.gray);
		txtremark.setBorder(border1);

		datapanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(1, 1, 1, 1);
		add(datapanel, lblfname, gbc, 0, 0, 1, 1);
		add(datapanel, txtfname, gbc, 1, 0, 1, 1);
		add(datapanel, lbllogId, gbc, 0, 2, 1, 1);
		add(datapanel, txtlogId, gbc, 1, 2, 1, 1);
		add(datapanel, lblpw, gbc, 0, 3, 1, 1);
		add(datapanel, txtpw, gbc, 1, 3, 1, 1);
		add(datapanel, lbluRight, gbc, 0, 4, 1, 1);
		add(datapanel, rolepanel, gbc, 1, 4, 1, 1);
		add(datapanel, lblremark, gbc, 0, 5, 1, 1);
		add(datapanel, txtremark, gbc, 1, 5, 1, 1);

		/** 画面のパネルを設定 */
		allPanel.setLayout(new BorderLayout());
		allPanel.add(titlepanel, BorderLayout.NORTH);
		allPanel.add(datapanel, BorderLayout.CENTER);
		allPanel.add(buttonpanel, BorderLayout.SOUTH);

		/** 画面にパネルを追加 */
		contentPane.add(allPanel);

		/** Newボタン押下 */
		btnnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfname.setText("");
				txtlogId.setText("");
				txtpw.setText("");
				txtremark.setText("");
				rbLimited.setSelected(true);
				rbAdmin.setSelected(false);
			}
		});

		/** Saveボタン押下 */
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = txtlogId.getText();
				logid = Integer.parseInt(s1);
				str[1] = txtfname.getText();
				str[2] = txtpw.getText();
				str[3] = txtremark.getText();
				UserListForm uform = new UserListForm();
				uform.newUpdate(logid, str[1], str[2], permit, str[3]);
			}
		});

		/** Editボタン押下 */
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserListForm uform = new UserListForm();
				String inputValue = JOptionPane.showInputDialog("Login id:");
				int i = Integer.parseInt(inputValue);
				uform.showDb(i);

				UserRegisterData ud = new UserRegisterData();
				if (ud.getLoginId() == 0)
					txtlogId.setText("");
				else
					txtlogId.setText("" + ud.getLoginId());
				txtfname.setText(ud.getName());
				txtpw.setText(ud.getPassword());
				txtremark.setText(ud.getRemark());
				String limit = ud.getUserRight();
				String str1 = "Limited User";
				if (limit.equals(str1))
					rbLimited.setSelected(true);
				else
					rbLimited.setSelected(false);
				String str2 = "Administrator";
				if (limit.equals(str2))
					rbAdmin.setSelected(true);
				else
					rbAdmin.setSelected(false);
			}
		});

		/** Deleteボタン押下 */
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserListForm uform = new UserListForm();
				String inputValue = JOptionPane.showInputDialog("Please input book id:");
				int i = Integer.parseInt(inputValue);
				uform.deleteDb(i);
			}
		});

		/** Cancelボタン押下 */
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	/**
	 * パネルに画面項目を追加
	 * 
	 * @param pan
	 * @param p
	 * @param s
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void add(JPanel pan, Component p, GridBagConstraints s, int x, int y, int w, int h) {
		s.gridwidth = w;
		s.gridheight = h;
		s.gridx = x;
		s.gridy = y;
		pan.add(p, s);
	}

	/**
	 * パネルに画面項目を追加
	 * 
	 * @param pan
	 * @param p1
	 * @param s
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void add(JPanel pan, JPanel p1, GridBagConstraints s, int x, int y, int w, int h) {
		s.gridwidth = w;
		s.gridheight = h;
		s.gridx = x;
		s.gridy = y;
		pan.add(p1, s);
	}

	/**
	 * ラジオボタンをパレルに追加
	 */
	public JRadioButton addRadioButton(JPanel p, ButtonGroup g, String name, boolean v) {
		JRadioButton b = new JRadioButton(name, v);
		p.add(b);
		g.add(b);
		b.addActionListener(this);
		return b;
	}

	/**
	 * ラジオボタン押下
	 */
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == rbLimited)
			permit = "Limited User";
		else if (source == rbAdmin)
			permit = "Administrator";
	}

	/**
	 * ユーザー登録情報を表示
	 */
	public void showData() {
		UserRegisterData ud = new UserRegisterData();
		txtlogId.setText("" + ud.getLoginId());
		txtfname.setText(ud.getName());
		txtpw.setText(ud.getPassword());
		txtremark.setText(ud.getRemark());
		String limit = ud.getUserRight();
		String str1 = "Limited User";
		if (limit.equals(str1))
			rbLimited.setSelected(true);
		else
			rbLimited.setSelected(false);
		String str2 = "Administrator";
		if (limit.equals(str2))
			rbAdmin.setSelected(true);
		else
			rbAdmin.setSelected(false);
	}
}