package com.bignerdranch.android.mycheckins;

import androidx.fragment.app.Fragment;

public class CheckListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CheckListFragment();
    }
}
