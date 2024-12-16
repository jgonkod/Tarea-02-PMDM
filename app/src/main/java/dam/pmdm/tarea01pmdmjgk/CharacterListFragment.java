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
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;

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
        Snackbar.make(getActivity().findViewById(android.R.id.content), getText(R.string.txtSnackList), Snackbar.LENGTH_SHORT).show();
        loadCharacters();

        adapter = new CharacterRecyclerViewAdapter(characters, getActivity());
        binding.characterRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.characterRecyclerview.setAdapter(adapter);

    }

    private void loadCharacters(){
        characters = new ArrayList<CharacterData>();

        characters.add(new CharacterData(R.drawable.mario, "Mario", getString(R.string.desMario),getString(R.string.abMario) ));
        characters.add(new CharacterData(R.drawable.luigi, "Luigi",getString(R.string.desLuigi) ,getString(R.string.abLuigi) ));
        characters.add(new CharacterData(R.drawable.peach, "Princess Peach",getString(R.string.desPeach) ,getString(R.string.abPeach) ));
        characters.add(new CharacterData(R.drawable.toad, "Toad",getString(R.string.desToad) ,getString(R.string.abToad) ));
        characters.add(new CharacterData(R.drawable.bowser, "Bowser",getString(R.string.desBowser) ,getString(R.string.abBowser)));
        characters.add(new CharacterData(R.drawable.yoshi, "Yoshi",getString(R.string.desYoshi) ,getString(R.string.abYoshi) ));
        characters.add(new CharacterData(R.drawable.wario, "Wario",getString(R.string.desWario) ,getString(R.string.abWario) ));

    }


    @Override
    public void onStart(){
        super.onStart();
        if(getActivity() != null){
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista_de_personajes);
        }
    }

}
