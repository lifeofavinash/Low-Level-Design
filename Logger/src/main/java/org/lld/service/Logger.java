package org.lld.service;

import org.lld.enums.LogLevel;
import org.lld.exception.LoggerTypeMismatch;
import org.lld.model.Log;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {

    private final Logger nextLogger;

    private static final Lock lock;

    static {
        lock = new ReentrantLock();
    }

    public Logger(Logger logger) {
        this.nextLogger = logger;
    }

    protected Log generateLog(String message, LogLevel logLevel) {

        lock.lock();

        LocalDateTime localDateTime = LocalDateTime.now();
        Log log = new Log(localDateTime, logLevel, message);

        lock.unlock();

        return log;

    }

    public Log log(String message, LogLevel logLevel) throws LoggerTypeMismatch {

        if(nextLogger != null)
        {
            return nextLogger.log(message, logLevel);
        }
        else {
            throw new LoggerTypeMismatch("Provided logger type is invalid.");
        }

    }

}
