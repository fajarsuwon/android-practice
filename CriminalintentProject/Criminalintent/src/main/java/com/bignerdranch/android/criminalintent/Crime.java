package com.bignerdranch.android.criminalintent;

import java.util.UUID;
import java.util.Date;

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;


    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }


    public UUID getmId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Crime() {
        mId = UUID.randomUUID();
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}