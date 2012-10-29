package ru.javabean.android.gunexam;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import static ru.javabean.android.gunexam.GunExamApplication.makeMeToastPlease;

public class ViewThemesActivity extends Activity implements OnClickListener {
	private Button firstThemeButton;
	private Button secondThemeButton;
	final int theme1Dialog = 1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setUpViews();

	}

	private void setUpViews() {
		makeMeToastPlease(ViewThemesActivity.this, "Main activity started");
		firstThemeButton = (Button) findViewById(R.id.go_to_theme1);
		secondThemeButton = (Button) findViewById(R.id.go_to_theme2);
		firstThemeButton.setOnClickListener(this);
		secondThemeButton.setOnClickListener(this);

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case theme1Dialog:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("are you sure?");
			builder.setPositiveButton(android.R.string.yes,
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							// AlertDialogButtonActivity.this.finish();

						}
					});

			// AlertDialog.Builder builder builder . setMessage ( "Are you
			// OnClickListener ( ) {
			// 1/ создаем кнопку "Yes" и обработчик события builder .
			// setPositiveButton (
			// "Yes", new Dialoginterface.OnClickListener() puЬlic void onClick
			// ( Dialoginterface dialog, int id)
			// AlertDialogButtonActivity . this . finish { ) ;
			// });
			// 11 создаем кнопку "No" и обработчик события builder .
			// setNegativeButton (
			// "No" , new Dialoginterface . OnClickListener ( ) puЬlic void
			// onClick (Dialoginterface dialog, int id)
			// dialog . cancel ( ) ;
			// builder.setCancelaЬle(false) ;
			// return builder. create ( ) ;
			builder.setCancelable(false);
			return builder.create();
		default:
			return null;
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.go_to_theme1:
//			showDialog(theme1Dialog);
			Intent firstThemeintent = new Intent(ViewThemesActivity.this,
					ViewSingleThemeActivity1.class);
			firstThemeintent.putExtra(GunExamApplication.THEME, 1);
			
			startActivity(firstThemeintent);

			break;
		case R.id.go_to_theme2:
			Intent secondThemeintent = new Intent(ViewThemesActivity.this,
					ViewSingleThemeActivity2.class);
			secondThemeintent.putExtra(GunExamApplication.THEME, 2);
			startActivity(secondThemeintent);

			break;

		}

	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		GunExamApplication app = (GunExamApplication)getApplication();
		app.setRightAnswersNull();
	}

}