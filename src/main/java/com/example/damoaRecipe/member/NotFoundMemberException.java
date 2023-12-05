package com.example.damoaRecipe.member;

public class NotFoundMemberException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public NotFoundMemberException(String message) {
        super(message);
    }
}