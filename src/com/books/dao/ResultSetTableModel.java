package com.books.dao;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.dao.ResultSetTableModel.java
 * テーブルデータ出力モデル
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

import java.util.*;
import javax.swing.table.*;
import java.sql.*;

public class ResultSetTableModel extends AbstractTableModel
{
	private ArrayList cache;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	/**
	 * 
	 * データセットモデル
	 * 
	 * @param aResultSet
	 */
	public ResultSetTableModel(ResultSet aResultSet){
    		rs = aResultSet;
    		try{
     			rsmd = rs.getMetaData();
			cache = new ArrayList();
	  		int cols = getColumnCount();	  
	  		while (rs.next()){
				Object[] row = new Object[cols];
				for (int j = 0; j < row.length; j++)
					row[j] = rs.getObject(j + 1);
				cache.add(row);
			}
    		}catch(SQLException e){
			System.out.println("Error " + e);
		}
	}
	
	/**
	 * 
	 * データベースからデータを取得
	 * 
	 * @return データ（Object）
	 * 
	 */
	public Object getValueAt(int r, int c){
		if (r < cache.size())
		  return ((Object[])cache.get(r))[c];
		else
		  return null;
	}
	
	/**
	 * 
	 * データベースのロールカウント
	 * 
	 * @return ロールカウント（int）
	 * 
	 */
	public int getRowCount()
	{
		return cache.size();
	}
	
	/**
	 * 
	 * データベースのコラムカウントを取得
	 * 
	 * @return コラムのカウント（int）
	 * 
	 */
	public int getColumnCount()
	{
		try{
			return rsmd.getColumnCount();
    		}catch(SQLException e){
			System.out.println("Error " + e);
			return 0;
		}
	}
	
	/**
	 * 
	 * データベースのコラム名称を取得
	 * 
	 * @return コラムの名称（String）
	 * 
	 */
	public String getColumnName(int c)
	{
  		try{
			return rsmd.getColumnName(c + 1);
    		}catch(SQLException e){
			System.out.println("Error " + e);
      			return "";
		}
  	}
}