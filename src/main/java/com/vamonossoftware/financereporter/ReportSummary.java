package com.vamonossoftware.financereporter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.joda.time.DateMidnight;

import com.vamonossoftware.financereporter.domain.model.Category;
import com.vamonossoftware.financereporter.domain.model.Transaction;

public class ReportSummary {
	private DateMidnight from;
	private DateMidnight to;

	private Map<Category, BigDecimal> categoryTotals;
	private List<Transaction> transactions;

}
