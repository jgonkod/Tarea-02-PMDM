package dam.pmdm.tarea01pmdmjgk;

import com.squareup.picasso.Picasso;
import androidx.recyclerview.widget.RecyclerView;

import java.net.CookieHandler;

import dam.pmdm.tarea01pmdmjgk.databinding.CharacterCardviewBinding;


public class CharacterViewHolder extends RecyclerView.ViewHolder {
    private final CharacterCardviewBinding binding;


    public CharacterViewHolder(CharacterCardviewBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(CharacterData character){
        Picasso.get().load(character.getImage()).into(binding.image);
        binding.name.setText(character.getName());
        binding.executePendingBindings();

    }
}
