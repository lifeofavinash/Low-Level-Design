package org.lld.service;

import org.lld.enums.LogLevel;
import org.lld.enums.LogOutputType;
import org.lld.model.DatabaseConfig;
import org.lld.model.Log;
import org.lld.service.loggertype.DebugLogger;
import org.lld.service.loggertype.ErrorLogger;
import org.lld.service.loggertype.InfoLogger;

import java.io.File;

public abstract class LogOutputStrategy {

    protected final Logger logger;

    public LogOutputStrategy() {
        logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
    }

    public void processLog(String message, LogLevel logLevel) {
        System.out.println("This operation is not permitted!");
    }

    public void processLog(String message, LogLevel logLevel, File logFile) {
        System.out.println("This operation is not permitted!");
    }

    public void processLog(String message, LogLevel logLevel, DatabaseConfig databaseConfig) {
        System.out.println("This operation is not permitted!");
    }

}
