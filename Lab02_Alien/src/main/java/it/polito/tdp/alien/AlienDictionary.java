package it.polito.tdp.alien;

import java.util.*;



public class AlienDictionary {

	private List<Word> dizionario;
	
	public AlienDictionary() {
		
		dizionario = new LinkedList<>();
	}
	
	public void addWord(String alienWord, String translation) {
		
		boolean trovato = false;
		for(Word w : dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				w.addTranslation(translation);
				trovato = true;
			}
		}
		if(trovato==false) {
			dizionario.add(new Word(alienWord, translation));
		}
	}
	
	public String translate(String alienWord) {
		String s = "";
		for(Word w : dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				s+=w.getTranslation();
				break;
			}
		}
		
		return s;
	}
	
	public void reset() {
		dizionario.clear();
	}
}
