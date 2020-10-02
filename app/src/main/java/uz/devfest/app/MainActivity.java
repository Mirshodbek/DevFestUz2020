package uz.devfest.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    ConstraintLayout team, agenda, speakers, sponsors, faq, locate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);

        toolbar = findViewById(R.id.agendaToolbar);
        setSupportActionBar(toolbar);

        agendaClick();
        speakersClick();
        teamClick();
        sponsorsClick();
        faqClick();
        locateClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String text = "It is the best app in the world :)";
        switch (item.getItemId()) {
            case R.id.action_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void agendaClick() {
        agenda = findViewById(R.id.constraintAgenda);
        agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agenda = new Intent(MainActivity.this, AgendaActivity.class);
                startActivity(agenda);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });
    }

    private void speakersClick() {
        speakers = findViewById(R.id.constraintSpeaker);
        speakers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent speakers = new Intent(MainActivity.this, SpeakerActivity.class);
                startActivity(speakers);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });
    }

    private void teamClick() {
        team = findViewById(R.id.constraintTeam);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent team = new Intent(MainActivity.this, TeamActivity.class);
                startActivity(team);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });
    }

    private void sponsorsClick() {
        sponsors = findViewById(R.id.constraintSponsor);
        sponsors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sponsors = new Intent(MainActivity.this, SponsorsActivity.class);
                startActivity(sponsors);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });
    }

    private void faqClick() {
        faq = findViewById(R.id.constraintFAQ);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent faq = new Intent(MainActivity.this, ActivityFAQ.class);
                startActivity(faq);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });
    }

    private void locateClick() {
        locate = findViewById(R.id.constraintLocate);
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=Humo Arena");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });
    }
}