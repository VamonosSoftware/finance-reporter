package com.vamonossoftware.financereporter.infrastructure.persistence;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.repository.CrudRepository;

import com.vamonossoftware.financereporter.domain.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	List<Transaction> findByDateBetween(DateTime from, DateTime to);
}
