package com.halfof73.halfof73.phone;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.halfof73.halfof73.R;

import java.util.ArrayList;
import java.util.List;

public class PhoneFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone, container,false);
        final ListView listView=view.findViewById(R.id.listview);
        final List<Phone> phones= getPhone();
        listView.setAdapter(new PhoneAdapter(phones,getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Phone phone = phones.get(position);
                Fragment fragment = new ResultFragment();

                Bundle bundle =new Bundle();
                bundle.putSerializable("phone",phone);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        return view;
    }
    private List<Phone> getPhone() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(R.drawable.large, "SONY Xperia XZ2", "$24,990"));
        phones.add(new Phone(R.drawable.large1, "OPPO R11s", "$12,800"));
        phones.add(new Phone(R.drawable.large2, "SONY Xperia XZ1", "$13,500"));
        phones.add(new Phone(R.drawable.large3, "ASUS ZenFone 5Q (ZC600KL)", "$9,500"));
        phones.add(new Phone(R.drawable.large4, "Samsung Galaxy A8+ (2018) 64GB", "$14,600"));
        phones.add(new Phone(R.drawable.large5, "SONY Xperia XZ Premium", "$15,800"));
        phones.add(new Phone(R.drawable.large6, "SHARP AQUOS S3", "$11,990"));
        phones.add(new Phone(R.drawable.large7, "OPPO A73", "$6,700"));
        phones.add(new Phone(R.drawable.large8, "Samsung Galaxy A8 (2018) 32GB", "$11,800"));
        phones.add(new Phone(R.drawable.large9, "ASUS ZenFone 5Z (ZS620KL) 6GB/128GB", "$--------"));
        phones.add(new Phone(R.drawable.large10, "Samsung Galaxy Note 8", "$24,800"));
        return phones;

    }
    class PhoneAdapter extends BaseAdapter {
        List<Phone> phones;
        Context context;

        public PhoneAdapter(List<Phone> phones, Context context) {
            this.phones = phones;
            this.context = context;
        }

        @Override
        public int getCount() {
            return phones.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Phone phone =phones.get(position);
            LayoutInflater layoutInflater= LayoutInflater.from(context);
            if (convertView == null){
                convertView = layoutInflater.inflate(R.layout.list_view,parent,false);
            }
            ImageView imageView = convertView.findViewById(R.id.iv_pic);
            imageView.setImageResource(phone.getImageId());
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView imageView = new ImageView(context);
                    imageView.setImageResource(phone.getImageId());
                    Toast toast = new Toast(context);
                    toast.setView(imageView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            TextView tvName = convertView.findViewById(R.id.tv_name);
            tvName.setText(phone.getName());
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,phone.getName(), Toast.LENGTH_SHORT).show();
                }
            });

            TextView tvMS = convertView.findViewById(R.id.tv_ms);
            tvMS.setText(phone.getMs());
            tvMS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,phone.getMs(), Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }
}
