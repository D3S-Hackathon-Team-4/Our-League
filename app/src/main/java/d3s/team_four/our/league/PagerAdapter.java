package d3s.team_four.our.league;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import d3s.team_four.our.league.SportSpeciesFragment.BadmintonFragment;
import d3s.team_four.our.league.SportSpeciesFragment.BaseballFragment;
import d3s.team_four.our.league.SportSpeciesFragment.BasketballFragment;
import d3s.team_four.our.league.SportSpeciesFragment.LOLFragment;
import d3s.team_four.our.league.SportSpeciesFragment.SoccerFragment;

/**
 * Created by songhyemin on 2017. 2. 4..
 */

public class PagerAdapter extends FragmentPagerAdapter{

    private int MAX_PAGE = 5;
    private Fragment curFragment = new Fragment();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position<0 || MAX_PAGE<=position)
            return null;
        switch (position){
            case 0:
                curFragment = new SoccerFragment();
                break;
            case 1:
                curFragment = new BaseballFragment();
                break;
            case 2:
                curFragment = new BadmintonFragment();
                break;
            case 3:
                curFragment = new BasketballFragment();
                break;
            case 4:
                curFragment = new LOLFragment();
                break;

        }
        return curFragment;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
