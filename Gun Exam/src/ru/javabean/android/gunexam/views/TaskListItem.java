package ru.javabean.android.gunexam.views;


import ru.javabean.android.gunexam.R;
import ru.javabean.android.gunexam.exception.GunExamException;
import ru.javabean.android.gunexam.tickets.Ticket;
//import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioButton;
//import android.widget.RadioGroup;
import android.widget.TextView;


public class TaskListItem extends LinearLayout {

//	private RadioGroup ansGroup;
	private RadioButton ansButton1;
	private RadioButton ansButton2;
	private RadioButton ansButton3;
	private RadioButton ansButton4;
	private RadioButton ansButton5;
	private TextView question;

	private Ticket currentTicket;
//	private AlertDialog unSavedChangesDialog;

	public TaskListItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
//		ansGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		ansButton1 = (RadioButton) findViewById(R.id.radio0);
		ansButton2 = (RadioButton) findViewById(R.id.radio1);
		ansButton3 = (RadioButton) findViewById(R.id.radio2);
		ansButton4 = (RadioButton) findViewById(R.id.RadioButton01);
		ansButton5 = (RadioButton) findViewById(R.id.RadioButton02);
		question = (TextView) findViewById(R.id.question_test);

	}

	public Ticket getCurrentTicket() {
		return currentTicket;
	}

	public void setCurrentTicket(Ticket currentTicket) {
		this.currentTicket = currentTicket;
		java.lang.System.out.println("test");
		question.setText(currentTicket.getQuestion());
		ansButton1.setText(currentTicket.getAnswers().get(0));
		
		
		try {
			if (currentTicket.getAnswers().get(1) != null) 
			{
				ansButton2.setText(currentTicket.getAnswers().get(1));
			} else 
				{
				
					ansButton2.setVisibility(GONE);
				}

		} catch (IndexOutOfBoundsException e) 
		{
			ansButton2.setVisibility(GONE);
			try {
				throw new GunExamException("some problem with array");
			} catch (GunExamException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} 
		finally 
		{
			
		};
		
		try {
			if (currentTicket.getAnswers().get(2) != null) 
			{
				ansButton3.setText(currentTicket.getAnswers().get(2));;
			} else 
				{
				
					ansButton3.setVisibility(GONE);
				}

		} catch (IndexOutOfBoundsException e) 
		{
			ansButton3.setVisibility(GONE);
			try {
				throw new GunExamException("some problem with array");
			} catch (GunExamException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} 
		finally 
		{
			
		};
		
		
		
		try {
			if (currentTicket.getAnswers().get(3) != null) 
			{
				ansButton4.setText(currentTicket.getAnswers().get(3));
			} else 
				{
				
					ansButton4.setVisibility(GONE);
				}

		} catch (IndexOutOfBoundsException e) 
		{
			ansButton4.setVisibility(GONE);
			try {
				throw new GunExamException("some problem with array");
			} catch (GunExamException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} 
		finally 
		{
			
		};

		try {
			if (currentTicket.getAnswers().get(4) != null) 
			{
				ansButton5.setText(currentTicket.getAnswers().get(4));
			} else 
				{
					ansButton5.setVisibility(GONE);
				}

		} catch (IndexOutOfBoundsException e) 
		{
			ansButton5.setVisibility(GONE);
			try {
				throw new GunExamException("some problem with array");
			} catch (GunExamException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} 
		finally 
		{
//			ansButton5.setVisibility(0);
		};
	}

}
