package com.vamonossoftware.financereporter.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table
public class Transaction implements Comparable<Transaction> {
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Id
	private long id;

	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime date;

	private String description;

	private String category;

	private String account;

	private BigDecimal amount;

	public Transaction() {
	}

	public Transaction(DateTime date, String account, String description, String category, BigDecimal amount) {
		super();
		this.date = date;
		this.account = account;
		this.description = description;
		this.category = category;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public String getAccount() {
		return account;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int compareTo(Transaction other) {
		return date.compareTo(other.date);
	}

}
