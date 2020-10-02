package uz.devfest.app.firebasedatabasehelper;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import uz.devfest.app.DevFest;

public class FirebaseDatabaseHelperSpeaker {
    private FirebaseDatabase db;
    private DatabaseReference reference;
    private List<DevFest> devFests = new ArrayList<>();

    public interface DataStatus {
        void DataIsLoaded(List<DevFest> devFests, List<String> keys);
    }

    public FirebaseDatabaseHelperSpeaker() {
        db = FirebaseDatabase.getInstance("https://first-app-42a55.firebaseio.com/");
        reference = db.getReference("speakers");
    }

    public void readDevFest(final DataStatus dataStatus) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                devFests.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    DevFest devFest = keyNode.getValue(DevFest.class);
                    devFests.add(devFest);
                }
                dataStatus.DataIsLoaded(devFests, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
