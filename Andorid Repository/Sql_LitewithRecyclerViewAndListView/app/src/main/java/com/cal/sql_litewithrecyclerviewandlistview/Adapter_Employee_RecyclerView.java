package com.cal.sql_litewithrecyclerviewandlistview;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Adapter_Employee_RecyclerView extends RecyclerView.Adapter<Adapter_Employee_RecyclerView.ProductViewHolder>   {
    int custom_list_item;
    SQLiteDatabase mDatabase;


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Model_Class> productList;

    public Adapter_Employee_RecyclerView(Context mCtx, List<Model_Class> productList,int custom_list_item, SQLiteDatabase mDatabase ) {
        this.custom_list_item = custom_list_item;
        this.mDatabase = mDatabase;
        this.mCtx = mCtx;
        this.productList = productList;
    }

    //getting the context and product list with constructor

    @NonNull
    @Override
    public Adapter_Employee_RecyclerView.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.custom_list_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Employee_RecyclerView.ProductViewHolder holder, int position) {


        //getting the product of the specified position
        final Model_Class product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewName.setText(product.getMname());
        holder.textViewUsername.setText(product.getMusername());
        holder.textViewEmail.setText(product.getMemail());
        holder.textViewPhone.setText(product.getMphno());


        holder.editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEmployee(product);
            }
        });

        holder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql = "DELETE FROM Student WHERE id = ?";
                        mDatabase.execSQL(sql, new Integer[]{product.getId()});
                        Snackbar.make(view, "Deleted" + product.getMname(), Snackbar.LENGTH_SHORT).show();
                        Toast.makeText(mCtx, "Deleted successfully!", Toast.LENGTH_SHORT).show();

                        reloadEmployeesFromDatabase(); //Reload List
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewUsername, textViewEmail, textViewPhone;
        ImageView editbtn, deletebtn;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);

            deletebtn = itemView.findViewById(R.id.buttonDeleteStudent);
            editbtn = itemView.findViewById(R.id.buttonEditstudent);

        }
    }



    private void updateEmployee(final Model_Class product) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.dialog_update_employee, null);
        builder.setView(view);


        final EditText editTextName = view.findViewById(R.id.editTextName);
        final EditText editUsername = view.findViewById(R.id.editUsername);
        final EditText editemail = view.findViewById(R.id.editEmail);
        final EditText editphno = view.findViewById(R.id.editTextphno);



        editTextName.setText(product.getMname());
        editUsername.setText(product.getMusername());
        editemail.setText(product.getMemail());
        editphno.setText(product.getMphno());

        final AlertDialog dialog = builder.create();
        dialog.show();

        // CREATE METHOD FOR EDIT THE FORM
        view.findViewById(R.id.buttonUpdateEmployee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String email = editemail.getText().toString().trim();
                String username = editUsername.getText().toString().trim();
                String phno = editphno.getText().toString().trim();



                if (name.isEmpty()) {
                    editTextName.setError("Name can't be blank");
                    editTextName.requestFocus();
                    return;
                }

                if (username.isEmpty()) {
                    editUsername.setError("Salary can't be blank");
                    editUsername.requestFocus();
                    return;
                }//Name, Email, UserName, PhoneNo

                String sql = "UPDATE Student \n" +
                        "SET Name = ?, \n" +
                        "Email = ?,\n"+
                        "Username = ?,\n"+
                        " PhoneNO= ? \n" +
                        "WHERE id = ?;\n";

                mDatabase.execSQL(sql, new String[]{name, email,username,phno, String.valueOf(product.getId())});
                Toast.makeText(mCtx, "Student Updated", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });
    }

    void reloadEmployeesFromDatabase(){

        Cursor cursorproduct1 = mDatabase.rawQuery("SELECT * FROM Student", null);
        if (cursorproduct1.moveToFirst()) {
            productList.clear();
            do {
                productList.add(new Model_Class(
                        cursorproduct1.getInt(0),
                        cursorproduct1.getString(1),
                        cursorproduct1.getString(2),
                        cursorproduct1.getString(3),
                        cursorproduct1.getString(4)   ));
            } while (cursorproduct1.moveToNext());
        }
        cursorproduct1.close();
        notifyDataSetChanged();
    }
}
