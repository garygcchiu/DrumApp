package gary.drumapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;

import static android.media.AudioManager.STREAM_MUSIC;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declare the appropriate buttons
        final Button kick = (Button) findViewById(R.id.button_kick);
        final Button snare = (Button) findViewById(R.id.button_snare);
        final Button clap = (Button) findViewById(R.id.button_clap);
        final Button hhat_o = (Button) findViewById(R.id.button_hhat_o);

        final Button bass = (Button) findViewById(R.id.button_bass);
        final Button ride = (Button) findViewById(R.id.button_ride);
        final Button snap = (Button) findViewById(R.id.button_snap);
        final Button hhat_c = (Button) findViewById(R.id.button_hhat_c);

        final ToggleButton rec = (ToggleButton) findViewById(R.id.button_rec);
        final ToggleButton play = (ToggleButton) findViewById(R.id.button_play);

        // create SoundPool object to handle playback
        final SoundPool player = new SoundPool(8, AudioManager.STREAM_MUSIC,  0);

        // load audio into the pool
        final int kickSoundID = player.load(this, R.raw.kick, 1);
        final int snareSoundID = player.load(this, R.raw.snare, 1);
        final int clapSoundID = player.load(this, R.raw.clap, 1);
        final int hhatoSoundID = player.load(this, R.raw.hhato, 1);
        final int bassSoundID = player.load(this, R.raw.bass, 1);
        final int rideSoundID = player.load(this, R.raw.ride, 1);
        final int snapSoundID = player.load(this, R.raw.snap, 1);
        final int hhatcSoundID = player.load(this, R.raw.hhatc, 1);

        // create onClickListeners to play sound when button clicked
        kick.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                player.play(kickSoundID, 1, 1, 8, 0, 1);
            }
        });

        snare.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                player.play(snareSoundID, 1, 1, 8, 0, 1);
            }
        });

        clap.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                player.play(clapSoundID, 1, 1, 8, 0, 1);
            }
        });

        hhat_o.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                player.play(hhatoSoundID, 1, 1, 8, 0, 1);
            }
        });

        bass.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                player.play(bassSoundID, 1, 1, 8, 0, 1);
            }
        });

        ride.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                player.play(rideSoundID, 1, 1, 8, 0, 1);
            }
        });

        snap.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                player.play(snapSoundID, 1, 1, 8, 0, 1);
            }
        });

        hhat_c.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                player.play(hhatcSoundID, 1, 1, 8, 0, 1);
            }
        });




    }





}
