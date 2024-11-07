package org.lld.service.logoutput;

import org.lld.enums.LogLevel;
import org.lld.model.Log;
import org.lld.service.LogOutputStrategy;

public class ConsoleLogOutput extends LogOutputStrategy {

    @Override
    public void processLog(String message, LogLevel logLevel) {

        Log log = logger.log(message, logLevel);

        printLog(log);

    }

    private void printLog(Log log) {

        System.out.printf("%s | %s | %s%n", log.getTimestamp().toString(), log.getLogLevel().toString(), log.getMessage());

    }
}
