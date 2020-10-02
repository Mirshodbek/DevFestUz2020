package uz.devfest.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityFAQ extends AppCompatActivity {
    private Toolbar toolbar;

    private String[] mGroupsArray = new String[] { "How to participate in DevFest2020?", "How to start my DevFest2020 project?",
            "When is the deadline in the DevFest2020?", "What are there prizes in this tournament?" };

    private String[] firstAnswerArray = new String[] { "Firstly, you need to do registration in our website. Then automatically you can take part." };
    private String[] secondAnswerArray = new String[] { "You must look our requirements before starting. And then you can begin by it." };
    private String[] thirdAnswerArray = new String[] { "Deadline is in the second October." };
    private String[] fourthAnswerArray = new String[] { "In our tournament there aren't many prizes.But I think it isn't worthless for you. Prizes: SmartWatch, Watch, Bracelet" };


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);

        toolbar = findViewById(R.id.agendaToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back);

        Map<String, String> map;
        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();

        for (String group : mGroupsArray) {
            map = new HashMap<>();
            map.put("groupName", group);
            groupDataList.add(map);
        }

        String groupFrom[] = new String[]{"groupName"};
        int groupTo[] = new int[]{android.R.id.text1};

        ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();

        ArrayList<Map<String, String>> сhildDataItemList = new ArrayList<>();
        for (String question : firstAnswerArray) {
            map = new HashMap<>();
            map.put("questionName", question);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String question : secondAnswerArray) {
            map = new HashMap<>();
            map.put("questionName", question);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String question : thirdAnswerArray) {
            map = new HashMap<>();
            map.put("questionName", question);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        сhildDataItemList = new ArrayList<>();
        for (String question : fourthAnswerArray) {
            map = new HashMap<>();
            map.put("questionName", question);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        String childFrom[] = new String[]{"questionName"};
        int childTo[] = new int[]{android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groupDataList,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, сhildDataList, android.R.layout.simple_list_item_1,
                childFrom, childTo);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expListView);
        expandableListView.setAdapter(adapter);
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