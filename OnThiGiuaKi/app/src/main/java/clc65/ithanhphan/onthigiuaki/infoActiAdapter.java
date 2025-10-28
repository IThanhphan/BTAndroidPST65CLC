package clc65.ithanhphan.onthigiuaki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class infoActiAdapter extends RecyclerView.Adapter<infoActiAdapter.ItemLanHolder> {
    Context context;
    static ArrayList<infoActi> listData;

    public infoActiAdapter(Context context, ArrayList<infoActi> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vItem = inflater.inflate(R.layout.layout_activiti, parent, false);
        return new ItemLanHolder(vItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLanHolder holder, int position) {
        infoActi infoActiDisplay = listData.get(position);
        String titleDisplay = infoActiDisplay.getTitle();
        String timeDisplay = infoActiDisplay.getTime();
        String imageDisplay = infoActiDisplay.getImage();
        holder.titleView.setText(titleDisplay);
        holder.timeView.setText(timeDisplay);
        String packageName = holder.itemView.getContext().getPackageName();
        int imgID = holder.itemView.getResources().getIdentifier(imageDisplay, "mipmap", packageName);
        if (imgID != 0)
            holder.imageAvatarView.setImageResource(imgID);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    static class ItemLanHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleView, timeView;
        ImageView imageAvatarView;

        public ItemLanHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.titleAt);
            timeView = itemView.findViewById(R.id.timeAt);
            imageAvatarView = itemView.findViewById(R.id.imgaeAt);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
