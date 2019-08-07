package com.example.tae_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter <PersonAdapter.PersonViewHolder>{

    private ArrayList<Person>personArrayList;
    private OnPersonClickedListener listener;

    public PersonAdapter(ArrayList<Person> personArrayList, OnPersonClickedListener onPersonClickedListener) {
        this.personArrayList = personArrayList;
        this.listener = onPersonClickedListener;

    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout,parent,false);

        return new PersonViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

        //first method to call
//        holder.tv_first_name.setText(personArrayList.get(position).getFirstName());
        //different method to call
        Person person = personArrayList.get(position);
        holder.tv_first_name.setText(person.getFirstName());
        holder.tv_last_name.setText(person.getLastName());

        //the "" is a shortcup to parse int to Strings
        holder.tv_age.setText(""+person.getAge());


    }
    //this determines how many items are going to be displayed on the device
    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public TextView tv_first_name, tv_last_name, tv_age;

        //we can init straight away in the constructor (down below)
        OnPersonClickedListener onPersonClickedListener;

        public PersonViewHolder(@NonNull View itemView,OnPersonClickedListener onPersonClickedListener) {
            super(itemView);
            tv_first_name = itemView.findViewById(R.id.tv_first_name);
            tv_last_name = itemView.findViewById(R.id.tv_last_name);
            tv_age = itemView.findViewById(R.id.tv_age);

            this.onPersonClickedListener = onPersonClickedListener;

            itemView.setOnClickListener(this);


        }

        //

        @Override
        public void onClick(View view) {
            Person person = personArrayList.get(getAdapterPosition());
            onPersonClickedListener.onItemClick(person);
        }
    }

    //this class will allow an action on an item of the list
    //don't forget to add the implement in the PersonViewHolder
    public interface OnPersonClickedListener{
        void onItemClick(Person person);

    }
}
