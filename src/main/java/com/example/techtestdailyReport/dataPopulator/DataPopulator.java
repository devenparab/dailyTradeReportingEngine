package com.example.techtestdailyReport.dataPopulator;


import com.example.techtestdailyReport.model.Instruction;
import com.example.techtestdailyReport.model.TradeType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class DataPopulator {
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static List<Instruction> getFakeData(){
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("Entity-1", TradeType.BUY, LocalDate.parse("27/04/2019",dateTimeFormatter),LocalDate.parse("28/04/2019",dateTimeFormatter),new BigDecimal(0.50),200,new BigDecimal(100.25), Currency.getInstance("SGD")));
        instructions.add(new Instruction("Entity-2", TradeType.BUY, LocalDate.parse("22/04/2019",dateTimeFormatter),LocalDate.parse("23/04/2019",dateTimeFormatter),new BigDecimal(0.22),150,new BigDecimal(150.50), Currency.getInstance("AED")));
        instructions.add(new Instruction("Entity-3", TradeType.SELL, LocalDate.parse("05/04/2019",dateTimeFormatter),LocalDate.parse("06/04/2019",dateTimeFormatter),new BigDecimal(0.27),20,new BigDecimal(400.80), Currency.getInstance("SAR")));
        instructions.add(new Instruction("Entity-4", TradeType.SELL, LocalDate.parse("01/03/2019",dateTimeFormatter),LocalDate.parse("02/03/2019",dateTimeFormatter),new BigDecimal(0.34),10,new BigDecimal(500.60), Currency.getInstance("EUR")));
        instructions.add(new Instruction("Entity-5", TradeType.BUY, LocalDate.parse("23/03/2019",dateTimeFormatter),LocalDate.parse("28/03/2019",dateTimeFormatter),new BigDecimal(0.34),200,new BigDecimal(40.60), Currency.getInstance("EUR")));
        instructions.add(new Instruction("Entity-6", TradeType.BUY, LocalDate.parse("27/03/2019",dateTimeFormatter),LocalDate.parse("28/03/2019",dateTimeFormatter),new BigDecimal(0.34),250,new BigDecimal(40.60), Currency.getInstance("EUR")));
        instructions.add(new Instruction("Entity-7", TradeType.SELL, LocalDate.parse("16/03/2019",dateTimeFormatter),LocalDate.parse("17/03/2019",dateTimeFormatter),new BigDecimal(0.34),1000,new BigDecimal(160.80), Currency.getInstance("INR")));
        instructions.add(new Instruction("Entity-8", TradeType.SELL, LocalDate.parse("10/03/2019",dateTimeFormatter),LocalDate.parse("31/03/2019",dateTimeFormatter),new BigDecimal(0.34),120,new BigDecimal(500.60), Currency.getInstance("EUR")));
        instructions.add(new Instruction("Entity-9", TradeType.SELL, LocalDate.parse("20/03/2019",dateTimeFormatter),LocalDate.parse("31/03/2019",dateTimeFormatter),new BigDecimal(0.34),110,new BigDecimal(50.60), Currency.getInstance("EUR")));
        instructions.add(new Instruction("Entity-10", TradeType.SELL, LocalDate.parse("30/03/2019",dateTimeFormatter),LocalDate.parse("31/03/2019",dateTimeFormatter),new BigDecimal(0.34),220,new BigDecimal(300.60), Currency.getInstance("EUR")));
        /*instructions.add(new Instruction("foo1", TradeType.BUY, LocalDate.parse("01/01/2016",dateTimeFormatter),LocalDate.parse("02/01/2016",dateTimeFormatter),0.50,200,150.25, Currency.getInstance("AED")));
        instructions.add(new Instruction("foo2", TradeType.BUY, LocalDate.parse("01/01/2016",dateTimeFormatter),LocalDate.parse("02/01/2016",dateTimeFormatter),0.50,200,120.50, Currency.getInstance("USD")));
        instructions.add(new Instruction("foo3", TradeType.SELL, LocalDate.parse("01/01/2016",dateTimeFormatter),LocalDate.parse("02/01/2016",dateTimeFormatter),0.50,200,300.00, Currency.getInstance("SAR")));
        instructions.add(new Instruction("foo4", TradeType.BUY, LocalDate.parse("01/01/2016",dateTimeFormatter),LocalDate.parse("02/01/2016",dateTimeFormatter),0.50,200,200.25, Currency.getInstance("INR")));
        instructions.add(new Instruction("bar", TradeType.SELL, LocalDate.parse("05/01/2016",dateTimeFormatter),LocalDate.parse("07/01/2016",dateTimeFormatter),0.50,200,300.25, Currency.getInstance("AED")));
        instructions.add(new Instruction("foobar", TradeType.BUY, LocalDate.parse("07/01/2016",dateTimeFormatter),LocalDate.parse("09/01/2016",dateTimeFormatter),0.50,200,100.25, Currency.getInstance("USD")));*/
        return  instructions;
    }
}
