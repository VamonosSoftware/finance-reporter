package com.vamonossoftware.financereporter.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Category implements Comparable<Category> {

	private String name;
	private List<String> matchPhrases = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPhrase(String phrase) {
		matchPhrases.add(phrase);
	}

	public boolean match(String description) {
		for (String phrase : matchPhrases) {
			if (description.toLowerCase().contains(phrase.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public int compareTo(Category other) {
		return name.compareTo(other.name);
	}

}
