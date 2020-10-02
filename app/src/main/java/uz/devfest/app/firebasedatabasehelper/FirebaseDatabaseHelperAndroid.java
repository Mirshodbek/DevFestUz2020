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

public class FirebaseDatabaseHelperAndroid {
    private FirebaseDatabase db;
    private List<DevFest> devFests = new ArrayList<>();
    private Query query;

    public interface DataStatus {
        void DataIsLoad(List<DevFest> devFests, List<String> keys);
    }

    public FirebaseDatabaseHelperAndroid() {
        db = FirebaseDatabase.getInstance();
        query = db.getReference("sessions").orderByChild("androidTime").endAt(15).limitToLast(15);
    }

    public void readDevFestAndroid(final FirebaseDatabaseHelperAndroid.DataStatus dataStatus) {
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
                dataStatus.DataIsLoad(devFests, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
