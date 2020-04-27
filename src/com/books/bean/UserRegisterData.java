package com.books.bean;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.bean.UserRegisterData.java
 * 登録ユーザー情報を格納するためのクラス
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

public class UserRegisterData
{
	/** 名称 */
	private static String name="";
	/** パスワード */
	private static String password="";
	/** ログインID */
	private static int loginId;
	/** ユーザーライト */
	private static String UserRight="";
	/** 備考 */
	private static String remark="";
	
	/**
	 * ゲッター（名前）
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * セッター（名前）
	 * @param sName
	 */
	public void setName(String sName) {
		name = sName;
	}
	
	/**
	 * ゲッター（パスワード）
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * セッター（パスワード）
	 * @param pw
	 */
	public void setPw(String pw) {
		password = pw;
	}
	
	/**
	 * ゲッター（ログインID）
	 * @return
	 */
	public int getLoginId() {
		return loginId;
	}
	
	/**
	 * セッター（ログインID）
	 * @param logId
	 */
	public void setLogId(int logId) {
		loginId = logId;
	}
	
	/**
	 * ゲッター（ユーザーライト）
	 * @return
	 */
	public String getUserRight() {
		return UserRight;
	}
	
	/**
	 * セッター（ユーザーライト）
	 * @param uRight
	 */
	public void setURight(String uRight) {
		UserRight = uRight;
	}
	
	/**
	 * ゲッター（備考）
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * セッター（備考）
	 * @param rMark
	 */
	public void setrMark(String rMark) {
		remark = rMark;
	}
}