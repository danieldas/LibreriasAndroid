package com.das.daniel.emojicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.rockerhieu.emojicon.EmojiconEditText;
import com.rockerhieu.emojicon.EmojiconGridFragment;
import com.rockerhieu.emojicon.EmojiconTextView;
import com.rockerhieu.emojicon.EmojiconsFragment;
import com.rockerhieu.emojicon.emoji.Emojicon;


public class MainActivity extends AppCompatActivity implements EmojiconGridFragment.OnEmojiconClickedListener,
        EmojiconsFragment.OnEmojiconBackspaceClickedListener {

    EmojiconEditText _etEmojicon;
    EmojiconTextView _tvEmojicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// inicializando EmojicobEditText y EmojiconTextView.
        _etEmojicon = (EmojiconEditText) findViewById(R.id.etEmojicon);
        _tvEmojicon = (EmojiconTextView) findViewById(R.id.tvEmojicon);

        _etEmojicon.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                _tvEmojicon.setText(s);
            }
        });

        setEmojiconFragment(false);

    }

    /**
     * Set the Emoticons in Fragment.
     * @param useSystemDefault
     */
    private void setEmojiconFragment(boolean useSystemDefault) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.emojicons, EmojiconsFragment.newInstance(useSystemDefault))
                .commit();
    }

    /**
     * It called, when click on icon of Emoticons.
     * @param emojicon
     */
    @Override
    public void onEmojiconClicked(Emojicon emojicon) {

        EmojiconsFragment.input(_etEmojicon, emojicon);
    }

    /**
     * It called, when backspace button of Emoticons pressed
     * @param view
     */
    @Override
    public void onEmojiconBackspaceClicked(View view) {

        EmojiconsFragment.backspace(_etEmojicon);
    }
}
