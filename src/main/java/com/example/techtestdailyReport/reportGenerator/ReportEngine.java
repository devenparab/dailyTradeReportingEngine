package com.example.techtestdailyReport.reportGenerator;

import com.example.techtestdailyReport.Exception.ReportEngineException;
import com.example.techtestdailyReport.model.Instruction;
import com.example.techtestdailyReport.model.TradeType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportEngine {

    public void dailyAmountSettled(List<Instruction> instructions, TradeType type) throws ReportEngineException {
        if (instructions == null || instructions.isEmpty()){
            throw new ReportEngineException("Instructions cannot be empty.");
        }

        List<Instruction> filtered = filterOnTypeCriteria(instructions, type);
        //Map<LocalDate, Double> amtSettledMap = filtered.stream().collect(Collectors.groupingBy(Instruction::getDerivedSettlementDate,Collectors.summingDouble(Instruction::getAmount)));
        Map<LocalDate, BigDecimal> amtSettledMap = filtered.stream().collect(Collectors.groupingBy(Instruction::getDerivedSettlementDate,
                                                                                                        Collectors.mapping(Instruction::getAmount,Collectors.reducing(BigDecimal.ZERO,BigDecimal::add))));
        String typeOfTrade = type.name().equals(TradeType.BUY.name()) ? "Outgoing" : "Incoming";
        System.out.println("--------------------");
        System.out.println(typeOfTrade + " Daily Amount (Based on Settlement Date)");
        System.out.println("--------------------");
        amtSettledMap.forEach((k,v) -> System.out.println("[Date : "+ k + "]   [Amount : "+v+" ]"));
        System.out.println("\n");
    }

    private List<Instruction> filterOnTypeCriteria(List<Instruction> instructions, TradeType type) {
        return instructions.stream().filter(i -> i.getTradeType().name().equals(type.name())).collect(Collectors.toList());
    }

    public void dailyEntityRanking(List<Instruction> instructions, TradeType type) throws ReportEngineException {
        if (instructions.isEmpty()){
            throw new ReportEngineException("Instructions cannot be empty.");
        }

        List<Instruction> filtered = filterOnTypeCriteria(instructions,type);
        Map<LocalDate, List<Instruction>> sortedWithAmtMap = filtered.stream().sorted(Comparator.comparing(Instruction::getAmount).reversed()).collect(Collectors.groupingBy(Instruction::getDerivedSettlementDate));
        String typeOfTrade = type.name().equals(TradeType.BUY.name()) ? "Outgoing" : "Incoming";
        System.out.println("--------------------");
        System.out.println(typeOfTrade + " Daily Ranking (Based on Settlement Date)");
        System.out.println("--------------------");
        for (Map.Entry<LocalDate, List<Instruction>> entry : sortedWithAmtMap.entrySet()) {
            int cnt = 1;
            for (Instruction instruction : entry.getValue()) {
                System.out.println("[Date : " + entry.getKey() + "] - [Rank : " + cnt + "] - [Entity Name : " + instruction.getEntity() + "] - [Amount : " + instruction.getAmount() + " $(USD)]");
                cnt++;
            }
        }
        System.out.println("\n");
    }
}
