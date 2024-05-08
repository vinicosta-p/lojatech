package com.pecastech.app.exceptions;

public class ServerErrorAliexpressException extends RuntimeException{
    public ServerErrorAliexpressException(){
        super("An error has occurred in the Aliexpress Api");
    }

    public ServerErrorAliexpressException(String message){
        super(message);
    }
}
