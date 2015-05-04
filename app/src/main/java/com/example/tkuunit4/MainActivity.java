package com.example.tkuunit4;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Xavier on 2015/5/4.
 */
public class MainActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);

		// ToolBar
		Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
		this.setSupportActionBar(toolbar);
		toolbar.setSubtitle("Toolbar");
		toolbar.setNavigationIcon(R.mipmap.ic_launcher);
		toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem menuItem) {
				switch (menuItem.getItemId()) {
					case R.id.action_add:
						Toast.makeText(MainActivity.this, "ToolBar Item: Add", Toast.LENGTH_LONG).show();
						break;

					case R.id.action_del:
						Toast.makeText(MainActivity.this, "ToolBar Item: Delete", Toast.LENGTH_LONG).show();
						break;
				}

				return true;
			}
		});

		// ListView
		ListView listView = (ListView) this.findViewById(R.id.listview_book);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(MainActivity.this, getString(R.string.items, position), Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.getMenuInflater().inflate(R.menu.menu_toolbar, menu);
		return true;
	}
}
