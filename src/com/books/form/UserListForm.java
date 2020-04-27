package com.books.form;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.form.UserListForm.java
 * ユーザー情報を設定・表示するためのクラス
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
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.text.*;

import com.books.bean.UserRegisterData;
import com.books.dao.ResultSetTableModel;

public class UserListForm extends JFrame
{
	ResultSet rs;
	AbstractTableModel tm;
	JTable tb;
	Statement stmt;
	String str[]=new String[10];
	int a,rset,bkid,num;
	int bkkid[];
	JLabel listLabel;
	JButton btnnew,btnedit,btncancel;
	JPanel buttonpanel,titlepanel,allPanel,datapanel;
	
	/**
	 * コンストラクタ
	 */
	public UserListForm() {
		try {
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//		Connection con=DriverManager.getConnection("jdbc:odbc:BookData");
			/** Microsoft AccessDB を接続する */
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://BookStoreDb.accdb");
			stmt = con.createStatement();
			/** ユーザー情報を取得する */
			rs = stmt.executeQuery("Select * from User");
			/** 取得したユーザー情報を画面に設定する */
			tm = new ResultSetTableModel(rs);
			tb = new JTable(tm);
			JScrollPane pan = new JScrollPane(tb);
			Dimension d = new Dimension(780, 600);
			pan.setPreferredSize(d);
			/** 画面項目を格納 */
			titlepanel = new JPanel();
			datapanel = new JPanel();
			listLabel = new JLabel("User Registration Lists");
			btnnew = new JButton("New");
			btnedit = new JButton("Edit");
			btncancel = new JButton("Cancel");
			buttonpanel = new JPanel();
			buttonpanel.add(btnnew);
			buttonpanel.add(btnedit);
			buttonpanel.add(btncancel);
			titlepanel.add(listLabel);
			datapanel.add(pan);
			allPanel = new JPanel();
			allPanel.setLayout(new BorderLayout());
			allPanel.add(titlepanel, BorderLayout.NORTH);
			allPanel.add(datapanel, BorderLayout.CENTER);
			allPanel.add(buttonpanel, BorderLayout.SOUTH);
			Container contentPane = getContentPane();
			contentPane.add(allPanel);

			/** Newボタン押下 */
			btnnew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new UserRegistrationFrame();
				}
			});

			/** Editボタン押下 */
			btnedit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int tRow = tb.getSelectedRow();
					Object a = tb.getValueAt(tRow, 0);
					String tbId = a.toString();
					int rId = Integer.parseInt(tbId);
					showDb(rId);
					UserRegistrationFrame urFrame = new UserRegistrationFrame();
					urFrame.showData();
				}
			});

			/** Cancelボタン押下 */
			btncancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfeException");
		}
	}

	/**
	 * テーブルからユーザー情報を取得
	 */
	public void createDatabase() {
		setTitle("User List");
		setBounds(300, 300, 800, 600);
		setLocation(150, 150);
		setVisible(true);
		try {
			rs = stmt.executeQuery("Select * from User");
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	/**
	 * ログインIDでユーザー情報を登録・更新
	 * 
	 * @param id
	 * @param str1
	 * @param str2
	 * @param str3
	 * @param str4
	 */
	public void newUpdate(int id, String str1, String str2, String str3, String str4) {
		try {
			/** ログインIDをチェック */
			ResultSet rs2 = stmt.executeQuery("Select * from User where LoginId=" + id + "");
			while (rs2.next()) {
				num = rs2.getInt("LoginId");
			}
			/** ログインIDがある場合、ユーザー情報を更新 */
			if (num == id) {
				stmt.executeUpdate("UPDATE User SET LoginId=" + id + ",Name='" + str1 + "',Password='" + str2
						+ "',UserRight='" + str3 + "',Remark='" + str4 + "' WHERE LoginId=" + id + ";");
			} else {
				/** ログインIDがない場合、ユーザー情報を登録 */
				stmt.executeUpdate("INSERT into User values(" + id + ",'" + str1 + "','" + str2 + "','" + str3 + "','"
						+ str4 + "')");
			}

		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	/**
	 * ログインIDでユーザー情報を削除
	 * 
	 * @param id
	 */
	public void deleteDb(int id) {
		try {
			/** ログインIDをチェック */
			ResultSet rs1 = stmt.executeQuery("Select * from User where LoginId=" + id + "");
			while (rs1.next()) {
				num = rs1.getInt("LoginId");
			}
			/** ログインIDがある場合、ユーザー情報を削除 */
			if (num == id) {
				stmt.executeUpdate("delete from User where LoginId=" + id + "");
			} else {
				/** ログインIDがある場合、エラーダイアログを表示 */
				JOptionPane.showMessageDialog(null, "Record not found", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	/**
	 * ログインIDでユーザー情報を表示
	 * 
	 * @param id
	 */
	public void showDb(int id) {
		UserRegisterData ud = new UserRegisterData();
		try {
			/** ログインIDをチェック */
			ResultSet rs1 = stmt.executeQuery("Select * from User where LoginId=" + id + "");
			while (rs1.next()) {
				num = rs1.getInt("LoginId");
			}
			/** ログインIDがある場合、ユーザー情報を編集 */
			if (num == id) {
				rs1 = stmt.executeQuery("Select * from User where LoginId=" + id + "");
				while (rs1.next()) {
					ud.setLogId(rs1.getInt("LoginId"));
					ud.setName(rs1.getString("Name"));
					ud.setPw(rs1.getString("Password"));
					ud.setURight(rs1.getString("UserRight"));
					ud.setrMark(rs1.getString("Remark"));
				}
			} else {
				/** ログインIDがない場合、エラーダイアログを表示 */
				JOptionPane.showMessageDialog(null, "Record not found", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
}