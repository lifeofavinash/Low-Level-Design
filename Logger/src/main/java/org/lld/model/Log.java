package org.lld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.lld.enums.LogLevel;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Log {

    LocalDateTime timestamp;
    LogLevel logLevel;
    String message;

}
