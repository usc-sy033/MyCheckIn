package com.bignerdranch.android.mycheckins;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class CheckFragment extends Fragment {

    private static final String ARG_CHECK_ID = "check_id";

    private Check mCheck;
    private EditText mTitleField;
    private EditText mDetailsField;
    private EditText mPlaceField;
    private Button mDateButton;

    public static CheckFragment newInstance(UUID checkId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CHECK_ID, checkId);
        CheckFragment fragment = new CheckFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCheck = new Check();
        UUID checkId = (UUID) getArguments().getSerializable(ARG_CHECK_ID);
        mCheck = CheckLab.get(getActivity()).getCheck(checkId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_check, container,false);

        mTitleField = (EditText) v.findViewById(R.id.check_title);
        mTitleField.setText(mCheck.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            // This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mCheck.setTitle(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            // This one too
            }
        });

        mDetailsField = (EditText) v.findViewById(R.id.check_details);
        mDetailsField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mCheck.setDetails(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });


        mPlaceField = (EditText) v.findViewById(R.id.check_place);
        mPlaceField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            // This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mCheck.setPlace(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            // This one too
            }
        });


        mDateButton = (Button) v.findViewById(R.id.check_date);
        mDateButton.setText(mCheck.getDate().toString());
        mDateButton.setEnabled(false);



        return v;
    }
}
