package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;


@SpringBootApplication
public class App implements CommandLineRunner {

    // JUL logger (java.util.logger)
    // this logger has different methods: warning(), fine(), finest(), severe()
    //Logger logger = Logger.getLogger(App.class.getName());

    // Logback logger (ch.qos.logback.classic.Logger)
    //Logger logger = (Logger) LoggerFactory.getLogger(App.class);

    // sl4j logger (and logback use it too)
    Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("debug");
        logger.trace("trace");
        logger.warn("warning");
        logger.info("info");
        logger.error("error");

        JdbcTemplateAutoConfiguration
    }
}
