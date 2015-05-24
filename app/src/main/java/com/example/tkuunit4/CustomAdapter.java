package com.example.tkuunit4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Xavier on 2015/5/24.
 */
public class CustomAdapter<T> extends BaseAdapter {
	private Context context;
	private List<T> dataSource;
	private LayoutInflater layoutInflater;

	CustomAdapter(Context context, List<T> dataSource) {
		this.context = context;
		this.layoutInflater = LayoutInflater.from(context);
		this.dataSource = dataSource;
	}

	@Override
	public int getCount() {
		return this.dataSource.size();
	}

	@Override
	public Object getItem(int position) {
		return this.dataSource.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = this.layoutInflater.inflate(R.layout.items, null);
		}

		ImageView imageView = (ImageView) convertView.findViewById(R.id.img_example);
		TextView textView = (TextView) convertView.findViewById(R.id.title);
		TextView subtextView = (TextView) convertView.findViewById(R.id.subtitle);

		Data data = (Data) this.getItem(position);

		if (position % 2 == 0) {
			imageView.setImageDrawable(this.context.getDrawable(R.drawable.img_example_a));
		} else {
			imageView.setImageDrawable(this.context.getDrawable(R.drawable.img_example_b));
		}

		textView.setText(data.getTitle());
		subtextView.setText(data.getSubTitle());

		return convertView;
	}
}
