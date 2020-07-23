package com.legalmatch.exam.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Helper {

    public static String calculateDateToStringNumber(LocalDate paramDate, LocalDate currentDate, boolean ageOnly) {
        if ((paramDate != null) && (currentDate != null)) {
            int years = Period.between(paramDate, currentDate).getYears();
            int months = Period.between(paramDate, currentDate).getMonths();
            if (ageOnly) {
                return years + "y";
            } else {
                return years + "y " + months + "m";
            }

        } else {
            return "";
        }
    }

    public static int convertDateToNumber(LocalDate paramDate, LocalDate currentDate) {
            return Period.between(paramDate, currentDate).getYears();
    }

    public static String convertLocalDateToString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date.split("T")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
