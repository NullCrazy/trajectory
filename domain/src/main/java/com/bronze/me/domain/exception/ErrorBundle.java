package com.bronze.me.domain.exception;

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
