package org.lld.service.loggertype;

import org.lld.enums.LogLevel;
import org.lld.model.Log;
import org.lld.service.Logger;

public class ErrorLogger extends Logger {

    public ErrorLogger(Logger logger) {
        super(logger);
    }

    @Override
    public Log log(String message, LogLevel logLevel) {

        if(logLevel.equals(LogLevel.ERROR)) {
            return generateLog(message, LogLevel.ERROR);
        }
        else {
            return super.log(message, logLevel);
        }

    }

}
