package com.example.testandroid.views;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.testandroid.R;
import com.example.testandroid.adapters.ChatListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CommunicationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommunicationFragment extends Fragment {
    private ListView listView;
    Activity context;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CommunicationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CommunicationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CommunicationFragment newInstance(String param1, String param2) {
        CommunicationFragment fragment = new CommunicationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity();
        View view=inflater.inflate(R.layout.fragment_communication, container, false);
        String[] items={"Group"};
        listView = view.findViewById(R.id.ListCommunication);
        ChatListAdapter adapter = new ChatListAdapter(items,context,items,items);
        listView.setAdapter(adapter);
        return inflater.inflate(R.layout.fragment_communication, container, false);
    }
    public void onStart(){
        super.onStart();
    }
}