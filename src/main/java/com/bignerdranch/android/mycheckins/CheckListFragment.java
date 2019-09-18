package com.bignerdranch.android.mycheckins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private void updateUI() {
        CheckLab checkLab = CheckLab.get(getActivity());
        List<Check> checks = checkLab.getChecks();
        mAdapter = new CheckAdapter(checks);
        mCheckRecyclerView.setAdapter(mAdapter);
    }

    private class CheckHolder extends RecyclerView.ViewHolder {
        public CheckHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_check, parent, false));
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

        }

        @Override
        public int getItemCount() {
            return mChecks.size();
        }
    }
}
