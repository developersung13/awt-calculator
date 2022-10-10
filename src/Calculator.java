import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
 
public class Calculator extends JFrame{
    JTextField field;
    JButton zero_bt, one_bt, two_bt, three_bt, four_bt, five_bt, six_bt, seven_bt, eight_bt, nine_bt;
    JButton plus_bt, minus_bt, multiply_bt, divide_bt, result_bt, clear_bt;
    String calculation="";
    
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    
    public Calculator() {
        setTitle("계산기");
        setSize(240,330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel main_panel = new JPanel();
        main_panel.setBackground(Color.darkGray);
        main_panel.setLayout(null);
        
        field = new JTextField();
        
        zero_bt = new JButton("0");
        zero_bt.setBackground(Color.white);
        one_bt = new JButton("1");
        one_bt.setBackground(Color.white);
        two_bt = new JButton("2");
        two_bt.setBackground(Color.white);
        three_bt = new JButton("3");
        three_bt.setBackground(Color.white);
        four_bt = new JButton("4");
        four_bt.setBackground(Color.white);
        five_bt = new JButton("5");
        five_bt.setBackground(Color.white);
        six_bt = new JButton("6");
        six_bt.setBackground(Color.white);
        seven_bt = new JButton("7");
        seven_bt.setBackground(Color.white);
        eight_bt = new JButton("8");
        eight_bt.setBackground(Color.white);
        nine_bt = new JButton("9");
        nine_bt.setBackground(Color.white);
        
        plus_bt = new JButton("+");
        minus_bt = new JButton("-");
        multiply_bt = new JButton("x");
        divide_bt = new JButton("÷");
        result_bt = new JButton("E");
        result_bt.setFont(new Font("Dialog",Font.BOLD,15));
        result_bt.setBackground(Color.pink);
        clear_bt = new JButton("C");
        clear_bt.setFont(new Font("Dialog",Font.BOLD,15));
        clear_bt.setBackground(Color.lightGray);
        
        field.setBounds(10, 10, 207, 45);
        zero_bt.setBounds(65,230,50,50);
        one_bt.setBounds(10,65,50,50);
        two_bt.setBounds(65,65,50,50);
        three_bt.setBounds(120,65,50,50);
        four_bt.setBounds(10,120,50,50);
        five_bt.setBounds(65,120,50,50);
        six_bt.setBounds(120,120,50,50);
        seven_bt.setBounds(10,175,50,50);
        eight_bt.setBounds(65,175,50,50);
        nine_bt.setBounds(120,175,50,50);
        plus_bt.setBounds(175,65,41,50);
        minus_bt.setBounds(175,120,41,50);
        multiply_bt.setBounds(175,175,41,50);
        divide_bt.setBounds(175,230,41,50);
        clear_bt.setBounds(120,230,50,50);
        result_bt.setBounds(10,230,50,50);
        
        main_panel.add(field);
        main_panel.add(zero_bt);
        main_panel.add(one_bt);
        main_panel.add(two_bt);
        main_panel.add(three_bt);
        main_panel.add(four_bt);
        main_panel.add(five_bt);
        main_panel.add(six_bt);
        main_panel.add(seven_bt);
        main_panel.add(eight_bt);
        main_panel.add(nine_bt);
        main_panel.add(plus_bt);
        main_panel.add(minus_bt);
        main_panel.add(multiply_bt);
        main_panel.add(divide_bt);
        main_panel.add(clear_bt);
        main_panel.add(result_bt);
        
        add(main_panel);
        
        zero_bt.addActionListener(new MyActionListener());
        one_bt.addActionListener(new MyActionListener());
        two_bt.addActionListener(new MyActionListener());
        three_bt.addActionListener(new MyActionListener());
        four_bt.addActionListener(new MyActionListener());
        five_bt.addActionListener(new MyActionListener());
        six_bt.addActionListener(new MyActionListener());
        seven_bt.addActionListener(new MyActionListener());
        eight_bt.addActionListener(new MyActionListener());
        nine_bt.addActionListener(new MyActionListener());
        plus_bt.addActionListener(new MyActionListener());
        minus_bt.addActionListener(new MyActionListener());
        multiply_bt.addActionListener(new MyActionListener());
        divide_bt.addActionListener(new MyActionListener());
        clear_bt.addActionListener(new MyActionListener());
        result_bt.addActionListener(new MyActionListener());
        
        setVisible(true);
    }
    
    class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == zero_bt) {
                calculation += "0";
                field.setText(calculation);
            } else if (e.getSource() == one_bt){
                calculation += "1";
                field.setText(calculation);
            } else if (e.getSource() == two_bt){
                calculation += "2";
                field.setText(calculation);
            } else if (e.getSource() == three_bt){
                calculation += "3";
                field.setText(calculation);
            } else if (e.getSource() == four_bt){
                calculation += "4";
                field.setText(calculation);
            } else if (e.getSource() == five_bt){
                calculation += "5";
                field.setText(calculation);
            } else if (e.getSource() == six_bt){
                calculation += "6";
                field.setText(calculation);
            } else if (e.getSource() == seven_bt){
                calculation += "7";
                field.setText(calculation);
            } else if (e.getSource() == eight_bt){
                calculation += "8";
                field.setText(calculation);
            } else if (e.getSource() == nine_bt){
                calculation += "9";
                field.setText( calculation);
            } 
            
            if(e.getSource() == plus_bt) {
                calculation += " + ";
                field.setText(calculation);
            } else if(e.getSource() == minus_bt) {
                calculation += " - ";
                field.setText(calculation);
            } else if(e.getSource() == multiply_bt) {
                calculation += " * ";
                field.setText(calculation);
            } else if(e.getSource() == divide_bt) {
                calculation += " / ";
                field.setText(calculation);
            } else if(e.getSource() == clear_bt) {
                calculation = "";
                field.setText("");
            }
            
            if(e.getSource() == result_bt) {
                Object ob;
                try {
                    ob = engine.eval(calculation);
                    field.setText(ob.toString());
                    calculation = field.getText();
                    field.setText(calculation);
                } catch (ScriptException e1) {
                    e1.printStackTrace();
                }
            }
            
        }
    }
    
    public static void main(String[] args) {
        new Calculator();
    }
}