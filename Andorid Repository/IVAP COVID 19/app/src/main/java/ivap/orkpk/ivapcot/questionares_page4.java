package ivap.orkpk.ivapcot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link questionares_page4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questionares_page4 extends Fragment {

    Button btnprevious, btnnext, btnyes, btnno;
    TextView txt_someoneelse;
    RadioButton btnradio_male, btnradio_female,btnradio_transgender;
    String contact_data,checkagree_data,data_yes1,main_raio_data,main_gender_radio_btn,str_male,str_female,str_trsngender;

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
    public static questionares_page4 newInstance(String param1, String param2) {
        questionares_page4 fragment = new questionares_page4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public questionares_page4() {
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


        View view = inflater.inflate(R.layout.fragment_questionares_page4, container, false);

        Bundle bundle=this.getArguments();
        checkagree_data =bundle.getString("key_check_agree");
        contact_data =bundle.getString("key_contact");
        data_yes1 =bundle.getString("key_Yes1");
        main_raio_data =bundle.getString("main_raio_data");

        str_country =bundle.getString("str_country");
        str_provice =bundle.getString("str_provice");
        str_district =bundle.getString("str_district");
        str_city =bundle.getString("str_city");
        str_spinner_age =bundle.getString("str_spinner_age");

        btnprevious = view.findViewById(R.id.btnpre);
        btnnext = view.findViewById(R.id.btnnext);

        btnyes = view.findViewById(R.id.btn_yes);
        btnno = view.findViewById(R.id.btn_no);
        txt_someoneelse = view.findViewById(R.id.txt_some_one);



        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("key_Yes1",data_yes1);
                bundle.putString("key_contact",contact_data);
                bundle.putString("key_check_agree",checkagree_data);
                bundle.putString("main_raio_data",main_raio_data);
                bundle.putString("main_gender_radio_btn",main_gender_radio_btn);


                bundle.putString("str_country",str_country);
                bundle.putString("str_provice",str_provice);
                bundle.putString("str_district",str_district);
                bundle.putString("str_city",str_city);
                bundle.putString("str_spinner_age",str_spinner_age);

                questionare_page3 page3=new questionare_page3();
                page3.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,page3).commit();            }
        });
        btnradio_male = view.findViewById(R.id.btnradio_male);
        btnradio_female = view.findViewById(R.id.btn_female);
        btnradio_transgender = view.findViewById(R.id.btn_transgender);


        str_male=btnradio_male.getText().toString();
        str_female=btnradio_female.getText().toString();
        str_trsngender=btnradio_transgender.getText().toString();



        btnradio_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);


                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        str_female.isEmpty();
                        str_trsngender.isEmpty();

                        main_gender_radio_btn=str_male;
                        main_gender_radio_btn="M";

                        Bundle bundle=new Bundle();
                        bundle.putString("key_Yes1",data_yes1);
                        bundle.putString("key_contact",contact_data);
                        bundle.putString("key_check_agree",checkagree_data);
                        bundle.putString("main_raio_data",main_raio_data);
                        bundle.putString("main_gender_radio_btn",main_gender_radio_btn);

                        bundle.putString("str_country",str_country);
                        bundle.putString("str_provice",str_provice);
                        bundle.putString("str_district",str_district);
                        bundle.putString("str_city",str_city);

                        bundle.putString("str_spinner_age",str_spinner_age);

                        questionares_page5 page5=new questionares_page5();
                        page5.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.datacontainer,page5).commit();
                        Toast.makeText(getActivity(), checkagree_data+" \n "+"\n"+contact_data+" \n "
                                + data_yes1 +"\n"+main_raio_data+"\n"+main_gender_radio_btn+"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                        +str_provice+"\n"+str_city+"\n"+str_district
                                +"\n"+str_spinner_age , Toast.LENGTH_SHORT).show();



                    }
                });


            }
        });

        btnradio_transgender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);


                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        str_male.isEmpty();
                        str_trsngender.isEmpty();

                        main_gender_radio_btn=str_trsngender;
                        main_gender_radio_btn="O";

                        Bundle bundle=new Bundle();
                        bundle.putString("key_Yes1",data_yes1);
                        bundle.putString("key_contact",contact_data);
                        bundle.putString("key_check_agree",checkagree_data);
                        bundle.putString("main_raio_data",main_raio_data);
                        bundle.putString("main_gender_radio_btn",main_gender_radio_btn);

                        bundle.putString("str_country",str_country);
                        bundle.putString("str_provice",str_provice);
                        bundle.putString("str_district",str_district);
                        bundle.putString("str_city",str_city);

                        bundle.putString("str_spinner_age",str_spinner_age);

                        questionares_page5 page5=new questionares_page5();
                        page5.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.datacontainer,page5).commit();
                        Toast.makeText(getActivity(), checkagree_data+" \n "+"\n"+contact_data+" \n "
                                + data_yes1 +"\n"+main_raio_data+"\n"+main_gender_radio_btn+"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                +str_provice+"\n"+str_city+"\n"+str_district
                                +"\n"+str_spinner_age , Toast.LENGTH_SHORT).show();




                    }
                });


            }
        });



        btnradio_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);


                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        str_male.isEmpty();
                        str_trsngender.isEmpty();

                        main_gender_radio_btn=str_female;
                        main_gender_radio_btn="F";

                        Bundle bundle=new Bundle();
                        bundle.putString("key_Yes1",data_yes1);
                        bundle.putString("key_contact",contact_data);
                        bundle.putString("key_check_agree",checkagree_data);
                        bundle.putString("main_raio_data",main_raio_data);
                        bundle.putString("main_gender_radio_btn",main_gender_radio_btn);

                        bundle.putString("str_country",str_country);
                        bundle.putString("str_provice",str_provice);
                        bundle.putString("str_district",str_district);
                        bundle.putString("str_city",str_city);

                        bundle.putString("str_spinner_age",str_spinner_age);

                        questionares_page5 page5=new questionares_page5();
                        page5.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.datacontainer,page5).commit();
                        Toast.makeText(getActivity(), checkagree_data+" \n "+"\n"+contact_data+" \n "
                                + data_yes1 +"\n"+main_raio_data+"\n"+main_gender_radio_btn+"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                +str_provice+"\n"+str_city+"\n"+str_district
                                +"\n"+str_spinner_age , Toast.LENGTH_SHORT).show();




                    }
                });


            }
        });
        return view;
    }
}