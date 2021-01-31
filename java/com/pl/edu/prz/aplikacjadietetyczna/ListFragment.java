package com.pl.edu.prz.aplikacjadietetyczna;

//import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.os.Bundle;// importowanie systemu operacyjnego android do obiektu Bundle
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;//importujemy wsparcie v4
import android.support.v7.widget.LinearLayoutManager;//importujemy wsparcie v7
import android.support.v7.widget.RecyclerView;//importujemy wsparcie v7
import android.view.LayoutInflater;// importowanie instalacji LayoutInflater
import android.view.View;// importowanie okna widokowego androida
import android.view.ViewGroup;///importowanie  grupy widoków  android

//klasa publiczna ListFragment rozszerzenie działania Fragmant
public class ListFragment extends Fragment {
    public interface OnSelectedInterface{
        void onListSelected(int index);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       OnSelectedInterface listener = (OnSelectedInterface) getActivity();
        //return super.onCreateView(inflater, container, savedInstatneState);
        //pobranie widoku layoutu z fragment_list
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        // wyświetlanie listy elementów o układzie
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.listRecyclerView);
        //dostarczanie nowych lub zmodyfikowanych danych do RecyclerView.Adapter i obsługuje wszystkie obliczenia różnic
        ListAdapter listAdapter = new ListAdapter(listener);
        recyclerView.setAdapter(listAdapter);
        //mierzenie i pozycjonowanie widoków elementów w RecyclerView
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        //zwrócenie widoku
        return view;
    }
}
