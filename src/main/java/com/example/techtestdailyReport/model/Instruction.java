package com.example.techtestdailyReport.model;

import com.example.techtestdailyReport.weekEvaluator.Week;
import com.example.techtestdailyReport.weekEvaluator.impl.MuslimWeekImpl;
import com.example.techtestdailyReport.weekEvaluator.impl.StandardWeekImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

public class Instruction implements Comparable<Instruction>{

    private String entity;
    private TradeType tradeType;
    private LocalDate instructionDate;
    private LocalDate instructedSettlementDate;
    private LocalDate derivedSettlementDate;

    private BigDecimal agreedFx;
    private Integer unit;
    private BigDecimal pricePerUnit;
    private Currency instructionCurrency;
    private BigDecimal amount;

    public Instruction(String entity, TradeType tradeType, LocalDate instructionDate, LocalDate instructedSettlementDate, BigDecimal agreedFx, Integer unit, BigDecimal pricePerUnit, Currency instructionCurrency) {
        this.entity = entity;
        this.tradeType = tradeType;
        this.instructionDate = instructionDate;
        this.instructedSettlementDate = instructedSettlementDate;
        this.derivedSettlementDate = deriveActualSettlementDate(instructionCurrency);
        this.agreedFx = agreedFx;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
        this.instructionCurrency = instructionCurrency;
        this.amount = getAmountOfTrade();
    }

    private BigDecimal getAmountOfTrade() {
        return this.pricePerUnit.multiply(this.agreedFx).multiply(BigDecimal.valueOf(this.unit)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
    }

    private LocalDate deriveActualSettlementDate(Currency instructionCurrency) {
        Week week;
        if (instructionCurrency.getCurrencyCode().equalsIgnoreCase("AED") || instructionCurrency.getCurrencyCode().equalsIgnoreCase("SAR")){
            week = new MuslimWeekImpl();
            return week.nextWorkingDay(this.instructedSettlementDate);
        }else{
            week = new StandardWeekImpl();
            return week.nextWorkingDay(this.instructedSettlementDate);
        }
    }

    public String getEntity() {
        return entity;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public LocalDate getInstructionDate() {
        return instructionDate;
    }

    public LocalDate getInstructedSettlementDate() {
        return instructedSettlementDate;
    }

    public LocalDate getDerivedSettlementDate() {
        return derivedSettlementDate;
    }

    public Integer getUnit() {
        return unit;
    }

    public Currency getInstructionCurrency() {
        return instructionCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "entity='" + entity + '\'' +
                ", tradeType=" + tradeType +
                ", instructionDate=" + instructionDate +
                ", instructedSettlementDate=" + instructedSettlementDate +
                ", derivedSettlementDate=" + derivedSettlementDate +
                ", agreedFx=" + agreedFx +
                ", unit=" + unit +
                ", pricePerUnit=" + pricePerUnit +
                ", instructionCurrency=" + instructionCurrency +
                ", amount=" + amount +
                '}';
    }



    @Override
    public int compareTo(Instruction o) {
        return this.getAmount().compareTo(o.getAmount());
    }
}
