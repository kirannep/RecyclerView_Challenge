package com.example.reclyclerview_challenge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder>{

    private ArrayList<Person> personArrayList;
    private OnClickedListener listener;

    public PersonAdapter(ArrayList<Person> personArrayList, OnClickedListener listener) {
        this.personArrayList = personArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personArrayList.get(position);
        holder.tvFirstname.setText(person.getFirstname());
        holder.bind(person,listener);

    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        public TextView tvFirstname;


        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstname = itemView.findViewById(R.id.first_name);

        }

        public void bind(final Person person, final OnClickedListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickedPerson(person);
                }
            });
        }
    }

    public interface OnClickedListener{
        void onClickedPerson(Person person);
    }
}
