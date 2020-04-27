package com.books.form;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.form.BookListForm.java
 * 本のリストを表示するクラス
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
import java.awt.event.*;
import com.books.bean.UserData;
import com.books.dao.ResultSetTableModel;

public class BookListForm extends JFrame
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

	public BookListForm() {
		try {
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//		Connection con=DriverManager.getConnection("jdbc:odbc:BookData");
			/** Access DBをアクセス */
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");// Loading Driver
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://BookStoreDb.accdb");// Establishing
																								// Connection
			stmt = con.createStatement();
			/** 本を取得SQL文 */
			rs = stmt.executeQuery("Select * from Book");
			/** 取得したデータをテーブルに表示 */
			tm = new ResultSetTableModel(rs);
			tb = new JTable(tm);

			/** スクロールを作成 */
			JScrollPane pan = new JScrollPane(tb);
			/** スクロールサイズの設定 */
			Dimension d = new Dimension(780, 600);
			pan.setPreferredSize(d);
			/** タイトル表示エリア */
			titlepanel = new JPanel();
			/** データ表示エリア */
			datapanel = new JPanel();
			listLabel = new JLabel("Book Registration Lists");
			btnnew = new JButton("New");
			btnedit = new JButton("Edit");
			btncancel = new JButton("Cancel");
			/** ボタン表示エリア */
			buttonpanel = new JPanel();
			buttonpanel.add(btnnew);
			buttonpanel.add(btnedit);
			buttonpanel.add(btncancel);
			titlepanel.add(listLabel);
			datapanel.add(pan);
			/** 画面全て表示エリア */
			allPanel = new JPanel();
			allPanel.setLayout(new BorderLayout());
			allPanel.add(titlepanel, BorderLayout.NORTH);
			allPanel.add(datapanel, BorderLayout.CENTER);
			allPanel.add(buttonpanel, BorderLayout.SOUTH);
			/** フォームに追加 */
			Container contentPane = getContentPane();
			contentPane.add(allPanel);

			/** Newボタン押下 */
			btnnew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new BookRegistrationFrame();
				}
			});

			/** Editボタン押下 */
			btnedit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// try{
					int tRow = tb.getSelectedRow();
					Object a = tb.getValueAt(tRow, 0);
					String tbId = a.toString();
					int rId = Integer.parseInt(tbId);
					showDb(rId);
					BookRegistrationFrame bkFrame = new BookRegistrationFrame();
					bkFrame.showData();
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
	 * データベースからデータを出力
	 */
	public void createDatabase()
	{
		setTitle("Book List");
		setBounds(300,300,800,600);
		setLocation(150,150);
		setVisible(true);
		try{
		 rs=stmt.executeQuery("Select * from Book");
		}catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
	}
	
	/**
	 * 
	 * 本の情報を登録・更新
	 * 
	 * @param id
	 * @param str1
	 * @param str2
	 * @param str3
	 * @param str4
	 * @param str5
	 * @param en
	 * @param my
	 * @param ch
	 * @param bkprice
	 * @param str6
	 */
	public void newUpdate(int id, String str1, String str2, String str3, String str4, String str5, String en, String my,
			String ch, int bkprice, String str6) {
		try {
			this.bkid = id;
			this.str[0] = str1;
			this.str[1] = str2;
			this.str[2] = str3;
			this.str[3] = str4;
			this.str[4] = str5;
			this.str[5] = en;
			this.str[6] = my;
			this.str[7] = ch;
			this.str[8] = str6;
			this.a = bkprice;
			/** 本の情報を出力 */
			ResultSet rs2 = stmt.executeQuery("Select * from Book where BkId=" + bkid + "");
			while (rs2.next()) {
				num = rs2.getInt("BkId");
			}
			/** 本のIDがある場合、Book（本）テーブルに更新 */
			if (num == bkid) {
				stmt.executeUpdate("UPDATE Book SET BkId=" + bkid + ",RegDate='" + str[0] + "',BKTitle='" + str[1]
						+ "',BkAuthor='" + str[2] + "',BkPubDate='" + str[3] + "',BkType='" + str[4] + "',PubInEng='"
						+ str[5] + "',PubInMyan='" + str[6] + "',PubInCc='" + str[7] + "',BkPrice=" + a + ",Remark='"
						+ str[8] + "' WHERE BkId=" + bkid + ";");
			} else {
				/** 本のIDがない場合、Book（本）テーブルに登録 */
				stmt.executeUpdate("INSERT into Book values(" + bkid + ",'" + str[0] + "','" + str[1] + "','" + str[2]
						+ "','" + str[3] + "','" + str[4] + "','" + str[5] + "','" + str[6] + "','" + str[7] + "'," + a
						+ ",'" + str[8] + "')");
			}

		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	
	/**
	 * 
	 * Book（本）テーブルから情報を削除
	 * 
	 * @param id
	 */
	public void deleteDb(int id)
	{
		try{
			/** BookIdでBookテーブルに探す */
			ResultSet rs1=stmt.executeQuery("Select * from Book where BkId="+id+"");
			while(rs1.next())
			{
				num=rs1.getInt("BkId");
			}
			/** BookIDがある場合、情報を削除 */
			if(num==id){
				stmt.executeUpdate("delete from Book where BkId="+id+"");
			}
			else{
				/** BookIDがない場合、エラーダイアログ表示 */
				JOptionPane.showMessageDialog(null,"Record not found","Error",JOptionPane.ERROR_MESSAGE); 
			}
		}catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
	}
	
	/**
	 * 
	 * Bookテーブルから情報を取得
	 * 
	 * @param id
	 */
	public void showDb(int id) {
		UserData ud = new UserData();
		this.bkid = id;
		try {
			/** BookIDでBookテーブルに探す */
			ResultSet rs1 = stmt.executeQuery("Select * from Book where BkId=" + id + "");
			while (rs1.next()) {
				num = rs1.getInt("BkId");
			}
			/** BookIdがある場合、情報を表示 */
			if (num == bkid) {
				rs1 = stmt.executeQuery("Select * from Book where BkId=" + id + "");
				while (rs1.next()) {
					ud.setId(rs1.getInt("BkId"));
					ud.setRegisterdate(rs1.getString("RegDate"));
					ud.setTitle(rs1.getString("BKTitle"));
					ud.setAuthor(rs1.getString("BkAuthor"));
					ud.setPublishDate(rs1.getString("BkPubDate"));
					ud.setType(rs1.getString("BkType"));
					ud.setEnglish(rs1.getString("PubInEng"));
					ud.setMyanmar(rs1.getString("PubInMyan"));
					ud.setChinese(rs1.getString("PubInCc"));
					ud.setPrice(rs1.getInt("BkPrice"));
					ud.setRemark(rs1.getString("Remark"));
				}
			} else {
				/** BookIdがない場合、エラーダイアログを表示 */
				JOptionPane.showMessageDialog(null, "Record not found", "Error", JOptionPane.ERROR_MESSAGE);

			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	/**
	 * 
	 * 最新BookIdを取得
	 * 
	 * @return
	 */
	public int getID() {
		try {
			ResultSet rs1 = stmt.executeQuery("Select max(BkId) from Book");
			while (rs1.next()) {
				num = rs1.getInt(1);
			}
			return num;

		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
			return 0;
		}
	}
}
	