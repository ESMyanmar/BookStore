package com.books.form;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.form.CustomerOrderFrame.java
 * お客様オーダ情報を格納するためのクラス
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
import com.books.bean.CustomerData;

import java.awt.event.*;

public class CustomerOrderFrame extends JFrame implements ActionListener
{
	private static JLabel lbllabel, lblbookId, lblpublish, lbltitle, lblauthor, lblpDate, lblbookType, lblprice,
			lblremark, lblname, lblpaid, lblshift, lblphone, lblemail, lblorderId, lblorderDate;
	private static JTextField txtbookId, txttitle, txtauthor, txtprice, txtremark, txtname, txtphone, txtemail, txten,
			txtmy, txtch, txtorderId;
	JTextArea txtshift;
	private static JButton btnSearch, btnNew, btnSave, btnEdit, btnDelete, btnCancel;
	JPanel titlePanel, dataPanel, dataPanel1, buttonPanel, allPanel, idPanel;
	private static JCheckBox ebox, mbox, cbox, enbox, mybox, chbox;
	private static JRadioButton cashrb, creditrb;
	private static ButtonGroup bg;
	private static JPanel chkpanel, chkpanel1, rbpanel;
	private static JFormattedTextField txtrDate, txtpDate, txtorderDate;
	MaskFormatter mf;
	private static int eng, myn, chn, orid, bkid, totalQty, totalCost, cost;
	private static int engnum = 0;
	private static int myynum = 0;
	private static int chnum = 0;
	private static String en, my, ch, rpaid;
	private static String str[] = new String[20];
	private static String paid;
	private static int count = 1;

	/**
	 * コンストラクタ
	 */
	public CustomerOrderFrame() {
		/** 画面タイトル */
		setTitle("Customer Order Entry");
		/** 画面のサイズ */
		setBounds(300, 300, 800, 600);
		/** 画面表示ポジション */
		setLocation(150, 150);
		setVisible(true);
		/** カスタマー情報を設定する */
		lbllabel = new JLabel("Customer Order Form");
		lblbookId = new JLabel("Book Id:");
		txtbookId = new JTextField(9);
		txtbookId.setEditable(false);
		btnSearch = new JButton("Search");
		lbltitle = new JLabel("Book Title:");
		txttitle = new JTextField(22);
		txttitle.setEditable(false);
		lblauthor = new JLabel("Author:");
		txtauthor = new JTextField(22);
		txtauthor.setEditable(false);
		lblpublish = new JLabel("Publish-Lang:");
		lblprice = new JLabel("Unit Price:");
		txtprice = new JTextField(22);
		txtprice.setEditable(false);
		/** 画面項目をパレルに追加 */
		idPanel = new JPanel();
		idPanel.setLayout(new GridLayout(0, 2));
		idPanel.add(txtbookId);
		idPanel.add(btnSearch);

		ebox = new JCheckBox("English");
		ebox.setSelected(false);
		mbox = new JCheckBox("Myanmar");
		cbox = new JCheckBox("Chinese");
		chkpanel = new JPanel();
		chkpanel.add(ebox);
		chkpanel.add(mbox);
		chkpanel.add(cbox);
		Border border = BorderFactory.createLineBorder(Color.gray);
		chkpanel.setBorder(border);

		/** パネルの格納 */
		titlePanel = new JPanel();
		dataPanel = new JPanel();
		dataPanel1 = new JPanel();
		buttonPanel = new JPanel();
		allPanel = new JPanel();

		/** ボタンの格納 */
		btnNew = new JButton("New");
		btnSave = new JButton("Save");
		btnEdit = new JButton("Edit");
		btnDelete = new JButton("Delete");
		btnCancel = new JButton("Cancel");

		/** パネルにボタンを追加 */
		titlePanel.add(lbllabel);
		buttonPanel.add(btnNew);
		buttonPanel.add(btnSave);
		buttonPanel.add(btnEdit);
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnCancel);

		/** チェックボックス格納 */
		ebox = new JCheckBox("English");
		mbox = new JCheckBox("Myanmar");
		cbox = new JCheckBox("Chinese");
		ebox.setEnabled(false);
		mbox.setEnabled(false);
		cbox.setEnabled(false);
		txten = new JTextField("0", 5);
		txtmy = new JTextField("0", 5);
		txtch = new JTextField("0", 5);
		chkpanel = new JPanel();
		chkpanel.add(ebox);
		chkpanel.add(mbox);
		chkpanel.add(cbox);
		Border border2 = BorderFactory.createLineBorder(Color.gray);
		chkpanel.setBorder(border2);

