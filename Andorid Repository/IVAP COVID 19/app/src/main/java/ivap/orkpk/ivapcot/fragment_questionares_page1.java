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
 * Use the {@link fragment_questionares_page1#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class fragment_questionares_page1 extends Fragment {
    Button btnprevious,btnnext ,btnyes,btnno;
    TextView txt_yes,txt_select;
    String contact_data,checkagree_data;
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

    public fragment_questionares_page1() {
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


        View view=inflater.inflate(R.layout.fragment_questionares_page1,container,false);


//        Bundle bundle=this.getArguments();
//        contact_data =bundle.getString("key_contact");
//        checkagree_data =bundle.getString("key_checkbox");
//        test_data=bundle.getString("keyBtn");


        Bundle bundle=this.getArguments();
        checkagree_data =bundle.getString("key_check_agree");
        contact_data =bundle.getString("key_contact");

        str_country =bundle.getString("str_country");
        str_provice =bundle.getString("str_provice");
        str_district =bundle.getString("str_district");
        str_city =bundle.getString("str_city");


        btnprevious=view.findViewById(R.id.btnpre);
        btnnext=view.findViewById(R.id.btnnext);

        btnyes=view.findViewById(R.id.btn_yes);
        btnno=view.findViewById(R.id.btn_no);
        txt_yes=view.findViewById(R.id.txt_yes);

        txt_select=view.findViewById(R.id.txt_select);




        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnnext.setVisibility(View.VISIBLE);
                String str_Yes = btnyes.getText().toString();
                Toast.makeText(getActivity(), str_Yes, Toast.LENGTH_SHORT).show();
                str_Yes="Y";
                txt_yes.setVisibility(View.GONE);
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_yes.setVisibility(View.VISIBLE);
                String str_No = btnno.getText().toString();
                Toast.makeText(getActivity(), str_No, Toast.LENGTH_SHORT).show();

                btnnext.setVisibility(View.INVISIBLE);

            }
        });

        


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_yes=btnyes.getText().toString();

                Bundle bundle=new Bundle();
                bundle.putString("key_contact",contact_data);
                bundle.putString("key_check_agree",checkagree_data);
                bundle.putString("key_Yes1",txt_yes);

                bundle.putString("str_country",str_country);
                bundle.putString("str_provice",str_provice);
                bundle.putString("str_district",str_district);
                bundle.putString("str_city",str_city);


                questionares_page2 page2=new questionares_page2();
                page2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,page2).commit();

                Toast.makeText(getActivity(), checkagree_data+" \n "+contact_data+" \n "+ txt_yes + "\n "
                        +"\n "

                                +"  "+checkagree_data+"  "+"\n"+str_country+"\n"
                                +str_provice+"\n"+str_city+"\n"+str_district
                        , Toast.LENGTH_SHORT).show();

            }
        });

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle=new Bundle();
                bundle.putString("key_contact",contact_data);
                bundle.putString("key_check_agree",checkagree_data);


                bundle.putString("str_country",str_country);
                bundle.putString("str_provice",str_provice);
                bundle.putString("str_district",str_district);
                bundle.putString("str_city",str_city);

                fragment_Where_Are_You_Located fragmentWhereAreYouLocated=new fragment_Where_Are_You_Located();
                fragmentWhereAreYouLocated.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.datacontainer,fragmentWhereAreYouLocated).commit();


            }
        });




        return view;    }
}