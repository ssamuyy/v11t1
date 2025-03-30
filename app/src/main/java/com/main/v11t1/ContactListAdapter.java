package com.main.v11t1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private Context context;
    private ArrayList<Contact> contacts;

    public ContactListAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_view, parent, false);
        return new ContactViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.contactNameText.setText(contact.getFullName());
        holder.contactNumberText.setText(contact.getNumber());
        holder.contactGroupText.setText(contact.getContactGroup());

        holder.contactDetailsButton.setOnClickListener(v -> {
            if (holder.contactNumberText.getVisibility() == View.GONE) {
                holder.contactNumberText.setVisibility(View.VISIBLE);
                holder.contactGroupText.setVisibility(View.VISIBLE);
            } else {
                holder.contactNumberText.setVisibility(View.GONE);
                holder.contactGroupText.setVisibility(View.GONE);
            }
        });

        holder.contactDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION && pos >= 0 && pos < contacts.size()) {
                    ContactStorage.getInstance().removeContact(pos);
                    notifyItemRemoved(pos); // Päivitä näkymä
                    notifyItemRangeChanged(pos, contacts.size());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}