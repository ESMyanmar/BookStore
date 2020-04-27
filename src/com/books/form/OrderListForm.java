package com.books.form;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.form.OrderListForm.java
 * オーダリストの設定クラス
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

import com.books.bean.UserData;
import com.books.bean.CustomerData;
import com.books.dao.ResultSetTableModel;

public class OrderListForm extends JFrame
{
	ResultSet rs;
	AbstractTableModel tm;
	JTable tb;
	Statement stmt;
	int rset, bkid, orrid, num;
	private static int a;
	int bkkid[];
	int cost[] = new int[20];
	String str[] = new String[20];
	JLabel listLabel;
	JPanel buttonpanel, titlepanel, allPanel, datapanel;
	JButton btnnew, btnedit, btncancel;

	/**
	 * コンストラクタ
	 */
	public OrderListForm() {
		try {
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//		Connection con=DriverManager.getConnection("jdbc:odbc:BookData");
			/** Microsoft Access Dbを接続する */
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://BookStoreDb.accdb");
			stmt = con.createStatement();
			/** オーダ情報を取得 */
			rs = stmt.executeQuery("Select * from Orders");
			tm = new ResultSetTableModel(rs);
			tb = new JTable(tm);
			tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane pan = new JScrollPane(tb);
			Dimension d = new Dimension(780, 400);
			pan.setPreferredSize(d);
			/** 画面項目を格納 */
			titlepanel = new JPanel();
			datapanel = new JPanel();
			listLabel = new JLabel("Customer Order Lists");
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
					new CustomerOrderFrame();
				}
			});

			/** Editボタン押下 */
			btnedit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int tRow = tb.getSelectedRow();
					Object a = tb.getValueAt(tRow, tb.getColumn("OrderId").getModelIndex());
					String tbId = a.toString();
					int rId = Integer.parseInt(tbId);
					editDb(rId);
					CustomerOrderFrame orFrame = new CustomerOrderFrame();
					orFrame.showData();
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
	 * オーダ情報を取得する
	 */
	public void createDatabase() {
		setTitle("Customer Order List");
		setBounds(300, 300, 800, 600);
		setLocation(150, 150);
		setVisible(true);
		try {
			rs = stmt.executeQuery("Select * from Orders");
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	/**
	 * オーダーテーブルにデータを登録・更新
	 * 
	 * @param orid
	 * @param str1
	 * @param bkid
	 * @param str2
	 * @param strdata
	 * @param en
	 * @param engnum
	 * @param my
	 * @param mynum
	 * @param ch
	 * @param chnum
	 * @param totalQty
	 * @param totalCost
	 * @param str3
	 * @param str4
	 * @param str5
	 */
	public void dbUpdate(int orid, String str1, int bkid, String str2, String strdata, String en, int engnum, String my,
			int mynum, String ch, int chnum, int totalQty, int totalCost, String str3, String str4, String str5) {
		try {
			this.orrid = orid;
			this.bkid = bkid;
			this.str[0] = str1;
			this.str[1] = str2;
			this.str[2] = strdata;
			this.str[3] = en;
			this.str[4] = my;
			this.str[5] = ch;
			this.str[6] = str3;
			this.str[7] = str4;
			this.str[8] = str5;
			this.cost[0] = engnum;
			this.cost[1] = mynum;
			this.cost[2] = chnum;
			this.cost[3] = totalQty;
			this.cost[4] = totalCost;
			/** オーダーIDをチェック */
			ResultSet rs2 = stmt.executeQuery("Select * from Orders where OrderId=" + orid + "");
			while (rs2.next()) {
				num = rs2.getInt("OrderId");
			}
			/** オーダーIDがある場合、テーブルにデータを更新 */
			if (num == orid) {
				stmt.executeUpdate("UPDATE Orders SET OrderId=" + orid + ",OrderDate='" + str[0] + "',BkId=" + bkid
						+ ",CustomerName='" + str[1] + "',Paidby='" + str[2] + "',PubInEng='" + str[3] + "',QtyEng="
						+ cost[0] + ",PubInMyn='" + str[4] + "',QtyMyn=" + cost[1] + ",PubInCc='" + str[5] + "',QtyCc="
						+ cost[2] + ",TotalQty=" + cost[3] + ",TotalCost=" + cost[4] + ",ShiftAddress='" + str[6]
						+ "',Phone='" + str[7] + "',Email='" + str[8] + "' WHERE OrderId=" + orid + ";");
			} else {
				/** オーダーIDがない場合、テーブルにデータを登録 */
				stmt.executeUpdate("INSERT into Orders values(" + orid + ",'" + str[0] + "'," + bkid + ",'" + str[1]
						+ "','" + str[2] + "','" + str[3] + "'," + cost[0] + ",'" + str[4] + "'," + cost[1] + ",'"
						+ str[5] + "'," + cost[2] + "," + cost[3] + "," + cost[4] + ",'" + str[6] + "','" + str[7]
						+ "','" + str[8] + "')");
			}

		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	/**
	 * オーダーIDでデータを削除
	 * 
	 * @param id
	 */
	public void deleteDb(int id) {
		try {
			/** オーダーIDチェック */
			ResultSet rs1 = stmt.executeQuery("Select * from Orders where OrderId=" + id + "");
			while (rs1.next()) {
				num = rs1.getInt("OrderId");
			}
			/** オーダーIDがある場合、テーブルからデータを削除 */
			if (num == id) {
				stmt.executeUpdate("delete from Orders where OrderId=" + id + "");
			} else {
				/** オーダーIDがない場合、エラーダイアログを表示 */
				JOptionPane.showMessageDialog(null, "Record not found", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	/**
	 * オーダ-IDでカスタマー情報を編集
	 * 
	 * @param id
	 */
	public void editDb(int id) {
		this.a = id;
		CustomerData ud = new CustomerData();
		try {
			/** オーダーIDをチェック */
			ResultSet rs3 = stmt.executeQuery("Select * from Orders where OrderId=" + a + "");
			while (rs3.next()) {
				num = rs3.getInt("OrderId");
			}
			/** オーダーIDがある場合、カスタマー情報を編集する */
			if (num == a) {
				rs3 = stmt.executeQuery("Select * from Orders where OrderId=" + a + "");
				while (rs3.next()) {
					ud.setOrderId(rs3.getInt("OrderId"));
					ud.setOrderDate(rs3.getString("OrderDate"));
					ud.setCustomerName(rs3.getString("CustomerName"));
					ud.setPaid(rs3.getString("Paidby"));
					ud.setPublishEng(rs3.getString("PubInEng"));
					ud.setQtyEnglish(rs3.getInt("QtyEng"));
					ud.setPublishMyanmar(rs3.getString("PubInMyn"));
					ud.setQtyMynmar(rs3.getInt("QtyMyn"));
					ud.setPublishChinese(rs3.getString("PubInCc"));
					ud.setQtyChinese(rs3.getInt("QtyCc"));
					ud.setTotalQty(rs3.getInt("TotalQty"));
					ud.setTotalCost(rs3.getInt("TotalCost"));
					ud.setOrderAddress(rs3.getString("ShiftAddress"));
					ud.setOrderPhone(rs3.getString("Phone"));
					ud.setOrderEmail(rs3.getString("Email"));
				}
			} else {
				/** オーダーIDがない場合、エラーダイアログを表示 */
				JOptionPane.showMessageDialog(null, "Record not found", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

	/**
	 * BookIdでBook情報を編集
	 * 
	 * @param id
	 */
	public void outBkDb(int id) {
		UserData ud = new UserData();
		try {
			/** BookIDをチェック */
			ResultSet rs1 = stmt.executeQuery("Select * from Book where BkId=" + id + "");
			while (rs1.next()) {
				num = rs1.getInt("BkId");
			}
			/** BookIdがある場合、Book情報を編集する */
			if (num == id) {
				rs1 = stmt.executeQuery("Select * from Book where BkId=" + id + "");
				while (rs1.next()) {
					ud.setId(rs1.getInt("BkId"));
					ud.setTitle(rs1.getString("BKTitle"));
					ud.setAuthor(rs1.getString("BkAuthor"));
					ud.setEnglish(rs1.getString("PubInEng"));
					ud.setMyanmar(rs1.getString("PubInMyan"));
					ud.setChinese(rs1.getString("PubInCc"));
					ud.setPrice(rs1.getInt("BkPrice"));
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
	 * 最新のオーダ-Idを取得する
	 * 
	 * @return
	 */
	public int getID() {
		try {
			ResultSet rs1 = stmt.executeQuery("Select max(OrderId) from Orders");
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