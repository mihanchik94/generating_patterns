package task_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:s ");
    private int num = 1;

    public void log(String msg) {
        System.out.println("[" + LocalDateTime.now().format(formatter) + num++ + "] " + msg);
    }

    private Logger() {
    }

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }
}