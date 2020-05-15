package com.feivirus.image;

import javax.swing.*;

public class CanvasBootstrap {
    public static void main(String[] args) {
        CanvasBootstrap bootstrap = new CanvasBootstrap();

        bootstrap.init();
    }

    public void init() {
        JFrame jFrame = new JFrame();
        jFrame.setLayout(null);
        jFrame.setBounds(0, 0, 1000, 1000);

        CanvasDemo canvasDemo = new CanvasDemo();
        canvasDemo.setBounds(0, 0, 800, 800);
        jFrame.add(canvasDemo);
        jFrame.setVisible(true);

    }
}
