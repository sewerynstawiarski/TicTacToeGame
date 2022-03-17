package com.HighLand;

import javax.print.attribute.standard.DocumentName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class KiK implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame("Kółka&Krzyżówki");
    JPanel titlePanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JLabel textLabel = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1turn;

    KiK() throws InterruptedException {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(100,100,100));
        frame.setVisible(true);

        textLabel.setBackground(new Color(80,150,100));
        textLabel.setForeground(new Color(100,30,150));
        textLabel.setFont(new Font("Ink Free", Font.BOLD,35));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Kółka&Krzyżówki");
        textLabel.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,600,200);
        titlePanel.add(textLabel);

        buttonsPanel.setLayout(new GridLayout(3,3));
        buttonsPanel.setBackground(new Color(190,100,20));

        for (int i=0; i<9; i++) {
            buttons[i] = new JButton();
            buttonsPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Times New Roman", Font.BOLD,90));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonsPanel, BorderLayout.CENTER);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i =0; i<9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.GREEN);
                        buttons[i].setText("X");
                        player1turn = false;
                        textLabel.setText("Kolej O");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                        player1turn=true;
                        textLabel.setText("Kolej X");
                        check();
                    }
                }
            }
        }

    }
    public void firstTurn() throws InterruptedException {

        Thread.sleep(3000);

        if (random.nextInt(2)==0) {
            player1turn = true;
            textLabel.setText(" Kolej X");
        }
        else {
            player1turn = false;
            textLabel.setText("Kolej O");
        }
    }
    public void check() {
        if (
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")

        ) {
            xWins(0,1,2);
        }
        if (
                (buttons[2].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X")

        ) {
            xWins(2,3,4);
        }
        if (
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X") &&
                (buttons[9].getText()=="X")

        ) {
            xWins(7,8,9);
        }
        if (
                (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")

        ) {
            xWins(0,3,6);
        }
        if (
                (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")

        ) {
            xWins(1,4,7);
        }
        if (
                (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")

        ) {
            xWins(2,5,8);
        }
        if (
                (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")

        ) {
            xWins(0,4,8);
        }
        if (
                (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")

        ) {
            xWins(2,4,6);
        }
        ////////////////////////////
        if (
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")

        ) {
            oWins(0,1,2);
        }
        if (
                (buttons[2].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O")

        ) {
            oWins(2,3,4);
        }
        if (
                (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O") &&
                        (buttons[9].getText()=="O")

        ) {
            oWins(7,8,9);
        }
        if (
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")

        ) {
            oWins(0,3,6);
        }
        if (
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")

        ) {
            oWins(1,4,7);
        }
        if (
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")

        ) {
            oWins(2,5,8);
        }
        if (
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")

        ) {
            oWins(0,4,8);
        }
        if (
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")

        ) {
            oWins(2,4,6);
        }
    }
    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.cyan);
        buttons[b].setBackground(Color.cyan);
        buttons[c].setBackground(Color.cyan);

        for (int i = 0; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textLabel.setText("Wygrywa X !!!");
    }
    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.cyan);
        buttons[b].setBackground(Color.cyan);
        buttons[c].setBackground(Color.cyan);

        for (int i = 0; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textLabel.setText("Wygrywa O !!!");

    }
}
