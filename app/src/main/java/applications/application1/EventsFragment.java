package applications.application1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class EventsFragment extends Fragment {
    int[] IMAGES = {R.drawable.splash, R.drawable.splash};

    String[] NAME = {"Consumer Electronics Exhibition", "A"};

    String[] DESC = {"Events", "A"};

    String[] DATE = {"24/5/2018", "A"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.events_tab, container, false);
        final ListView listView=(ListView) view.findViewById(R.id.listView);

        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                TextView data = (TextView) view.findViewById(R.id.textView_name);

                Toast.makeText(getActivity().getBaseContext(), data.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            TextView textView_desc = (TextView)view.findViewById(R.id.textView_desc);
            TextView textView_date = (TextView)view.findViewById(R.id.textView_date);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAME[i]);
            textView_desc.setText(DESC[i]);
            textView_date.setText(DATE[i]);
            return view;
        }


    }
}
