package com.buliang.exc;

public class AddToCartExc extends Exception{


    public AddToCartExc(String exc) {
       super(exc);
    }

    public AddToCartExc() {
    }

    public AddToCartExc(String message, Throwable cause) {
        super(message, cause);
    }

    public AddToCartExc(Throwable cause) {
        super(cause);
    }

    protected AddToCartExc(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
