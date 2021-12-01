package com.example.bloodbank;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Search_blood_camp_fragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Search_blood_camp_fragments extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;




    private static final String URL_province = "http://cvp.crazybillys.net/MobileUser/getProvinces";
    private static final String URL_district = "http://cvp.crazybillys.net/MobileUser/getDistrict";
    private static final String URL_getBloodCamp= "http://cvp.crazybillys.net/MobileUser/getBloodCamp";
    List<model_class_blood> campList;
    private List<Response.Listener<JSONObject>> arrayList;
    RecyclerView recyclerView;
    private Blood_detail_Adapter adapter;
    String camp_name,camp_address;
    Spinner spinner_province,spinner_district;
    String province_name, province_id , str_district_name,str_district_id,str_blood_camp_Name,str_Bloodcapm_Detail,str_Bloodcapm_adress,str_Bloodcapm_status;

    TextView txt_blood_camp_name,txt_blood_camp_detail,txt_blood_camp_adress,txt_blood_camp_status;

    private List<blood_Model_class> contactListFiltered;
    //listview object
    ListView listView;

    public static final String  PROVINCE_ID ="PROVINCE_ID";
    public static final String  DISTRICT_ID ="DISTRICT_ID";




    //for Provinces
    ArrayList<Pair<String, String>> province_pair_array = new ArrayList<androidx.core.util.Pair<String, String>>();

    ArrayList<androidx.core.util.Pair<String, String>> district_pair_array = new ArrayList<androidx.core.util.Pair<String, String>>();

    //for Province
    ArrayList<String> ProvinceName,ProvinceId;


    //for District
    ArrayList<String> DistrictName,DistrictId;
    //for District





    public Search_blood_camp_fragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search_blood_camp_fragments.
     */
    // TODO: Rename and change types and number of parameters
    public static Search_blood_camp_fragments newInstance(String param1, String param2) {
        Search_blood_camp_fragments fragment = new Search_blood_camp_fragments();
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

        View view=inflater.inflate(R.layout.fragment_search_blood_camp_fragments,container,false);


        //initializing listview and hero list
        listView = (ListView) view.findViewById(R.id.listView);
        campList = new ArrayList<>();


        getprovice();


        ProvinceName = new ArrayList<>();
        DistrictName = new ArrayList<>();
        ProvinceId = new ArrayList<>();
        DistrictId = new ArrayList<>();


        spinner_province = view.findViewById(R.id.spinner_province);
        spinner_district = view.findViewById(R.id.spinner_district);


        return view;

    }


    private void getprovice() {

        final JsonObjectRequest jsonObjectReques=new JsonObjectRequest(Request.Method.GET, URL_province, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(final JSONObject response) {
                        try {
                            JSONArray array=response.getJSONArray("data");

                            for (int i=0 ; i < array.length(); i++){
                                JSONObject province_data=array.getJSONObject(i);
                                province_name =province_data.getString("PROVINCE_NAME");
                                province_id =province_data.getString("PROVINCE_ID");

                                String str_id = String.valueOf(province_id);

                                ProvinceName.add(province_name + "  " + province_id);
                                ProvinceId.add(province_id);

                                province_pair_array.add(androidx.core.util.Pair.create(str_id, province_name));

                                spinner_province.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, ProvinceName));


                                spinner_province.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                                spinner_district.setAdapter(new ArrayAdapter<String>(User_Profile.this, android.R.layout.simple_spinner_dropdown_item,ProvinceId));

                                        DistrictName.clear();
                                        province_id = province_pair_array.get(i).first;


//                               String  str_provice= adapterView.getItemAtPosition(i).toString();

//                                Toast.makeText(User_Profile.this, province_id, Toast.LENGTH_SHORT).show();

                                        post_for_Get_district();
//
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),error.toString(), Toast.LENGTH_SHORT).show();


//                spinner_province.setAdapter(new ArrayAdapter<String>(User_Profile.this, android.R.layout.simple_spinner_dropdown_item, ProvinceName));

            }
        });
        RequestQueue queue1 = Volley.newRequestQueue(getActivity());
        queue1.add(jsonObjectReques);
    }


    private void  post_for_Get_district(){



        StringRequest stringRequest_Get_district=new StringRequest(Request.Method.POST, URL_district, new Response.Listener<String>() {
            @Override
            public void onResponse(String response2) {

//                        Toast.makeText(User_Profile.this, "Success"+response2, Toast.LENGTH_SHORT).show();



                try {

                    JSONObject object_Get_district=new JSONObject(response2);
                    JSONArray jsonArray1=object_Get_district.getJSONArray("data");
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        JSONObject distrt = jsonArray1.getJSONObject(i);
                        str_district_name=distrt.getString("DISTRICT_NAME");
                        str_district_id=distrt.getString("DISTRICT_ID");
//                        Toast.makeText(User_Profile.this, "Success"+str_district_name, Toast.LENGTH_SHORT).show();

                        String str_id_district = String.valueOf(str_district_id);

                        DistrictName.add(str_district_name + "  " + str_district_id);
                        DistrictId.add(str_district_id);

                        district_pair_array.add(androidx.core.util.Pair.create(str_id_district, str_id_district));

                        spinner_district.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, DistrictName));

                        spinner_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                str_district_id = district_pair_array.get(i).first;

                                //creating custom adapter object
                                ListViewAdapter adapter = new ListViewAdapter(campList, getActivity());

                                listView.setAdapter(null);

                                adapter.notifyDataSetChanged();

                                post_for_Get_Blood_Camp_detail();


                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {




                            }
                        });

                        // Do you fancy stuff
                        // Example: String gifUrl = jo.getString("url");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),error.toString(), Toast.LENGTH_LONG).show();




            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put(PROVINCE_ID,province_id);

                return map;
            }
        };
        RequestQueue requestQueue_post_Get_district= Volley.newRequestQueue(getActivity());
        requestQueue_post_Get_district.add(stringRequest_Get_district);
    }


    private void post_for_Get_Blood_Camp_detail(){
        StringRequest stringRequest_campt_detail=new StringRequest(Request.Method.POST, URL_getBloodCamp, new Response.Listener<String>() {
            @Override
            public void onResponse(String response2) {

                Toast.makeText(getActivity(), response2, Toast.LENGTH_SHORT).show();
                try {
                    //getting the whole json object from the response
                    JSONObject obj = new JSONObject(response2);

                    //we have the array named hero inside the object
                    //so here we are getting that json array
                    JSONArray heroArray = obj.getJSONArray("data");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        JSONObject heroObject = heroArray.getJSONObject(i);

                        //creating a hero object and giving them the values from json object
                        model_class_blood camp_name = new model_class_blood(heroObject.getString("CAMP_NAME"), heroObject.getString("ADDRESS"));

                        //adding the hero to herolist
                        campList.add(camp_name);
                    }

                    //creating custom adapter object
                    ListViewAdapter adapter = new ListViewAdapter(campList,getActivity());



                    //adding the adapter to listview
                    listView.setAdapter(adapter);

                    // ListView setOnItemClickListener function apply here.

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                    {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {

                            Intent intent = new Intent(getActivity(),Donait_Blood.class);
                            startActivity(intent);
                            // TODO Auto-generated method stub
                        }
                    });



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),error.toString(), Toast.LENGTH_LONG).show();


            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> map_get_blood_camp_detail=new HashMap<>();
                map_get_blood_camp_detail.put(PROVINCE_ID,province_id);
                map_get_blood_camp_detail.put(DISTRICT_ID,str_district_id);



                return map_get_blood_camp_detail;
            }
        };
        RequestQueue requestQueue_post_Blood_Camp_detail= Volley.newRequestQueue(getActivity());
        requestQueue_post_Blood_Camp_detail.add(stringRequest_campt_detail);

    }

}