# Util Package

The `util/` package contains utility classes that provide helpful functionalities across the application. One of the main classes in this package is the `LoggerUtil`, which is a singleton utility for logging application events and errors.

## LoggerUtil

The `LoggerUtil` class is designed to handle logging in the application, providing a central point for logging messages with configurable log levels and output locations.

### Features:
- **Singleton Pattern**: Ensures a single instance of the logger is used throughout the application.
- **Configurable Log File Path**: Allows you to specify the log file path via a configuration file.
- **Log Level Configuration**: Dynamically adjusts log level based on configuration (supports levels like `INFO`, `SEVERE`, etc.).
- **File Logging**: Logs messages to a file in append mode.
- **Error Handling**: Graceful handling of configuration issues (like missing file paths or invalid log levels).

### Configuration

The `LoggerUtil` class retrieves configuration settings from the `ConfigLoader` class, which should load properties from an external configuration file (such as a `.properties` or `.yml` file). 

- **logging.file.path**: Specifies the path where the log file will be stored.
- **logging.level**: Specifies the log level (`INFO`, `SEVERE`, `WARNING`, etc.). If an invalid level is provided, the log level defaults to `INFO`.

### Usage

You can use the `LoggerUtil` class to log messages in your application as follows:

1. **Get the Logger Instance**:

   You can access the logger through the singleton `getInstance()` method:
   
   ```java
   LoggerUtil loggerUtil = LoggerUtil.getInstance();
   Logger logger = loggerUtil.getLogger();
   ```

2. **Log Messages**:

   Once you have the logger instance, you can log messages at various levels:

   ```java
   logger.info("This is an informational message.");
   logger.warning("This is a warning message.");
   logger.severe("This is a severe error message.");
   ```

3. **Log File**:

   The logs will be written to the file specified by the `logging.file.path` property in the configuration file.

### Example Configuration (`config.properties`)

An example configuration file might look like this:

```properties
logging.file.path=logs/application.log
logging.level=INFO
```

### Error Handling

- **Missing Configuration**: If the `logging.file.path` or `logging.level` properties are missing in the configuration, the application will throw an error, or default to reasonable values (like the default `INFO` log level).
- **Invalid Log Level**: If an invalid log level is provided in the configuration (e.g., `INVALID`), the logger will default to the `INFO` level, and a warning will be logged.

### Example Usage in Application

```java
public class MyApplication {
    public static void main(String[] args) {
        // Get the logger instance
        Logger logger = LoggerUtil.getInstance().getLogger();

        // Log messages at different levels
        logger.info("Application started successfully.");
        logger.warning("This is a warning message.");
        logger.severe("An error occurred!");
    }
}
```
