package com.bignerdranch.android.criminalintent;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stevecho on 2013-11-21.
 */
public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> mCrimes;
    private static final String TAG = "CrimeListFragment";
    private static final int REQUEST_CRIME = 1;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
        Log.d(TAG, c.getTitle() + " was clicked ************************** >>>>>>>>>>>>>>>>>>>>>>>>>>");


        Intent i = new Intent(getActivity(), CrimePagerActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
        startActivity(i);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CRIME) {
            Log.d(TAG, "Should do something");
        }
    }

    private class CrimeAdapter extends ArrayAdapter<Crime> {

        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_crime, null);
            }

            Crime c = getItem(position);

            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());

            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
//            Log.d(TAG, R.id.crime_list_item_dateTextView);
            Log.d(TAG, "Crime is " + c);
            dateTextView.setText(c.getDate().toString());
            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());
            return convertView;
        }
    }
}