package org.example;

import java.io.IOException;
import java.util.logging.*;

/**
 * Central logger configuration used by all classes.
 * This ensures the file handler is created only once.
 */
public final class LoggerConfig {
    private static final String LOG_FILE = "realEstateApp.log";
    private static final Level FILE_LEVEL = Level.ALL;

    private LoggerConfig() { /* no instances */ }

    /**
     * Initialize default handlers (console + file) for a given logger name.
     * Calling this multiple times is safe.
     *
     * @param logger the logger to configure
     */
    public static void configureLogger(Logger logger) {
        try {
            // Avoid adding handlers repeatedly
            if (hasFileHandler(logger)) return;

            logger.setUseParentHandlers(false); // avoid duplicate parent handlers

            // Console handler
            ConsoleHandler ch = new ConsoleHandler();
            ch.setLevel(Level.INFO);
            ch.setFormatter(new SimpleFormatter());
            logger.addHandler(ch);

            // File handler (append)
            FileHandler fh = new FileHandler(LOG_FILE, true);
            fh.setLevel(FILE_LEVEL);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("Failed to configure logger: " + e.getMessage());
        }
    }

    private static boolean hasFileHandler(Logger logger) {
        for (Handler h : logger.getHandlers()) {
            if (h instanceof FileHandler) return true;
        }
        return false;
    }
}
