package com.legalmatch.exam.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Helper {

    public static String calculateAge(LocalDate birthDate, LocalDate currentDate, boolean ageOnly) {
        if ((birthDate != null) && (currentDate != null)) {
            int years = Period.between(birthDate, currentDate).getYears();
            int months = Period.between(birthDate, currentDate).getMonths();
            if (ageOnly) {
                return years + "y";
            } else {
                return years + "y " + months + "m";
            }

        } else {
            return "";
        }
    }

    public static String convertLocalDateToString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date.split("T")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
