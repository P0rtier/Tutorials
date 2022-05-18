package pl.core;

import javax.swing.*;

public class GameFrame extends JFrame {
    //atributes


    //functionality
    GameFrame(){
        add(new GamePanel());
        setTitle("Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
