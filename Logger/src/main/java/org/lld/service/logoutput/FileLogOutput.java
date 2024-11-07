package org.lld.service.logoutput;

import org.lld.enums.LogLevel;
import org.lld.model.Log;
import org.lld.service.LogOutputStrategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileLogOutput extends LogOutputStrategy {

    private static final Lock lock;

    static {
        lock = new ReentrantLock();
    }

    @Override
    public void processLog(String message, LogLevel logLevel, File logFile) {

        Log log = logger.log(message, logLevel);

        saveLogToFile(log, logFile);

    }

    private void saveLogToFile(Log log, File logFile) {

        String logString = generateLogString(log);

        try(FileWriter fileWriter = new FileWriter(logFile, true)) {

            lock.lock();

            fileWriter.write(logString);

            lock.unlock();

        }
        catch (IOException e) {
            System.out.println("File does not exist please try again.");
        }
    }

    private String generateLogString(Log log) {

        StringBuilder logString = new StringBuilder();

        logString.append(log.getTimestamp().toString())
                .append(" | ")
                .append(log.getLogLevel().toString())
                .append(" | ")
                .append(log.getMessage())
                .append("\n");

        return logString.toString();

    }

}
