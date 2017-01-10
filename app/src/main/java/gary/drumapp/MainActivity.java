package gary.drumapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button kick = (Button) findViewById(R.id.button_kick);
        Button snare = (Button) findViewById(R.id.button_snare);
        Button clap = (Button) findViewById(R.id.button_clap);
        Button hhat_o = (Button) findViewById(R.id.button_hhat_o);

        Button bass = (Button) findViewById(R.id.button_bass);
        Button ride = (Button) findViewById(R.id.button_ride);
        Button crash = (Button) findViewById(R.id.button_crash);
        Button hhat_c = (Button) findViewById(R.id.button_hhat_c);

        ToggleButton rec = (ToggleButton) findViewById(R.id.button_rec);
        ToggleButton play = (ToggleButton) findViewById(R.id.button_play);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.kick);

        kick.setOnClickListener(new OnClickListener(){

            public void onClick(View v){
                mp.start();
            }
        });


    }





}
