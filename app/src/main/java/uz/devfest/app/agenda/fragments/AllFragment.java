package uz.devfest.app.agenda.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.client.Firebase;

import java.util.List;

import uz.devfest.app.DevFest;
import uz.devfest.app.R;
import uz.devfest.app.adapter.CustomAdapter;
import uz.devfest.app.firebasedatabasehelper.FirebaseDatabaseHelperSessions;


public class AllFragment extends Fragment {
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.agenda_fragment, container, false);
        Firebase.setAndroidContext((getContext()));
        mRecyclerView = view.findViewById(R.id.recycler_view);
        new FirebaseDatabaseHelperSessions().readDevFest(new FirebaseDatabaseHelperSessions.DataStatus() {
            @Override
            public void DataIsLoaded(List<DevFest> devFest, List<String> keys) {
                view.findViewById(R.id.progressBar).setVisibility(View.GONE);
                new CustomAdapter().setConfig(mRecyclerView, getContext(), devFest, keys);
            }
        });
        return view;
    }
}
