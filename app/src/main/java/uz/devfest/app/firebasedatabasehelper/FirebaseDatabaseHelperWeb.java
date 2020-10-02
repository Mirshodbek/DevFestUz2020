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

public class FirebaseDatabaseHelperWeb {
    private FirebaseDatabase db;
    private List<DevFest> devFests = new ArrayList<>();
    private Query query;

    public interface DataStatus {
        void DataIsLoad(List<DevFest> devFests, List<String> keys);
    }

    public FirebaseDatabaseHelperWeb() {
        db = FirebaseDatabase.getInstance();
        query = db.getReference("sessions").orderByChild("webTime").endAt(8).limitToLast(8);
    }

    public void readDevFestWeb(final FirebaseDatabaseHelperWeb.DataStatus dataStatus) {
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
