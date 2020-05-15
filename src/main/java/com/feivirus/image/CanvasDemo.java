package com.feivirus.image;

import java.awt.*;

public class CanvasDemo extends Canvas {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(0, 0, 50, 100);
    }
}
