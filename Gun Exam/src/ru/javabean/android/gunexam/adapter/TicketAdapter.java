package ru.javabean.android.gunexam.adapter;

import java.util.ArrayList;

import ru.javabean.android.gunexam.GunExamApplication;
import ru.javabean.android.gunexam.R;
import ru.javabean.android.gunexam.tickets.Ticket;

import ru.javabean.android.gunexam.views.TaskListItem;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TicketAdapter extends BaseAdapter {
	private ArrayList<Ticket> tickets;
	private Context context;

	public TicketAdapter(ArrayList<Ticket> tickets, Context context) {
		super();
		this.tickets = tickets;
		this.context = context;
	}

	static class ViewHolder {
		TextView t = null;
		RadioGroup group;
		RadioButton button1;
		RadioButton button2;
		RadioButton button3;
		RadioButton button4;
		RadioButton button5;

		public ViewHolder(TaskListItem tli) {
			t = (TextView) tli.findViewById(R.id.question_test);
			group = (RadioGroup) tli.findViewById(R.id.radioGroup1);

			button1 = (RadioButton) tli.findViewById(R.id.radio0);
			button2 = (RadioButton) tli.findViewById(R.id.radio1);
			button3 = (RadioButton) tli.findViewById(R.id.radio2);
			button4 = (RadioButton) tli.findViewById(R.id.RadioButton01);
			button5 = (RadioButton) tli.findViewById(R.id.RadioButton02);
		}

	};

	public int getCount() {
		// TODO Auto-generated method stub
		return tickets.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return (null == tickets) ? null : tickets.get(arg0);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		TaskListItem tli;
		if (null == convertView) {
			tli = (TaskListItem) View.inflate(context, R.layout.task_list_item,
					null);
			final ViewHolder holder = new ViewHolder(tli);
			tli.setTag(holder);
			holder.group
					.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

						private GunExamApplication app;

						public void onCheckedChanged(RadioGroup group,
								int checkedId) {
							switch (checkedId) {
							case R.id.radio0:
								checkAndSetAnswered(1, holder.button1);
								break;
							case R.id.radio1:
								checkAndSetAnswered(2, holder.button2);
								break;
							case R.id.radio2:
								checkAndSetAnswered(3, holder.button3);
								break;
							case R.id.RadioButton01:
								checkAndSetAnswered(4, holder.button4);
								break;
							case R.id.RadioButton02:
								checkAndSetAnswered(5, holder.button5);
								break;
							default:
								break;
							}

						}

						private void checkAndSetAnswered(int i,
								RadioButton checkedButton) {
							boolean isItRight = tickets.get(position)
									.checkifItIsRight(i);
							

							if (isItRight) {
								checkedButton.setTypeface(null, Typeface.BOLD) ;
								app = (GunExamApplication)context.getApplicationContext();
								app.setRightAnswersCnt();
							}

							holder.button1.setEnabled(false);
							holder.button1.setTextColor(R.color.Chocolate);
							holder.button2.setEnabled(false);
							holder.button2.setTextColor(R.color.Chocolate);
							holder.button3.setEnabled(false);
							holder.button3.setTextColor(R.color.Chocolate);
							holder.button4.setEnabled(false);
							holder.button4.setTextColor(R.color.Chocolate);
							holder.button5.setEnabled(false);
							holder.button5.setTextColor(R.color.Chocolate);

						}

				
					});

		} else {
			tli = (TaskListItem) convertView;
		}

		tli.setCurrentTicket(tickets.get(position));

		return tli;
	}


	public void forceReload() {
		notifyDataSetChanged();

	}

}
