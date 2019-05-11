package com.example.techtestdailyReport.weekEvaluator;

import java.time.LocalDate;

public interface Week {

    LocalDate nextWorkingDay(LocalDate localDate);

    /*default LocalDate nextWorkingDay(LocalDate localDate){
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
    }*/
}
