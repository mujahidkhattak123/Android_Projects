package com.example.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Main_Data_Fragments extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button btn_home,btn_create_account,btn_blood_camp_regis,btn_search_donors,btn_login,btn_request_for_blood_donation,btn_user_profile;


    // TODO: Rename and change types and number of parameters
    public static Main_Data_Fragments newInstance(String param1, String param2) {
        Main_Data_Fragments fragment = new Main_Data_Fragments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Main_Data_Fragments() {
        // Required empty public constructor
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
        View view=inflater.inflate(R.layout.fragment_main__data__fragments,container,false);

        btn_home=view.findViewById(R.id.btn_home);
        btn_create_account=view.findViewById(R.id.btn_create_account);
        btn_search_donors=view.findViewById(R.id.btn_search_blood_camp);
        btn_user_profile=view.findViewById(R.id.btn_user_profile);
        btn_login=view.findViewById(R.id.btn_login);

        btn_request_for_blood_donation=view.findViewById(R.id.btn_request_for_blood_donation);




        btn_user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(), User_profile.class);
                startActivity(intent1);
            }
        });
        btn_request_for_blood_donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(), Donait_Blood.class);
                startActivity(intent1);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(), Home_Activity.class);
                startActivity(intent1);
            }
        });


        btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(getActivity(), Sign_Up_Act.class);
                startActivity(intent2);
            }
        });



        btn_search_donors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(getActivity(), Search_Blood_Camp.class);
                startActivity(intent4);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(getActivity(), Sign_in.class);
                startActivity(intent5);
            }
        });

        return view;
    }
}




