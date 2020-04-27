package com.books.form;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.form.BookRegistrationFrame.java
 * 本の情報を登録のクラス
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
import javax.swing.text.MaskFormatter;

import com.books.bean.UserData;

import java.awt.event.*;
import javax.swing.text.*;
import java.sql.*;

public class BookRegistrationFrame extends JFrame
{
	JLabel lbllabel,lblbookId,lblrDate,lbltitle,lblauthor,lblpDate,lblbookType,lblprice,lblremark;
	JTextField txtbookId,txttitle,txtauthor,txtprice;
	JTextArea txtremark;
	JButton btnNew,btnSave,btnEdit,btnDelete,btnCancel;
	JPanel titlePanel,dataPanel,buttonPanel,allPanel;
	JCheckBox ebox,mbox,cbox;
	JComboBox cbbookType;
	JPanel chkpanel;
	JFormattedTextField txtrDate,txtpDate;
	MaskFormatter mf,mf1;
	private static int count=1;
	String str[]=new String[10];
	int bkkid[];
	int bkid,bkprice,bkcount;
	int eng,m,c;
	boolean bcheckId;
	String en,my,ch,bktype;
	
	/**
	 * コンストラクタ
	 */
	public BookRegistrationFrame() {
		/** 画面タイトル */
		setTitle("Book Entry");
		/** 画面サイズ */
		setBounds(300, 300, 800, 600);
		/** 画面表示ポジション */
		setLocation(150, 150);
		/** 画面表示・非表示設定 */
		setVisible(true);
		lbllabel = new JLabel("Book Information Registration Form");
		lblbookId = new JLabel("Book Id:");
		txtbookId = new JTextField(15);
		txtbookId.setText("" + (new OrderListForm().getID() + 1));
		txtbookId.setEditable(false);
		lblrDate = new JLabel("Reg Date(dd/MM/yyyy):");
		/** 日付のフォーマットを設定（dd/MM/yyyy） */
		try {
			mf = new MaskFormatter("**/**/****");
			txtrDate = new JFormattedTextField(mf);
			txtrDate.setColumns(15);
		} catch (Exception e) {
		}
		lbltitle = new JLabel("Title:");
		txttitle = new JTextField(22);
		lblauthor = new JLabel("Author:");
		txtauthor = new JTextField(22);
		lblpDate = new JLabel("Publish Date(dd/MM/yyyy):");
		/** 日付のフォーマットを設定 */
		try {
			mf1 = new MaskFormatter("**/**/****");
			txtpDate = new JFormattedTextField(mf1);
			txtpDate.setColumns(22);
		} catch (Exception e) {
		}
		lblbookType = new JLabel("Book Type:");
		/** コンボボックス作成 */
		cbbookType = new JComboBox();
		cbbookType.setEditable(false);
		cbbookType.addItem("Art");
		cbbookType.addItem("Technology");
		cbbookType.addItem("Language");
		lblprice = new JLabel("Price:");
		txtprice = new JTextField(22);
		lblremark = new JLabel("Remark:");
		txtremark = new JTextArea(10, 22);
		Border border2 = BorderFactory.createLineBorder(Color.gray);
		txtremark.setBorder(border2);

		/** チェックボックス作成 */
		ebox = new JCheckBox("English");
		mbox = new JCheckBox("Myanmar");
		cbox = new JCheckBox("Chinese");
		chkpanel = new JPanel();
		chkpanel.add(ebox);
		chkpanel.add(mbox);
		chkpanel.add(cbox);
		Border border = BorderFactory.createTitledBorder("Publishing Language");
		chkpanel.setBorder(border);

		titlePanel = new JPanel();
		dataPanel = new JPanel();
		buttonPanel = new JPanel();
		allPanel = new JPanel();

		btnNew = new JButton("New");
		btnSave = new JButton("Save");
		btnEdit = new JButton("Edit");
		btnDelete = new JButton("Delete");
		btnCancel = new JButton("Cancel");

		/** 画面タイトル表示エリア設定 */
		titlePanel.add(lbllabel);
		/** 画面のボタン表示エリア設定 */
		buttonPanel.add(btnNew);
		buttonPanel.add(btnSave);
		buttonPanel.add(btnEdit);
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnCancel);

		/** 画面のデータ表示エリア設定 */
		dataPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(1, 1, 1, 1);
		add(dataPanel, lblbookId, gbc, 3, 0, 1, 1);
		add(dataPanel, txtbookId, gbc, 4, 0, 1, 1);
		add(dataPanel, lblrDate, gbc, 3, 1, 1, 1);
		add(dataPanel, txtrDate, gbc, 4, 1, 1, 1);
		add(dataPanel, lbltitle, gbc, 0, 2, 1, 1);
		add(dataPanel, txttitle, gbc, 1, 2, 1, 1);
		add(dataPanel, lblauthor, gbc, 0, 3, 1, 1);
		add(dataPanel, txtauthor, gbc, 1, 3, 1, 1);
		add(dataPanel, lblpDate, gbc, 0, 4, 1, 1);
		add(dataPanel, txtpDate, gbc, 1, 4, 1, 1);
		add(dataPanel, lblbookType, gbc, 0, 5, 1, 1);
		gbc.ipadx = 152;
		add(dataPanel, cbbookType, gbc, 1, 5, 1, 1);
		gbc.ipadx = 0;
		add(dataPanel, chkpanel, gbc, 1, 6, 1, 1);
		add(dataPanel, lblprice, gbc, 0, 7, 1, 1);
		add(dataPanel, txtprice, gbc, 1, 7, 1, 1);
		add(dataPanel, lblremark, gbc, 0, 8, 1, 1);
		add(dataPanel, txtremark, gbc, 1, 8, 1, 1);

