package d3s.team_four.our.league.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import d3s.team_four.our.league.PagerAdapter;
import d3s.team_four.our.league.R;
import d3s.team_four.our.league.SportSpeciesFragment.BadmintonFragment;
import d3s.team_four.our.league.SportSpeciesFragment.BaseballFragment;
import d3s.team_four.our.league.SportSpeciesFragment.BasketballFragment;
import d3s.team_four.our.league.SportSpeciesFragment.LOLFragment;
import d3s.team_four.our.league.SportSpeciesFragment.SoccerFragment;

public class MainActivity extends AppCompatActivity implements LOLFragment.OnFragmentInteractionListener, BaseballFragment.OnFragmentInteractionListener,
        SoccerFragment.OnFragmentInteractionListener, BasketballFragment.OnFragmentInteractionListener, BadmintonFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ViewPager viewpager = (ViewPager) findViewById(R.id.view_pager);
        TextView textView = (TextView) findViewById(R.id.species_text);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), textView);
        viewpager.setAdapter(pagerAdapter);

        Button rankingShowButton = (Button) findViewById(R.id.ranking_button);
        rankingShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
