package uz.devfest.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;


import uz.devfest.app.adapter.SponsorsAdapter;

public class SponsorsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);

        toolbar = findViewById(R.id.agendaToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back);
        recyclerView = findViewById(R.id.recycler_sponsors);

        String[] sponsors = new String[Sponsors.sponsors.length];
        for (int i = 0; i < sponsors.length; i++) {
            sponsors[i] = Sponsors.sponsors[i].getNameSponsor();
        }
        String[] descriptionSponsors = new String[Sponsors.sponsors.length];
        for (int i = 0; i < sponsors.length; i++) {
            descriptionSponsors[i] = Sponsors.sponsors[i].getDescriptionSponsor();
        }
        int[] imageSponsors = new int[Sponsors.sponsors.length];
        for (int i = 0; i < imageSponsors.length; i++) {
            imageSponsors[i] = Sponsors.sponsors[i].getImageSponsor();
        }
        SponsorsAdapter adapter = new SponsorsAdapter(sponsors, descriptionSponsors, imageSponsors);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setListener(new SponsorsAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}