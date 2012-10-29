package ru.javabean.android.gunexam;

import android.app.Activity;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends Activity {

	
	private int right;
	private int overall;
	private ShapeDrawable d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		   setContentView(R.layout.results);
	    Bundle extras = getIntent().getExtras();
	    right = extras.getInt(ViewSingleThemeActivitySuper.rightAnswered);
	    overall = extras.getInt(ViewSingleThemeActivitySuper.overAll);
	        setUpViews();
	}

	private void setUpViews() {
		
//		WebView googleChartView = new WebView(this);
//		setContentView(googleChartView);
		
//		 WebView googleChart=(WebView)findViewById(R.id.WebView);
		
		 TextView right_text = (TextView) findViewById(R.id.results_right);
		 TextView wrong_text = (TextView) findViewById(R.id.results_wrong);
		 
		 ImageView graphics = (ImageView)findViewById(R.id.imageView1);
		 
		 float[] outR = new float[] {6, 6, 6, 6,6, 6, 6, 6};
		 
		 RectF rectF = new RectF(8, 8, 8, 8) ;
		 float[] inR= new float[] { 6, 6, 6, 6, 6, 6, 6, 6};
		 
		 d = new ShapeDrawable (new RoundRectShape(outR, rectF, inR));
		 ShapeDrawable circle = new ShapeDrawable( new  OvalShape() );
		 d.setIntrinsicHeight(100) ;
		 d.setIntrinsicWidth(150) ;
		 d.getPaint().setColor(R.color.aqua);
		 right_text.setText(String.valueOf(right));
		 wrong_text.setText(String.valueOf(overall-right));
		 graphics.setBackgroundDrawable(circle);
		 
//		String mUrl = "http://chart.apis.google.com/chart?cht=gom&chs=320x150&chd=t:"+(right/(float)overall)*100+"&chl=Правильно";
////		"http://chart.apis.google.com/chart?cht=p3&chs=300x100&chd=t:"+(right/overall)*100+"&chco=80C65A,224499,FF0000&chl=RIGHT%7CWRONG";
//		
//		googleChart.loadUrl(mUrl);
		
		
	}
}
