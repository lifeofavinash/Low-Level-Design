package org.lld.utils;

import org.lld.enums.LogLevel;
import org.lld.enums.LogOutputType;
import org.lld.model.DatabaseConfig;
import org.lld.service.LogOutputFactory;
import org.lld.service.LogOutputStrategy;

import java.io.File;

public class LoggerUtils {

    private final LogOutputFactory logOutputFactory;
    private LogOutputStrategy logOutputStrategy;

    public LoggerUtils() {

        this.logOutputFactory = new LogOutputFactory();

    }

    public void log(String message, LogLevel logLevel) {

        logOutputStrategy = logOutputFactory.getLogOutput(LogOutputType.CONSOLE);

        logOutputStrategy.processLog(message, logLevel);

    }

    public void log(String message, LogLevel logLevel, File file) {

        logOutputStrategy = logOutputFactory.getLogOutput(LogOutputType.FILE);

        logOutputStrategy.processLog(message, logLevel, file);

    }

    public void log(String message, LogLevel logLevel, DatabaseConfig databaseConfig) {

        logOutputStrategy = logOutputFactory.getLogOutput(LogOutputType.DATABASE);

        logOutputStrategy.processLog(message, logLevel, databaseConfig);

    }

}
