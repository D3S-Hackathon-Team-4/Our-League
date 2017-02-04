package d3s.team_four.our.league.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import d3s.team_four.our.league.List2ViewCustomAdapter;
import d3s.team_four.our.league.List2ViewItemComponent;
import d3s.team_four.our.league.R;

public class AlarmActivity extends AppCompatActivity {
    private ListView listView;
    private List2ViewCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("알림");

        adapter = new List2ViewCustomAdapter();

        listView = (ListView) findViewById(R.id.list2view);
        listView.setAdapter(adapter);

        adapter.add(new List2ViewItemComponent("asdfdsasdfdsasdf", "baseball"));
        adapter.add(new List2ViewItemComponent("asdfdsasdfdsasdf", "basketball"));
        adapter.add(new List2ViewItemComponent("asdfdsasdfdsasdf", "lol"));

    }
}
