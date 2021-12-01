package ivap.orkpk.ivapcot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link questionare_page3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questionare_page3 extends Fragment {

    Button btnprevious,btnnext ,btnyes,btnno;
    Spinner age;
    String contact_data,checkagree_data,data_yes1,main_raio_data;
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
    public static questionare_page3 newInstance(String param1, String param2) {
        questionare_page3 fragment = new questionare_page3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public questionare_page3() {
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


        View view=inflater.inflate(R.layout.fragment_questionare_page3,container,false);


        Bundle bundle=this.getArguments();
        checkagree_data =bundle.getString("key_check_agree");
        contact_data =bundle.getString("key_contact");
        data_yes1 =bundle.getString("key_Yes1");
        main_raio_data =bundle.getString("main_raio_data");

        str_country =bundle.getString("str_country");
        str_provice =bundle.getString("str_provice");
        str_district =bundle.getString("str_district");
        str_city =bundle.getString("str_city");


        btnprevious=view.findViewById(R.id.btnpre);
        btnnext=view.findViewById(R.id.btnnext);

        btnyes=view.findViewById(R.id.btn_yes);
        btnno=view.findViewById(R.id.btn_no);






        btnnext.setOnClickListener(new View.OnClickListener() {
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
                bundle.putString("str_spinner_age",str_spinner_age);


                questionares_page4 page4=new questionares_page4();
                page4.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,page4).commit();
                Toast.makeText(getActivity(), checkagree_data+" \n "+"\n"+contact_data+" \n "+ data_yes1
                        +"\n"+main_raio_data+"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                +str_provice+"\n"+str_city+"\n"+str_district
                       +"\n"+str_spinner_age , Toast.LENGTH_SHORT).show();




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


                bundle.putString("str_country",str_country);
                bundle.putString("str_provice",str_provice);
                bundle.putString("str_district",str_district);
                bundle.putString("str_city",str_city);
                bundle.putString("str_spinner_age",str_spinner_age);

                questionares_page2 page2=new questionares_page2();
                page2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,page2).commit();
            }
        });

        age =view.findViewById(R.id.spinner_age);
        ArrayAdapter<CharSequence> adapter_age= ArrayAdapter.createFromResource(getActivity(), R.array.age_arrays,
                android.R.layout.simple_spinner_item);
        age.setAdapter(adapter_age);

        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_spinner_age = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getActivity(), str_spinner_age, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
}