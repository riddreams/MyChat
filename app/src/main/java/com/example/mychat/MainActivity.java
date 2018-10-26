package com.example.mychat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView chat = (ListView)findViewById(R.id.chat);
        final String[] chatNames = {"ylw","xh","ljw"};
        String[] chatDesc = {"哈哈哈哈哈","去去去去去","呃呃呃呃呃"};
        int[] chatImages = new int[]{R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
        List<Map<String,Object>> listItems = new ArrayList<>();
        for(int i=0;i<chatNames.length;i++){
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("header",chatImages[i]);
            listItem.put("name",chatNames[i]);
            listItem.put("desc",chatDesc[i]);
            listItems.add(listItem);

        }
        SimpleAdapter chatAdapter = new SimpleAdapter(this,listItems,R.layout.item_main,
                new String[]{"header","name","desc"},
                new int[] {R.id.header,R.id.name,R.id.desc});
        chat.setAdapter(chatAdapter);

        chat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = chatNames[position];
                Intent intent = new Intent(MainActivity.this,ChatActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
