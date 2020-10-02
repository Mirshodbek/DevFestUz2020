package uz.devfest.app.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import uz.devfest.app.R;

public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.MyViewSponsorsHolder> {
    private Listener listener;
    private String[] nameSponsors;
    private String[] descriptionSponsors;
    private int[] imageSponsors;

    public interface Listener {
        void onClick(int position);
    }

    public static class MyViewSponsorsHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout constraintLayout;

        public MyViewSponsorsHolder(ConstraintLayout parent) {
            super(parent);
            constraintLayout = parent;
        }
    }

    public SponsorsAdapter(String[] nameSponsors, String[] descriptionSponsors, int[] imageSponsors) {
        this.nameSponsors = nameSponsors;
        this.descriptionSponsors = descriptionSponsors;
        this.imageSponsors = imageSponsors;
    }

    @NonNull
    @Override
    public MyViewSponsorsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_sponsor, parent, false);
        return new MyViewSponsorsHolder(constraintLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewSponsorsHolder holder, final int position) {
        ConstraintLayout constraintLayout = holder.constraintLayout;
        CardView cardView = constraintLayout.findViewById(R.id.card_view);
        ImageFilterView imageFilterView = cardView.findViewById(R.id.image);
        Drawable drawable = ContextCompat.getDrawable(constraintLayout.getContext(), imageSponsors[position]);
        imageFilterView.setImageDrawable(drawable);
        TextView sponsors = constraintLayout.findViewById(R.id.sponsors);
        sponsors.setText(nameSponsors[position]);
        TextView sponsorsPosition = constraintLayout.findViewById(R.id.sponsorsPosition);
        sponsorsPosition.setText(descriptionSponsors[position]);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameSponsors.length;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
