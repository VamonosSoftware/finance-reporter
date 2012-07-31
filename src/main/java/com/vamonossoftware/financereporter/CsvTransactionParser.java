package com.vamonossoftware.financereporter;

import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateMidnight;
import org.joda.time.format.DateTimeFormat;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;

import com.vamonossoftware.financereporter.domain.model.CsvConfig;
import com.vamonossoftware.financereporter.domain.model.TransactionFactory;

@Component
public class CsvTransactionParser {

	public void parseCsvFile(File file, CsvConfig csvConfig, TransactionFactory transactionFactory) throws Exception {
		parseCsv(new CSVReader(new FileReader(file)), csvConfig, transactionFactory);
	}

	public void parseCsvString(String string, CsvConfig csvConfig, TransactionFactory transactionFactory) throws Exception {
		parseCsv(new CSVReader(new StringReader(string)), csvConfig, transactionFactory);
	}

	public void parseCsv(CSVReader reader, CsvConfig csvConfig, TransactionFactory transactionFactory) throws Exception {
		String[] nextLine;
		reader.readNext();
		while ((nextLine = reader.readNext()) != null) {
			parseLine(nextLine, csvConfig, transactionFactory);
		}
	}

	private void parseLine(String[] nextLine, CsvConfig csvConfig, TransactionFactory transactionFactory) {
		// System.out.println(StringUtils.join(nextLine, ","));
		transactionFactory.create(parseDate(nextLine[csvConfig.getDate()], csvConfig), nextLine[csvConfig.getDescription()],
				parseAmount(nextLine[csvConfig.getDebit()]), parseAmount(nextLine[csvConfig.getCredit()]), nextLine[csvConfig.getAccount()]);
		// System.out.println(transaction);
	}

	private DateMidnight parseDate(String value, CsvConfig csvConfig) {
		return new DateMidnight(DateTimeFormat.forPattern(csvConfig.getDateFormat()).parseDateTime(value));
	}

	private BigDecimal parseAmount(String value) {
		if (value != null && !StringUtils.isBlank(value)) {
			return new BigDecimal(value);
		}
		return null;
	}

}
