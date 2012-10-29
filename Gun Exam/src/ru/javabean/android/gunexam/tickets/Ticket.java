package ru.javabean.android.gunexam.tickets;

import java.util.ArrayList;

public class Ticket {

	private int id ;
	private int theme_id;
	private String question;
	private ArrayList<String> answers;
	private int correct_answer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTheme_id() {
		return theme_id;
	}
	public void setTheme_id(int theme_id) {
		this.theme_id = theme_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<String> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	public int getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(int correct_answer) {
		this.correct_answer = correct_answer;
	}
	public boolean checkifItIsRight(int answerPosition) {
		boolean answerIsCorrect = false;
		if (answerPosition==correct_answer) {
			answerIsCorrect=true;
		} ;
		
		return answerIsCorrect;
	}
	
	
}
