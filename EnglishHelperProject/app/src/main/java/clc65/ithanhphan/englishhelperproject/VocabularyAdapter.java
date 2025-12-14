package clc65.ithanhphan.englishhelperproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VocabularyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Vocabulary> data;

    public VocabularyAdapter(Context context, ArrayList<Vocabulary> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getVocabularyID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_vocabulary, parent, false);
        }

        TextView txtWord = convertView.findViewById(R.id.txtWord);
        TextView txtNote = convertView.findViewById(R.id.txtNote);

        Vocabulary tu = data.get(position);

        txtWord.setText(tu.getWord());
        txtNote.setText(tu.getNote().isEmpty() ? "Không có ghi chú" : tu.getNote());

        return convertView;
    }
}
