package com.example.administrator.nuoctinhkhiet.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.nuoctinhkhiet.Models.Order;
import com.example.administrator.nuoctinhkhiet.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderNewFragment extends Fragment {
    ListView listOrder;
    public OrderNewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_new, container, false);


    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listOrder = (ListView)getActivity().findViewById(R.id.listNewOrder);


        List<Order> list = new ArrayList<Order>();
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));
        list.add(new Order("1",new Date(), 123912, "0", "Đã gửi"));

       OrderAdapter orderAdapter = new OrderAdapter(list);
        listOrder.setAdapter(orderAdapter);

//        listOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                ProductDetailFragment nextFrag= new ProductDetailFragment();
//
//                Bundle bundle = new Bundle();
//                bundle.putString("key","abc"); // Put anything what you want
//                nextFrag.setArguments(bundle);
//
//                FragmentManager fragmentManager=getActivity().getFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.contenLayout,nextFrag,"tag");
//                fragmentTransaction.addToBackStack("tag");
//                fragmentTransaction.commit();
//
//                //show back button
//                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//            }
//        });
    }

    class OrderAdapter extends BaseAdapter{
        List<Order> list;
        public OrderAdapter(List<Order> list)
        {
            this.list=list;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getActivity().getLayoutInflater().inflate(R.layout.item_order,null);

            TextView txtNumber= (TextView)convertView.findViewById(R.id.txtOrderNumber);
            TextView txtQuantity= (TextView) convertView.findViewById(R.id.txtQuantity);
            TextView txtCost = (TextView) convertView.findViewById(R.id.txtCost);
            TextView txtStatus = (TextView) convertView.findViewById(R.id.txtStatus);

            txtQuantity.setText("asdasd");
            txtNumber.setText(list.get(position).id);
            txtCost.setText(list.get(position).cost.toString());
            txtStatus.setText(list.get(position).status);


            return convertView;
        }
    }
}
