package study.unit5.ex02;

import java.io.IOException;

public class KeyNotFoundException extends IOException {
    public KeyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeyNotFoundException(String message) {
        super(message);
    }
}