		/** 画面レイアウト設定 */
		dataPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10, 5, 10, 5);
		add(dataPanel, lblbookId, gbc, 0, 0, 1, 1);
		gbc.ipadx = 40;
		add(dataPanel, idPanel, gbc, 1, 0, 1, 1);
		gbc.ipadx = 0;
		add(dataPanel, lbltitle, gbc, 0, 3, 1, 1);
		add(dataPanel, txttitle, gbc, 1, 3, 1, 1);
		add(dataPanel, lblauthor, gbc, 0, 5, 1, 1);
		add(dataPanel, txtauthor, gbc, 1, 5, 1, 1);
		add(dataPanel, lblpublish, gbc, 0, 7, 1, 1);
		add(dataPanel, chkpanel, gbc, 1, 7, 1, 1);
		add(dataPanel, lblprice, gbc, 0, 9, 1, 1);
		add(dataPanel, txtprice, gbc, 1, 9, 1, 1);

		/** オーダ情報を設定する */
		lblorderId = new JLabel("Order Id:");
		txtorderId = new JTextField(10);
		txtorderId.setText("" + (new OrderListForm().getID() + 1));
		txtorderId.setEditable(false);
		lblorderDate = new JLabel("Order Date(dd/MM/yyyy):");
		try {
			mf = new MaskFormatter("**/**/****");
			txtorderDate = new JFormattedTextField(mf);
			txtorderDate.setColumns(10);
		} catch (Exception e) {
		}
		lblname = new JLabel("Customer Name:");
		txtname = new JTextField(22);
		lblpaid = new JLabel("Paied By:");
		rbpanel = new JPanel();
		bg = new ButtonGroup();
		cashrb = addRadioButton(rbpanel, bg, "Cash", true);
		creditrb = addRadioButton(rbpanel, bg, "CreditCard", false);
		cashrb.addActionListener(this);
		creditrb.addActionListener(this);
		lblshift = new JLabel("Shift Add:");
		txtshift = new JTextArea(10, 22);
		Border border3 = BorderFactory.createLineBorder(Color.gray);
		txtshift.setBorder(border3);
		lblphone = new JLabel("Phone:");
		txtphone = new JTextField(22);
		lblemail = new JLabel("Email:");
		txtemail = new JTextField(22);

		enbox = new JCheckBox("English");
		mybox = new JCheckBox("Myanmar");
		chbox = new JCheckBox("Chinese");
		txten = new JTextField(5);
		txten.setText("0");
		txtmy = new JTextField(5);
		txtmy.setText("0");
		txtch = new JTextField(5);
		txtch.setText("0");
		chkpanel1 = new JPanel();
		chkpanel1.setLayout(new GridLayout(2, 3));
		chkpanel1.add(enbox);
		chkpanel1.add(mybox);
		chkpanel1.add(chbox);
		chkpanel1.add(txten);
		chkpanel1.add(txtmy);
		chkpanel1.add(txtch);
		Border border1 = BorderFactory.createTitledBorder("Order Book in Language");
		chkpanel1.setBorder(border1);

		dataPanel1.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.LINE_START;
		gbc1.insets = new Insets(1, 1, 1, 1);
		add(lblorderId, dataPanel1, gbc1, 0, 0, 1, 1);
		add(txtorderId, dataPanel1, gbc1, 1, 0, 1, 1);
		add(lblorderDate, dataPanel1, gbc1, 0, 1, 1, 1);
		add(txtorderDate, dataPanel1, gbc1, 1, 1, 1, 1);
		add(lblname, dataPanel1, gbc1, 0, 2, 1, 1);
		add(txtname, dataPanel1, gbc1, 1, 2, 1, 1);
		add(lblpaid, dataPanel1, gbc1, 0, 3, 1, 1);
		add(dataPanel1, rbpanel, gbc1, 1, 3, 1, 1);
		add(lblshift, dataPanel1, gbc1, 0, 4, 1, 1);
		add(txtshift, dataPanel1, gbc1, 1, 4, 1, 1);
		add(lblphone, dataPanel1, gbc1, 0, 5, 1, 1);
		add(txtphone, dataPanel1, gbc1, 1, 5, 1, 1);
		add(lblemail, dataPanel1, gbc1, 0, 6, 1, 1);
		add(txtemail, dataPanel1, gbc1, 1, 6, 1, 1);
		add(dataPanel1, chkpanel1, gbc1, 1, 7, 1, 1);

		/** 画面レイアウトの設定 */
		allPanel.setLayout(new BorderLayout());
		allPanel.add(titlePanel, BorderLayout.NORTH);
		allPanel.add(dataPanel, BorderLayout.WEST);
		allPanel.add(dataPanel1, BorderLayout.EAST);
		allPanel.add(buttonPanel, BorderLayout.SOUTH);
		Container contentPane = getContentPane();
		contentPane.add(allPanel);

		/** Newボタン押下 */
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtorderId.setText("" + (new OrderListForm().getID() + 1));
				txtorderDate.setText("");
				cashrb.setSelected(true);
				txtname.setText("");
				txtshift.setText("");
				txtphone.setText("");
				txtemail.setText("");
				enbox.setSelected(false);
				mybox.setSelected(false);
				chbox.setSelected(false);
				txten.setText("0");
				txtmy.setText("0");
				txtch.setText("0");
				txtbookId.setText("");
				txttitle.setText("");
				txtauthor.setText("");
				txtprice.setText("");
				ebox.setSelected(false);
				mbox.setSelected(false);
				cbox.setSelected(false);
			}
		});

		/** 英語チェックボックス押下 */
		enbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enbox.isSelected()) {
					eng = 1;
				}
			}
		});

		/** ミャンマー語チェックボックス押下 */
		mybox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mybox.isSelected()) {
					myn = 1;
				}
			}
		});

		/** 中国語チェックボックス押下 */
		chbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chbox.isSelected()) {
					chn = 1;
				}
			}
		});
		
		/** Searchボタン押下 */
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Please input book id:");
				int i = Integer.parseInt(inputValue);
				OrderListForm oform = new OrderListForm();
				oform.outBkDb(i);

				UserData ud = new UserData();
				if (ud.getId() == 0)
					txtbookId.setText("");
				else
					txtbookId.setText("" + ud.getId());
				bkid = ud.getId();
				txttitle.setText(ud.getTitle());
				txtauthor.setText(ud.getAuthor());
				if (ud.getPrice() == 0)
					txtprice.setText("");
				else
					txtprice.setText(ud.getPrice() + "");
				if (txtprice.getText().equals(""))
					cost = 0;
				else
					cost = Integer.parseInt(txtprice.getText());
				String engstr = ud.getEnglish();
				if (engstr.equals("Yes"))
					ebox.setSelected(true);
				else
					ebox.setSelected(false);
				String mynstr = ud.getMyanmar();
				if (mynstr.equals("Yes"))
					mbox.setSelected(true);
				else
					mbox.setSelected(false);
				String chstr = ud.getChinese();
				if (chstr.equals("Yes"))
					cbox.setSelected(true);
				else
					cbox.setSelected(false);
			}
		});

		/** Saveボタン押下 */
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = txtorderId.getText();
				orid = Integer.parseInt(s1);

				str[0] = txtorderDate.getText();
				str[1] = txtname.getText();
				str[2] = txtshift.getText();
				str[3] = txtphone.getText();
				str[4] = txtemail.getText();
				str[5] = txten.getText();
				engnum = Integer.parseInt(str[5]);
				str[6] = txtmy.getText();
				myynum = Integer.parseInt(str[6]);
				str[7] = txtch.getText();
				chnum = Integer.parseInt(str[7]);
				totalQty = engnum + myynum + chnum;
				totalCost = totalQty * cost;
				if (eng == 1)
					en = "Yes";
				else
					en = "No";
				if (myn == 1)
					my = "Yes";
				else
					my = "No";
				if (chn == 1)
					ch = "Yes";
				else
					ch = "No";
				OrderListForm oform = new OrderListForm();
				oform.dbUpdate(orid, str[0], bkid, str[1], paid, en, engnum, my, myynum, ch, chnum, totalQty, totalCost,
						str[2], str[3], str[4]);

				count = count + 1;

			}
		});

		/** Editボタン押下 */
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderListForm oform = new OrderListForm();
				String inputValue = JOptionPane.showInputDialog("Please input order id:");
				if(!inputValue.isEmpty()) {
					int i = Integer.parseInt(inputValue);
					oform.editDb(i);	
				}
				CustomerData ud = new CustomerData();
				txtorderId.setText("" + (new OrderListForm().getID() + 1));
				txtorderDate.setText(ud.getOrderDate());
				txtname.setText(ud.getCustomerName());
				rpaid = ud.getPaid();
				if (rpaid.equals("Credit"))
					creditrb.setSelected(true);
				else
					creditrb.setSelected(false);
				if (rpaid.equals("Cash"))
					cashrb.setSelected(true);
				else
					cashrb.setSelected(false);
				String eng = ud.getPublishEng();
				String tstr = "Yes";
				if (eng.equals(tstr))
					enbox.setSelected(true);
				else
					enbox.setSelected(false);
				String myn = ud.getPublishMyanmar();
				if (myn.equals(tstr))
					mybox.setSelected(true);
				else
					mybox.setSelected(false);
				String ch = ud.getPublishChinese();
				if (ch.equals(tstr))
					chbox.setSelected(true);
				else
					chbox.setSelected(false);
				txten.setText(ud.getQtyEnglish() + "");
				txtmy.setText(ud.getQtyMyanmar() + "");
				txtch.setText(ud.getQtyChinese() + "");
				txtshift.setText(ud.getOrderAddress());
				txtphone.setText(ud.getOrderPhone());
				txtemail.setText(ud.getOrderEmail());
			}
		});

		/** Deleteボタン押下 */
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderListForm oform = new OrderListForm();
				String inputValue = JOptionPane.showInputDialog("Please input book id:");
				int i = Integer.parseInt(inputValue);
				oform.deleteDb(i);
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
	 * パネルに画面項目追加
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
		Border border = BorderFactory.createTitledBorder("Publishing Language");
		pan.setBorder(border);
	}

	/**
	 * パレルに画面項目追加
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
	 * パレルに画面項目追加
	 * 
	 * @param p
	 * @param pan
	 * @param s
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void add(Component p, JPanel pan, GridBagConstraints s, int x, int y, int w, int h) {
		s.gridwidth = w;
		s.gridheight = h;
		s.gridx = x;
		s.gridy = y;
		pan.add(p, s);
		Border border = BorderFactory.createTitledBorder("Customer Info");
		pan.setBorder(border);
	}

	/**
	 * ラジオボタンを設定する
	 * 
	 * @param p
	 * @param g
	 * @param name
	 * @param v
	 * @return
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
		if (source == cashrb)
			paid = "Cash";
		else if (source == creditrb)
			paid = "Credit";
	}

	/**
	 * カスタマー情報を表示
	 */
	public void showData() {
		CustomerData ud = new CustomerData();
		txtorderId.setText("" + ud.getOrderId());
		txtorderDate.setText(ud.getOrderDate());
		txtname.setText(ud.getCustomerName());
		rpaid = ud.getPaid();
		if (rpaid.equals("Credit"))
			creditrb.setSelected(true);
		else
			creditrb.setSelected(false);
		if (rpaid.equals("Cash"))
			cashrb.setSelected(true);
		else
			cashrb.setSelected(false);
		String eng = ud.getPublishEng();
		String tstr = "Yes";
		if (eng.equals(tstr))
			enbox.setSelected(true);
		else
			enbox.setSelected(false);
		String myn = ud.getPublishMyanmar();
		if (myn.equals(tstr))
			mybox.setSelected(true);
		else
			mybox.setSelected(false);
		String ch = ud.getPublishChinese();
		if (ch.equals(tstr))
			chbox.setSelected(true);
		else
			chbox.setSelected(false);
		txten.setText(ud.getQtyEnglish() + "");
		txtmy.setText(ud.getQtyMyanmar() + "");
		txtch.setText(ud.getQtyChinese() + "");
		txtshift.setText(ud.getOrderAddress());
		txtphone.setText(ud.getOrderPhone());
		txtemail.setText(ud.getOrderEmail());
	}
}