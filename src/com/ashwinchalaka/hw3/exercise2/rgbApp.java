package com.ashwinchalaka.hw3.exercise2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rgbApp extends JFrame {
    private JPanel panel1;
    private JPanel numberViewWrap;
    private JPanel graphViewWrap;
    private JLabel nvRedLabel;
    private JLabel nvGreenLabel;
    private JLabel nvBlueLabel;
    private JSlider nvRedSlider;
    private JSlider nvGreenSlider;
    private JSlider nvBlueSlider;
    private JLabel gvRedNum;
    private JLabel gvGreenNum;
    private JLabel gvBlueNum;
    private JPanel gvRedBar;
    private JPanel gvGreenBar;
    private JPanel gvBlueBar;
    private JButton generateButton;
    private JButton goBackButton;

    private RGB rgbDataStore;

    public rgbApp() {
        super("RGB app");
        this.showNumberView();
        this.rgbDataStore = new RGB(255,255,255);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRGBModel(nvRedSlider.getValue(),nvGreenSlider.getValue(),nvBlueSlider.getValue());
                updateGraphViewData();
                showGraphView();
                System.out.println(gvRedBar.getPreferredSize());
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNumberView();
            }
        });
        nvRedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                nvRedLabel.setText("Red: " + nvRedSlider.getValue());
            }
        });
        nvGreenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                nvGreenLabel.setText("Green: " + nvGreenSlider.getValue());
            }
        });
        nvBlueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                nvBlueLabel.setText("Blue: " + nvBlueSlider.getValue());
            }
        });
    }

    private void showNumberView() {
        this.setContentPane(this.numberViewWrap);
        graphViewWrap.setVisible(false);
        numberViewWrap.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    private void showGraphView() {
        this.setContentPane(this.graphViewWrap);
        numberViewWrap.setVisible(false);
        graphViewWrap.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    private void updateRGBModel(int r, int g, int b) {
        this.rgbDataStore.setRedValue(r);
        this.rgbDataStore.setGreenValue(g);
        this.rgbDataStore.setBlueValue(b);
    }

    private void updateGraphViewData() {
        this.gvRedNum.setText(Integer.toString(this.rgbDataStore.getRedValue()));
        this.gvGreenNum.setText(Integer.toString(this.rgbDataStore.getGreenValue()));
        this.gvBlueNum.setText(Integer.toString(this.rgbDataStore.getBlueValue()));

        this.gvRedBar.setBackground(new Color(this.rgbDataStore.getRedValue(),0,0));
        this.gvRedBar.setPreferredSize(new Dimension(50,this.rgbDataStore.getRedValue()));
//        this.gvRedBar.setSize(new Dimension(50,this.rgbDataStore.getRedValue()));
//        System.out.println(this.gvRedBar.getPreferredSize());
//        System.out.println(this.gvRedBar.getSize());

        this.gvGreenBar.setBackground(new Color(0,this.rgbDataStore.getGreenValue(),0));
        this.gvGreenBar.setPreferredSize(new Dimension(50,this.rgbDataStore.getGreenValue()));
//        this.gvGreenBar.setMaximumSize(new Dimension(50,this.rgbDataStore.getGreenValue()));
//        System.out.println(this.gvGreenBar.getPreferredSize());

        this.gvBlueBar.setBackground(new Color(0,0,this.rgbDataStore.getBlueValue()));
        this.gvBlueBar.setPreferredSize(new Dimension(50,this.rgbDataStore.getBlueValue()));
//        System.out.println(this.gvBlueBar.getPreferredSize());

        this.repaint();
        this.revalidate();
    }
}
