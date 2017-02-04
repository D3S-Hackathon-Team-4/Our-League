package d3s.team_four.our.league.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import d3s.team_four.our.league.R;

public class CreateGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(""); // 야구면 야구 축구면 축구, 인텐트 ㄲ

    }
}
