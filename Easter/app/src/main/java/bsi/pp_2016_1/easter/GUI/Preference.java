package bsi.pp_2016_1.easter.GUI;

import android.preference.PreferenceActivity;

import java.util.List;

import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 26/05/2016.
 */
public class Preference extends PreferenceActivity {
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.fragment_preference, target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return Preference.class.getName().equals(fragmentName);
    }
}
