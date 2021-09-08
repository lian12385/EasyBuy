package com.buliang.exc;

public class EBuyExc extends Exception{


    public EBuyExc(String exc) {
       super(exc);
    }

    public EBuyExc() {
    }

    public EBuyExc(String message, Throwable cause) {
        super(message, cause);
    }

    public EBuyExc(Throwable cause) {
        super(cause);
    }

    protected EBuyExc(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
