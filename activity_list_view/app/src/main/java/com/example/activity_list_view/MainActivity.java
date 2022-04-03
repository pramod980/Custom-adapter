package com.example.activity_list_view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String arrname[]={"Banana","Pineapple","Papaya","Strawberry","Pineapple","Papaya","Strawberry","Pineapple","Papaya","Strawberry"};
    int arrimage[]={R.drawable.banana,R.drawable.pineapple,R.drawable.papaya,R.drawable.strawberry,R.drawable.pineapple,R.drawable.papaya,R.drawable.strawberry,R.drawable.pineapple,R.drawable.papaya,R.drawable.strawberry};
    String arrmessage[]={"I am fruit","I am fruit too","I am also fruit","I am nothing","I am fruit too","I am also fruit","I am nothing","I am fruit too","I am also fruit","I am nothing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        myadapter adapter=new myadapter(this,arrname,arrmessage,arrimage);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(MainActivity.this,user_image.class);

                intent.putExtra("image",arrname[position]);
                intent.putExtra("message",arrmessage[position]);
                intent.putExtra("image",arrimage[position]);
                startActivity(intent);
            }
        });
    }

    class myadapter extends ArrayAdapter<String>
    {
        Context context;
        String rname[];
        String rmsg[];
        int rimg[];

        public myadapter( Context context, String[] rname, String[] rmsg, int[] rimg) {
            super(context, R.layout.row, R.id.imageView, rname);
            this.rname = rname;
            this.rmsg = rmsg;
            this.rimg = rimg;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.row,parent,false);
            CircleImageView img=view.findViewById(R.id.imageView);
            TextView username=view.findViewById(R.id.name);
            TextView usermessage=view.findViewById(R.id.message);
            usermessage.setText(rname[position]);
            usermessage.setText(rmsg[position]);
            img.setImageResource(rimg[position]);
            return view;
        }
    }
}