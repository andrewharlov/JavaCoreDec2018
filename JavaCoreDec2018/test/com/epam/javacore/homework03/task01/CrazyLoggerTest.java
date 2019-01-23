package com.epam.javacore.homework03.task01;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CrazyLoggerTest {
    @Test
    public void addMessage(){
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("Hello Emma!");

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY : HH-mm");
        String logRecord = dateFormat.format(date) + " - " + "Hello Emma!;";

        boolean actual = logger.getLog().toString().contains(logRecord);
        assertTrue(actual);
    }

    @Test
    public void searchByMessageTest1(){
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("Hello Andy!");
        logger.addMessage("Hi Tony!");
        logger.addMessage("Hello Emma!");
        logger.addMessage("Hello Tommy!");
        logger.addMessage("Hi Daniel!");

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY : HH-mm");
        String expected = dateFormat.format(date) + " - " + "Hello Emma!;";

        String actual = logger.searchByMessage("emma").toString();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByMessageTest2(){
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("Hello Emma!");
        logger.addMessage("Hello Andy!");
        logger.addMessage("Hi Tony!");
        logger.addMessage("Hello Tommy!");
        logger.addMessage("Hi Daniel!");

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY : HH-mm");

        String expected = dateFormat.format(date) + " - " + "Hello Emma!;";
        String actual = logger.searchByMessage("emma").toString();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByMessageTest3(){
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("Hello Andy!");
        logger.addMessage("Hi Tony!");
        logger.addMessage("Hello Tommy!");
        logger.addMessage("Hi Daniel!");
        logger.addMessage("Hello Emma!");

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY : HH-mm");

        String expected = dateFormat.format(date) + " - " + "Hello Emma!;";
        String actual = logger.searchByMessage("emma").toString();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByYear(){
        StringBuilder logs = new StringBuilder();
        logs.append("23-01-1999 : 10-53 - Hello Emma!;");
        logs.append("23-01-2019 : 13-53 - Hello Emma!;");
        logs.append("23-01-2019 : 13-53 - Hello Emma!;");
        logs.append("23-01-1999 : 13-45 - Hello Emma!;");
        logs.append("23-01-2019 : 13-53 - Hello Emma!;");
        logs.append("23-01-1999 : 9-53 - Hello Emma!;");

        CrazyLogger crazyLogger = new CrazyLogger(logs);

        StringBuilder expectedlogs = new StringBuilder();
        expectedlogs.append("23-01-1999 : 10-53 - Hello Emma!;");
        expectedlogs.append("23-01-1999 : 13-45 - Hello Emma!;");
        expectedlogs.append("23-01-1999 : 9-53 - Hello Emma!;");

        String expected = expectedlogs.toString();
        String actual = crazyLogger.searchByYear(1999).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByMonthYear(){
        StringBuilder logs = new StringBuilder();
        logs.append("23-01-1999 : 10-53 - Hello Emma!;");
        logs.append("23-03-2019 : 19-53 - Hello Emma!;");
        logs.append("23-01-2019 : 13-53 - Hello Emma!;");
        logs.append("23-01-1999 : 13-45 - Hello Emma!;");
        logs.append("23-03-2019 : 18-53 - Hello Emma!;");
        logs.append("23-01-1999 : 9-53 - Hello Emma!;");

        CrazyLogger crazyLogger = new CrazyLogger(logs);

        StringBuilder expectedlogs = new StringBuilder();
        expectedlogs.append("23-03-2019 : 19-53 - Hello Emma!;");
        expectedlogs.append("23-03-2019 : 18-53 - Hello Emma!;");

        String expected = expectedlogs.toString();
        String actual = crazyLogger.searchByMonthYear(3, 2019).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void searchByDayMonthYear(){
        StringBuilder logs = new StringBuilder();
        logs.append("23-01-1999 : 10-53 - Hello Emma!;");
        logs.append("10-03-2019 : 19-53 - Hello Emma!;");
        logs.append("23-01-2019 : 13-53 - Hello Emma!;");
        logs.append("23-01-1999 : 13-45 - Hello Emma!;");
        logs.append("23-03-2019 : 18-53 - Hello Emma!;");
        logs.append("7-03-2019 : 18-53 - Hello Emma! How are you?;");

        CrazyLogger crazyLogger = new CrazyLogger(logs);

        String expected = "7-03-2019 : 18-53 - Hello Emma! How are you?;";
        String actual = crazyLogger.searchByDayMonthYear(7, 3, 2019).toString();
        assertEquals(expected, actual);
    }
}