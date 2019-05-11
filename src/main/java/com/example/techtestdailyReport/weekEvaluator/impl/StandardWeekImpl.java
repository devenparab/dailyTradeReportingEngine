package com.example.techtestdailyReport.weekEvaluator.impl;

import com.example.techtestdailyReport.weekEvaluator.Week;

import java.time.LocalDate;

public class StandardWeekImpl implements Week {
    @Override
    public LocalDate nextWorkingDay(LocalDate localDate) {
        LocalDate res ;
        switch (localDate.getDayOfWeek()) {
            case SATURDAY:
                res = localDate.plusDays(2);
                break;
            case SUNDAY:
                res = localDate.plusDays(1);
                break;
            default:
                res = localDate;
                break;
        }

        return res;
    }
}
