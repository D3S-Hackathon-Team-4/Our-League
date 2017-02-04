package d3s.team_four.our.league;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

import d3s.team_four.our.league.SportSpeciesFragment.BadmintonFragment;
import d3s.team_four.our.league.SportSpeciesFragment.BaseballFragment;
import d3s.team_four.our.league.SportSpeciesFragment.BasketballFragment;
import d3s.team_four.our.league.SportSpeciesFragment.LOLFragment;
import d3s.team_four.our.league.SportSpeciesFragment.SoccerFragment;

/**
 * Created by songhyemin on 2017. 2. 4..
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private int MAX_PAGE = 5;
    private Fragment curFragment = new Fragment();
    private TextView v = null;

    public PagerAdapter(FragmentManager fm, TextView v) {
        super(fm);
        this.v = v;
    }

    @Override
    public Fragment getItem(int position) {
        if(position<0 || MAX_PAGE<=position)
            return null;
        switch (position){
            case 0:
                v.setText("축구");
                curFragment = new SoccerFragment();
                break;
            case 1:
                v.setText("야구");
                curFragment = new BaseballFragment();
                break;
            case 2:
                v.setText("배드민턴");
                curFragment = new BadmintonFragment();
                break;
            case 3:
                v.setText("농구");
                curFragment = new BasketballFragment();
                break;
            case 4:
                v.setText("LOL");
                curFragment = new LOLFragment();

                break;

        }
        return curFragment;
    }

    @Override
    public int getCount() {
        return MAX_PAGE;
    }

}
