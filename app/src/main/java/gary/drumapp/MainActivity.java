package gary.drumapp;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque; // faster tan LinkedList implementation of Queue
import java.util.Iterator;
import java.util.Queue;


public class MainActivity extends AppCompatActivity {

    // declare global variables
    Queue<Long> playbackQueue = new ArrayDeque<Long>(1000);
    long time;
    long elapsedTime;
    Uri uri;
    int kickSoundID, snareSoundID, clapSoundID, hhatoSoundID, bassSoundID, rideSoundID, snapSoundID, hhatcSoundID;

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
        final Button play = (Button) findViewById(R.id.button_play);
        final Button reset = (Button) findViewById(R.id.button_reset);

        // array to link soundIDs : buttons
        final Button[] array = new Button[8];
        array[0] = kick;
        array[1] = snare;
        array[2] = clap;
        array[3] = hhat_o;
        array[4] = bass;
        array[5] = ride;
        array[6] = snap;
        array[7] = hhat_c;

        // create SoundPool object to handle playback
        final SoundPool player = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);

        // load default audio into the pool
        kickSoundID = player.load(this, R.raw.default_kick, 1);
        snareSoundID = player.load(this, R.raw.default_snare, 1);
        clapSoundID = player.load(this, R.raw.default_clap, 1);
        hhatoSoundID = player.load(this, R.raw.default_hhato, 1);
        bassSoundID = player.load(this, R.raw.default_bass, 1);
        rideSoundID = player.load(this, R.raw.default_ride, 1);
        snapSoundID = player.load(this, R.raw.default_snap, 1);
        hhatcSoundID = player.load(this, R.raw.default_hhatc, 1);

        // create onClickListeners to play sound when button clicked
        kick.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(kickSoundID, 1, 1, 8, 0, 1);
                if (rec.isChecked()) {
                    elapsedTime = System.currentTimeMillis() - time;
                    playbackQueue.add(elapsedTime);
                    playbackQueue.add((long) kickSoundID);
                    time = System.currentTimeMillis();
                }
            }
        });

        snare.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(snareSoundID, 1, 1, 8, 0, 1);
                if (rec.isChecked()) {
                    elapsedTime = System.currentTimeMillis() - time;
                    playbackQueue.add(elapsedTime);
                    playbackQueue.add((long) snareSoundID);
                    time = System.currentTimeMillis();
                }
            }
        });

        clap.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(clapSoundID, 1, 1, 8, 0, 1);
                if (rec.isChecked()) {
                    elapsedTime = System.currentTimeMillis() - time;
                    playbackQueue.add(elapsedTime);
                    playbackQueue.add((long) clapSoundID);
                    time = System.currentTimeMillis();
                }
            }
        });

        hhat_o.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(hhatoSoundID, 1, 1, 8, 0, 1);
                if (rec.isChecked()) {
                    elapsedTime = System.currentTimeMillis() - time;
                    playbackQueue.add(elapsedTime);
                    playbackQueue.add((long) hhatoSoundID);
                    time = System.currentTimeMillis();
                }
            }
        });

        bass.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(bassSoundID, 1, 1, 8, 0, 1);
                if (rec.isChecked()) {
                    elapsedTime = System.currentTimeMillis() - time;
                    playbackQueue.add(elapsedTime);
                    playbackQueue.add((long) bassSoundID);
                    time = System.currentTimeMillis();
                }
            }
        });

        ride.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(rideSoundID, 1, 1, 8, 0, 1);
                if (rec.isChecked()) {
                    elapsedTime = System.currentTimeMillis() - time;
                    playbackQueue.add(elapsedTime);
                    playbackQueue.add((long) rideSoundID);
                }
            }
        });

        snap.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(snapSoundID, 1, 1, 8, 0, 1);
                if (rec.isChecked()) {
                    elapsedTime = System.currentTimeMillis() - time;
                    playbackQueue.add(elapsedTime);
                    playbackQueue.add((long) snapSoundID);
                    time = System.currentTimeMillis();
                }
            }
        });

        hhat_c.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                player.play(hhatcSoundID, 1, 1, 8, 0, 1);
                if (rec.isChecked()) {
                    elapsedTime = System.currentTimeMillis() - time;
                    playbackQueue.add(elapsedTime);
                    playbackQueue.add((long) hhatcSoundID);
                    time = System.currentTimeMillis();
                }
            }
        });

        // allow the user to record performances
        rec.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (rec.isChecked()) {
                    playbackQueue.clear();
                    Toast.makeText(MainActivity.this, getString(R.string.recording), Toast.LENGTH_SHORT).show();
                    time = System.currentTimeMillis();
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.not_recording), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // playback recording: iterate through queue
        play.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (!playbackQueue.isEmpty()) {
                    long delay;
                    int beatID;
                    Iterator<Long> iter = playbackQueue.iterator();
                    while (iter.hasNext()) {
                        delay = iter.next();
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException ie) {
                            // skip exception
                        }
                        beatID = iter.next().intValue();
                        array[beatID - 1].performClick();
                    }
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.no_record_saved), Toast.LENGTH_SHORT).show();
                    showFileChooser();
                }
            }
        });

        // reset to default sound clips
        reset.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                kickSoundID = player.load(MainActivity.this, R.raw.default_kick, 1);
                snareSoundID = player.load(MainActivity.this, R.raw.default_snare, 1);
                clapSoundID = player.load(MainActivity.this, R.raw.default_clap, 1);
                hhatoSoundID = player.load(MainActivity.this, R.raw.default_hhato, 1);
                bassSoundID = player.load(MainActivity.this, R.raw.default_bass, 1);
                rideSoundID = player.load(MainActivity.this, R.raw.default_ride, 1);
                snapSoundID = player.load(MainActivity.this, R.raw.default_snap, 1);
                hhatcSoundID = player.load(MainActivity.this, R.raw.default_hhatc, 1);
            }
        });

        // create onLongClick listeners to allow user to choose clips when buttons are held
        kick.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                showFileChooser();
                //File newClip = new File(uri.toString());
                kickSoundID = player.load(MainActivity.this, R.raw.new_clip, 1);
                return false;
            }
        });

        snare.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                showFileChooser();
                return false;
            }
        });
    }

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        try {
            startActivityForResult(
                    Intent.createChooser(intent, getString(R.string.open_file)),
                    0);
        } catch (android.content.ActivityNotFoundException ex) {
            // potentially direct the user to app store
            Toast.makeText(MainActivity.this, getString(R.string.no_file_manager),
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 0:
                if (resultCode == Activity.RESULT_OK) {
                    // get the Uri of the selected file
                    uri = data.getData();
                    // copy file to raw, name it new_clip.wav
                    File source = new File(uri.getPath());

                    Toast.makeText(MainActivity.this, source.getAbsolutePath(),
                            Toast.LENGTH_LONG).show();

                    File destination = new File("android.resource://" + getPackageName() + "/raw/new_clip.wav");

                    Toast.makeText(MainActivity.this, destination.getAbsolutePath(),
                            Toast.LENGTH_LONG).show();

                    try {
                        copy(source, destination);
                    } catch (IOException e) {
                        // IOException
                    }

                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static void copy(File sourceLocation, File targetLocation)
            throws IOException {

        InputStream in = new FileInputStream(sourceLocation);
        OutputStream out = new FileOutputStream(targetLocation);

        // Copy the bits from instream to outstream
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

}


