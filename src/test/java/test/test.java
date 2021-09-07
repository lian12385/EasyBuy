package test;

import org.junit.Test;

public class test {
    public int add(int a, String b){
        return a;
    }

    public static void main(String[] args) {
        String a = "a";
        String b = new String("a");
        /*
        equals是String类的方法，一般是String类的
        对象.方法名()来调用；
         */
        System.out.println(a.equals(b));
    }


}
