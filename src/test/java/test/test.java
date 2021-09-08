package test;

import org.junit.Test;

import java.util.UUID;

public class test {
    public int add(int a, String b){
        return a;
    }

    public static void main(String[] args) {
        String randomNum = UUID.randomUUID().toString();
        System.out.println(randomNum.toUpperCase().replaceAll("\\-",""));
    }


}
