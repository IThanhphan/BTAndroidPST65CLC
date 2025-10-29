package gk1.phansithanh.thigiuakibmi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BaiThuocAdapter  extends RecyclerView.Adapter<BaiThuocAdapter.ItemHolder> {
    Context context;
    static ArrayList<BaiThuocView> listBaiThuoc;

    public BaiThuocAdapter(Context context, ArrayList<BaiThuocView> listBaiThuoc) {
        this.context = context;
        this.listBaiThuoc =listBaiThuoc;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vItem = inflater.inflate(R.layout.layout_bai_thuoc, parent, false);
        return new ItemHolder(vItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        BaiThuocView baiThuocViewDisplay = listBaiThuoc.get(position);
        String titleDisplay = baiThuocViewDisplay.getTenBaiThuoc();
        String timeDisplay = baiThuocViewDisplay.getThoiGian();
        String imageDisplay = baiThuocViewDisplay.getAnhBaiThuoc();
        holder.titleBaiThuoc.setText(titleDisplay);
        holder.timeBaiThuoc.setText(timeDisplay);
        String packageName = holder.itemView.getContext().getPackageName();
        int imgID = holder.itemView.getResources().getIdentifier(imageDisplay, "mipmap", packageName);
        if (imgID != 0)
            holder.imageBaiThuoc.setImageResource(imgID);
    }

    @Override
    public int getItemCount() {
        return listBaiThuoc.size();
    }

    static class ItemHolder extends RecyclerView.ViewHolder{
        TextView titleBaiThuoc, timeBaiThuoc;
        ImageView imageBaiThuoc;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            titleBaiThuoc = itemView.findViewById(R.id.title_bai_thuoc);
            timeBaiThuoc = itemView.findViewById(R.id.thoi_gian_bai_thuoc);
            imageBaiThuoc = itemView.findViewById(R.id.anh_bai_thuoc);
        }
    }
}
