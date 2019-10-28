package com.biplab.bloackchain;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Date;


public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = computeHash(); //Make sure other values already set.
    }

    //Calculating new hash based on blocks data
    public String computeHash() {
        return applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        data
        );
    }

    private static String applySha256(String inputData) throws RuntimeException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(inputData.getBytes("UTF-8"));

            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}


