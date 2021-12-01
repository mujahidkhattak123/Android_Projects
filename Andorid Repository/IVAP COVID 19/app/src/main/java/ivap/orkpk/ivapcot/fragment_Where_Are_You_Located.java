package ivap.orkpk.ivapcot;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.layout.simple_spinner_item;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_Where_Are_You_Located#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_Where_Are_You_Located extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {


    Button btnprevious,btnnext ;
    Spinner spinner_county,spinner_province,spinner_district,spinner_city;
    EditText edt_contact;
    String check_agree_data;
    String str_country,str_provice,str_city,str_district;
  //  String str_contactText;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Bundle bundle;
    private String string;

    public fragment_Where_Are_You_Located() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_Where_Are_You_Located.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_Where_Are_You_Located newInstance(String param1, String param2) {
        fragment_Where_Are_You_Located fragment = new fragment_Where_Are_You_Located();
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

    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment__where__are__you__located,container,false);

        btnprevious=view.findViewById(R.id.btnpre);
        btnnext=view.findViewById(R.id.btnnext);
        edt_contact  = view.findViewById(R.id.id_edt_contact);



        Bundle bundle=this.getArguments();
        check_agree_data =bundle.getString("key_check_agree");



        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_contactText = edt_contact.getText().toString();

                Bundle bundle=new Bundle();
                bundle.putString("key_contact",str_contactText);
                bundle.putString("key_check_agree",check_agree_data);
                bundle.putString("str_country",str_country);
                bundle.putString("str_provice",str_provice);
                bundle.putString("str_district",str_district);
                bundle.putString("str_city",str_city);



                fragment_questionares_page1 page1=new fragment_questionares_page1();
                page1.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,page1).commit();


//
                Toast.makeText(getActivity(), str_contactText+"  "+check_agree_data+"  "+"\n"+str_country+"\n"
                        +str_provice+"\n"+str_city+"\n"+str_district, Toast.LENGTH_SHORT).show();
//



            }
        });

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.datacontainer,new BeinAssesmentsFragments(),null).commit();

            }
        });


        spinner_county =view.findViewById(R.id.spinner_county);
        spinner_province=view.findViewById(R.id.spinner_province);
        spinner_district=view.findViewById(R.id.spinner_district);
        spinner_city=view.findViewById(R.id.spinner_city);

        ArrayAdapter<CharSequence> adapter_province = ArrayAdapter.createFromResource(getActivity(), R.array.povince_arrays,
                android.R.layout.simple_spinner_item);
        spinner_province.setAdapter(adapter_province);

        spinner_province.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_provice= adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter_city = ArrayAdapter.createFromResource(getActivity(), R.array.city_arrays,
                android.R.layout.simple_spinner_item);
        spinner_city.setAdapter(adapter_city);


spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
       str_city  = adapterView.getItemAtPosition(i).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});
        ArrayAdapter<CharSequence> adapter_district = ArrayAdapter.createFromResource(getActivity(), R.array.district_arrays,
                android.R.layout.simple_spinner_item);
        spinner_district.setAdapter(adapter_district);
        spinner_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_district = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<CharSequence> adapter_country = ArrayAdapter.createFromResource(getActivity(), R.array.country_arrays,
                android.R.layout.simple_spinner_item);
        spinner_county.setAdapter(adapter_country);

        spinner_county.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_country = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }





}