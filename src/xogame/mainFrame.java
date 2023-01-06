/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class mainFrame extends JFrame implements ActionListener , ItemListener{
    
	// write your code here
        String [] arr= {"x","o"};
        Font font24 =new Font("NewTimeRoman",Font.BOLD, 24);
        JPanel panel =new JPanel(null);
        JLabel nameplayerone= new JLabel("player 1");
        JLabel nameplayertow= new JLabel("player 2");
        JLabel formname= new JLabel("X , O  Game");
        JLabel charplayertow = new JLabel();  
        
        
        JTextField txtplayerone = new JTextField("Mostafa");
        JTextField txtplayertow = new JTextField("Computer");
        
        
        JComboBox playerone =new JComboBox(arr);
        JLabel playertow=new JLabel("o");
        
        JButton play =new JButton("play");
        
        JPanel panecolor =new JPanel(null);
        public mainFrame(){
            this.setSize(800,500);
            this.setLayout(null);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            panel.setBounds(0,50,800,500);

            formname.setBounds(320,20,200,35);
            nameplayerone.setBounds(20,100,150,35);
            txtplayerone.setBounds(180,100,350,35);
            playerone.setBounds(550,100,120,35);

            nameplayertow.setBounds(20,200,150,35);
            txtplayertow.setBounds(180,200,350,35);
            playertow.setBounds(550,200,120,35);
            play.setBounds(200,300,300,35);
            panecolor.setBounds(0,0,800,100);

            nameplayerone.setFont(font24);
            nameplayertow.setFont(font24);
            txtplayerone.setFont(font24);
            txtplayertow.setFont(font24);
            playerone.setFont(font24);
            playertow.setFont(font24);
            play.setFont(font24);
            formname.setFont(font24);

            nameplayerone.setForeground(Color.white);

            nameplayertow.setForeground(Color.white);
            panecolor.setBackground(Color.red);
            panel.setBackground(Color.decode("#330033"));
            playertow.setOpaque(true);
            playertow.setBackground(Color.white);
            panel.add(nameplayerone);
            panel.add(nameplayertow);
            panel.add(txtplayerone);
            panel.add(txtplayertow);
            panel.add(playerone);
            panel.add(playertow);
            panel.add(play);
            panecolor.add(formname);
            this.add(panecolor);
            this.add(panel);

            play.addActionListener(this);
            playerone.addActionListener(this);

        }
        
        public boolean checkInfo(){
            if(!txtplayerone.getText().isEmpty() && !txtplayertow.getText().isEmpty()){
                XOGame.arr_player[0] = txtplayerone.getText();
                XOGame.arr_player[1] = txtplayertow.getText();
                XOGame.arr_player[2] = String.valueOf(playerone.getSelectedItem());
                XOGame.arr_player[3] = String.valueOf(playertow.getText());
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Enter Player Names");
            }
            return false;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
               if(e.getSource() == play){
                   if(checkInfo()){
//                       XOGame.playerone = txtplayerone.getText();
                       XOGame.playertwo = txtplayertow.getText();
                       new XOGame().setVisible(true);
                       this.dispose();
                   }
               }
        }

        
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == playerone){
                if(playerone.getSelectedIndex() == 0){
                    playertow.setText("o");
                }else{
                    playertow.setText("x");
                }
            }
        }

        
        public static void main(String[] args){
            new mainFrame().setVisible(true);
        }
    }

