package exercise5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class MyFrame extends JFrame implements ActionListener {
    JPanel fieldVisual;
    JPanel fieldInput;

    //Buttons:
    JButton b0;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    JButton b9;
    JButton b10;
    JButton plus;
    JButton difference;
    JButton multiply;
    JButton division;

    JLabel resultLabel;

    public MyFrame(){
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);


        setPanel();
        setVisible(true);


    }
    private void setPanel(){

        fieldVisual = new JPanel();
        fieldVisual.setBounds(0,0,500,400);
        fieldVisual.setBackground(Color.blue);
        fieldVisual.setLayout(new BorderLayout());

        fieldInput = new JPanel();
        fieldInput.setBounds(0,400,500,100);
        fieldInput.setBackground(Color.red);
        fieldInput.setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b10 = new JButton("10");
        plus = new JButton("+");
        difference = new JButton("-");
        multiply = new JButton("*");
        division = new JButton("/");


        JLabel label = new JLabel("Result");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setSize(300,200);
        label.setBackground(Color.white);
        label.setOpaque(true);

        fieldVisual.add(label,BorderLayout.CENTER);


        fieldInput.add(b0);
        fieldInput.add(b1);
        fieldInput.add(b2);
        fieldInput.add(b3);
        fieldInput.add(b4);
        fieldInput.add(b5);
        fieldInput.add(b6);
        fieldInput.add(b7);
        fieldInput.add(b8);
        fieldInput.add(b9);
        fieldInput.add(b10);
        fieldInput.add(plus);
        fieldInput.add(difference);
        fieldInput.add(multiply);
        fieldInput.add(division);
        this.add(fieldVisual);
        this.add(fieldInput);



    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MyFrame();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
