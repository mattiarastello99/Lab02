package it.polito.tdp.alien;

import java.util.LinkedList;

public class Word {
	
	private String alienWord;	
	private LinkedList<String> translation;
	
	public Word(String alienWord, String translation) {
		
		this.translation = new LinkedList<String>();
		
		this.alienWord = alienWord;
		this.translation.add(translation);
	}
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	public String getTranslation() {
		
		String s = "";
		for(String trad : translation)
			s+=trad + "\n";
		
		
		return s;
	}
	public void addTranslation(String translation) {
		this.translation.add(translation);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	

}
