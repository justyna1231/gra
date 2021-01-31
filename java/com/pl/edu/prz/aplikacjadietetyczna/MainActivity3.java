//spakowano do folderu
package com.pl.edu.prz.aplikacjadietetyczna;
//import android.os.Bundle;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.os.Bundle;// importowanie systemu operacyjnego android do obiektu Bundle
import android.support.v4.app.FragmentManager;//importujemy wsparcie v4
import android.support.v4.app.FragmentTransaction;//importujemy wsparcie v4
import android.support.v7.app.AppCompatActivity;//importujemy wsparcie v7
// publiczna klasa MainActivity3 rozszerzenie działania aplikacji CompatActivity
public class MainActivity3 extends AppCompatActivity implements ListFragment.OnSelectedInterface{
    //publiczna klasa statycznego finału biblioteki String  VIEWPAGER_FRAGMENT
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";
    //publiczna klasa statycznego finału biblioteki String  LIST_FRAGMENT
    public static final String LIST_FRAGMENT = "viewpager_fragment";
    ////kreujemy w modyfikatorze protected funkcji void pakiet zapisanych InstanceState
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
// jeśli zapisane fragment jest null
if(savedFragment == null) {
        ListFragment fragment = new ListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    //dodanie LIST_FRAGMENT
        fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
    //Zatwierdzenie transakcji fragmentarycznej
        fragmentTransaction.commit();
    }
}
@Override//wywoływanie obsługi elementów typu fragments
public void onListSelected(int index){
    //Toast.makeText(MainActivity.this, Recipes.names[index], Toast.LENGTH_LONG).show();
    ViewPagerFragment fragment = new ViewPagerFragment();
    Bundle bundle = new Bundle();//odzwzorowanie kluczy literowych String
    bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);//odpowiedzialne za numer indexu przepisu
    fragment.setArguments(bundle);
    FragmentManager fragmentManager = getSupportFragmentManager();//FragmentMenager służy do tworzynia transakcji dodawania usawania i zastępowania fragmentów
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
    fragmentTransaction.addToBackStack(null);//dodanie do stosu wstecznego
    fragmentTransaction.commit();//Zatwierdzenie transakcji fragmentarycznej
    }
}
