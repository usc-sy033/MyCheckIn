package com.bignerdranch.android.mycheckins;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CheckLab {
    private static CheckLab sCheckLab;

    private List<Check> mChecks;


    public static CheckLab get(Context context) {
        if (sCheckLab == null) {
            sCheckLab = new CheckLab(context);
        }
        return sCheckLab;
    }
    private CheckLab(Context context) {
        mChecks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Check check = new Check();
            check.setTitle("Check #" + i);
            mChecks.add(check);
        }
    }

    public List<Check> getChecks() {
        return mChecks;
    }

    public Check getCheck(UUID id) {
        for (Check check : mChecks) {
            if (check.getId().equals(id)) {
                return check;
            }
        }

        return null;
    }
}
