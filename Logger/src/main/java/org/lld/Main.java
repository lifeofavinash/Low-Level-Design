package org.lld;

import org.lld.enums.LogLevel;
import org.lld.utils.LoggerUtils;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        LoggerUtils loggerUtils = new LoggerUtils();

        File logFile = new File("/Users/avinashrao/IdeaProjects/Logger/src/main/resources/output.log");

        loggerUtils.log("Logger is starting!", LogLevel.INFO, logFile);

        try(ExecutorService executorService = Executors.newFixedThreadPool(3)) {

            executorService.submit(() -> {

                loggerUtils.log("Hi This is Avinash!", LogLevel.INFO);

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    // Handle Exception
                }

                loggerUtils.log("This is second log line", LogLevel.DEBUG);

                loggerUtils.log("This is from thread1", LogLevel.INFO, logFile);

            });

            executorService.submit(() -> {

                loggerUtils.log("Hi This is Avinash!", LogLevel.DEBUG, logFile);
                loggerUtils.log("This is second line", LogLevel.DEBUG, logFile);

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    // Handle Exception
                }

                loggerUtils.log("This is from thread2", LogLevel.INFO, logFile);
            });

            executorService.submit(() -> {

                loggerUtils.log("This is from thread1", LogLevel.DEBUG);

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    // Handle Exception
                }

                loggerUtils.log("This is from thread3", LogLevel.DEBUG, logFile);

                loggerUtils.log("Okay bye!", LogLevel.DEBUG);

            });

        }
        catch (Exception e) {
            // Handle exception
        }

    }
}