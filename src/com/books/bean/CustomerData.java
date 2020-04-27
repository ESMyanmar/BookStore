package com.books.bean;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.bean.CustomerData.java
 * お客様情報を格納するためのクラス
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

public class CustomerData
{
	/** 日付（yyyy/MM/dd） */
	private static String orderDate="";
	/** 名称 */
	private static String customerName="";
	/** 支払い*/
	private static String paid="";
	/** 英語 */
	private static String publishEnglish="";
	/** ミャンマー語 */
	private static String publishMyanmar="";
	/** 中国語 */
	private static String publishChinese="";
	/** 住所 */
	private static String orderAddress="";
	/** 電話番号 */
	private static String orderPhone="";
	/** Email */
	private static String orderEmail="";
	/** オーダーID */
	private static int orderId;
	/** 英語量 */
	private static int qtyEnglish;
	/** ミャンマー語量 */
	private static int qtyMyanmar;
	/** 中国語量 */
	private static int qtyChinese;
	/** 合計量 */
	private static int totalQty;
	/** 合計値段 */
	private static int totalCost;
	
	/**
	 * 英語量を出力するゲッターメソッド
	 * @return
	 */
	public int getQtyEnglish() {
		return qtyEnglish;
	}
	
	/**
	 * 英語量を取得するセッターメソッド
	 * @param qtyEng
	 */
	public void setQtyEnglish(int qtyEng) {
		qtyEnglish = qtyEng;
	}
	
	/**
	 * ミャンマー語量を出力するゲッターメソッド
	 * @return
	 */
	public int getQtyMyanmar() {
		return qtyMyanmar;
	}
	
	/**
	 * ミャンマー語量を取得するセッターメソッド
	 * @param qtyMyn
	 */
	public void setQtyMynmar(int qtyMyn) {
		qtyMyanmar = qtyMyn;
	}
	
	/**
	 * 中国語量を出力するゲッターメソッド
	 * @return
	 */
	public int getQtyChinese() {
		return qtyChinese;
	}
	
	/**
	 * 中国語量を取得するセッターメソッド
	 * @param qtyCc
	 */
	public void setQtyChinese(int qtyCc) {
		qtyChinese = qtyCc;
	}
	
	/**
	 * 合計量を出力するゲッターメソッド
	 * @return
	 */
	public int getTotalQty() {
		return totalQty;
	}
	
	/**
	 * 合計量を取得するセッターメソッド
	 * @param totQty
	 */
	public void setTotalQty(int totQty) {
		totalQty = totQty;
	}
	
	/**
	 * 合計を取得するゲッターメソッド
	 * @return
	 */
	public int getTotalCost() {
		return totalCost;
	}
	
	/**
	 * 合計を取得するセッターメソッド
	 * @param totCost
	 */
	public void setTotalCost(int totCost) {
		totalCost = totCost;
	}
	
	/**
	 * オーダー日付を出力するゲッターメソッド
	 * @return
	 */
	public String getOrderDate() {
		return orderDate;
	}
	
	/**
	 * オーダー日付を取得するセッターメソッド
	 * @param oDate
	 */
	public void setOrderDate(String oDate) {
		orderDate = oDate;
	}
	
	/**
	 * お客様名称を出力するゲッターメソッド
	 * @return
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * お客様名称を取得するセッターメソッド
	 * @param cName
	 */
	public void setCustomerName(String cName) {
		customerName = cName;
	}
	
	/**
	 * 支払いを出力するゲッターメソッド
	 * @return
	 */
	public String getPaid() {
		return paid;
	}
	
	/**
	 * 支払いを取得するセッターメソッド
	 * @param sPaid
	 */
	public void setPaid(String sPaid) {
		paid = sPaid;
	}
	
	/**
	 * 英語本をを出力するゲッターメソッド
	 * @return
	 */
	public String getPublishEng() {
		return publishEnglish;
	}
	
	/**
	 * 英語本を取得するセッターメソッド
	 * @param pEng
	 */
	public void setPublishEng(String pEng) {
		publishEnglish = pEng;
	}
	
	/**
	 * ミャンマー語本を出力するゲッターメソッド
	 * @return
	 */
	public String getPublishMyanmar() {
		return publishMyanmar;
	}
	
	/**
	 * ミャンマー語本を取得するセッターメソッド
	 * @param pMyn
	 */
	public void setPublishMyanmar(String pMyn) {
		publishMyanmar = pMyn;
	}
	
	/**
	 * 中国語本を出力するゲッターメソッド
	 * @return
	 */
	public String getPublishChinese() {
		return publishChinese;
	}
	
	/**
	 * 中国語本を取得するセッターメソッド
	 * @param pCc
	 */
	public void setPublishChinese(String pCc) {
		publishChinese = pCc;
	}
	
	/**
	 * 住所を出力するゲッターメソッド
	 * @return
	 */
	public String getOrderAddress() {
		return orderAddress;
	}
	
	/**
	 * 住所を取得するセッターメソッド
	 * @param sAdd
	 */
	public void setOrderAddress(String sAdd) {
		orderAddress = sAdd;
	}
	
	/**
	 * 電話番号を出力するゲッターメソッド
	 * @return
	 */
	public String getOrderPhone() {
		return orderPhone;
	}
	
	/**
	 * 電話番号を取得するセッターメソッド
	 * @param orPhone
	 */
	public void setOrderPhone(String orPhone) {
		orderPhone = orPhone;
	}
	
	/**
	 * 電話番号を出力するゲッターメソッド
	 * @return
	 */
	public String getOrderEmail() {
		return orderEmail;
	}
	
	/**
	 * 電話番号を取得するセッターメソッド
	 * @param orEmail
	 */
	public void setOrderEmail(String orEmail) {
		orderEmail = orEmail;
	}
	
	/**
	 * オーダーIDを出力するゲッターメソッド
	 * @return
	 */
	public int getOrderId() {
		return orderId;
	}
	
	/**
	 * オーダーIDを取得するセッターメソッド
	 * @param orid
	 */
	public void setOrderId(int orid) {
		orderId = orid;
	}
}