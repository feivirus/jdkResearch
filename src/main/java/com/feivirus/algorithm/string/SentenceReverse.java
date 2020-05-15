package com.feivirus.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feivirus
 * 句子反转
 * 比如把 i'm a student.反转成 student a i'm
 */
public class SentenceReverse {
    public static void main(String[] args) {
        SentenceReverse reverse = new SentenceReverse();
        String result = reverse.reverseSentence("i'm a student");

        System.out.println("result: " + result);
    }

    /**
     * 翻转句子
     * @param sentence
     * @return
     */
    public String reverseSentence(String sentence) {
        List<String> wordList = new ArrayList<>();
        StringBuffer word = new StringBuffer();

        //注意句子的最后一个字符加到word里面
        for(int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            if (currentChar == ' ' ||
                i == (sentence.length() - 1)) {
                if (i == sentence.length() - 1) {
                    word.append(sentence.charAt(sentence.length() - 1));
                }

                if (word.length() > 0) {
                    wordList.add(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(sentence.charAt(i));
            }
        }

        StringBuffer result = new StringBuffer();
        for(int i = wordList.size() - 1; i >=0; i--) {
            result.append(wordList.get(i)).append(" ");
        }
        return result.toString();
    }
}
