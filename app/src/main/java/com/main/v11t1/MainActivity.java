package com.main.v11t1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView contactListRV;
    private ContactListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactListRV = findViewById(R.id.ListContactsRV);
        contactListRV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactListAdapter(this, ContactStorage.getInstance().getContacts());
        contactListRV.setAdapter(adapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();
        adapter = new ContactListAdapter(this, ContactStorage.getInstance().getContacts());
        contactListRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void openAddContactActivity(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }

    public void sortAlphabetically(View view) {
        ContactStorage.getInstance().sortAlphabetically();
        adapter.notifyDataSetChanged();
    }

    public void sortByGroup(View view) {
        ContactStorage.getInstance().sortByGroup();
        adapter.notifyDataSetChanged();
    }

}