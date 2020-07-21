package com.hl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Hailin
 * @date 2020/6/20
 */
public class Test {

    public static void main(String[] args) {
        JFrame frm = new JFrame();
        frm.setBounds(100, 100, 300, 300);
        frm.setTitle("我的窗口");
        Container c = frm.getContentPane(); // frm中包含一个内容窗格， 需要获取内容窗格，再设置背景颜色，直接设置frm的背景颜色会被内容窗格挡住
        c.setBackground(Color.RED);
        frm.setLayout(null);                // 如过不设置为null默认，按钮会充满整个内容框，挡住背景颜色
        JButton btn = new JButton("确定");
        btn.setLocation(100, 100);
        btn.setSize(100, 40);
//		btn.setBounds(100, 100, 100, 40);   // 功能与上面相同
        frm.add(btn);                    // 添加了按钮会把背景颜色挡住，可以通过面板来调节
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}