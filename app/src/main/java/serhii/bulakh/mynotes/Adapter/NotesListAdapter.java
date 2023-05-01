package serhii.bulakh.mynotes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import serhii.bulakh.mynotes.Models.Notes;
import serhii.bulakh.mynotes.NotesClickListener;
import serhii.bulakh.mynotes.R;

public class NotesListAdapter extends RecyclerView.Adapter <NotesViewHolder>{

    Context context;
    List<Notes> list;

    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        holder.textView_title.setText(list.get(position).getTitle());
        holder.textView_title.setSelected(true);

        holder.textView_notes.setText(list.get(position).getNotes());

        holder.textView_date.setText(list.get(position).getDate());
        holder.textView_date.setSelected(true);

        if (list.get(position).isPinned()) {
            holder.imageView_pin.setImageResource(R.drawable.pin_icon);
        } else {
            holder.imageView_pin.setImageResource(0);
        }
        int color_code = getRandomColor();
        holder.notes_conteiner.setCardBackgroundColor(holder.itemView.getResources().getColor(color_code, null));


        holder.notes_conteiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });
        holder.notes_conteiner.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onLongCLick(list.get(holder.getAdapterPosition()), holder.notes_conteiner);
                return true;
            }
        });
    }

    private int getRandomColor(){
        List <Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);
        colorCode.add(R.color.color6);
        colorCode.add(R.color.color7);
        colorCode.add(R.color.color8);
        colorCode.add(R.color.color9);
        colorCode.add(R.color.color10);
        colorCode.add(R.color.color11);
        colorCode.add(R.color.color12);
        colorCode.add(R.color.color13);
        colorCode.add(R.color.color14);
        colorCode.add(R.color.color15);
        colorCode.add(R.color.color16);
        colorCode.add(R.color.color17);
        colorCode.add(R.color.color18);
        colorCode.add(R.color.color19);
        colorCode.add(R.color.color20);
        colorCode.add(R.color.color21);
        colorCode.add(R.color.color22);
        colorCode.add(R.color.color23);
        colorCode.add(R.color.color24);
        colorCode.add(R.color.color25);
        colorCode.add(R.color.color26);
        colorCode.add(R.color.color27);
        colorCode.add(R.color.color28);
        colorCode.add(R.color.color29);
        colorCode.add(R.color.color30);
        colorCode.add(R.color.color31);
        colorCode.add(R.color.color32);
        colorCode.add(R.color.color33);

        Random random = new Random();
        int random_color = random.nextInt(colorCode.size());
        return colorCode.get(random_color);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList (List<Notes> filteredList) {
        list = filteredList;
        notifyDataSetChanged();
    }

}

class NotesViewHolder extends RecyclerView.ViewHolder {

    CardView notes_conteiner;
    TextView textView_title, textView_notes, textView_date;
    ImageView imageView_pin;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);

        notes_conteiner = itemView.findViewById(R.id.notes_conteiner);
        textView_title = itemView.findViewById(R.id.textView_title);
        textView_notes = itemView.findViewById(R.id.textView_notes);
        textView_date = itemView.findViewById(R.id.textView_date);
        imageView_pin = itemView.findViewById(R.id.imageView_pin);
    }
}
