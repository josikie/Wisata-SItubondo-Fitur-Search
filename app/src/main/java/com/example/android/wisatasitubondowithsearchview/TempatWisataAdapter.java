package com.example.android.wisatasitubondowithsearchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TempatWisataAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    private List<TempatWisata> tempatWisataList;
    private ArrayList<TempatWisata> tempatWisataArrayList;

    public TempatWisataAdapter(Context context, List<TempatWisata> tempatWisataList) {
        context = context;
        this.tempatWisataList = tempatWisataList;
        layoutInflater = LayoutInflater.from(context);
        this.tempatWisataArrayList = new ArrayList<TempatWisata>();
        this.tempatWisataArrayList.addAll(tempatWisataList);
    }

    public class ViewHolder {
        ImageView gambarTempat;
        TextView namaTempat;
        TextView lokasiTempat;
    }

    @Override
    public int getCount(){
        return tempatWisataList.size();
    }

    @Override
    public TempatWisata getItem(int position){
        return tempatWisataList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }
    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.list_items, null);
            viewHolder.gambarTempat = convertView.findViewById(R.id.image_view);
            viewHolder.namaTempat = convertView.findViewById(R.id.tvName);
            viewHolder.lokasiTempat = convertView.findViewById(R.id.tvLocation);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.gambarTempat.setImageResource(tempatWisataList.get(position).getGambar());
        viewHolder.namaTempat.setText(tempatWisataList.get(position).getNamaTempat());
        viewHolder.lokasiTempat.setText(tempatWisataList.get(position).getLokasiTempat());
        return convertView;

    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        tempatWisataList.clear();
        if (charText.length() == 0) {
            tempatWisataList.addAll(tempatWisataArrayList);
        } else {
            for (TempatWisata wp : tempatWisataArrayList) {
                if (wp.getNamaTempat().toLowerCase(Locale.getDefault()).contains(charText)) {
                    tempatWisataList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
