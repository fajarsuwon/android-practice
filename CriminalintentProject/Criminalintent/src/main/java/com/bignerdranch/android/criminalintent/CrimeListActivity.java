package com.bignerdranch.android.criminalintent;


import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by stevecho on 2013-11-21.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}