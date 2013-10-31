package com.example.ormlitedemo;

import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {
	private final String LOG_TAG = "demo";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		doSampleDatabaseStuff();
	}

	
	private void doSampleDatabaseStuff() {
		RuntimeExceptionDao<Note, Integer> simpleDao = getHelper().getNoteDao();
		
		simpleDao.create(new Note("Note 1", "Note 1 text ..."));
		simpleDao.create(new Note("Note 2", "Note 2 text ..."));
		simpleDao.create(new Note("Note 3", "Note 3 text ..."));
		
		//DatabaseHelper helper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		//RuntimeExceptionDao<Note, Integer> simpleDao = helper.getNoteDao();
		
		// query for all of the data objects in the database
		List<Note> list = simpleDao.queryForAll();
		Log.d(LOG_TAG, list.toString());
		
		list = simpleDao.queryForEq("id", 1);
		Log.d(LOG_TAG, list.toString());
		
		//OpenHelperManager.releaseHelper();
	}

}
