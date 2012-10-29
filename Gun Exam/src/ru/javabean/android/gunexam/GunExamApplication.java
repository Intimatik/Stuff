package ru.javabean.android.gunexam;

import java.util.ArrayList;

import ru.javabean.android.gunexam.database.TicketsSQLiteOpenHelper;
import ru.javabean.android.gunexam.tickets.Ticket;
import static ru.javabean.android.gunexam.database.TicketsSQLiteOpenHelper.*;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Gravity;
import android.widget.Toast;

public class GunExamApplication extends Application {

	private ArrayList<Ticket> currentTasks = new ArrayList<Ticket>();
	public static final String THEME = "theme";
	private int rightAnswersCnt=0;
	private SQLiteDatabase database;

	@Override
	public void onCreate() {
		super.onCreate();
		TicketsSQLiteOpenHelper helper = new TicketsSQLiteOpenHelper(this);
		helper.initializeDataBase();
		
		
		try {
            // A reference to the database can be obtained after initialization.
            database = helper.getWritableDatabase();
            /*
             * Place code to use database here.
             */
         } catch (Exception ex) {
            ex.printStackTrace();
//         } finally {
////            try {
////            	helper.close();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            } finally {
////            	helper.close();
//            }
        }
					

	}

	public ArrayList<Ticket> getCurrentTasks(int theme2) {

		loadTasksFromDatabase(theme2);

		return currentTasks;
	}

	private void loadTasksFromDatabase(int theme2) {

		currentTasks = new ArrayList<Ticket>();
		Cursor tasksCursor = database.query(TICKETS_TABLE,
				new String[] { TICKET_ID, TICKET_QUESTION, TICKET_ANSWERS,
						TICKET_RIGHT_ANSWER }, TICKET_THEME + "=" + theme2,
				null, null, null, String.format("%s", TICKET_ID));
		tasksCursor.moveToFirst();
		Ticket t;
		if (!tasksCursor.isAfterLast()) {
			do {
				int id = tasksCursor.getInt(0);
				String question = tasksCursor.getString(1);
				String ticket_answers = tasksCursor.getString(2);
				int right_answer = tasksCursor.getInt(3);

				t = new Ticket();
				t.setId(id);
				t.setQuestion(question);
				ArrayList<String> answers = new ArrayList<String>();

				String[] tokens = ticket_answers.split(";", -1);
				for (int i = 0; i < tokens.length; i++) {
					answers.add(tokens[i]);
				}
                t.setAnswers(answers);
				t.setCorrect_answer(right_answer);
				currentTasks.add(t);
			} while (tasksCursor.moveToNext());
		}

		tasksCursor.close();

	}

	public static void makeMeToastPlease(Context context, String text) {
		Toast newToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
		newToast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
		newToast.show();
	}

	public int getRightAnswersCnt() {
		return rightAnswersCnt;
	}

	public void setRightAnswersCnt() {
		this.rightAnswersCnt++;
	}

	public void setRightAnswersNull() {
		this.rightAnswersCnt=0;
	}
}
