package com.vamonossoftware.financereporter.domain.model;

import java.util.ArrayList;
import java.util.List;

public class CsvConfig {
	private int date;
	private int description;
	private int debit;
	private int credit;
	private int account;
	private String dateFormat;
	private int max = 20;

	public CsvConfig(int date, int description, int debit, int credit, int account, String dateFormat) {
		super();
		this.date = date;
		this.description = description;
		this.debit = debit;
		this.credit = credit;
		this.account = account;
		this.dateFormat = dateFormat;
	}

	public int getDate() {
		return date;
	}

	public int getDescription() {
		return description;
	}

	public int getDebit() {
		return debit;
	}

	public int getCredit() {
		return credit;
	}

	public int getAccount() {
		return account;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public String getColumn(int col) {
		if (date == col)
			return "date";
		if (description == col)
			return "description";
		if (account == col)
			return "account";
		if (debit == col)
			return "debit";
		if (credit == col)
			return "credit";
		return null;
	}

	public List<String> getColumns() {
		List<String> columns = new ArrayList<String>();
		for (int i = 0; i < max; i++) {
			columns.add(getColumn(i));
		}
		return columns;
	}

	public int getMaxColumn() {
		return max;
	}

}
