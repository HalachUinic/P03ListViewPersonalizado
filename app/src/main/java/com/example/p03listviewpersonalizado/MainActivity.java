package com.example.p03listviewpersonalizado;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    private AdapterAlumno adapter;
    private ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayList<AlumnoItem> list = new ArrayList<>(Arrays.asList(
                new AlumnoItem(getString(R.string.itemEstefano), getString(R.string.Estefano), R.drawable.ft2019030344),
                new AlumnoItem(getString(R.string.itemCarlosAlberto), getString(R.string.CarlosAlberto), R.drawable.ft2020030174),
                new AlumnoItem(getString(R.string.itemMarcoAntonio), getString(R.string.MarcoAntonioAlarid), R.drawable.ft2020030176),
                new AlumnoItem(getString(R.string.itemJoshuaDaniel), getString(R.string.JoshuaDaniel), R.drawable.ft2020030181),
                new AlumnoItem(getString(R.string.itemErnestoDavid), getString(R.string.ErnestoDavid), R.drawable.ft2020030184),
                new AlumnoItem(getString(R.string.itemMaximiliano), getString(R.string.Maximiliano), R.drawable.ft2020030189),
                new AlumnoItem(getString(R.string.itemIvanEnrique), getString(R.string.IvanEnrique), R.drawable.ft2020030199),
                new AlumnoItem(getString(R.string.itemJesusEduardo), getString(R.string.JesusEduardo), R.drawable.ft2020030212),
                new AlumnoItem(getString(R.string.itemDavidAntonio), getString(R.string.DavidAntonio), R.drawable.ft2020030241),
                new AlumnoItem(getString(R.string.itemGustavoAdolfo), getString(R.string.GustavoAdolfo), R.drawable.ft2020030243),
                new AlumnoItem(getString(R.string.itemJuanCarlos), getString(R.string.JuanCarlos), R.drawable.ft2020030249),
                new AlumnoItem(getString(R.string.itemAlejo), getString(R.string.Alejo), R.drawable.ft2020030264),
                new AlumnoItem(getString(R.string.itemCarlosJair), getString(R.string.CarlosJair), R.drawable.ft2020030268),
                new AlumnoItem(getString(R.string.itemJesusTadeo), getString(R.string.JesusTadeo), R.drawable.ft2020030292),
                new AlumnoItem(getString(R.string.itemJair), getString(R.string.Jair), R.drawable.ft2020030304),
                new AlumnoItem(getString(R.string.itemAngelRonaldoAnastacio), getString(R.string.AngelRonaldoAnastacio), R.drawable.ft2020030329),
                new AlumnoItem(getString(R.string.itemAngelZinedineAnastacio), getString(R.string.AngelZinedineAnastacio), R.drawable.ft2020030325),
                new AlumnoItem(getString(R.string.itemDiego), getString(R.string.Diego), R.drawable.ft2020030306),
                new AlumnoItem(getString(R.string.itemSalmaYareth), getString(R.string.SalmaYareth), R.drawable.ft2020030315),
                new AlumnoItem(getString(R.string.itemJesusAntonio), getString(R.string.JesusAntonio), R.drawable.ft2020030333),
                new AlumnoItem(getString(R.string.itemYenniferCarolina), getString(R.string.YenniferCarolina), R.drawable.ft2020030389),
                new AlumnoItem(getString(R.string.itemManuelAlexis), getString(R.string.ManuelAlexis), R.drawable.ft2020030766),
                new AlumnoItem(getString(R.string.itemVictorMoises), getString(R.string.VictorMoises), R.drawable.ft2020030771),
                new AlumnoItem(getString(R.string.itemHalachUinic), getString(R.string.HalachUinic), R.drawable.ft2020030777),
                new AlumnoItem(getString(R.string.itemEnzoAlejandro), getString(R.string.EnzoAlejandro), R.drawable.ft2020030799),
                new AlumnoItem(getString(R.string.itemJoseAlberto), getString(R.string.JoseAlberto), R.drawable.ft2020030808),
                new AlumnoItem(getString(R.string.itemGiancarlo), getString(R.string.Giancarlo), R.drawable.ft2020030819),
                new AlumnoItem(getString(R.string.itemLuisAngel), getString(R.string.LuisAngel), R.drawable.ft2020030865),
                new AlumnoItem( getString(R.string.itemPaolaEmiret), getString(R.string.PaolaEmiret), R.drawable.ft2020030313)
        ));


        listView = findViewById(R.id.listView);
        adapter = new AdapterAlumno(this, R.layout.item_alumno, R.id.lblNombe, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Se ha seleccionado " + ((AlumnoItem) adapterView.getItemAtPosition(i)).getTxtNombre(), Toast.LENGTH_SHORT).show();

           }
        }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.searchview, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
