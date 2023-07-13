package kr.gamso.exception.url;

public class UrlAlreadyExistsException extends RuntimeException{
    public UrlAlreadyExistsException(String message){
        super(message);
    }
}
