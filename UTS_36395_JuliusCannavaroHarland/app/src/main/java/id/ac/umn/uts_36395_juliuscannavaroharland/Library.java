package id.ac.umn.uts_36395_juliuscannavaroharland;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;

public class Library extends AppCompatActivity {
    public LinkedList<SourceLagu> daftarLagu = new LinkedList<>();
    DaftarLaguAdapter mAdapter;
    RecyclerView rvDaftarLagu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Bundle extras = getIntent().getExtras();
        String username = extras.getString("Username");
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(username);

        Context context = getApplicationContext();
        CharSequence text = "Selamat datang, "+username;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        isiDaftarLagu();

        rvDaftarLagu = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarLaguAdapter(this, daftarLagu);
        rvDaftarLagu.setAdapter(mAdapter);
        rvDaftarLagu.setLayoutManager(new LinearLayoutManager(this));

    }

    public void isiDaftarLagu(){
        daftarLagu.add(new SourceLagu("Ding Ding Ding",
                "Ding Ding Ding SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.dingdingding));
        daftarLagu.add(new SourceLagu("Absolutely Perfect",
                "Absolutely Perfect SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.absolutelyperfect));
        daftarLagu.add(new SourceLagu("BOOM! ",
                "You Know Whats Cooking ? SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.youknowwhatscookingboom));
        daftarLagu.add(new SourceLagu("Etwiyola",
                "Etwiyola SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.etwiyola));
        daftarLagu.add(new SourceLagu("Lakad Matatag",
                "Lakad Matatag SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.lakadmatatag));
        daftarLagu.add(new SourceLagu("Nakupuu",
                "Nakupuu SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.nakupuu));
        daftarLagu.add(new SourceLagu("Fast Small Sweep",
                "Fast Small Sweep SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.fastsmallsweep));
        daftarLagu.add(new SourceLagu(
                "Arcade Retro Game",
                "Arcade Retro Game SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.arcaderetrogame));
        daftarLagu.add(new SourceLagu("Cricket Sand Insects",
                "Cricket Sand Insects SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.cricketsandinsectsinthewild));
        daftarLagu.add(new SourceLagu("Dog Barking Twice",
                "Dog Barking Twice SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.dogbarkingtwice));
        daftarLagu.add(new SourceLagu("Fast Rocket Whoosh",
                "Fast Rocket Whoosh SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.fastrocketwhoosh));
        daftarLagu.add(new SourceLagu("Emergency Alarm",
                "Emergency Alarm SFX",
                "android.resource://" +getPackageName() + "/"+
                        R.raw.emergencyalarm));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent profileView = new Intent(Library.this, Profile.class);
                startActivity(profileView);
                return true;
            case R.id.logout:
                Intent mainView = new Intent(Library.this, MainActivity.class);
                startActivity(mainView);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}