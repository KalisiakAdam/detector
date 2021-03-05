package com.silent.detector.exception;

public class DetectorRuntimeException extends DetectorException {
    public DetectorRuntimeException(String message) {
        super(message);
    }
    public DetectorRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
