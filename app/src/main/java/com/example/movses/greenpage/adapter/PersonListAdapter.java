package com.example.movses.greenpage.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movses.greenpage.R;
import com.example.movses.greenpage.activities.DetailsActivity;
import com.example.movses.greenpage.activities.MainActivity;
import com.example.movses.greenpage.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Movses on 1/14/18.
 */

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.ViewHolder>{

    private List<Person> personList;
    private Context context;




    public PersonListAdapter(List<Person> personList, Context context  ) {
        this.personList = personList;
        this.context = context;}


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false
        );
        return new ViewHolder(view) ;




    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person=personList.get(position);
        holder.surname.setText(person.getName());
        holder.name.setText(person.getSurname());

        Glide.with(context)
                .load(person.getImgUrl())
                .apply(new RequestOptions().error(R.drawable.ic_launcher_background).circleCrop())
                .into(holder.profileImage);
        changeColor(person.isSex(),holder.name,holder.surname);
        holder.itemLayout.setOnClickListener(v -> {
            Intent intent= new Intent(context, DetailsActivity.class);
            intent.putExtra("img_url", person.getImgUrl());
            intent.putExtra("name", person.getName());
            intent.putExtra("surname", person.getSurname());
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return personList.isEmpty()?0:personList.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImage;
        private TextView name;
        private TextView surname;
        private LinearLayout itemLayout;

        public ViewHolder(View itemView)  {
            super(itemView);
            profileImage=itemView.findViewById(R.id.profile_image);
            name=itemView.findViewById(R.id.name);
            surname=itemView.findViewById(R.id.surname);
            itemLayout=(LinearLayout) itemView.findViewById(R.id.layout);
        }


    }

    private void changeColor(boolean gender,TextView... view){
        if (!gender){
            view[0].setTextColor(context.getResources().getColor(R.color.female_color));
            view[1].setTextColor(context.getResources().getColor(R.color.female_color));
        }
    }

    public void filterList(List<Person> filteredPerson) {
        this.personList = filteredPerson;
       notifyDataSetChanged();}



}


