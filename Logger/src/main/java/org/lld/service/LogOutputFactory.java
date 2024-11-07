package org.lld.service;

import org.lld.enums.LogOutputType;
import org.lld.model.DatabaseConfig;
import org.lld.service.logoutput.ConsoleLogOutput;
import org.lld.service.logoutput.DatabaseLogOutput;
import org.lld.service.logoutput.FileLogOutput;

public class LogOutputFactory {

    public LogOutputStrategy getLogOutput(LogOutputType logOutputType) {

        switch (logOutputType) {

            case FILE -> {
                return new FileLogOutput();
            }
            case DATABASE -> {
                return new DatabaseLogOutput();
            }
            default -> {
                return new ConsoleLogOutput();
            }

        }

    }

}
