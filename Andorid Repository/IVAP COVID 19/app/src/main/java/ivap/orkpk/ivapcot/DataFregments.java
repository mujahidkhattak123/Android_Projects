package ivap.orkpk.ivapcot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataFregments extends Fragment {
    private Button btnbtnbeingassisments;
    TextView txtabout,txt_faq;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.data_fregments_layout,container,false);
        btnbtnbeingassisments=view.findViewById(R.id.btnbeingassisments);
        btnbtnbeingassisments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                MainActivity.fragmentManager.beginTransaction().replace(R.id.datacontainer,new BeinAssesmentsFragments(),null).commit();
            }
        });

        txtabout=view.findViewById(R.id.txtaboutus);
        txt_faq=view.findViewById(R.id.faq);



        return view;

    }
}
