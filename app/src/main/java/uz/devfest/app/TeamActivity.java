package uz.devfest.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import uz.devfest.app.adapter.SpeakerAdapter;
import uz.devfest.app.firebasedatabasehelper.FirebaseDatabaseHelperTeam;

public class TeamActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ProgressBar progressBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_and_team);

        toolbar = findViewById(R.id.agendaToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back);

        mRecyclerView = findViewById(R.id.recycler_speaker_and_team);
        new FirebaseDatabaseHelperTeam().readDevFest(new FirebaseDatabaseHelperTeam.DataStatus() {
            @Override
            public void DataIsLoaded(List<DevFest> devFests, List<String> keys) {
                progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.GONE);
                new SpeakerAdapter().setConfig(mRecyclerView, TeamActivity.this, devFests, keys);
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