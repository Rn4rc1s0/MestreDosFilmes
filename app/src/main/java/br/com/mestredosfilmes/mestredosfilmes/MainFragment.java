package br.com.mestredosfilmes.mestredosfilmes;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

    private static final String KEY_POSICAO = "SELECIONADO";
    private int posicaoItem = ListView.INVALID_POSITION;
    private ListView listView;

    private boolean useFilmeDestaque = false;

    private FilmesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);


        listView = (ListView) view.findViewById(R.id.list_filmes);

        final ArrayList<ItemFilme> lista = new ArrayList<>();

        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 5));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 2.5f));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 3));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 4));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 4.5f));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 3.5f));
        lista.add(new ItemFilme("Homem de Ferro", "Filme de heroi Gênio, bilionário, playboy, filantropo.", "28/04/2016", 2.5f));


         adapter = new FilmesAdapter(getContext(), lista);
        adapter.setUseFilmeDestaque(useFilmeDestaque);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemFilme itemFilme = lista.get(position);

                CallBack callBack = (CallBack) getActivity();
                callBack.onItemSelected(itemFilme);

                posicaoItem = position;
            }
        });

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_POSICAO)) {

            posicaoItem = savedInstanceState.getInt(KEY_POSICAO);
        }


        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        if (posicaoItem != ListView.INVALID_POSITION) {
            outState.putInt(KEY_POSICAO, posicaoItem);

        }

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (posicaoItem != ListView.INVALID_POSITION && listView != null) {

            listView.smoothScrollToPosition(posicaoItem);
        }

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

    public void setUseFilmeDestaque(boolean useFilmeDestaque) {
        this.useFilmeDestaque = useFilmeDestaque;

        if (adapter != null){
            adapter.setUseFilmeDestaque(useFilmeDestaque);
        }
    }

    public interface CallBack {

        void onItemSelected(ItemFilme itemFilme);
    }


}
