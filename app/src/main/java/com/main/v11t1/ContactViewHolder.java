package com.main.v11t1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView contactNameText, contactNumberText, contactGroupText;
    ImageView contactDetailsButton, contactDeleteButton;

    public ContactViewHolder(View itemView) {
        super(itemView);
        contactNameText = itemView.findViewById(R.id.ContactNameText);
        contactNumberText = itemView.findViewById(R.id.ContactNumberText);
        contactGroupText = itemView.findViewById(R.id.ContactGroupText);
        contactDetailsButton = itemView.findViewById(R.id.ContactDetailsButton);
        contactDeleteButton = itemView.findViewById(R.id.ContactDeleteButton);
    }
}