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

public class ListViewCustomAdapter extends BaseAdapter {
    private ArrayList<ListViewItemComponent> list;

    public ListViewCustomAdapter() {
        list = new ArrayList<ListViewItemComponent>();
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
            view = inflater.inflate(R.layout.listview_item, viewGroup, false);

            TextView dateText = (TextView) view.findViewById(R.id.date_text);
            TextView timeText = (TextView) view.findViewById(R.id.time_text);
            TextView schoolName = (TextView) view.findViewById(R.id.school_name_list);
            ImageView imageIc = (ImageView) view.findViewById(R.id.image_ic);
            TextView location = (TextView) view.findViewById(R.id.location);

            dateText.setText(list.get(position).date);
            timeText.setText(list.get(position).time);
            schoolName.setText(list.get(position).school);
            location.setText(list.get(position).location);

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

    public void add(ListViewItemComponent msg) {
        list.add(msg);
    }

    // 외부에서 아이템 삭제 요청 시 사용
    public void remove(int position) {
        list.remove(position);
    }
}
