package com.example.personrecyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonDataAdapter extends RecyclerView.Adapter<PersonDataAdapter.PersonViewHolder>{

    private ArrayList<PersonData> personArrayList;
    private OnPersonClickedListener listener;

    //initialize the above two member variables inside the class constructor
    public PersonDataAdapter(ArrayList<PersonData> personArrayList, OnPersonClickedListener listener) {
        this.personArrayList = personArrayList;
        this.listener = listener;
    }

    //create the viewholder object passing it the layout reference and the listener
    @NonNull
    @Override
    public PersonDataAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_itemview_layout,parent,false);
        return new PersonViewHolder(view);
    }

    //bind the view holder to the data from a given position on the list
    @Override
    public void onBindViewHolder(@NonNull PersonDataAdapter.PersonViewHolder holder, int position) {

        PersonData person = personArrayList.get(position);
        holder.tvFirstname.setText(person.getFirstName());
        holder.tvLastname.setText(person.getLastName());
        holder.tvAge.setText(String.valueOf(person.getAge()));
        holder.tvSalary.setText(String.valueOf(person.getSalary()));

        holder.bind(person, listener);
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    //the view holder is the backbone of the recyclerview adapter as it
    // provides the references to the child view to display the data.
    public class PersonViewHolder extends RecyclerView.ViewHolder {

        public TextView tvFirstname;
        public TextView tvLastname;
        public TextView tvAge;
        public TextView tvSalary;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView); //the itemView is one of the numerous rows of a list.
                            // it holds other views such as textviews, imageviews, etc.

            tvFirstname = itemView.findViewById(R.id.tv_firstname);
            tvLastname = itemView.findViewById(R.id.tv_lastname);
            tvAge = itemView.findViewById(R.id.tv_age);
            tvSalary = itemView.findViewById(R.id.tv_salary);
        }

        //this method is used to bind the listener to the itemview or each row of the list
        public void bind(final PersonData person, final OnPersonClickedListener listener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(person);
                }
            });
        }
    }

    public interface OnPersonClickedListener{

        void onItemClicked(PersonData person);
    }

}
