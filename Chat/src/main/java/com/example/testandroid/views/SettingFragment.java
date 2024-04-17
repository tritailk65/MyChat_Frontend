package com.example.testandroid.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.testandroid.R;
import com.example.testandroid.databinding.FragmentSettingBinding;
import com.example.testandroid.databinding.FragmentSettingBindingImpl;
import com.example.testandroid.databinding.LoginBinding;
import com.example.testandroid.viewmodels.SettingViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends Fragment {
    Activity context;
    private SettingViewModel settingViewModel;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
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
        context= getActivity();
        View view=inflater.inflate(R.layout.fragment_call, container, false);
        FragmentSettingBinding loginBinding = DataBindingUtil.setContentView(context, R.layout.fragment_call);
        settingViewModel=new SettingViewModel();
        settingViewModel.setContextViewModel(context.getApplicationContext());
        loginBinding.setViewModel(settingViewModel);
        settingViewModel.getIsLoggedOut().observe((LifecycleOwner) context, IsLoggedOut->{
            if(IsLoggedOut){
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
        loginBinding.executePendingBindings();
        ImageView imageView=context.findViewById(R.id.editAvatar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivity(intent);
            }
        });
        ImageView changeName=context.findViewById(R.id.editName);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyDialogFragment();
            }
        });
        return view;
    }

    public void onStart(){
        super.onStart();
    }

    public class MyDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.dialog_changename, null);
            EditText editText = dialogView.findViewById(R.id.editAccountName); // Lấy EditText từ layout
            builder.setView(dialogView)
                    .setTitle("Nhập thông tin")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String userInput = editText.getText().toString();
                            // Xử lý dữ liệu nhập vào
                        }
                    })
                    .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            return builder.create();
        }
    }
}