		/** 表示エリアを格納 */
		allPanel.setLayout(new BorderLayout());
		allPanel.add(titlePanel, BorderLayout.NORTH);
		allPanel.add(dataPanel, BorderLayout.CENTER);
		allPanel.add(buttonPanel, BorderLayout.SOUTH);
		Container contentPane = getContentPane();
		contentPane.add(allPanel);

		/** Newボタン押下 */
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtbookId.setText("" + (new OrderListForm().getID() + 1));
				txtrDate.setText("");
				txttitle.setText("");
				txtauthor.setText("");
				txtpDate.setText("");
				txtprice.setText("");
				ebox.setSelected(false);
				mbox.setSelected(false);
				cbox.setSelected(false);
				cbbookType.setSelectedIndex(0);
				txtremark.setText("");
			}
		});

		/** 英語チェックボックス選択 */
		ebox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ebox.isSelected()) {
					eng = 1;
				}
			}
		});
		/** ミャンマー語チェックボックス選択 */
		mbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mbox.isSelected()) {
					m = 1;
				}
			}
		});
		/** 中国語チェックボックス選択 */
		cbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbox.isSelected()) {
					c = 1;
				}
			}
		});
		/** Saveボタン押下 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = txtbookId.getText();
				bkid = Integer.parseInt(s1);
				str[1] = txtrDate.getText();
				str[2] = txttitle.getText();
				str[3] = txtauthor.getText();
				str[4] = txtpDate.getText();
				str[5] = txtremark.getText();
				str[6] = (String) cbbookType.getSelectedItem();
				if (eng == 1)
					en = "Yes";
				else
					en = "No";
				if (m == 1)
					my = "Yes";
				else
					my = "No";
				if (c == 1)
					ch = "Yes";
				else
					ch = "No";
				str[7] = txtprice.getText();
				bkprice = Integer.parseInt(str[7]);
				BookListForm bform = new BookListForm();
				bform.newUpdate(bkid, str[1], str[2], str[3], str[4], str[6], en, my, ch, bkprice, str[5]);

				count = count + 1;

			}
		});

		/** Editボタン押下 */
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookListForm bform = new BookListForm();
				String inputValue = JOptionPane.showInputDialog("Please input book id:");
				int i = Integer.parseInt(inputValue);
				bform.showDb(i);

				UserData ud = new UserData();
				txtbookId.setText("" + (new OrderListForm().getID() + 1));
				txtrDate.setText(ud.getRegisterdate());
				txttitle.setText(ud.getTitle());
				txtauthor.setText(ud.getAuthor());
				txtpDate.setText(ud.getPublishDate());
				if (ud.getPrice() == 0)
					txtprice.setText("");
				else
					txtprice.setText(ud.getPrice() + "");
				String eng = ud.getEnglish();
				if (eng.equals("Yes"))
					ebox.setSelected(true);
				else
					ebox.setSelected(false);
				String myn = ud.getMyanmar();
				if (myn.equals("Yes"))
					mbox.setSelected(true);
				else
					mbox.setSelected(false);
				String ch = ud.getChinese();
				if (ch.equals("Yes"))
					cbox.setSelected(true);
				else
					cbox.setSelected(false);
				String str = ud.getType();
				if (str.equals("Art"))
					cbbookType.setSelectedIndex(0);
				else if (str.equals("Technology"))
					cbbookType.setSelectedIndex(1);
				else if (str.equals("Language"))
					cbbookType.setSelectedIndex(2);
				txtremark.setText(ud.getRemark());
			}
		});

		/** Deleteボタン押下 */
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookListForm bform = new BookListForm();
				String inputValue = JOptionPane.showInputDialog("Please input book id:");
				if(!inputValue.isEmpty()) {
					int i = Integer.parseInt(inputValue);
					bform.deleteDb(i);
				}
			}
		});

		/** Cancelボタン押下 */
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	/**
	 * 
	 * パネルに画面表示エリア情報を追加
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
	 * 
	 * パネルに画面表示エリア情報を追加
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

	/** ユーザーデータを表示 */
	public void showData() {
		UserData ud = new UserData();
		txtbookId.setText("" + ud.getId());
		txtrDate.setText(ud.getRegisterdate());
		txttitle.setText(ud.getTitle());
		txtauthor.setText(ud.getAuthor());
		txtpDate.setText(ud.getPublishDate());
		txtprice.setText(ud.getPrice() + "");
		String eng = ud.getEnglish();
		if (eng.equals("Yes"))
			ebox.setSelected(true);
		else
			ebox.setSelected(false);
		String myn = ud.getMyanmar();
		if (myn.equals("Yes"))
			mbox.setSelected(true);
		else
			mbox.setSelected(false);
		String ch = ud.getChinese();
		if (ch.equals("Yes"))
			cbox.setSelected(true);
		else
			cbox.setSelected(false);
		String str = ud.getType();
		if (str.equals("Art"))
			cbbookType.setSelectedIndex(0);
		else if (str.equals("Technology"))
			cbbookType.setSelectedIndex(1);
		else if (str.equals("Language"))
			cbbookType.setSelectedIndex(2);
		txtremark.setText(ud.getRemark());
	}
}