package uz.devfest.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import uz.devfest.app.DevFest;
import uz.devfest.app.R;


public class CustomAdapter extends AppCompatActivity {
    private Context context;
    private DevFestAdapter adapter;

    public void setConfig(RecyclerView recyclerView, Context mContext, List<DevFest> devFests, List<String> keys) {
        context = mContext;
        adapter = new DevFestAdapter(devFests, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout expandableLayout, clickLayout;
        private TextView title;
        private TextView speaker;
        private TextView description;
        private TextView time;
        private TextView startTime;
        private TextView complexity;
        private TextView complexityView;
        private TextView language;
        private TextView languageView;
        private TextView presentation;
        private ImageView image;
        private TextView videoId;
        private TextView date;
        private TextView share;
        private String key;

        public MyViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(context).inflate(R.layout.item_layouts, parent, false));
            title = itemView.findViewById(R.id.title);
            speaker = itemView.findViewById(R.id.speakerEvent);
            description = itemView.findViewById(R.id.description);
            complexity = itemView.findViewById(R.id.complexity);
            complexityView = itemView.findViewById(R.id.complexityView);
            language = itemView.findViewById(R.id.language);
            languageView = itemView.findViewById(R.id.languageView);
            startTime = itemView.findViewById(R.id.startTime);
            time = itemView.findViewById(R.id.time);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.avatar);
            presentation = itemView.findViewById(R.id.presentation);
            videoId = itemView.findViewById(R.id.videoId);
            share = itemView.findViewById(R.id.share);

            clickLayout = itemView.findViewById(R.id.clickLayout);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
        }

        public void bind(final DevFest devFest, String key) {
            startTime.setText(devFest.getStartTime());
            time.setText(devFest.getTime());
            date.setText(devFest.getDate());
            title.setText(devFest.getTitle());
            speaker.setText(devFest.getSpeaker());
            String sp = speaker.getText().toString();
            if (TextUtils.isEmpty(sp)) {
                speaker.setVisibility(View.GONE);
            }
            description.setText(devFest.getDescription());
            complexity.setText(devFest.getComplexity());
            String comp = complexity.getText().toString();
            if (TextUtils.isEmpty(comp)) {
                complexityView.setVisibility(View.GONE);
            }
            language.setText(devFest.getLanguage());
            String lang = language.getText().toString();
            if (TextUtils.isEmpty(lang)) {
                languageView.setVisibility(View.GONE);
            }
            Picasso.get().load(devFest.getImage()).into(image);
            boolean isExpended = devFest.isExpanded();
            expandableLayout.setVisibility(isExpended ? View.VISIBLE : View.GONE);
            clickLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    devFest.setExpanded(!devFest.isExpanded());
                    adapter.notifyItemChanged(getAdapterPosition());
                }
            });
            final String all = "Theme: " + devFest.getTitle() + ".\nSpeaker: " + devFest.getSpeaker() + ".\nTime: "
                    + devFest.getStartTime() + " " + devFest.getDate() + "\nDescription: " + devFest.getDescription();
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_TEXT, all);
                    context.startActivity(i);
                }
            });
            final String presentationUrl = devFest.getPresentation();
            if (TextUtils.isEmpty(presentationUrl)) {
                return;
            }
            presentation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(presentationUrl));
                    context.startActivity(intent);
                }
            });
            String videoIdUrl = devFest.getVideoId();
            if (TextUtils.isEmpty(videoIdUrl)) {
                return;
            }
            videoId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent videoId = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/#q="));
                    context.startActivity(videoId);
                }
            });
        }

    }

    class DevFestAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<DevFest> devFestList;
        private List<String> mKeys;

        public DevFestAdapter(List<DevFest> devFestList, List<String> mKeys) {
            this.devFestList = devFestList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.bind(devFestList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return devFestList.size();
        }
    }
}
