package com.feivirus.image.impl;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

/**
 * 图像处理类
 * {@link https://www.cnblogs.com/bmbm/archive/2012/01/07/2342248.html}
 */
public class ImageHelper {

    public boolean copyImage(String srcImgPath, String newImgPath) {
        ImageLoader imageLoader = new ImageLoader();

        ImageData[] imageData = imageLoader.load(srcImgPath);

        if (imageData.length <= 0) {
            return false;
        }

        Image newImage = new Image(null, imageData[0]);

        imageLoader.data[0] = newImage.getImageData();
        imageLoader.save(newImgPath, SWT.IMAGE_BMP);
        return true;
    }

    public ImageData lightImage(ImageData srcData) {
        return null;
    }

    public static void main(String[] args) {
        String oldPath = "e:\\tmp\\desktop.jpg";
        String newPath = "e:\\tmp\\new.jpg";

        ImageHelper imageHelper = new ImageHelper();
        imageHelper.copyImage(oldPath, newPath);
    }

}
