package serhii.bulakh.mynotes;

import androidx.cardview.widget.CardView;

import serhii.bulakh.mynotes.Models.Notes;

public interface NotesClickListener {

    void onClick (Notes notes) ;
    void onLongCLick (Notes notes, CardView cardView );


}
