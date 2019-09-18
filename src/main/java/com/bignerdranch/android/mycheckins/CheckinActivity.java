package com.bignerdranch.android.mycheckins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;

public class CheckinActivity extends SingleFragmentActivity {

    private static final String EXTRA_CHECK_ID =
            "com.bignerdranch.android.criminalintent.check_id";

    public static Intent newIntent(Context packageContext, UUID checkId) {
        Intent intent = new Intent(packageContext, CheckinActivity.class);
        intent.putExtra(EXTRA_CHECK_ID, checkId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID checkId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CHECK_ID);
        return CheckFragment.newInstance(checkId);

    }

}

