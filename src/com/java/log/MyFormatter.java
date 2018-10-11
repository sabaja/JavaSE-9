package com.java.log;

import java.time.LocalDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;


/**
 * 
 * @author sabaja 
 * Java Logging Formatters
 * Formatters are used to format the log messages. There are two available formatters in java logging API.
 * 
 * SimpleFormatter: This formatter generates text messages with basic information. ConsoleHandler uses this formatter class to print log messages to console.
 * XMLFormatter: This formatter generates XML message for the log, FileHandler uses XMLFormatter as a default formatter.
 * We can create our own custom Formatter class by extending java.util.logging.Formatter class 
 * and attach it to any of the handlers. Here is an example of a simple custom formatter class.
 *
 */
public class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getThreadID()+"::"+record.getSourceClassName()+"::"
                +record.getSourceMethodName()+"::"
                +LocalDateTime.now()+"::"
                +record.getMessage()+"\n";
    }

}