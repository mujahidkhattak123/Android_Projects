package ivap.orkpk.ivapcot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link questionarers_page_7_completed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questionarers_page_7_completed extends Fragment {

    Button btnprevious,btn_show_data;
    TextView txt_yes,txt_select,txt_all_main;
    String contact_data,checkagree_data,data_yes1,main_raio_data,main_gender_radio_btn,str_maincheck_store;
    String str_country,str_provice,str_city,str_district;
    String str_spinner_age;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_questionares_page1.
     */
    // TODO: Rename and change types and number of parameters
    public static questionarers_page_7_completed newInstance(String param1, String param2) {
        questionarers_page_7_completed fragment = new questionarers_page_7_completed();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public questionarers_page_7_completed() {
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
        // Inflate the layout for this fragment


        View view=inflater.inflate(R.layout.fragment_questionarers_page_7_completed,container,false);

        Bundle bundle=this.getArguments();
        checkagree_data =bundle.getString("key_check_agree");
        contact_data =bundle.getString("key_contact");
        data_yes1 =bundle.getString("key_Yes1");
        main_raio_data =bundle.getString("main_raio_data");
        main_gender_radio_btn =bundle.getString("main_gender_radio_btn");
        str_maincheck_store =bundle.getString("str_maincheck_store");

        str_country =bundle.getString("str_country");
        str_provice =bundle.getString("str_provice");
        str_district =bundle.getString("str_district");
        str_city =bundle.getString("str_city");
        str_spinner_age =bundle.getString("str_spinner_age");


        btnprevious=view.findViewById(R.id.btnpre);
        btn_show_data=view.findViewById(R.id.btn_show_data);
        btn_show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_all_main.setText("1  "+checkagree_data+" \n "+"\n"+"2  "+contact_data+" \n"+"3  "
                        + data_yes1 +"\n"+"4  "+main_raio_data+"\n"+"5  "+main_gender_radio_btn
                        +"\n"+"\n 6  "+str_maincheck_store
                        +"  "+"\n"+"\n 7  "+str_country+"\n" +"8  "+str_provice+"\n"+"9  "
                        +str_city+"\n"+"10  "+str_district+"\n"
                        +"\n"+"11  "+str_spinner_age
                );

            }
        });

        txt_all_main=view.findViewById(R.id.txt_all_text);

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.datacontainer,new BeinAssesmentsFragments(),null).commit();

//                Toast.makeText(getActivity(), checkagree_data+" \n "+"\n"+contact_data+" \n "+ data_yes1 +"\n"+main_raio_data+"\n"+main_gender_radio_btn+"\n"+str_maincheck_store, Toast.LENGTH_SHORT).show();

            }
        });




        return view;    }
}