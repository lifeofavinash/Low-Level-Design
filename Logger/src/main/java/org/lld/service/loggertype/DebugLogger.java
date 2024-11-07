package org.lld.service.loggertype;

import org.lld.enums.LogLevel;
import org.lld.model.Log;
import org.lld.service.Logger;

public class DebugLogger extends Logger {

    public DebugLogger(Logger logger) {
        super(logger);
    }

    @Override
    public Log log(String message, LogLevel logLevel) {

        if(logLevel.equals(LogLevel.DEBUG)) {
            return generateLog(message, LogLevel.DEBUG);
        }
        else {
            return super.log(message, logLevel);
        }

    }

}
