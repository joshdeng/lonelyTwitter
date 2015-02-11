package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.json";
	private EditText bodyText;
	private ListView oldTweetsList;
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	private ArrayList<NormalTweetModel> tweets;
	private ArrayAdapter<NormalTweetModel> adapter;
=======
	private ArrayAdapter<String> adapter;
	private ArrayList<String> tweets;
	
>>>>>>> f069fc746c5cbcf4226e777a33d4d4c339e96fab:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
				NormalTweetModel tweet = new NormalTweetModel(text);
				saveInFile(tweet);
				tweets.add(tweet);
=======
				saveInFile(text, new Date(System.currentTimeMillis()));
				tweets.add(text);
>>>>>>> f069fc746c5cbcf4226e777a33d4d4c339e96fab:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		User u = new Author ("Joe");
		u.getName();
		
		
		super.onStart();
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
		tweets = loadFromFile();
		adapter = new ArrayAdapter<NormalTweetModel>(this,
=======
		ArrayList<String> tweets = this.loadFromFile();
		adapter = new ArrayAdapter<String>(this,
>>>>>>> f069fc746c5cbcf4226e777a33d4d4c339e96fab:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	private ArrayList<NormalTweetModel> loadFromFile() {
		ArrayList<NormalTweetModel> tweets = new ArrayList<NormalTweetModel>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(NormalTweetModel.fromJSON(line));
				line = in.readLine();
			}
=======
	private ArrayList<String> loadFromFile() {
		Gson gson = new Gson();
		tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader in = new InputStreamReader(fis);
			// Taken from 
			Type typeOfT = new TypeToken<ArrayList<String>>(){}.getType();
			tweets = gson.fromJson(in, typeOfT);
			fis.close();
>>>>>>> f069fc746c5cbcf4226e777a33d4d4c339e96fab:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;
	}
	
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	private void saveInFile(NormalTweetModel tweet) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write((tweet.toJSON() + "\n").getBytes());
=======
	private void saveInFile(String text, Date date) {
		Gson gson = new Gson();
		
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(tweets, osw);
			osw.flush();
>>>>>>> f069fc746c5cbcf4226e777a33d4d4c339e96fab:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}