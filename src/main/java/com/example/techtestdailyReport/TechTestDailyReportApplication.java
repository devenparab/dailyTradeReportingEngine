package com.example.techtestdailyReport;

import com.example.techtestdailyReport.dataPopulator.DataPopulator;
import com.example.techtestdailyReport.model.Instruction;
import com.example.techtestdailyReport.model.TradeType;
import com.example.techtestdailyReport.reportGenerator.ReportEngine;

import java.util.List;

public class TechTestDailyReportApplication {

	public static void main(String[] args) {
		List<Instruction> instructions = DataPopulator.getFakeData();

		ReportEngine engine = new ReportEngine();

		//Daily outgoing amount
		engine.dailyAmountSettled(instructions,TradeType.BUY);

		//Daily incoming amount
		engine.dailyAmountSettled(instructions,TradeType.SELL);

		//Daily Ranking outgoing
		engine.dailyEntityRanking(instructions,TradeType.BUY);

		//Daily Ranking incoming
		engine.dailyEntityRanking(instructions,TradeType.SELL);

	}

}
