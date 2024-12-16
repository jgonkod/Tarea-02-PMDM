package dam.pmdm.tarea01pmdmjgk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import dam.pmdm.tarea01pmdmjgk.databinding.CharacterDetailFragmentBinding;

public class CharacterDetailFragment extends Fragment {

        private CharacterDetailFragmentBinding binding;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            //Mostramos un mensaje Toast cada vez que se crea la nueva view de detalles del personaje
            Toast.makeText(getActivity(), getText(R.string.txtDetailToast) + " " + getArguments().getString("name"), Toast.LENGTH_SHORT).show();

            binding = CharacterDetailFragmentBinding.inflate(inflater, container, false);
            return binding.getRoot();

        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);



            if (getArguments() != null) {
                int image = getArguments().getInt("image");
                String name = getArguments().getString("name");
                String description = getArguments().getString("description");
                String abilities = getArguments().getString("abilities");

                Picasso.get()
                        .load(image)
                        .into(binding.image);
                binding.name.setText(name);
                binding.description.setText(description);
                binding.abilities.setText(abilities);
            }
        }

        @Override
        public void onStart() {
            super.onStart();

            if (getActivity() != null) {
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.detalles_del_personaje);
            }
        }
}
