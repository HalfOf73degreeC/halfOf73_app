package com.halfof73.halfof73;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NewsFragment extends Fragment {
    private View view;
    private MySQLiteOpenHelper sqliteHelper;
    private SpotAdapter spotAdapter;
    private RecyclerView rvSpots;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sqlite, container,false);
        findViews();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        List<Spot> spotList = getSpotList();
        if (spotList.size() <= 0) {
            Toast.makeText(
                    getActivity(), R.string.text_NoDataFound, Toast.LENGTH_SHORT
            ).show();
        }

        if (spotAdapter == null) {
            spotAdapter = new SpotAdapter(getActivity(), spotList);
        } else {
            spotAdapter.setSpotList(spotList);
        }
        rvSpots.setAdapter(spotAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (sqliteHelper != null) {
            sqliteHelper.close();
        }
    }

    public List<Spot> getSpotList() {
        return sqliteHelper.getAllSpots();
    }

    private void findViews() {
        if (sqliteHelper == null) {
            sqliteHelper = new MySQLiteOpenHelper(getActivity());
        }
        rvSpots = (RecyclerView)view.findViewById(R.id.rvSpots);
        rvSpots.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.SpotViewHolder> {
        Context context;
        List<Spot> spotList;

        void setSpotList(List<Spot> spotList) {
            this.spotList = spotList;
        }

        SpotAdapter(Context context, List<Spot> spotList) {
            this.context = context;
            this.spotList = spotList;
        }

        class SpotViewHolder extends RecyclerView.ViewHolder {
            ImageView ivSpot;
            TextView tvName, tvPhone, tvAddress, tvWeb;

            SpotViewHolder(View itemView) {
                super(itemView);
                ivSpot = (ImageView) itemView.findViewById(R.id.ivSpot);
                tvName = (TextView) itemView.findViewById(R.id.tvName);
                tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);
                tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
                tvWeb = (TextView) itemView.findViewById(R.id.tvWeb);
            }
        }

        @Override
        public int getItemCount() {
            return spotList.size();
        }

        @Override
        public SpotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View itemView = layoutInflater.inflate(R.layout.item_view, parent, false);
            return new SpotViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(SpotViewHolder holder, int position) {
            final Spot spot = spotList.get(position);
            if (spot.getImage() == null) {
                holder.ivSpot.setImageResource(R.drawable.default_image);
            } else {
                Bitmap bitmap = BitmapFactory.decodeByteArray(
                        spot.getImage(), 0, spot.getImage().length);
                holder.ivSpot.setImageBitmap(bitmap);
            }
            holder.tvName.setText(spot.getName());
            holder.tvPhone.setText(spot.getPhone());
            holder.tvAddress.setText(spot.getAddress());
            holder.tvWeb.setText(spot.getWeb());

//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, UpdateActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("id", spot.getId());
//                    intent.putExtras(bundle);
//                    startActivity(intent);
//                }
//            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int count = sqliteHelper.deleteById(spot.getId());
//                    Toast.makeText(context, count + " " + getString(R.string.msg_RowDeleted),
//                            Toast.LENGTH_SHORT).show();
                    spotList = sqliteHelper.getAllSpots();
                    notifyDataSetChanged();
                    return true;
                }
            });
        }
    }


}
