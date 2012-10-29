package ru.javabean.android.gunexam;

import java.util.ArrayList;

import ru.javabean.android.gunexam.adapter.TicketAdapter;
import ru.javabean.android.gunexam.tickets.Ticket;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.RadioGroup;
import static ru.javabean.android.gunexam.GunExamApplication.*;

public class ViewSingleThemeActivitySuper extends ListActivity {

	private Button goToResultsButton;
	private GunExamApplication app;
	private TicketAdapter adapter;
	public static String rightAnswered = "right";
	public static String overAll = "all";
//	private RadioGroup radioGroup;
	private int theme;
	private int ticketsCnt=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.theme);
		setUpViews();
		Bundle extras = getIntent().getExtras();

		theme = extras.getInt(GunExamApplication.THEME);

		app = (GunExamApplication) getApplication();
		ArrayList<Ticket> tickets = app.getCurrentTasks(theme);
		ticketsCnt = tickets.size();
		adapter = new TicketAdapter(tickets, this);
		setListAdapter(adapter);
	}

	private void setUpViews() {

		makeMeToastPlease(this, getString(R.string.theme1_header));

		goToResultsButton = (Button) findViewById(R.id.button1);

		

		goToResultsButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(ViewSingleThemeActivitySuper.this,
						ResultsActivity.class);
				intent.putExtra(rightAnswered, app.getRightAnswersCnt());
				intent.putExtra(overAll, ticketsCnt);
				startActivity(intent);

			}

		});

	}

	
}
