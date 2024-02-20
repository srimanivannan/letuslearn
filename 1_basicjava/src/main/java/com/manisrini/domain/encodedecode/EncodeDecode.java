package com.manisrini.domain.encodedecode;

import java.nio.charset.StandardCharsets;

public class EncodeDecode {
    public static void main(String[] args) {
        String decodedString = new String("AKZEmoroC8oOBTqN6Qi2AAABFA==".getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        System.out.println(decodedString);
    }
}
