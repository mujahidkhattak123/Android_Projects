package ivap.orkpk.ivapcot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BeinAssesmentsFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeinAssesmentsFragments extends Fragment {

    private CheckBox checkBox;
    private Button btnnext,btnprevious;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BeinAssesmentsFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BeinAssesmentsFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static BeinAssesmentsFragments newInstance(String param1, String param2) {
        BeinAssesmentsFragments fragment = new BeinAssesmentsFragments();
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



        View view=inflater.inflate(R.layout.fragment_bein_assesments_fragments,container,false);



        checkBox=view.findViewById(R.id.btncheckbox);
        btnnext=view.findViewById(R.id.btnnext);



        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    btnnext.setVisibility(View.VISIBLE);
                } else if(!checkBox.isChecked()) {
                    btnnext.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnprevious=view.findViewById(R.id.btnpre);
        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.datacontainer,new DataFregments(),null).commit();

            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String check_agree=checkBox.getText().toString();

                Bundle bundle=new Bundle();
                bundle.putString("key_check_agree",check_agree);

                fragment_Where_Are_You_Located fragmentWhereAreYouLocated=new fragment_Where_Are_You_Located();
                fragmentWhereAreYouLocated.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,fragmentWhereAreYouLocated).commit();


                Toast.makeText(getActivity(), check_agree, Toast.LENGTH_SHORT).show();
//                MainActivity.fragmentManager.beginTransaction().replace(R.id.datacontainer,new fragment_Where_Are_You_Located(),null).commit();
            }
        });

        return view;

    }

}