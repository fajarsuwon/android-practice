package com.bignerdranch.android.criminalintent;

import android.app.Fragment;

/**
 * Created by steve on 2/6/2014.
 */
public class CrimeCameraActivity extends SingleFragmentActivity {
    @Override
    protected android.support.v4.app.Fragment createFragment() {
        return new CrimeCameraFragment();
    }
}
