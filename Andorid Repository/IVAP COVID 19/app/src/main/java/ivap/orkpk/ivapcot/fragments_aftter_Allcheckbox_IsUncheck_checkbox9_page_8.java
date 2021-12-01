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
 * Use the {@link fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_8#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_8 extends Fragment {
    Button btnprevious, btnnext, btnyes, btnno;
    TextView txt_yes, txt_select;
    String contact_data,checkagree_data,data_yes1,main_raio_data,main_gender_radio_btn
            ,str_maincheck_store,data_yes1_after_check,data_yes2_after_check,data_yes3_after_check
            ,data_yes4_after_check,data_yes5_after_check,data_yes6_after_check,data_yes7_after_check
    ,data_yes8_after_check
    ,data_no1_after_check,data_no2_after_check,data_no3_after_check
            ,data_no4_after_check,data_no5_after_check,data_no6_after_check,data_no7_after_check
            ,data_no8_after_check,str_action_main1,str_action_main2,str_action_main3,str_action_main4,str_action_main5,str_action_main6,str_action_main7,str_action_main8;
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
    public static fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_8 newInstance(String param1, String param2) {
        fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_8 fragment = new fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_8();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_8() {
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


        View view = inflater.inflate(R.layout.fragment_fragments_aftter__allcheckbox__is_uncheck_checkbox9_page_8, container, false);
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

        str_action_main1 =bundle.getString("str_action_main1");
        str_action_main2 =bundle.getString("str_action_main2");
        str_action_main3 =bundle.getString("str_action_main3");
        str_action_main4 =bundle.getString("str_action_main4");
        str_action_main5 =bundle.getString("str_action_main5");
        str_action_main6 =bundle.getString("str_action_main6");
        str_action_main7 =bundle.getString("str_action_main7");




        str_spinner_age =bundle.getString("str_spinner_age");


        btnprevious = view.findViewById(R.id.btnpre);
        btnnext = view.findViewById(R.id.btnnext);

        btnyes = view.findViewById(R.id.btn_yes);
        btnno = view.findViewById(R.id.btn_no);
        txt_yes = view.findViewById(R.id.txt_yes);

        txt_select = view.findViewById(R.id.txt_select);

        data_yes8_after_check=btnyes.getText().toString();
        data_no8_after_check=btnno.getText().toString();



        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), data_yes8_after_check, Toast.LENGTH_SHORT).show();

                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        str_action_main8=data_yes8_after_check;
                        str_action_main8="Y";
                        Bundle bundle=new Bundle();
                        bundle.putString("key_Yes1",data_yes1);
                        bundle.putString("key_contact",contact_data);
                        bundle.putString("key_check_agree",checkagree_data);
                        bundle.putString("main_raio_data",main_raio_data);
                        bundle.putString("main_gender_radio_btn",main_gender_radio_btn);
                        bundle.putString("str_maincheck_store",str_maincheck_store);


                        bundle.putString("str_country",str_country);
                        bundle.putString("str_provice",str_provice);
                        bundle.putString("str_district",str_district);
                        bundle.putString("str_city",str_city);
                        bundle.putString("str_spinner_age",str_spinner_age);

                        bundle.putString("str_action_main1",str_action_main1);
                        bundle.putString("str_action_main2",str_action_main2);
                        bundle.putString("str_action_main3",str_action_main3);
                        bundle.putString("str_action_main4",str_action_main4);
                        bundle.putString("str_action_main5",str_action_main5);
                        bundle.putString("str_action_main6",str_action_main6);
                        bundle.putString("str_action_main7",str_action_main7);
                        bundle.putString("str_action_main8",str_action_main8);


                        fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_9
                                page_9_9=new fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_9();
                        page_9_9.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.datacontainer,page_9_9).commit();
                        Toast.makeText(getActivity(), checkagree_data+" \n "+"\n"+contact_data+" \n "
                                + data_yes1 +"\n"+main_raio_data+"\n"+main_gender_radio_btn+"\n"
                                +str_maincheck_store+"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                +str_provice+"\n"+str_city+"\n"+str_district
                                +"\n"+str_spinner_age+str_action_main1+str_action_main2+str_action_main3+str_action_main4+str_action_main5+str_action_main6+str_action_main7+str_action_main8 , Toast.LENGTH_SHORT).show();




                    }
                });
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_action_main8=data_no8_after_check;
                Toast.makeText(getActivity(), data_no8_after_check, Toast.LENGTH_SHORT).show();
                btnnext.setVisibility(View.VISIBLE);

                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        str_action_main8=data_no8_after_check;
                        str_action_main8="N";
                        Bundle bundle=new Bundle();
                        bundle.putString("key_Yes1",data_yes1);
                        bundle.putString("key_contact",contact_data);
                        bundle.putString("key_check_agree",checkagree_data);
                        bundle.putString("main_raio_data",main_raio_data);
                        bundle.putString("main_gender_radio_btn",main_gender_radio_btn);
                        bundle.putString("str_maincheck_store",str_maincheck_store);


                        bundle.putString("str_country",str_country);
                        bundle.putString("str_provice",str_provice);
                        bundle.putString("str_district",str_district);
                        bundle.putString("str_city",str_city);
                        bundle.putString("str_spinner_age",str_spinner_age);



                        bundle.putString("str_action_main1",str_action_main1);
                        bundle.putString("str_action_main2",str_action_main2);
                        bundle.putString("str_action_main3",str_action_main3);
                        bundle.putString("str_action_main4",str_action_main4);
                        bundle.putString("str_action_main5",str_action_main5);
                        bundle.putString("str_action_main6",str_action_main6);
                        bundle.putString("str_action_main7",str_action_main7);
                        bundle.putString("str_action_main8",str_action_main8);

                        fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_9
                                page_9_9=new fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_9();
                        page_9_9.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.datacontainer,page_9_9).commit();
                        Toast.makeText(getActivity(), checkagree_data+" \n "+"\n"+contact_data+" \n "
                                + data_yes1 +"\n"+main_raio_data+"\n"+main_gender_radio_btn+"\n"
                                +str_maincheck_store+"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                +str_provice+"\n"+str_city+"\n"+str_district
                                +"\n"+str_spinner_age+str_spinner_age+str_action_main1+str_action_main2+str_action_main3+str_action_main4+str_action_main5+str_action_main6+str_action_main7+str_action_main8 , Toast.LENGTH_SHORT).show();




                    }
                });

            }
        });




        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("key_Yes1",data_yes1);
                bundle.putString("key_contact",contact_data);
                bundle.putString("key_check_agree",checkagree_data);
                bundle.putString("main_raio_data",main_raio_data);
                bundle.putString("main_gender_radio_btn",main_gender_radio_btn);
                bundle.putString("str_maincheck_store",str_maincheck_store);


                bundle.putString("str_country",str_country);
                bundle.putString("str_provice",str_provice);
                bundle.putString("str_district",str_district);
                bundle.putString("str_city",str_city);
                bundle.putString("str_spinner_age",str_spinner_age);

                bundle.putString("str_action_main1",str_action_main1);
                bundle.putString("str_action_main2",str_action_main2);
                bundle.putString("str_action_main3",str_action_main3);
                bundle.putString("str_action_main4",str_action_main4);
                bundle.putString("str_action_main5",str_action_main5);
                bundle.putString("str_action_main6",str_action_main6);
                bundle.putString("str_action_main7",str_action_main7);
                bundle.putString("str_action_main8",str_action_main8);

                fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_7      page_9_2=new fragments_aftter_Allcheckbox_IsUncheck_checkbox9_page_7();
                page_9_2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,page_9_2).commit();


            }
        });


        return view;
    }

}