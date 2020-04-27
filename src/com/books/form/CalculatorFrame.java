package com.books.form;

/**
 * <pre>
 * ＯＪＴ用システム
 * Copyright(C) Creative Future Tech. All right reserved.
 *
 * com.books.form.CalculatorFrame.java
 * 電卓クラス
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
import java.awt.event.*;

public class CalculatorFrame extends JFrame
{
	/**
	 * コンストラクタ
	 */
	public CalculatorFrame() {
		/** 画面のタイトル */
		setTitle("Calculator");
		/** 画面項目追加エリア */
		CalculatorPanel panel = new CalculatorPanel();
		/** 画面に追加 */
		Container contentpane = getContentPane();
		contentpane.add(panel);
		// add(panel);
		pack();

		setVisible(true);
		/** 閉じるボタン（X）押下 */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
}

/**
 * 画面パネル作成クラス
 * @author user
 *
 */
class CalculatorPanel extends JPanel {
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean start;

	/**
	 * コンストラクタ
	 */
	public CalculatorPanel() {
		/** レイアウトの設定 */
		setLayout(new BorderLayout());

		result = 0;
		lastCommand = "=";
		start = true;

		// add the display
		display = new JButton("0");
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);

		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();

		// add the buttons in a 4 x 4 grid
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));

		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);

		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);

		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);

		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);

		add(panel, BorderLayout.CENTER);
	}

	/**
	 * ボタンをパレルに追加
	 * @param label
	 * @param listener
	 */
	private void addButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}

	/**
	 * 押下したボタンの値を画面に表示
	 * 
	 * @author user
	 *
	 */
	private class InsertAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String input = event.getActionCommand();
			if (start) {
				display.setText("");
				start = false;
			}
			display.setText(display.getText() + input);
		}
	}

	/**
	 * コマンドボタンを押下するとき計算する
	 * 
	 * @author user
	 *
	 */
	private class CommandAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String command = event.getActionCommand();

			if (start) {
				if (command.equals("-")) {
					display.setText(command);
					start = false;
				} else
					lastCommand = command;
			} else {
				calculate(Double.parseDouble(display.getText()));
				lastCommand = command;
				start = true;
			}
		}
	}

	/**
	 * 計算する
	 * @param x
	 */
	public void calculate(double x) {
		if (lastCommand.equals("+"))
			result += x;
		else if (lastCommand.equals("-"))
			result -= x;
		else if (lastCommand.equals("*"))
			result *= x;
		else if (lastCommand.equals("/"))
			result /= x;
		else if (lastCommand.equals("="))
			result = x;
		display.setText("" + result);
	}
}