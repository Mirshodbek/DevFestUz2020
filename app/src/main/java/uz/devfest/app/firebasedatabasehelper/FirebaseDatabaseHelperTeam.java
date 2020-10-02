package uz.devfest.app.firebasedatabasehelper;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import uz.devfest.app.DevFest;

public class FirebaseDatabaseHelperTeam {
    private FirebaseDatabase db;
    private Query query;
    private List<DevFest> devFests = new ArrayList<>();

    public interface DataStatus {
        void DataIsLoaded(List<DevFest> devFests, List<String> keys);
    }

    public FirebaseDatabaseHelperTeam() {
        db = FirebaseDatabase.getInstance("https://first-app-42a55.firebaseio.com/");
        query = db.getReference("speakers").orderByChild("badges/0/name").equalTo("gdg");
    }

    public void readDevFest(final FirebaseDatabaseHelperTeam.DataStatus dataStatus) {
        query.addValueEventListener(new ValueEventListener() {
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
