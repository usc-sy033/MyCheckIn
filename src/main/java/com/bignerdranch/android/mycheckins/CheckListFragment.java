package com.bignerdranch.android.mycheckins;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CheckListFragment extends Fragment {
    private RecyclerView mCheckRecyclerView;
    private CheckAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_list, container, false);
        mCheckRecyclerView = (RecyclerView) view
                .findViewById(R.id.check_recycler_view);
        mCheckRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        CheckLab checkLab = CheckLab.get(getActivity());
        List<Check> checks = checkLab.getChecks();
        if (mAdapter == null) {
            mAdapter = new CheckAdapter(checks);
            mCheckRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class CheckHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private Check mCheck;

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private TextView mPlaceTextView;

        public CheckHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_check, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.check_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.check_date);
            mPlaceTextView = (TextView) itemView.findViewById(R.id.check_place);
        }

        public void bind(Check check) {
            mCheck = check;
            mTitleTextView.setText(mCheck.getTitle());
            mDateTextView.setText(mCheck.getDate().toString());
            mPlaceTextView.setText(mCheck.getPlace());
        }

        @Override
        public void onClick(View view) {
            Intent intent = CheckinActivity.newIntent(getActivity(), mCheck.getId());
            startActivity(intent);
        }
    }

    private class CheckAdapter extends RecyclerView.Adapter<CheckHolder> {
        private List<Check> mChecks;
        public CheckAdapter(List<Check> checks) {
            mChecks = checks;
        }

        @NonNull
        @Override
        public CheckHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CheckHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CheckHolder holder, int position) {
            Check check = mChecks.get(position);
            holder.bind(check);
        }

        @Override
        public int getItemCount() {
            return mChecks.size();
        }
    }
}
