package uz.devfest.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

import uz.devfest.app.DevFest;
import uz.devfest.app.R;

public class SpeakerAdapter {
    private Context context;
    private DevFestSpeakerAdapter adapter;

    public void setConfig(RecyclerView recyclerView, Context mContext, List<DevFest> devFests, List<String> keys) {
        context = mContext;
        adapter = new DevFestSpeakerAdapter(devFests, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);
    }

    class MyViewSpeakerHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout constraintLayout;
        private ImageView photoUrl;
        private TextView name;
        private TextView title;
        private TextView shortBio;
        private TextView company;
        private TextView country;
        private ImageButton twitter;
        private ImageButton linkedIn;
        private ImageButton github;
        private ImageButton facebook;
        private ImageButton website;

        public MyViewSpeakerHolder(ViewGroup parent) {
            super(LayoutInflater.from(context).inflate(R.layout.item_layout_speakers, parent, false));
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            shortBio = itemView.findViewById(R.id.shortBio);
            photoUrl = itemView.findViewById(R.id.avatar);
            company = itemView.findViewById(R.id.companyName);
            country = itemView.findViewById(R.id.countryName);
            twitter = itemView.findViewById(R.id.twitter);
            linkedIn = itemView.findViewById(R.id.linkedId);
            github = itemView.findViewById(R.id.github);
            facebook = itemView.findViewById(R.id.facebook);
            website = itemView.findViewById(R.id.website);
        }

        public void bind(final DevFest devFest, String key) {
            Picasso.get().load(devFest.getPhotoUrl()).into(photoUrl);
            constraintLayout.setVisibility(View.GONE);
            name.setText(devFest.getName());
            title.setText(devFest.getTitle());
            company.setText(devFest.getCompany());
            country.setText(devFest.getCountry());
            shortBio.setText(devFest.getShortBio());
            shortBio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    shortBio.setText(devFest.getBio());
                    constraintLayout.setVisibility(View.VISIBLE);
                }
            });
            final String twitterLink = devFest.getTwitter();
            if (TextUtils.isEmpty(twitterLink)) {
                twitter.setVisibility(View.GONE);
            }
            twitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent twitter = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterLink));
                    context.startActivity(twitter);
                }
            });
            final String linkedInLink = devFest.getLinkedin();
            if (TextUtils.isEmpty(linkedInLink)) {
                linkedIn.setVisibility(View.GONE);
            }
            linkedIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent twitter = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInLink));
                    context.startActivity(twitter);
                }
            });
            final String githubLink = devFest.getGithub();
            if (TextUtils.isEmpty(githubLink)) {
                github.setVisibility(View.GONE);
            }
            github.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent twitter = new Intent(Intent.ACTION_VIEW, Uri.parse(githubLink));
                    context.startActivity(twitter);
                }
            });
            final String facebookLink = devFest.getFacebook();
            if (TextUtils.isEmpty(facebookLink)) {
                facebook.setVisibility(View.GONE);
            }
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent facebook = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookLink));
                    context.startActivity(facebook);
                }
            });
            final String websiteLink = devFest.getWebsite();
            if (TextUtils.isEmpty(websiteLink)) {
                website.setVisibility(View.GONE);
            }
            website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteLink));
                    context.startActivity(website);
                }
            });

        }
    }

    class DevFestSpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.MyViewSpeakerHolder> {
        private List<DevFest> devFestList;
        private List<String> mKeys;

        public DevFestSpeakerAdapter(List<DevFest> devFestList, List<String> mKeys) {
            this.devFestList = devFestList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public MyViewSpeakerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewSpeakerHolder(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewSpeakerHolder holder, int position) {
            holder.bind(devFestList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return devFestList.size();
        }
    }
}
