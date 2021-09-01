package test;

import org.junit.Test;

public class ResultDaoTest {

    @Test
    public void test1(){
        MyThread2 mt = new MyThread2();
        new Thread(mt).start();
        new Thread(mt).start();
    }


    static class MyThread2 implements Runnable{
        private int ticket = 5;
        public void run(){
            while(true){
                System.out.println("Runnable ticket = " + ticket--);
                if(ticket < 0){
                    break;
                }
            }
        }
    }

    //买了两次因为new两两次MyThread对象
    @Test
    public void test2(){
        new MyThread().start();
        //new MyThread().start();
    }

    static class MyThread extends Thread{
        private int ticket = 5;
        public void run(){
            while(true){
                System.out.println(" Thread ticket = " + ticket--);
                if(ticket < 0){
                    break;
                }
            }

        }
    }


}