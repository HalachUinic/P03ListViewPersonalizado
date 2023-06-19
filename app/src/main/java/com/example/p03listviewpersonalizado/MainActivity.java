package com.example.p03listviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SearchView srcLista;
    private AdapterAlumno adapter;
    private ListView sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        srcLista = findViewById(R.id.menu_search);

        ArrayList<AlumnoItem> list = new ArrayList<>();
        list.add(new AlumnoItem(getString(R.string.itemEstefano), getString(R.string.Estefano), R.drawable.ft2019030344));
        list.add(new AlumnoItem(getString(R.string.itemCarlosAlberto), getString(R.string.CarlosAlberto), R.drawable.ft2020030174));
        list.add(new AlumnoItem(getString(R.string.itemMarcoAntonio), getString(R.string.MarcoAntonioAlarid), R.drawable.ft2020030176));
        list.add(new AlumnoItem(getString(R.string.itemJoshuaDaniel), getString(R.string.JoshuaDaniel), R.drawable.ft2020030181));
        list.add(new AlumnoItem(getString(R.string.itemErnestoDavid), getString(R.string.ErnestoDavid), R.drawable.ft2020030184));
        list.add(new AlumnoItem(getString(R.string.itemMaximiliano), getString(R.string.Maximiliano), R.drawable.ft2020030189));
        list.add(new AlumnoItem(getString(R.string.itemIvanEnrique), getString(R.string.IvanEnrique), R.drawable.ft2020030199));
        list.add(new AlumnoItem(getString(R.string.itemJesusEduardo), getString(R.string.JesusEduardo), R.drawable.ft2020030212));
        list.add(new AlumnoItem(getString(R.string.itemDavidAntonio), getString(R.string.DavidAntonio), R.drawable.ft2020030241));
        list.add(new AlumnoItem(getString(R.string.itemGustavoAdolfo), getString(R.string.GustavoAdolfo), R.drawable.ft2020030243));
        list.add(new AlumnoItem(getString(R.string.itemJuanCarlos), getString(R.string.JuanCarlos), R.drawable.ft2020030249));
        list.add(new AlumnoItem(getString(R.string.itemAlejo), getString(R.string.Alejo), R.drawable.ft2020030264));
        list.add(new AlumnoItem(getString(R.string.itemCarlosJair), getString(R.string.CarlosJair), R.drawable.ft2020030268));
        list.add(new AlumnoItem(getString(R.string.itemJesusTadeo), getString(R.string.JesusTadeo), R.drawable.ft2020030292));
        list.add(new AlumnoItem(getString(R.string.itemJair), getString(R.string.Jair), R.drawable.ft2020030304));
        list.add(new AlumnoItem(getString(R.string.itemDiego), getString(R.string.Diego), R.drawable.ft2020030306));
        list.add(new AlumnoItem(getString(R.string.itemSalmaYareth),getString(R.string.SalmaYareth),R.drawable.ft2020030315));
        list.add(new AlumnoItem(getString(R.string.itemJesusAntonio), getString(R.string.JesusAntonio), R.drawable.ft2020030333));
        list.add(new AlumnoItem(getString(R.string.itemYenniferCarolina), getString(R.string.YenniferCarolina), R.drawable.ft2020030389));
        list.add(new AlumnoItem(getString(R.string.itemManuelAlexis), getString(R.string.ManuelAlexis), R.drawable.ft2020030766));
        list.add(new AlumnoItem(getString(R.string.itemVictorMoises), getString(R.string.VictorMoises), R.drawable.ft2020030771));
        list.add(new AlumnoItem(getString(R.string.itemHalachUinic), getString(R.string.HalachUinic), R.drawable.ft2020030777));
        list.add(new AlumnoItem(getString(R.string.itemEnzoAlejandro), getString(R.string.EnzoAlejandro), R.drawable.ft2020030799));
        list.add(new AlumnoItem(getString(R.string.itemJoseAlberto), getString(R.string.JoseAlberto), R.drawable.ft2020030808));
        list.add(new AlumnoItem(getString(R.string.itemGiancarlo), getString(R.string.Giancarlo), R.drawable.ft2020030819));
        list.add(new AlumnoItem(getString(R.string.itemLuisAngel), getString(R.string.LuisAngel), R.drawable.ft2020030865));
        //Sí los puse a mano, se que pude haber utilizado una herramienta *guiño guiño* pero se me fue el rollo :c
        sp = findViewById(R.id.listView);
        adapter = new AdapterAlumno(this, R.layout.item_alumno, R.id.lblNombe, list);
        sp.setAdapter(adapter);

        sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapter.getContext(), "Se ha seleccionado".toString()+ " "+((AlumnoItem) adapterView.getItemAtPosition(i)).getTxtNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

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