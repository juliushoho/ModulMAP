package id.ac.umn.uts_36395_juliuscannavaroharland;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailLaguActivity extends AppCompatActivity {
    private TextView etJudul;
    private TextView etKeterangan;
    private Button playLagu;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lagu);
        etJudul = (TextView) findViewById(R.id.etJudul);
        etKeterangan = (TextView) findViewById(R.id.etKeterangan);
        playLagu = (Button) findViewById(R.id.playSFX);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Bundle extras = getIntent().getExtras();
        String username = extras.getString("Judul");
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(username);
        SourceLagu sv = (SourceLagu) bundle.getSerializable("DetailLagu");
        etJudul.setText(sv.getJudul());
        etKeterangan.setText(sv.getKeterangan());

        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, Uri.parse(sv.getLaguURI()));
        }

        playLagu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        mediaPlayer.release();
        this.finish();
    }
}