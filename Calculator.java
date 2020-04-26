import javax.swing.*;
import java.awt.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        Queue<String> fuhao = new LinkedList<>();                //队列，就用一次
        Queue<Double> result = new LinkedList<>();        //队列，也用一次
        /*
        主窗体
         */
        JFrame frame = new JFrame("计算器");
        frame.setLocation(600,300);
        frame.setResizable(false);

        JTextField result_TextFiled = new JTextField("0",20);
        JButton clear_Button = new JButton("归零");
        clear_Button.addActionListener(e->result_TextFiled.setText("0"));
        JButton button0 = new JButton("0");
        button0.addActionListener(e -> {
            if(!result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(result_TextFiled.getText()+button0.getText());
            }
        });
        JButton button1 = new JButton("1");
        button1.addActionListener(e->{
            if(result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(button1.getText());
            }
            else {
                result_TextFiled.setText(result_TextFiled.getText()+button1.getText());
            }
        });
        JButton button2 = new JButton("2");
        button2.addActionListener(e->{
            if(result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(button2.getText());
            }
            else {
                result_TextFiled.setText(result_TextFiled.getText()+button2.getText());
            }
        });
        JButton button3 = new JButton("3");
        button3.addActionListener(e->{
            if(result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(button3.getText());
            }
            else {
                result_TextFiled.setText(result_TextFiled.getText()+button3.getText());
            }
        });
        JButton button4 = new JButton("4");
        button4.addActionListener(e->{
            if(result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(button4.getText());
            }
            else {
                result_TextFiled.setText(result_TextFiled.getText()+button4.getText());
            }
        });
        JButton button5 = new JButton("5");
        button5.addActionListener(e->{
            if(result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(button5.getText());
            }
            else {
                result_TextFiled.setText(result_TextFiled.getText()+button5.getText());
            }
        });
        JButton button6 = new JButton("6");
        button6.addActionListener(e->{
            if(result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(button6.getText());
            }
            else {
                result_TextFiled.setText(result_TextFiled.getText()+button6.getText());
            }
        });
        JButton button7 = new JButton("7");
        button7.addActionListener(e->{
            if(result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(button7.getText());
            }
            else {
                result_TextFiled.setText(result_TextFiled.getText()+button7.getText());
            }
        });
        JButton button8 = new JButton("8");
        button8.addActionListener(e->{
            if(result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(button8.getText());
            }
            else {
                result_TextFiled.setText(result_TextFiled.getText()+button8.getText());
            }
        });
        JButton button9 = new JButton("9");
        button9.addActionListener(e->{
            if(result_TextFiled.getText().equals("0")){
                result_TextFiled.setText(button9.getText());
            }
            else {
                result_TextFiled.setText(result_TextFiled.getText()+button9.getText());
            }
        });
        JButton button_Dian = new JButton(".");
        button_Dian.addActionListener(e->{
            Pattern pattern = Pattern.compile("^[0-9]+\\.[0-9]*");
            Matcher matcher = pattern.matcher(result_TextFiled.getText());
            if(!matcher.matches()){
                result_TextFiled.setText(result_TextFiled.getText()+button_Dian.getText());
            }
        });
        JButton button_jia = new JButton("+");
        button_jia.addActionListener(e->{
            fuhao.add(button_jia.getText());
            result.add(Double.parseDouble(result_TextFiled.getText()));
            result_TextFiled.setText("0");

        });
        JButton button_jian = new JButton("-");
        button_jian.addActionListener(e->{
            fuhao.add(button_jian.getText());
            result.add(Double.parseDouble(result_TextFiled.getText()));
            result_TextFiled.setText("0");
        });
        JButton button_cheng = new JButton("*");
        button_cheng.addActionListener(e->{
            fuhao.add(button_cheng.getText());
            result.add(Double.parseDouble(result_TextFiled.getText()));
            result_TextFiled.setText("0");
        });
        JButton button_chu = new JButton("/");
        button_chu.addActionListener(e->{
            fuhao.add(button_chu.getText());
            result.add(Double.parseDouble(result_TextFiled.getText()));
            result_TextFiled.setText("0");
        });
        JButton button_dy = new JButton("=");
        button_dy.addActionListener(e->{
            switch (fuhao.poll()){
                case "+":
                    result_TextFiled.setText(result.poll()+Double.parseDouble(result_TextFiled.getText())+"");
                    break;
                case "-":
                    result_TextFiled.setText(result.poll()-Double.parseDouble(result_TextFiled.getText())+"");
                    break;
                case "*":
                    result_TextFiled.setText(result.poll()*Double.parseDouble(result_TextFiled.getText())+"");
                    break;
                case "/":
                    result_TextFiled.setText(result.poll()/Double.parseDouble(result_TextFiled.getText())+"");
                    break;
            }
        });

        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(4,4,5,5));
        pan.add(button7);
        pan.add(button8);
        pan.add(button9);
        pan.add(button_chu);
        pan.add(button4);
        pan.add(button5);
        pan.add(button6);
        pan.add(button_cheng);
        pan.add(button1);
        pan.add(button2);
        pan.add(button3);
        pan.add(button_jian);
        pan.add(button0);
        pan.add(button_Dian);
        pan.add(button_dy);
        pan.add(button_jia);
        pan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        JPanel pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());
        pan2.add(result_TextFiled,BorderLayout.WEST);
        pan2.add(clear_Button,BorderLayout.EAST);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(pan2,BorderLayout.NORTH);
        frame.getContentPane().add(pan,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
