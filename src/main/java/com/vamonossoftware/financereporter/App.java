package com.vamonossoftware.financereporter;

import java.io.File;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vamonossoftware.financereporter.domain.model.Category;
import com.vamonossoftware.financereporter.domain.model.CsvConfig;
import com.vamonossoftware.financereporter.domain.model.TransactionFactory;
import com.vamonossoftware.financereporter.infrastructure.persistence.TransactionRepository;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring2.xml");

		TransactionRepository transactionRepository = context.getBean(TransactionRepository.class);
		ArrayList<Category> categories = new ArrayList<Category>();
		TransactionFactory transactionFactory = new TransactionFactory(categories, transactionRepository);

		CsvConfig csvConfig = new CsvConfig(1, 2, 3, 4, 0, "dd/MM/yyyy");
		CsvTransactionParser parser = context.getBean(CsvTransactionParser.class);
		parser.parseCsvFile(new File("/Users/paulrule/Downloads/Data (1).CSV"), csvConfig, transactionFactory);
		//
		// Collection<Transaction> tx = transactionRepository.load();
		// System.out.println(tx.size());
	}
}
