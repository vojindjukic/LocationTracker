package com.bignerdranch.android.locationtracker;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bignerdranch.android.locationtracker.Adapters.TracksAdapter;


public class MyTracks extends AppCompatActivity {

    private ListView listView;
    private TracksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tracks);

    }

    @Override
    protected void onResume() {
        super.onResume();
        listView = (ListView) findViewById(R.id.mytracks_list);
        adapter = new TracksAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                String trackName = adapter.getName(arg1);
                Intent intent = new Intent(getApplicationContext(), TrackDetailsActivity.class);
                intent.putExtra("caller", "MyTracks");
                intent.putExtra("trackName", trackName);
                intent.putExtra("position", position); //+1 because indexes in database start from 1 not 0
                startActivity(intent);
            }
        });

        adapter.notifyDataSetChanged();

        if(adapter.getCount() > 0){
            findViewById(R.id.textViewEmptyList).setVisibility(View.GONE);
        }

    }

    public void click_on_settings_button(View view) {
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }

    public void click_on_new_track_button (View view){

        Intent newTrackIntent = new Intent(this, NewTrackActivity.class);
        startActivity(newTrackIntent);
    }
}
