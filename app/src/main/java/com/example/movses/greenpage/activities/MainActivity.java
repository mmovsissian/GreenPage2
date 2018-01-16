package com.example.movses.greenpage.activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.movses.greenpage.adapter.PersonListAdapter;
import com.example.movses.greenpage.R;
import com.example.movses.greenpage.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PersonListAdapter adapter;
    EditText editsearch;
    ImageButton search;
    ImageButton cancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);
        editsearch = findViewById(R.id.editsearch);
        search = findViewById(R.id.search);
        cancel= findViewById(R.id.cancel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new PersonListAdapter(getPersonList(),this);
        recyclerView.setAdapter(adapter);





//        search.setOnClickListener((View event) ->{
//            filter(editsearch.getText().toString());
//        });


        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editsearch.getText().toString());
            }
        });





        cancel.setOnClickListener((View event) ->{
            editsearch.setText("");
            filter(editsearch.getText().toString());
        });


        }



//    private List<Person> getPersonList(){
//        List<Person> personList=new ArrayList<>();
//        personList.add(new Person("Vaxo","Karapetyan"));
//        personList.add(new Person("Gago","Alexanyan"));
//        personList.add(new Person("Armine","Ghevondyan"));
//        personList.add(new Person("Gayane","Karapetyan"));
//        personList.add(new Person("Vaxo","Karapetyan"));
//        personList.add(new Person("Gago","Alexanyan"));
//        personList.add(new Person("Armine","Ghevondyan"));
//        personList.add(new Person("Gayane","Karapetyan"));
//        personList.add(new Person("Vaxo","Karapetyan"));
//        personList.add(new Person("Gago","Alexanyan"));
//        personList.add(new Person("Armine","Ghevondyan"));
//        personList.add(new Person("Gayane","Karapetyan"));
//        return personList;
//    }

    private List<Person> getPersonList(){
        List<Person> personList=new ArrayList<>();
        personList.add(new Person("Vaxo","Karapetyan",true,"https://cdn-images-1.medium.com/fit/c/36/36/0*m8eYUA8hxoCIDIrU.jpeg"));
        personList.add(new Person("Gago","Alexanyan",true,"https://i1.rgstatic.net/ii/profile.image/272579155984397-1441999343548_Q64/John_Hart9.jpg"));
        personList.add(new Person("Armine","Ghevondyan",false,"https://i1.rgstatic.net/ii/profile.image/569303440924674-1512743925674_Q64/Samara_Danel.jpg"));
        personList.add(new Person("Gayane","Karapetyan",false,"https://cdn.slidesharecdn.com/profile-photo-carologic-48x48.jpg?cb=1512956919"));
        personList.add(new Person("Vaxo","Karapetyan",true,"https://cdn-images-1.medium.com/fit/c/36/36/0*m8eYUA8hxoCIDIrU.jpeg"));
        personList.add(new Person("Gago","Alexanyan",true,"https://i1.rgstatic.net/ii/profile.image/272579155984397-1441999343548_Q64/John_Hart9.jpg"));
        personList.add(new Person("Armine","Ghevondyan",false,"https://i1.rgstatic.net/ii/profile.image/569303440924674-1512743925674_Q64/Samara_Danel.jpg"));
        personList.add(new Person("Gayane","Karapetyan",false,"https://cdn.slidesharecdn.com/profile-photo-carologic-48x48.jpg?cb=1512956919"));
        personList.add(new Person("Vaxo","Karapetyan",true,"https://cdn-images-1.medium.com/fit/c/36/36/0*m8eYUA8hxoCIDIrU.jpeg"));
        personList.add(new Person("Gago","Alexanyan",true,"https://i1.rgstatic.net/ii/profile.image/272579155984397-1441999343548_Q64/John_Hart9.jpg"));
        personList.add(new Person("Armine","Ghevondyan",false,"https://i1.rgstatic.net/ii/profile.image/569303440924674-1512743925674_Q64/Samara_Danel.jpg"));
        personList.add(new Person("Gayane","Karapetyan",false,"https://cdn.slidesharecdn.com/profile-photo-carologic-48x48.jpg?cb=1512956919"));
        return personList;
    }

    private void filter(String text) {
        List<Person> filterPersonlist= new ArrayList<>();
        for (Person s : getPersonList()) {
            if (s.getName().toLowerCase().contains(text.toLowerCase())) {
                filterPersonlist.add(s);
            }
        }
        adapter.filterList(filterPersonlist);
    }






}
