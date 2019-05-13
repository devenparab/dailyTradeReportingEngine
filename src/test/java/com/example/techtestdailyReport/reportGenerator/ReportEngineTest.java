package com.example.techtestdailyReport.reportGenerator;

import com.example.techtestdailyReport.Exception.ReportEngineException;
import com.example.techtestdailyReport.dataPopulator.DataPopulator;
import com.example.techtestdailyReport.model.Instruction;
import com.example.techtestdailyReport.model.TradeType;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReportEngineTest {

    static List<Instruction> instructions = new ArrayList<>();

    ReportEngine reportEngine = new ReportEngine();

    @BeforeClass
    public static void setUpForTests(){
        instructions = DataPopulator.getFakeData();
    }

    @Test
    public void dailyAmountSettled_BUY() {
        try {
            reportEngine.dailyAmountSettled(instructions, TradeType.BUY);
        } catch (ReportEngineException e) {
            Assert.fail("Test case failed due to :: "+e.getMessage());
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Instructions cannot be empty."));
        }
    }

    @Test(expected = ReportEngineException.class)
    public void dailyAmountSettled_BUY_Negative() throws ReportEngineException {
        reportEngine.dailyAmountSettled(new ArrayList<>(), TradeType.BUY);
    }

    @Test
    public void dailyAmountSettled_SELL() {
        try {
            reportEngine.dailyAmountSettled(instructions, TradeType.SELL);
        } catch (ReportEngineException e) {
            Assert.fail("Test case failed due to :: "+e.getMessage());
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Instructions cannot be empty."));
        }
    }

    @Test(expected = ReportEngineException.class)
    public void dailyAmountSettled_SELL_Negative() throws ReportEngineException {
        reportEngine.dailyAmountSettled(new ArrayList<>(), TradeType.SELL);
    }


    @Test
    public void dailyEntityRanking_BUY() {
        try {
            reportEngine.dailyEntityRanking(instructions,TradeType.BUY);
        } catch (ReportEngineException e) {
            Assert.fail("Test case failed due to :: "+e.getMessage());
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Instructions cannot be empty."));
        }
    }

    @Test(expected = ReportEngineException.class)
    public void dailyEntityRanking_BUY_Negative() throws ReportEngineException {
        reportEngine.dailyEntityRanking(new ArrayList<>(), TradeType.BUY);
    }

    @Test
    public void dailyEntityRanking_SELL() {
        try {
            reportEngine.dailyEntityRanking(instructions,TradeType.SELL);
        } catch (ReportEngineException e) {
            Assert.fail("Test case failed due to :: "+e.getMessage());
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("Instructions cannot be empty."));
        }
    }

    @Test(expected = ReportEngineException.class)
    public void dailyEntityRanking_SELL_Negative() throws ReportEngineException {
        reportEngine.dailyEntityRanking(new ArrayList<>(), TradeType.SELL);
    }
}