package com.vamonossoftware.financereporter.infrastructure.persistence;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import org.joda.time.DateMidnight;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vamonossoftware.financereporter.domain.model.Transaction;

@Repository
@Transactional
public class TransactionRepository {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Transaction> load() {
		Query query = em.createQuery("from Transaction");
		return query.getResultList();
	}

	public Collection<Transaction> load(DateMidnight from, DateMidnight to) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		return query.getResultList();
	}

	public Transaction create(Transaction transaction) {
		return em.merge(transaction);
	}

}
