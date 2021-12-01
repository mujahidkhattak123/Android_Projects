package ivap.orkpk.ivapcot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link questionares_page5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questionares_page5 extends Fragment {


    Button btnprevious, btnnext, btnyes, btnno;
    TextView txt_someoneelse;
    CheckBox btnCheckBox_1, btnCheckBox_2,btnCheckBox_3,btnCheckBox_4,btnCheckBox_5,btnCheckBox_6,btnCheckBox_7,btnCheckBox_8,btnCheckBox_9;
    String contact_data,checkagree_data,data_yes1,main_raio_data,main_gender_radio_btn
            ,str_checkbox1,str_checkbox2,str_checkbox3,str_checkbox4,str_checkbox5,str_checkbox6,
    str_checkbox7,str_checkbox8,str_checkbox9,str_maincheck_store;
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
    public static questionares_page5 newInstance(String param1, String param2) {
        questionares_page5 fragment = new questionares_page5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public questionares_page5() {
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


        View view = inflater.inflate(R.layout.fragment_questionares_page5, container, false);




        Bundle bundle=this.getArguments();
        checkagree_data =bundle.getString("key_check_agree");
        contact_data =bundle.getString("key_contact");
        data_yes1 =bundle.getString("key_Yes1");
        main_raio_data =bundle.getString("main_raio_data");
        main_gender_radio_btn =bundle.getString("main_gender_radio_btn");

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





        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                str_maincheck_store="";

                if (btnCheckBox_1.isChecked()){
                    str_maincheck_store+=str_checkbox1;
                }
                if (btnCheckBox_2.isChecked()){
                    str_maincheck_store+=str_checkbox2;
                }

                if (btnCheckBox_3.isChecked()){
                    str_maincheck_store+=str_checkbox3;
                }

                if (btnCheckBox_4.isChecked()){
                    str_maincheck_store+=str_checkbox4;
                }
                if (btnCheckBox_5.isChecked()){
                    str_maincheck_store+=str_checkbox5;
                }

                if (btnCheckBox_6.isChecked()){
                    str_maincheck_store+=str_checkbox6;
                }

                if (btnCheckBox_7.isChecked()){
                    str_maincheck_store+=str_checkbox7;
                }
                if (btnCheckBox_8.isChecked()){
                    str_maincheck_store+=str_checkbox8;
                }



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

                questionares_page6 page6=new questionares_page6();
                page6.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,page6).commit();
                Toast.makeText(getActivity(), checkagree_data+" \n "+"\n"+contact_data+" \n "
                        + data_yes1 +"\n"+main_raio_data+"\n"+main_gender_radio_btn+"\n"
                        +str_maincheck_store+"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                +str_provice+"\n"+str_city+"\n"+str_district
                        +"\n"+str_spinner_age  , Toast.LENGTH_SHORT).show();



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

                questionares_page4 page4=new questionares_page4();
                page4.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,page4).commit();
            }
        });


        btnCheckBox_1 = view.findViewById(R.id.btnCheckBox_1);
        btnCheckBox_2 = view.findViewById(R.id.btnCheckBox_2);
        btnCheckBox_3 = view.findViewById(R.id.btnCheckBox_3);
        btnCheckBox_4 = view.findViewById(R.id.btnCheckBox_4);
        btnCheckBox_5 = view.findViewById(R.id.btnCheckBox_5);
        btnCheckBox_6 = view.findViewById(R.id.btnCheckBox_6);
        btnCheckBox_7 = view.findViewById(R.id.btnCheckBox_7);
        btnCheckBox_8 = view.findViewById(R.id.btnCheckBox_8);
        btnCheckBox_9 = view.findViewById(R.id.btnCheckBox_9);


        str_checkbox1=btnCheckBox_1.getText().toString();
        str_checkbox2=btnCheckBox_2.getText().toString();
        str_checkbox3=btnCheckBox_3.getText().toString();
        str_checkbox4=btnCheckBox_4.getText().toString();
        str_checkbox5=btnCheckBox_5.getText().toString();
        str_checkbox6=btnCheckBox_6.getText().toString();
        str_checkbox7=btnCheckBox_7.getText().toString();
        str_checkbox8=btnCheckBox_8.getText().toString();
        str_checkbox9=btnCheckBox_9.getText().toString();





        btnCheckBox_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);
            }
        });

        btnCheckBox_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);

            }
        });

        btnCheckBox_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);

            }
        });

        btnCheckBox_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);

            }
        });

        btnCheckBox_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);

            }
        });
        btnCheckBox_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                btnnext.setVisibility(View.VISIBLE);

            }
        });
        btnCheckBox_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    btnnext.setVisibility(View.VISIBLE);



            }
        });



        btnCheckBox_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    btnnext.setVisibility(View.VISIBLE);



            }
        });


        btnCheckBox_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);
                str_maincheck_store=str_checkbox9;


                btnnext.setOnClickListener(new View.OnClickListener() {
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

                        fragments_aftter_Allcheckbox_IsUncheck_checkbox9 page_1_after_9=new fragments_aftter_Allcheckbox_IsUncheck_checkbox9();
                        page_1_after_9.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.datacontainer,page_1_after_9).commit();
                        Toast.makeText(getActivity(), checkagree_data+" \n "+"\n"+contact_data+" \n "
                                + data_yes1 +"\n"+main_raio_data+"\n"+main_gender_radio_btn+"\n"
                                +str_maincheck_store+"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                +str_provice+"\n"+str_city+"\n"+str_district
                                +"\n"+str_spinner_age  , Toast.LENGTH_SHORT).show();


                    }
                });

                if (btnCheckBox_9.isChecked()){
                    btnCheckBox_1.setEnabled(false);

                    btnnext.setVisibility(View.VISIBLE);
                    btnCheckBox_2.setEnabled(false);
                    btnCheckBox_3.setEnabled(false);
                    btnCheckBox_4.setEnabled(false);
                    btnCheckBox_5.setEnabled(false);
                    btnCheckBox_6.setEnabled(false);
                    btnCheckBox_7.setEnabled(false);
                    btnCheckBox_8.setEnabled(false);
                }
                else {

                    btnCheckBox_1.setEnabled(true);
                    btnCheckBox_2.setEnabled(true);
                    btnCheckBox_3.setEnabled(true);
                    btnCheckBox_4.setEnabled(true);
                    btnCheckBox_5.setEnabled(true);
                    btnCheckBox_6.setEnabled(true);
                    btnCheckBox_7.setEnabled(true);
                    btnCheckBox_8.setEnabled(true);

                }


            }
        });



        return view;


    }


}
