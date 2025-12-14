package clc65.ithanhphan.englishhelperproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlashCardAdapter extends RecyclerView.Adapter<FlashCardAdapter.CardViewHolder> {
    Context context;
    private ArrayList<Vocabulary> list;

    public FlashCardAdapter(Context context, ArrayList<Vocabulary> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vItem = inflater.inflate(R.layout.item_flash_card, parent, false);
        return new CardViewHolder(vItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Vocabulary voca = list.get(position);

        holder.tvWord.setText(voca.getWord());
        holder.tvNote.setText(voca.getNote().isEmpty() ? "Không có ghi chú" : voca.getNote());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.tvWord.getVisibility() == View.VISIBLE) {
                    holder.tvWord.setVisibility(View.GONE);
                    holder.tvNote.setVisibility(View.VISIBLE);
                } else {
                    holder.tvWord.setVisibility(View.VISIBLE);
                    holder.tvNote.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvWord, tvNote;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tvWord);
            tvNote = itemView.findViewById(R.id.tvNote);
        }
    }
}

