package Timor;

import java.awt.*;
import javax.swing.*;

public class Game extends JFrame
{
    public static void main(String[] args)throws InterruptedException{
        Thread.sleep(10,000);
        Game d = new Game();
        GamePlay s = new GamePlay();
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d.setSize(600,600);
        d.setTitle("Game");
        d.setVisible(true);
        d.add(s);
    }
}
