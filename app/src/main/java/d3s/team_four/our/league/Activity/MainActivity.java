package d3s.team_four.our.league.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.gigamole.infinitecycleviewpager.OnInfiniteCyclePageTransformListener;

import d3s.team_four.our.league.PagerAdapter;
import d3s.team_four.our.league.R;
import d3s.team_four.our.league.SportSpeciesFragment.BadmintonFragment;
import d3s.team_four.our.league.SportSpeciesFragment.BaseballFragment;
import d3s.team_four.our.league.SportSpeciesFragment.BasketballFragment;
import d3s.team_four.our.league.SportSpeciesFragment.LOLFragment;
import d3s.team_four.our.league.SportSpeciesFragment.SoccerFragment;

public class MainActivity extends AppCompatActivity implements LOLFragment.OnFragmentInteractionListener, BaseballFragment.OnFragmentInteractionListener,
        SoccerFragment.OnFragmentInteractionListener, BasketballFragment.OnFragmentInteractionListener, BadmintonFragment.OnFragmentInteractionListener{

    private HorizontalInfiniteCycleViewPager mHorizontalInfiniteCycleViewPager;
    private TextView mScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


        getWindow().setStatusBarColor(Color.TRANSPARENT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("한국디지털미디어고등학교");
        actionBar.setSubtitle("송혜민(Song Hyemin)");
        actionBar.hide();
        mHorizontalInfiniteCycleViewPager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.viewPager);
        mScoreText = (TextView)findViewById(R.id.score);

        mHorizontalInfiniteCycleViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        mHorizontalInfiniteCycleViewPager.setScrollDuration(500);
        mHorizontalInfiniteCycleViewPager.setInterpolator(new AccelerateInterpolator());
        mHorizontalInfiniteCycleViewPager.setMediumScaled(true);
        mHorizontalInfiniteCycleViewPager.setMaxPageScale(0.8F);
        mHorizontalInfiniteCycleViewPager.setMinPageScale(0.5F);
        mHorizontalInfiniteCycleViewPager.setCenterPageScaleOffset(20.0F);
        mHorizontalInfiniteCycleViewPager.setMinPageScaleOffset(5.0F);

        mHorizontalInfiniteCycleViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position == 0) {
                    mScoreText.setText("0전 0승 0패 0무");
                } else if(position == 1) {
                    mScoreText.setText("2전 1승 1패 0무");
                } else if(position == 2) {
                    mScoreText.setText("1전 0승 1패 0무");
                } else if(position == 3) {
                    mScoreText.setText("0전 0승 0패 0무");
                } else {
                    mScoreText.setText("0전 0승 0패 0무");
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
