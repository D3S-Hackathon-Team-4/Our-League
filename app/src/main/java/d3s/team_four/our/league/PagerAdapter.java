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

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new SoccerFragment();
            case 1:
                return new BaseballFragment();
            case 2:
                return new BadmintonFragment();
            case 3:
                return new BasketballFragment();
            case 4:
                return new LOLFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return MAX_PAGE;
    }

}
