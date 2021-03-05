package com.silent.detector.exception;

public class DetectorException extends RuntimeException {
    DetectorException(String message) {
        super(message);
    }

    DetectorException(String message, Throwable cause) {
        super(message, cause);
    }
}
