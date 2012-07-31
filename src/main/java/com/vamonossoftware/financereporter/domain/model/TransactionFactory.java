package com.vamonossoftware.financereporter.domain.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;

import com.vamonossoftware.financereporter.infrastructure.persistence.TransactionRepository;

public class TransactionFactory {
	private List<Category> categories;
	private TransactionRepository repository;

	public TransactionFactory(List<Category> categories, TransactionRepository repository) {
		super();
		this.categories = categories;
		this.repository = repository;
	}

	public Transaction create(DateMidnight date, String description, BigDecimal debit, BigDecimal credit, String account) {
		Transaction transaction = new Transaction(new DateTime(date), account, description, categorize(description), (debit == null ? credit : debit.negate()));
		return repository.create(transaction);
	}

	String categorize(String description) {
		for (Category category : categories) {
			if (category.match(description))
				return category.getName();
		}
		return null;
	}

}
