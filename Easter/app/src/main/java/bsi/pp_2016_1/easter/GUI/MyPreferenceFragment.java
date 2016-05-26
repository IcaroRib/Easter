package bsi.pp_2016_1.easter.GUI;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 26/05/2016.
 */
public class MyPreferenceFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.fragment_preference);
    }
}
