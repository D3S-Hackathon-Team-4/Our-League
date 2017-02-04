package d3s.team_four.our.league;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by songhyemin on 2017. 2. 5..
 */

public class List2ViewCustomAdapter extends BaseAdapter{
    private ArrayList<List2ViewItemComponent> list;

    public List2ViewCustomAdapter() {
        list = new ArrayList<List2ViewItemComponent>();
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final int pos = position;
        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list2view_item, viewGroup, false);

            TextView sentence = (TextView) view.findViewById(R.id.sentence);
            ImageView imageIc = (ImageView) view.findViewById(R.id.species_ic);


            sentence.setText(list.get(position).sentence);

            switch(list.get(position).species){
                case "badminton":
                    imageIc.setImageResource(R.drawable.badminton_ball);
                    break;

                case "baseball":
                    imageIc.setImageResource(R.drawable.baseball_ball);
                    break;

                case "basketball":
                    imageIc.setImageResource(R.drawable.basketball_ball);
                    break;

                case "lol":
                    imageIc.setImageResource(R.drawable.lol_ic);
                    break;

                case "soccer":
                    imageIc.setImageResource(R.drawable.soccer_ball);
                    break;
            }



        }



        return view;
    }

    public void add(List2ViewItemComponent msg) {
        list.add(msg);
    }

    // 외부에서 아이템 삭제 요청 시 사용
    public void remove(int position) {
        list.remove(position);
    }
}
