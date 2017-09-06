package br.com.mestredosfilmes.mestredosfilmes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);


        ListView listView = (ListView) view.findViewById(R.id.list_filmes);

        final ArrayList<ItemFilme> lista = new ArrayList<>();

        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 5));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 2.5f));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 3));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 4));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 4.5f));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 3.5f));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 2.5f));


        FilmesAdapter adapter = new FilmesAdapter(getContext(), lista);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemFilme itemFilme = lista.get(position);

                Intent intent = new Intent(getContext(), FilmeDetalheActivity.class);

                intent.putExtra(MainActivity.KEY_FILME, itemFilme);

                startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu, menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_atualizar:
                Toast.makeText(getContext(), "Atualizando os filmes...", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }


    }


}
