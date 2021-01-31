//spakowano do folderu
package com.pl.edu.prz.aplikacjadietetyczna;


import android.content.Intent;// importowanie rozmiar treści
import android.os.Bundle;// importowanie systemu operacyjnego android do obiektu Bundle
import android.view.View;// importowanie okna widokowego androida
import android.widget.Button;// importowanie z panelu bocznego przycisk do aplikcji android
import android.widget.EditText;// importujemy z panelu bocznego androida pole tekstowe
import android.widget.Toast;// importujemy z panelu bocznego androida widoku zawierającego krótką krótką wiadomość dla użytkownika
import android.support.v7.app.AppCompatActivity;//importujemy wsparcie v7
// publiczna klasa MainActivity1 rozszerzenie działania aplikacji CompatActivity
public class MainActivity2 extends AppCompatActivity {
    // prywatne miejsce na wpisanie imienia
    private EditText Name;
    // prywatne miejsce na wpisanie nazwiska
    private EditText Surname;
    //prywatny przycisk startu
    private Button Start;

    //prywatna biblioteka nazwy imienia
    private String Username ;
    //prywatna biblioteka nazwy nazwiska
    private String Usersurname ;
    //weryfikacja uporządkowanego  zbioru wartości
    boolean isValid = false;

    @Override
    //kreujemy w modyfikatorze protected funkcji void pakiet zapisanych InstanceState
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //wyszukiwanie poszczególnych identyfikatorów danych
        Name = findViewById(R.id.idName);
        Surname = findViewById(R.id.idSurname);
        Start = findViewById(R.id.idRozpocznij);

//wywołany po kliknięciu przycisku
        Start.setOnClickListener(new View.OnClickListener() {//zaimplementować View.OnClickListener i utworzyć nową instancję View.OnClickListener jako parametr metody setOnClickListener ()
            @Override
            public void onClick(View v) {
                Intent toMainActivity3=new Intent(MainActivity2.this,MainActivity3.class);//wysłanie do MainActivity3 nowych klas
                String inputName = Name.getText().toString(); //załącznie biblioteki z imieniem
                String inputSurname = Surname.getText().toString();// załaczenie bibiolteki z nazwiskiem

                if (inputName.isEmpty() || inputSurname.isEmpty()){// jeśli pole imię lub pole nazwisko jest puste
                    Toast.makeText(MainActivity2.this, "Proszę uzupełnić brakujące pola!", Toast.LENGTH_SHORT).show();// wyskakuje wskazówka "Proszę uzupełnić brakujące pola!"
                }else {// lub
                    isValid = validate(inputName, inputSurname);// jeśli imię jest poprawnie wpisane  to ....
                    {
                        Toast.makeText(MainActivity2.this, "Witamy!", Toast.LENGTH_SHORT).show();//Wyświetlenie tekstu "Witamy"
                        //dodajemy nowe activity
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(toMainActivity3);// przekierowanie do MAinActivity3
                    }
                }
            }
        });
    }
    private boolean validate(String name, String surname){// weryfikacja uporządkowanego zbioru wartości bibioteki imienia oraz bibliotekinazwiska
        if (name.equals(Username) && surname.equals(Usersurname)){//jeśli imie i nazwisko się zgadza z username
            return true;// zwrócenie prawdy
        }
        return true;// zwrócenie prawdy
    }
}
