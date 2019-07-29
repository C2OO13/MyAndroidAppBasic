package c2oo13.learn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b2=findViewById(R.id.button2);
        b1= findViewById(R.id.button);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cnt++;
        
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("cnt",cnt);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cnt= (int) savedInstanceState.getInt(String.valueOf(cnt));
    }

    public void dothis (View v)
    {

        if (b2.getVisibility()==View.INVISIBLE)
        {
            Log.d("TRY","Button 1 was clicked"+cnt);
            b2.setVisibility(View.VISIBLE);
            b1.setVisibility(View.INVISIBLE);
        }
        else
        {
            Log.d("TRY","Button 2 was clicked"+cnt);
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.INVISIBLE);

        }
    }

    public void gotoactivityb(View v)
    {
        Intent i=new Intent(this,ActivityB.class);
        startActivity(i);
    }

    public void launchmaps(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:21.292,73.018"));
        Intent chooser_list=Intent.createChooser(i,"Launch Maps");
        startActivity(chooser_list);
    }

    public void email(View v)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        String [] send_to={"smitpat2000@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL,send_to);
        i.putExtra(Intent.EXTRA_SUBJECT,"Hi,SMIT app here");
        i.putExtra(Intent.EXTRA_TEXT,"YUP,lets send the mail,plz select a application to continue.");
        i.setType("message/rfc822");
        Intent chooser_list=Intent.createChooser(i,"SEND EMAIL");
        startActivity(chooser_list);

    }
}
