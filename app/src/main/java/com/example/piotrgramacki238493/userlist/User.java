package com.example.piotrgramacki238493.userlist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Piotrek on 2018-03-15.
 */

public class User {
    private static long SEC_IN_YEAR = 365 * 24 * 60 * 60;

    private String name = "";
    private String surname = "";
    private Date birthDate;

    public User(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        if (isDateValid(birthDate)) {
            this.birthDate = convertStringToDate(birthDate);
        }
        else this.birthDate = Calendar.getInstance().getTime();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        return String.format(Locale.getDefault(), "%d", getAgeYears());
    }

    private long getAgeYears() {
        Date currentTime = Calendar.getInstance().getTime();
        long difference = currentTime.getTime() - birthDate.getTime();
        return difference / (1000 * SEC_IN_YEAR);
    }

    public static boolean isDateValid(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        try {
            Date check = format.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private Date convertStringToDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        Date result = null;
        try {
            result = format.parse(date);
        } catch (ParseException e) {
            return null;
        }
        return result;
    }
}
