package com.example.administrator.nuoctinhkhiet.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.nuoctinhkhiet.Activities.LoginActivity;
import com.example.administrator.nuoctinhkhiet.R;

public class SettingFragment extends Fragment {

    String[] menus = new String[] {"Hóa đơn","Lịch sử","Đổi mật khẩu","Góp ý","About","Đăng xuất"};
    Integer[] icons = new Integer[]{R.drawable.ic_invoice_white_24dp,R.drawable.ic_history_white_24dp,R.drawable.ic_password_white_24dp,R.drawable.ic_feedback_white_24dp,R.drawable.ic_about_white_24dp,R.drawable.ic_logout_white_24dp};
    ListView listMenu;
    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listMenu= (ListView)getActivity().findViewById(R.id.listMenu);
        MenuAdapter menuAdapter = new MenuAdapter(menus,icons);
        listMenu.setAdapter(menuAdapter);

        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                switch ((int) id)
                {
                    case 0:

                        return;
                    case 1:

                        return;

                    case 2:

                        return;
                    case 3:

                        return;

                    case 4:

                        return;
                    case 5:
                        LoginActivity loginActivity = new LoginActivity();

                        Intent intent = new Intent(getActivity(),LoginActivity.class);
                        startActivity(intent);
                        return;
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    class MenuAdapter extends BaseAdapter {
        String[] menus;
        Integer[] icons;
        public MenuAdapter(String[] menus, Integer[] icons)
        {
            this.menus=menus;
            this.icons=icons;
        }
        @Override
        public int getCount() {
            return menus.length;
        }

        @Override
        public Object getItem(int position) {
            return menus[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getActivity().getLayoutInflater().inflate(R.layout.item_setting,null);
            ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
            TextView txtMenu= (TextView)convertView.findViewById(R.id.txtMenu);

//            imgIcon.setColorFilter(Color.parseColor("#cd4ff7"));
           imgIcon.setImageResource(icons[position]);
            txtMenu.setText(menus[position]);


            return convertView;
        }
    }

}
