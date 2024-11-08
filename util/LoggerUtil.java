package util;

import resources.config.ConfigLoader;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {

    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());
    private static volatile LoggerUtil instance;

    // Private constructor to prevent instantiation from other classes
    private LoggerUtil() {
        try {
            ConfigLoader config = ConfigLoader.getInstance();

            // Load the log file path and log level from configuration
            String logFilePath = Optional.ofNullable(config.getProperty("logging.file.path"))
                    .orElseThrow(() -> new IllegalArgumentException("Log file path not found in config"));

            // Set up file handler for logging
            FileHandler fileHandler = new FileHandler(logFilePath, true);  // Append mode
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            // Set log level from configuration with fallback to INFO
            String logLevel = Optional.ofNullable(config.getProperty("logging.level")).orElse("INFO");
            try {
                logger.setLevel(Level.parse(logLevel.toUpperCase()));
            } catch (IllegalArgumentException e) {
                logger.warning("Invalid log level in config, defaulting to INFO.");
                logger.setLevel(Level.INFO);  // Default to INFO if invalid level is provided
            }

        } catch (IOException e) {
            logger.severe("Failed to initialize file handler for logger: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.severe("Configuration error: " + e.getMessage());
        }
    }

    // Public method to get the single instance of LoggerUtil (Singleton pattern)
    public static LoggerUtil getInstance() {
        if (instance == null) {
            synchronized (LoggerUtil.class) {
                if (instance == null) {
                    instance = new LoggerUtil();
                }
            }
        }
        return instance;
    }

    // Method to provide access to the actual logger
    public Logger getLogger() {
        return logger;
    }
}
