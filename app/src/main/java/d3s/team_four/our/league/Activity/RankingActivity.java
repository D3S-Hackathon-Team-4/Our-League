package d3s.team_four.our.league.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import d3s.team_four.our.league.ListViewCustomAdapter;
import d3s.team_four.our.league.ListViewItemComponent;
import d3s.team_four.our.league.R;

public class RankingActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewCustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("경기 일정");

        adapter = new ListViewCustomAdapter();

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        adapter.add(new ListViewItemComponent("03.01", "15:00~17:00", "배민고", "baseball", "와동체육공원"));
        adapter.add(new ListViewItemComponent("03.12", "13:00~15:00", "우형고", "soccer", "안산 와스타디움"));
        adapter.add(new ListViewItemComponent("03.13", "11:00~13:00", "광민고", "badminton", "학봉 배드민턴장"));
        adapter.add(new ListViewItemComponent("04.01", "18:00~20:00", "지리고", "lol", "갤러리 PC방"));
        adapter.add(new ListViewItemComponent("04.03", "12:00~14:00", "오지고", "lol", "하이원 PC방"));


    }
}
