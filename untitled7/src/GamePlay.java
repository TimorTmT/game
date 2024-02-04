package Timor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener
        ,MouseListener
{
    private boolean play = true;
    private int tm = 0;
    private int tl = 0;

    private int scoreplayer2 = 0;
    private int scoreplayer1 = 0;
    private int totalBriks = 21;
    private Timer timer;
    private int  delay = 3;
    private int playerX = 310;
    private int ballposX = 120;
    private int ballposY = 350;
    private int ballposV = 240;
    private int ballposD = 100;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private int y = 550;
    private int dx = 290;
    private int dy = 3;
    int seconds = 0;

    public GamePlay()
    {
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(1,1,600,600);

        g.setColor(Color.blue);
        g.fillRect(20,300,600,8);

        g.setColor(Color.blue);
        g.fillOval(300,270,70,70);

        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(581,3,3,596);

        g.setColor(Color.green);
        g.fillRect(playerX,y,140,9);


        g.setColor(Color.green);
        g.fillRect(dx,dy,140,8);

        g.setColor(Color.yellow);
        g.fillOval(ballposX,ballposY,20,20);

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD, 25));
        g.drawString("score player1 :"+scoreplayer1,400,80);

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("score player2 :"+scoreplayer2,25,80);


        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("A = left",25,120);

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("D = right",25,160);

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("< for left",400,120);

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("> for right",400,160);

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,16));
        g.drawString("ENTER for restart",25,200);

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,16));
        g.drawString("CLICK to pause",25,240);

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,16));
        g.drawString("ALT to release",25,280);


        if(ballposY > 550)
        {


            scoreplayer1 += 1;

            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("score player1 :" + scoreplayer1, 400, 80);

            g.setColor(Color.yellow);
            g.fillOval(ballposX,ballposY,20,20);
        }

        if(ballposY < 0)
        {
            scoreplayer2 += 1;

            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("score player2 :" + scoreplayer2,25, 80);

            g.setColor(Color.yellow);
            g.fillOval(ballposX,ballposY,20,20);
        }
        if(scoreplayer2 >= 15){
            g.setFont(new Font("serif", Font.BOLD, 50));
            g.drawString("PLAYER 2 WIN", 100,250);
            g.drawString("with 15 points", 100, 300);
            play = false;
            ballposX = 300;
            ballposY = 450;
        }
        if(scoreplayer1 >= 15)
        {
            g.setColor(Color.yellow);
            g.setFont(new Font("serif", Font.BOLD,50));
            g.drawString("PLAYER 1 WIN", 100, 250);
            g.drawString("with 15 points", 100, 300);
            play = false;
            ballposX = 300;
            ballposY = 450;
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        timer.start();
        if(play){
            if(play){
                if(new Rectangle(ballposX, ballposY, 20,20).intersects(new Rectangle(playerX, 550, 140, 8))){
                    ballYdir = -ballYdir;

                }
                if(new Rectangle(ballposX, ballposY, 20,20).intersects(new Rectangle(dx, dy, 140, 8))){
                    ballYdir = -ballYdir;

                }
                ballposX += ballXdir;
                ballposY += ballYdir;
                if(ballposY < 0 ){
                    ballYdir = -ballYdir;
                }
                if(ballposX < 0){
                    ballXdir = -ballXdir;
                }
                if(ballposX > 560){
                    ballXdir = -ballXdir;
                }
                if(ballposY > 550){
                    ballYdir = -ballYdir;
                }
                if(playerX < 0){
                    playerX += 100;
                }
                if(y < 0){
                    y += 100;
                }
                if(playerX > 500){
                    playerX -= 100;
                }
                if(dx < 0){
                    dx += 100;
                }
                if(dx > 500){
                    dx -= 100;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            moveRight();
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            moveLeft();
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            play = true;
            scoreplayer1 = 0;
            scoreplayer2 = 0;
            ballposX = 120;
            ballposY = 350;
            ballXdir = -1;
            ballYdir = -2;
            playerX = 310;
            y = 550;
            dx = 290;
            dy = 15;

        }

        if(e.getKeyCode() == KeyEvent.VK_SHIFT)
        {

        }

        if(e.getKeyCode() == KeyEvent.VK_ALT)
        {
            play = true;
        }




        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            move();
        }

        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            moveL();
        }
        if(e.getKeyCode() == KeyEvent.VK_F)
        {
            superdash();
        }


    }
    public void mousePressed(MouseEvent e)
    {

    }
    public void mouseReleased(MouseEvent e)
    {

    }
    public void mouseClicked(MouseEvent e)
    {
        play = false;
    }
    public void mouseEntered(MouseEvent e)
    {

    }
    public void mouseExited(MouseEvent e)
    {

    }
    public void moveRight()
    {
        play = true;
        playerX += 50;
    }

    public void moveLeft()
    {
        play = true;
        playerX -= 50;
    }

    public void moveUp()
    {
        play = false;
        y -= 2;
    }

    public void moveDown()
    {
        play = false;
        y += 2;
    }

    public void move()
    {
        play = true;
        dx -= 40;
    }

    public void moveL()
    {
        play = true;
        dx += 40;
    }

    public void moveU()
    {
        play = false;
        dy -= 2;
    }

    public void moveD()
    {
        play = false;
        dy += 2;
    }

    public void superdash()
    {
        play = true;

        timer = new Timer(delay = 2,this);
        timer.start();


    }
    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
