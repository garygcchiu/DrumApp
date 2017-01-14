package gary.drumapp;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;

import java.util.ArrayDeque; // faster tan LinkedList implementation of Queue
import java.util.Iterator;
import java.util.Queue;


public class MainActivity extends AppCompatActivity {

    // declare global variables
    Queue<Long> playbackQueue = new ArrayDeque<Long>(1000);
    long time;
    long elapsedTime;

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
        final SoundPool player = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);

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
        kick.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(kickSoundID, 1, 1, 8, 0, 1);
                elapsedTime = System.currentTimeMillis() - time;
                playbackQueue.add(elapsedTime);
                playbackQueue.add((long) kickSoundID);
                time = System.currentTimeMillis();
            }
        });

        snare.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(snareSoundID, 1, 1, 8, 0, 1);
                elapsedTime = System.currentTimeMillis() - time;
                playbackQueue.add(elapsedTime);
                playbackQueue.add((long) snareSoundID);
                time = System.currentTimeMillis();
            }
        });

        clap.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(clapSoundID, 1, 1, 8, 0, 1);
                elapsedTime = System.currentTimeMillis() - time;
                playbackQueue.add(elapsedTime);
                playbackQueue.add((long) clapSoundID);
                time = System.currentTimeMillis();
            }
        });

        hhat_o.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(hhatoSoundID, 1, 1, 8, 0, 1);
                elapsedTime = System.currentTimeMillis() - time;
                playbackQueue.add(elapsedTime);
                playbackQueue.add((long) hhatoSoundID);
                time = System.currentTimeMillis();
            }
        });

        bass.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(bassSoundID, 1, 1, 8, 0, 1);
                elapsedTime = System.currentTimeMillis() - time;
                playbackQueue.add(elapsedTime);
                playbackQueue.add((long) bassSoundID);
                time = System.currentTimeMillis();
            }
        });

        ride.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(rideSoundID, 1, 1, 8, 0, 1);
                elapsedTime = System.currentTimeMillis() - time;
                playbackQueue.add(elapsedTime);
                playbackQueue.add((long) rideSoundID);
            }
        });

        snap.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(snapSoundID, 1, 1, 8, 0, 1);
                elapsedTime = System.currentTimeMillis() - time;
                playbackQueue.add(elapsedTime);
                playbackQueue.add((long) snapSoundID);
                time = System.currentTimeMillis();
            }
        });

        hhat_c.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(hhatcSoundID, 1, 1, 8, 0, 1);
                elapsedTime = System.currentTimeMillis() - time;
                playbackQueue.add(elapsedTime);
                playbackQueue.add((long) hhatcSoundID);
                time = System.currentTimeMillis();
            }
        });

        // allow the user to record performances
        rec.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (rec.isChecked()) {
                    playbackQueue.clear();
                    Toast.makeText(MainActivity.this, getString(R.string.recording), Toast.LENGTH_SHORT).show();
                    time = System.currentTimeMillis();
                    Toast.makeText(MainActivity.this, "Starting time: " + time, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.not_recording), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Queue's size = " + playbackQueue.size(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        play.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (play.isChecked()){
                    long delay;
                    int beatID;
                    Iterator<Long> iter = playbackQueue.iterator();
                    while (iter.hasNext()) {
                        delay = iter.next();
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException ie) {
                            Toast.makeText(MainActivity.this, "CAUGHT EXCEPTION", Toast.LENGTH_SHORT).show();
                        }
                        beatID = iter.next().intValue();
                        player.play(beatID, 1, 1, 8, 0, 1);

                    }
                }
            }
        });


    }


}
