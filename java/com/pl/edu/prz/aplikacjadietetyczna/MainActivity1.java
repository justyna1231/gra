//spakowano do folderu
package com.pl.edu.prz.aplikacjadietetyczna;

import android.content.Intent;// importowanie rozmiar treści
import android.os.Bundle;// importowanie systemu operacyjnego android do obiektu Bundle
import android.view.View;// importowanie okna widokowego androida
import android.widget.Button;// importowanie z panelu bocznego przycisk do aplikcji android
import android.support.v7.app.AppCompatActivity;//importujemy wsparcie v7

// publiczna klasa MainActivity1 rozszerzenie działania aplikacji CompatActivity
public class MainActivity1 extends AppCompatActivity {
    //prywatny przycisk przycisku
    private Button button;
    @Override
    //kreujemy w modyfikatorze protected funkcji void pakiet zapisanych InstanceState
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        //przypisujemy pola View z pliku xml do zmiennych
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //przekazywanie danych pomiędzy Activity
                Intent intent = new Intent(MainActivity1.this , MainActivity2.class);
                //start aktywności
                startActivity(intent);
            }
        });
    }

    }

