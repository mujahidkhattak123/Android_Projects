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
 * Use the {@link questionares_page2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questionares_page2 extends Fragment {

    Button btnprevious,btnnext ,btnyes,btnno;
    TextView txt_someoneelse;
    RadioButton btnradio_my_self,btnradio_someone_else;
    RadioGroup radioGroup;
    String contact_data,checkagree_data,test_data,data_yes1;
    String str_radiomySelf,str_radiomySomeOne,main_raio_data;

    String str_country,str_provice,str_city,str_district;


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
    public static fragment_questionares_page1 newInstance(String param1, String param2) {
        fragment_questionares_page1 fragment = new fragment_questionares_page1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public questionares_page2() {
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


        View view=inflater.inflate(R.layout.fragment_questionares_page2,container,false);


        Bundle bundle=this.getArguments();
        checkagree_data =bundle.getString("key_check_agree");
        contact_data =bundle.getString("key_contact");
        data_yes1 =bundle.getString("key_Yes1");


        str_country =bundle.getString("str_country");
        str_provice =bundle.getString("str_provice");
        str_district =bundle.getString("str_district");
        str_city =bundle.getString("str_city");




        btnprevious=view.findViewById(R.id.btnpre);
        btnnext=view.findViewById(R.id.btnnext);

        txt_someoneelse=view.findViewById(R.id.txt_some_one);







        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("key_Yes1",data_yes1);
                bundle.putString("key_contact",contact_data);
                bundle.putString("key_check_agree",checkagree_data);
                bundle.putString("main_raio_data",main_raio_data);



                bundle.putString("str_country",str_country);
                bundle.putString("str_provice",str_provice);
                bundle.putString("str_district",str_district);
                bundle.putString("str_city",str_city);

                fragment_questionares_page1 page1=new fragment_questionares_page1();
                page1.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,page1).commit();
            }
        });


        btnradio_my_self=view.findViewById(R.id.btnradio_my_self);
        btnradio_someone_else=view.findViewById(R.id.btnradio_someone_else);
        radioGroup=view.findViewById(R.id.groupradio);

        str_radiomySelf=btnradio_my_self.getText().toString();
        str_radiomySomeOne=btnradio_someone_else.getText().toString();



        btnradio_my_self.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(),str_radiomySelf, Toast.LENGTH_SHORT).show();
                str_radiomySomeOne.isEmpty();

                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        main_raio_data=str_radiomySelf;

                        main_raio_data="M";

                        Bundle bundle=new Bundle();
                        bundle.putString("key_Yes1",data_yes1);
                        bundle.putString("key_contact",contact_data);
                        bundle.putString("key_check_agree",checkagree_data);
                        bundle.putString("main_raio_data",main_raio_data);

                        bundle.putString("str_country",str_country);
                        bundle.putString("str_provice",str_provice);
                        bundle.putString("str_district",str_district);
                        bundle.putString("str_city",str_city);


                        questionare_page3 page3=new questionare_page3();
                        page3.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.datacontainer,page3).commit();
                        Toast.makeText(getActivity(), checkagree_data+" \n "+contact_data+" \n "
                                + data_yes1 + "\n " +"\n"+str_radiomySelf+"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                        +str_provice+"\n"+str_city+"\n"+str_district
                                , Toast.LENGTH_SHORT).show();


                    }
                });


            }
        });

        btnradio_someone_else.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);

                Toast.makeText(getActivity(),str_radiomySomeOne, Toast.LENGTH_SHORT).show();
                str_radiomySelf.isEmpty();
                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        txt_someoneelse.isEnabled();

                        main_raio_data=str_radiomySomeOne;
                        main_raio_data="S";

                        Bundle bundle=new Bundle();
                        bundle.putString("key_Yes1",data_yes1);
                        bundle.putString("key_contact",contact_data);
                        bundle.putString("key_check_agree",checkagree_data);
                        bundle.putString("main_raio_data",main_raio_data);

                        bundle.putString("str_country",str_country);
                        bundle.putString("str_provice",str_provice);
                        bundle.putString("str_district",str_district);
                        bundle.putString("str_city",str_city);


                        questionare_page3 page3=new questionare_page3();
                        page3.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.datacontainer,page3).commit();
                        Toast.makeText(getActivity(), "1"+checkagree_data+" \n 2"+" \n 3"+" \n 4"+contact_data+" \n 5"
                                        + data_yes1 +" \n 6"+ "\n 7" +"\n"+str_radiomySelf+" 8 "+checkagree_data+" 9 "+"\n 10"+str_country+"\n 11"
                                        +str_provice+"\n 12"+str_city+"\n 13"+str_district
                                , Toast.LENGTH_SHORT).show();


                    }
                });


            }
        });





        return view;
    }
}