package com.feivirus.image.api;

/**
 * 计算图像的熵
 */
public interface ImageEntropy {
    /**
     *
     * @param filePath
     * @return
     */
    Double calcEntropy(String filePath);

    /**
     *
     * @param filePath
     * @return
     */
    Double calc2DEntropy(String filePath);

}
