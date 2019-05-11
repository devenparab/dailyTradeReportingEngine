package com.example.techtestdailyReport.weekEvaluator.impl;

import com.example.techtestdailyReport.weekEvaluator.Week;

import java.time.LocalDate;

public class MuslimWeekImpl implements Week {

    public LocalDate nextWorkingDay(LocalDate localDate){

        LocalDate res;
        switch (localDate.getDayOfWeek()) {
            case FRIDAY:
                res = localDate.plusDays(2);
                break;
            case SATURDAY:
                res = localDate.plusDays(1);
                break;
            default:
                res = localDate;
                break;
        }

        return res;
    }
}
