package com.example.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Blood_detail_Adapter extends RecyclerView.Adapter<Blood_detail_Adapter.InstallmentViewHolder> {

    Context mContext;
    private List<blood_Model_class> installmentList;

    public Blood_detail_Adapter(Context mContext, List<blood_Model_class> installmentList) {
        this.mContext = mContext;
        this.installmentList = installmentList;
    }

    @NonNull
    @Override
    public InstallmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.country_list, parent, false);

        return new InstallmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstallmentViewHolder holder, int position) {

        blood_Model_class user_installment = installmentList.get(position);
        holder.txt_TotalAmount.setText("Total Amount: "+user_installment.CAMP_ID);
        holder.txt_PaidAmount.setText("Paid Installment: "+user_installment.CAMP_NAME);
        holder.txt_RemainingAmount.setText("Balance Due: "+user_installment.ADDRESS);

    }

    @Override
    public int getItemCount() {
        return installmentList.size();
    }

    class InstallmentViewHolder extends RecyclerView.ViewHolder{

        TextView txt_TotalAmount, txt_PaidAmount, txt_RemainingAmount;

        public InstallmentViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_TotalAmount = itemView.findViewById(R.id.id_capital);
            txt_PaidAmount = itemView.findViewById(R.id.id_c_code);
            txt_RemainingAmount = itemView.findViewById(R.id.id_calling_code);
        }
    }
}
