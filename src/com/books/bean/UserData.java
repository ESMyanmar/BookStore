package com.books.bean;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.bean.UserData.java
 * ユーザー情報を格納するためのクラス
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

public class UserData
{
	/** ID */
	private static int id;
	/** 登録日 */
	private static String registerDate="";
	/** タイトル */
	private static String title="";
	/** 筆者 */
	private static String author="";
	/** 出版日 */
	private static String publishDate="";
	/** 種類 */
	private static String type="";
	/** 英語 */
	private static String eng="";
	/** ミャンマー語 */
	private static String myn="";
	/** 中国語 */
	private static String ch="";
	/** 値段 */
	private static int price;
	/** 備考 */
	private static String remark="";
	/** 注文日 */
	private static String orderDate="";
	/** お客様名 */
	private static String customerName="";
	/** 支払い方法） */
	private static String paidMethod="";
	/** 英語本 */
	private static String publishEng="";
	/** ミャンマー語本 */
	private static String publishMyn="";
	/** 中国語本 */
	private static String publishCh="";
	/** 住所 */
	private static String address="";
	/** 電話番号 */
	private static String orderPhone="";
	/** Eメール */
	private static String orderEmail="";
	/** 注文ID */
	private static int orderId;
	/** 英語量 */
	private static int qtyEnglish;
	/** ミャンマー語量 */
	private static int qtyMyanmar;
	/** 中国語量 */
	private static int qtyChinese;
	/** 合計量 */
	private static int totalQty;
	/** 合計 */
	private static int TotalCost;
	
	/**
	 * ゲッター
	 * @return
	 */
	public static int getQtyEnglish() {
		return qtyEnglish;
	}
	
	/**
	 * セッター
	 * @param qtyEng
	 */
	public static void setQtyEnglish(int qtyEng) {
		qtyEnglish = qtyEng;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static int getQtyMyanmar() {
		return qtyMyanmar;
	}
	
	/**
	 * セッター
	 * @param qtyMyn
	 */
	public static void setQtyMyn(int qtyMyn) {
		qtyMyanmar = qtyMyn;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static int getQtyChinese() {
		return qtyChinese;
	}
	
	/**
	 * セッター
	 * @param qtyCh
	 */
	public static void setQtyChinese(int qtyCh) {
		qtyChinese = qtyCh;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static int getTotalQty() {
		return totalQty;
	}
	
	/**
	 * セッター
	 * @param totQty
	 */
	public static void setTotalQty(int totQty) {
		totalQty = totQty;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static int getTotalCost() {
		return TotalCost;
	}
	
	/**
	 * セッター
	 * @param totCost
	 */
	public static void setTotalCost(int totCost) {
		TotalCost = totCost;
	}
	
	/**
	 * ゲッター
	 */
	public static String getOrderDate() {
		return orderDate;
	}
	
	/**
	 * セッター
	 * @param oDate
	 */
	public static void setOrderDate(String oDate) {
		orderDate = oDate;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static String getCustomerName() {
		return customerName;
	}
	
	/**
	 * セッター
	 * @param cName
	 */
	public static void setCustomerName(String cName) {
		customerName = cName;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static String getPaid() {
		return paidMethod;
	}
	
	/**
	 * セッター
	 * @param paid
	 */
	public static void setPaid(String paid) {
		paidMethod = paid;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static String getPublishEnglish() {
		return publishEng;
	}
	
	/**
	 * セッター
	 * @param pEng
	 */
	public static void setPublishEnglish(String pEng) {
		publishEng = pEng;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static String getPublishMyanmar() {
		return publishMyn;
	}
	
	/**
	 * セッター
	 * @param pMyn
	 */
	public static void setpMyn(String pMyn) {
		publishMyn = pMyn;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static String getPublishChinese() {
		return publishCh;
	}
	
	/**
	 * セッター
	 * @param pCc
	 */
	public static void setpCc(String pCc) {
		publishCh = pCc;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static String getAddress() {
		return address;
	}
	
	/**
	 * セッター
	 * @param sAdd
	 */
	public static void setsAdd(String sAdd) {
		address = sAdd;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static String getOrderPhone() {
		return orderPhone;
	}
	
	/**
	 * セッター
	 * @param orPhone
	 */
	public static void setOrPhone(String orPhone) {
		orderPhone = orPhone;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static String getOrderEmail() {
		return orderEmail;
	}
	
	/**
	 * セッター
	 * @param orEmail
	 */
	public static void setOrderEmail(String orEmail) {
		orderEmail = orEmail;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public static int getOrderId() {
		return orderId;
	}
	
	/**
	 * セッター
	 * @param orid
	 */
	public static void setOrderId(int orid) {
		orderId = orid;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * セッター
	 * @param id
	 */
	public void setId(int pid) {
		id = pid;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public String getRegisterdate() {
		return registerDate;
	}
	
	/**
	 * セッター
	 * @param rdate
	 */
	public void setRegisterdate(String rdate) {
		registerDate = rdate;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * セッター
	 * @param ptitle
	 */
	public void setTitle(String ptitle) {
		title = ptitle;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * セッター
	 * @param author
	 */
	public void setAuthor(String pauthor) {
		author = pauthor;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public String getPublishDate() {
		return publishDate;
	}
	
	/**
	 * セッター
	 * @param pdate
	 */
	public void setPublishDate(String pdate) {
		publishDate = pdate;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * セッター
	 * @param type
	 */
	public void setType(String stype) {
		type = stype;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public String getEnglish() {
		return eng;
	}
	
	/**
	 * セッター
	 * @param sEng
	 */
	public void setEnglish(String sEng) {
		eng = sEng;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public String getMyanmar() {
		return myn;
	}
	
	/**
	 * セッター
	 * @param sMyn
	 */
	public void setMyanmar(String sMyn) {
		myn = sMyn;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public String getChinese() {
		return ch;
	}
	
	/**
	 * セッター
	 * @param sCh
	 */
	public void setChinese(String sCh) {
		ch = sCh;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * セッター
	 * @param price
	 */
	public void setPrice(int iPrice) {
		price = iPrice;
	}
	
	/**
	 * ゲッター
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * セッター
	 * @param remark
	 */
	public void setRemark(String sRemark) {
		remark = sRemark;
	}
}