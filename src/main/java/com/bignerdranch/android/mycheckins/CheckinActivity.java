package com.bignerdranch.android.mycheckins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class CheckinActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CheckFragment();
    }

}

