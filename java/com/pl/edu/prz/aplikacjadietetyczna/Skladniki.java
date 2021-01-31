//spakowano do folderu
package com.pl.edu.prz.aplikacjadietetyczna;

import android.os.Bundle;// importowanie systemu operacyjnego android do obiektu Bundle
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;//importujemy wsparcie v4
import android.view.LayoutInflater;// importowanie instalacji LayoutInflater
import android.view.View;// importowanie okna widokowego androida
import android.view.ViewGroup;//importowanie  grupy widoków  android
import android.widget.CheckBox;// importowanie pola wyboru
import android.widget.LinearLayout;// importowanie Linear Layout
//publiczna klasa Skladniki rozszerzona do Fragment
public class Skladniki extends Fragment {
    @org.jetbrains.annotations.Nullable
    @Override
    //zapisanie aktualnego stanu aplikacji
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //pobranie odpowiedniego indeksu (odpowiedzialnego za przepis)
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        //pobranie widoku layoutu z fragment_viewpager
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.ingredientsLayout);
        //podzielenie ciągu bibiolteki (składników)
        String[] ingredients = Diets.ingredients[index].split(";");
        setUpCheckBoxes(ingredients, linearLayout);
        // zwrócenie widoku
        return  view;
    }
    //skonfigurowanie CheckBoxa
    private void setUpCheckBoxes(String[] ingredients, ViewGroup container){
        for (String ingredient : ingredients){
            CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setPadding(8,16,8,16);
            checkBox.setTextSize(20f);
            checkBox.setText(ingredient);
            container.addView(checkBox);
        }
    }
}
