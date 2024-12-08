package dam.pmdm.tarea01pmdmjgk;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import dam.pmdm.tarea01pmdmjgk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);



        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this,navController);
    }

        public void characterClicked(CharacterData character, View view){
            Bundle bundle = new Bundle();
            bundle.putString("name",character.getName());
            bundle.putString("description",character.getDescription());
            bundle.putString("abilities", character.getAbilities());
            bundle.putInt("image", character.getImage());

            Navigation.findNavController(view).navigate(R.id.characterDetailFragment, bundle);
        }

        @Override
        public boolean onSupportNavigateUp() {
            return navController.navigateUp() || super.onSupportNavigateUp();
        }



}