package dam.pmdm.tarea01pmdmjgk;


import android.app.GameManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dam.pmdm.tarea01pmdmjgk.databinding.CharacterListFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class CharacterListFragment extends Fragment {

    private CharacterListFragmentBinding binding;
    private ArrayList<CharacterData> characters;
    private CharacterRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        binding = CharacterListFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        loadCharacters();

        adapter = new CharacterRecyclerViewAdapter(characters, getActivity());
        binding.characterRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.characterRecyclerview.setAdapter(adapter);
    }

    private void loadCharacters(){
        characters = new ArrayList<CharacterData>();

        characters.add(new CharacterData(R.drawable.mario, "Mario", "El famoso fontanero de Mushroom Kingdom.", "Salto alto, Super Mario, Power-ups."));
        characters.add(new CharacterData(R.drawable.luigi, "Luigi", "El hermano de Mario, conocido por su valentía.", "Salto alto, Super Luigi, Power-ups."));
        characters.add(new CharacterData(R.drawable.peach, "Princess Peach", "La princesa del Reino Champiñón.", "Poder de curación, Invocación de Toads."));
        characters.add(new CharacterData(R.drawable.toad, "Toad", "Un leal sirviente de la princesa Peach.", "Velocidad, Ayuda en misiones."));
        characters.add(new CharacterData(R.drawable.bowser, "Bowser", "El rey de los Koopas y archienemigo de Mario.", "Fuego, Fuerza bruta."));
        characters.add(new CharacterData(R.drawable.yoshi, "Yoshi", "El dinosaurio amigo de Mario.", "Comer enemigos, Saltar alto."));
        characters.add(new CharacterData(R.drawable.wario, "Wario", "El rival de Mario, conocido por su avaricia.", "Fuerza, Poder de explosión."));

    }

    @Override
    public void onStart(){
        super.onStart();
        if(getActivity() != null){
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista_de_personajes);
        }
    }

}
