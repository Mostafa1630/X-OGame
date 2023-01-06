/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tech Faz
 */
public class XOGame extends JFrame implements ActionListener, MouseListener {

    JLabel score = new JLabel("Score");
    //array to score players
    static String arr_player[] = {"", "", "", "", "0", "0"};
    Font font20 = new Font("NewTimeRoman", Font.BOLD, 30);
    //panel to content All
    JPanel areaPlay = new JPanel(null);
    JLabel numberScore = new JLabel("Vs");
    JPanel pane3 = new JPanel(null);

    JButton restart = new JButton("Restart");
    JButton back = new JButton("Back");

    Vector<JLabel> array = new Vector();
    Vector<JLabel> vectorPlayer = new Vector();
    Vector<Integer> finishlable = new Vector();

    boolean end = false;
    static String playertwo = "";

    public XOGame() {
        this.setSize(1230, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        int x = 80, y = 40, w = 70, h = 70;

        for (int i = 0; i < 9; i++) {
            JLabel array = new JLabel("");
            array.setFont(new Font("NewTimeRoman", Font.BOLD, 20));
            array.setBounds(x, y, w, h);
            array.setOpaque(true);
            array.setBackground(Color.GREEN);
            array.setForeground(Color.WHITE);
            array.setHorizontalAlignment(JLabel.CENTER);
            array.addMouseListener(this);
            if (i == 2 || i == 5) {
                y += h + 90;
                x = 80;
            } else {
                x += w + 80;
            }
            this.array.add(array);

            pane3.add(array);
        }

        x = 200;
        y = 60;
        w = 250;
        h = 35;
        for (int i = 0; i < 6; i++) {
            JLabel array = new JLabel(arr_player[i]);
            array.setFont(font20);
            array.setBounds(x, y, w, h);
            array.setForeground(Color.WHITE);
            array.setHorizontalAlignment(JLabel.CENTER);
            if (i == 1 || i == 3) {
                y += h + 10;
                x = 200;
            } else {
                x += w + 400;
            }
            vectorPlayer.add(array);
            areaPlay.add(array);

        }

        vectorPlayer.get(0).setForeground(Color.magenta);
        areaPlay.setBorder(BorderFactory.createTitledBorder(""));
        areaPlay.setBounds(0, 0, 1200, 800);
        score.setBounds(600, 20, 150, 35);
        numberScore.setBounds(630, 60, 70, 35);
        pane3.setBounds(400, 200, 500, 500);
        pane3.setBorder(BorderFactory.createTitledBorder(""));
        back.setBounds(700, 850, 350, 35);
        restart.setBounds(150, 850, 350, 35);

        score.setFont(font20);
        numberScore.setFont(font20);
        back.setFont(font20);
        restart.setFont(font20);

        score.setForeground(Color.BLUE);
        numberScore.setForeground(Color.red);
        back.setBackground(Color.BLACK);
        restart.setBackground(Color.BLACK);

        back.setForeground(Color.WHITE);
        restart.setForeground(Color.WHITE);

        this.getContentPane().setBackground(Color.BLACK);
        areaPlay.setBackground(Color.BLACK);
        pane3.setBackground(Color.BLACK);

        areaPlay.add(pane3);
        areaPlay.add(score);
        areaPlay.add(numberScore);

        add(areaPlay);
        add(back);
        add(restart);

        back.addActionListener(this);
        restart.addActionListener(this);

    }

    public void ComputerPlayer() {
        try {
            Random random = new Random();
            int computerchoose = random.nextInt(8);
            if (array.get(computerchoose).getText().isEmpty()) {
                array.get(computerchoose).setText(arr_player[3]);
                finishlable.add(computerchoose);
            } else {
                ComputerPlayer();
            }
        } catch (Exception ex) {
        }

    }

    public void multipulPlayer(MouseEvent e) {
        for (int i = 0; i < array.size(); i++) {

            if (e.getSource() == array.get(i)) {
                if (vectorPlayer.get(0).getForeground() == Color.MAGENTA && checklabelfinish(i) == false) {
                    array.get(i).setText(vectorPlayer.get(2).getText());
                    finishlable.add(i);
                    vectorPlayer.get(1).setForeground(Color.WHITE);
                    vectorPlayer.get(0).setForeground(Color.MAGENTA);
                }

                if (vectorPlayer.get(1).getForeground() == Color.MAGENTA && checklabelfinish(i) == false) {
                    array.get(i).setText(vectorPlayer.get(3).getText());
                    finishlable.add(i);
                    vectorPlayer.get(1).setForeground(Color.WHITE);
                    vectorPlayer.get(0).setForeground(Color.MAGENTA);
                }
            }
        }
    }

    public boolean checklabelfinish(int index) {

        for (int i = 0; i < finishlable.size(); i++) {
            if (finishlable.get(i) == index) {
                return true;
            }
        }
        return false;
    }

    public void singlePlayer(MouseEvent e) {

        for (int i = 0; i < array.size(); i++) {

            if (e.getSource() == array.get(i)) {

                if (vectorPlayer.get(0).getForeground() == Color.MAGENTA && checklabelfinish(i) == false) {
                    array.get(i).setText(vectorPlayer.get(2).getText());
                    finishlable.add(i);
                    ComputerPlayer();
                }
            }
        }
    }

    public void checkAndChange(int num1, int num2, int num3) {

        if (vectorPlayer.get(2).getText().equals(array.get(num1).getText())) {
            int num = Integer.parseInt(vectorPlayer.get(4).getText());

            num++;

            vectorPlayer.get(4).setText(String.valueOf(num));

        } else {

            int num = Integer.parseInt(vectorPlayer.get(5).getText());

            num++;

            vectorPlayer.get(5).setText(String.valueOf(num));
        }
        array.get(num1).setBackground(Color.red);
        array.get(num2).setBackground(Color.red);
        array.get(num3).setBackground(Color.red);

    }

    //###############################################3333
    public boolean row1() {
        if (!array.get(0).getText().isEmpty() && !array.get(1).getText().isEmpty() && !array.get(2).getText().isEmpty()) {

            if (array.get(0).getText().equals(array.get(1).getText()) && array.get(0).getText().equals(array.get(2).getText())) {
                checkAndChange(0, 1, 2);
                end = true;
                return true;
            }
        }
        return false;
    }

    public boolean row2() {
        if (!array.get(3).getText().isEmpty() && !array.get(4).getText().isEmpty() && !array.get(5).getText().isEmpty()) {

            if (array.get(3).getText().equals(array.get(4).getText()) && array.get(3).getText().equals(array.get(5).getText())) {
                checkAndChange(3, 4, 5);
                end = true;
                return true;
            }
        }
        return false;
    }

    public boolean row3() {
        if (!array.get(6).getText().isEmpty() && !array.get(7).getText().isEmpty() && !array.get(8).getText().isEmpty()) {

            if (array.get(6).getText().equals(array.get(7).getText()) && array.get(6).getText().equals(array.get(8).getText())) {
                checkAndChange(6, 7, 8);
                end = true;
                return true;
            }
        }
        return false;
    }

    public boolean cloumn1() {
        if (!array.get(0).getText().isEmpty() && !array.get(3).getText().isEmpty() && !array.get(6).getText().isEmpty()) {

            if (array.get(0).getText().equals(array.get(3).getText()) && array.get(0).getText().equals(array.get(6).getText())) {
                checkAndChange(0, 3, 6);
                end = true;
                return true;
            }
        }
        return false;
    }

    public boolean cloumn2() {
        if (!array.get(1).getText().isEmpty() && !array.get(4).getText().isEmpty() && !array.get(7).getText().isEmpty()) {

            if (array.get(1).getText().equals(array.get(4).getText()) && array.get(1).getText().equals(array.get(7).getText())) {
                checkAndChange(1, 4, 7);
                end = true;
                return true;
            }
        }
        return false;
    }

    public boolean cloumn3() {
        if (!array.get(2).getText().isEmpty() && !array.get(5).getText().isEmpty() && !array.get(8).getText().isEmpty()) {

            if (array.get(6).getText().equals(array.get(5).getText()) && array.get(2).getText().equals(array.get(8).getText())) {
                checkAndChange(2, 5, 8);
                end = true;
                return true;
            }
        }
        return false;
    }

    public boolean reverse1() {
        if (!array.get(2).getText().isEmpty() && !array.get(4).getText().isEmpty() && !array.get(6).getText().isEmpty()) {

            if (array.get(6).getText().equals(array.get(4).getText()) && array.get(2).getText().equals(array.get(6).getText())) {
                checkAndChange(2, 4, 6);
                end = true;
                return true;
            }
        }
        return false;
    }

    public boolean reverse2() {
        if (!array.get(0).getText().isEmpty() && !array.get(4).getText().isEmpty() && !array.get(8).getText().isEmpty()) {

            if (array.get(0).getText().equals(array.get(4).getText()) && array.get(0).getText().equals(array.get(8).getText())) {
                checkAndChange(0, 4, 8);
                end = true;
                return true;
            }
        }
        return false;
    }

    public boolean result() {
        if (row1()) {
            return true;
        }

        if (row2()) {
            return true;
        }

        if (row3()) {
            return true;
        }

        if (cloumn1()) {
            return true;
        }

        if (cloumn2()) {
            return true;
        }

        if (cloumn3()) {
            return true;
        }

        if (reverse1()) {
            return true;
        }

        if (reverse2()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restart) {
            end = false;
            for (int i = 0; i < array.size(); i++) {
                array.get(i).setText("");
                array.get(i).setBackground(Color.GREEN);
            }
            finishlable.removeAllElements();
        } else if (e.getSource() == back) {
            this.dispose();
            new mainFrame().setVisible(true);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (end == false) {
            if (playertwo.trim().equalsIgnoreCase("Computer")) {
                singlePlayer(e);
            } else {
                multipulPlayer(e);
            }
            result();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
