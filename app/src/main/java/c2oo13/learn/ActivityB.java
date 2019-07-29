package c2oo13.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView l;
    Button b;
    String[] names={"Smit","Parth","ABC","DEF","GHI","Smit","Parth","ABC","DEF","GHI","Smit","Parth","ABC","DEF","GHI"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        b=findViewById(R.id.button3);
        l=findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);
    }

    public void gotomainactivity(View v)
    {
        Intent i;
        i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView t= (TextView) view;
        Toast.makeText(this,t.getText()+" is clicked with it's number as: "+(i) ,Toast.LENGTH_SHORT).show();
    }
}
