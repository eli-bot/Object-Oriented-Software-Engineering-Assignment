package controller;

public class PlayerException extends Exception
{
    public PlayerException(String message, Throwable cause)
    {
        super(message,cause);
    }
}