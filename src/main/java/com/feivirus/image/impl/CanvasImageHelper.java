package com.feivirus.image.impl;

import sun.awt.image.FileImageSource;

import java.awt.*;

/**
 *
 */
@Deprecated
public class CanvasImageHelper {
    private Canvas canvas = new Canvas();

    /**
     * 初始化图片
     * 1.根据url创建image
     * 2.获取canvas的context
     * 3.调用context画图
     */
    public void init(String imagePath) {
        FileImageSource fileImageSource = new FileImageSource(imagePath);

        Image image = canvas.createImage(fileImageSource);

        canvas.setBounds(0, 0, image.getWidth(null), image.getHeight(null));

        Graphics graphics = canvas.getGraphics();
        graphics.drawImage(image, 0, 0, image.getWidth(null),
                image.getHeight(null), null);

        return;
    }


}
