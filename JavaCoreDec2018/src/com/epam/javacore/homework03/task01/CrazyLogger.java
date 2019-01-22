package com.epam.javacore.homework03.task01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CrazyLogger {
    private StringBuilder log;

    public CrazyLogger(){
        this.log = new StringBuilder();
    }

    public CrazyLogger(StringBuilder log) {
        this.log = log;
    }

    public void addMessage(String message){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        DateFormat timeFormat = new SimpleDateFormat("HH-mm");

        String currentDate = dateFormat.format(date);
        String currentTime = timeFormat.format(date);

        String newLogMessage = currentDate + " : " + currentTime + " - " + message + ";";
        this.log.append(newLogMessage);
    }

    public StringBuilder searchByMessage(String message){
        StringBuilder searchResults = new StringBuilder();
        int lastSemicolon = this.log.lastIndexOf(";");
        int previousSemicolon;
        int nextSemicolon = -1;

        do{
            previousSemicolon = nextSemicolon;
            nextSemicolon = this.log.indexOf(";", previousSemicolon + 1);

            String logRecord = "";
            try {
                logRecord = this.log.substring(previousSemicolon + 1, nextSemicolon);
            } catch (StringIndexOutOfBoundsException e){
                e.printStackTrace();
                break; //log is empty - nothing to search
            }

            int dashChar = logRecord.lastIndexOf("-");
            String logMessage = logRecord.substring(dashChar + 2);
            logMessage = logMessage.toLowerCase();

            if (logMessage.contains(message.toLowerCase())){
                logRecord = logRecord + ";";
                searchResults.append(logRecord);
            }
        } while (nextSemicolon != lastSemicolon);

        return searchResults;
    }

    public StringBuilder searchByYear(int year){
        StringBuilder searchResults = new StringBuilder();
        int lastSemicolon = this.log.lastIndexOf(";");
        int previousSemicolon;
        int nextSemicolon = -1;

        do{
            previousSemicolon = nextSemicolon;
            nextSemicolon = this.log.indexOf(";", previousSemicolon + 1);

            String logRecord = "";
            try {
                logRecord = this.log.substring(previousSemicolon + 1, nextSemicolon);
            } catch (StringIndexOutOfBoundsException e){
                break; //log is empty - nothing to search
            }

            int colonChar = logRecord.indexOf(":");
            String dateString = logRecord.substring(0, colonChar - 1);

            Date logDate = new Date();
            try {
                logDate = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            LocalDate date = LocalDate.ofInstant(logDate.toInstant(), ZoneId.systemDefault());
            int logYear = date.getYear();

            if (logYear == year){
                logRecord = logRecord + ";";
                searchResults.append(logRecord);
            }
        } while (nextSemicolon != lastSemicolon);

        return searchResults;
    }

    public StringBuilder searchByMonthYear(int month, int year) {
        StringBuilder searchResults = new StringBuilder();
        int lastSemicolon = this.log.lastIndexOf(";");
        int previousSemicolon;
        int nextSemicolon = -1;

        do {
            previousSemicolon = nextSemicolon;
            nextSemicolon = this.log.indexOf(";", previousSemicolon + 1);

            String logRecord = "";
            try {
                logRecord = this.log.substring(previousSemicolon + 1, nextSemicolon);
            } catch (StringIndexOutOfBoundsException e) {
                break; //log is empty - nothing to search
            }

            int colonChar = logRecord.indexOf(":");
            String dateString = logRecord.substring(0, colonChar - 1);

            Date logDate = new Date();
            try {
                logDate = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            LocalDate date = LocalDate.ofInstant(logDate.toInstant(), ZoneId.systemDefault());
            int logYear = date.getYear();
            int logMonth = date.getMonth().getValue();

            if (logYear == year && logMonth == month) {
                logRecord = logRecord + ";";
                searchResults.append(logRecord);
            }
        } while (nextSemicolon != lastSemicolon);

        return searchResults;
    }

    public StringBuilder searchByDayMonthYear(int day, int month, int year) {
        StringBuilder searchResults = new StringBuilder();
        int lastSemicolon = this.log.lastIndexOf(";");
        int previousSemicolon;
        int nextSemicolon = -1;

        do {
            previousSemicolon = nextSemicolon;
            nextSemicolon = this.log.indexOf(";", previousSemicolon + 1);

            String logRecord = "";
            try {
                logRecord = this.log.substring(previousSemicolon + 1, nextSemicolon);
            } catch (StringIndexOutOfBoundsException e) {
                break; //log is empty - nothing to search
            }

            int colonChar = logRecord.indexOf(":");
            String dateString = logRecord.substring(0, colonChar - 1);

            Date logDate = new Date();
            try {
                logDate = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            LocalDate date = LocalDate.ofInstant(logDate.toInstant(), ZoneId.systemDefault());
            int logYear = date.getYear();
            int logMonth = date.getMonth().getValue();
            int logDay = date.getDayOfMonth();

            if (logYear == year && logMonth == month && logDay == day) {
                logRecord = logRecord + ";";
                searchResults.append(logRecord);
            }
        } while (nextSemicolon != lastSemicolon);

        return searchResults;
    }
}
