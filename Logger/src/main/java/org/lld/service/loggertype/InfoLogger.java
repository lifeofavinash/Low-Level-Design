package org.lld.service.loggertype;

import org.lld.enums.LogLevel;
import org.lld.model.Log;
import org.lld.service.Logger;

public class InfoLogger extends Logger {

    public InfoLogger(Logger logger) {
        super(logger);
    }

    @Override
    public Log log(String message, LogLevel logLevel) {

        if(logLevel.equals(LogLevel.INFO)) {
            return generateLog(message, LogLevel.INFO);
        }
        else {
            return super.log(message, logLevel);
        }

    }
}
