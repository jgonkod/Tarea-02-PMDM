package dam.pmdm.tarea01pmdmjgk;

import static dam.pmdm.tarea01pmdmjgk.R.menu.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import dam.pmdm.tarea01pmdmjgk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    private NavController navController;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);

        //Creamos el binfing para no tener que referirse a cada elemento del XML por id
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();



        // Configurar menú toggle   ç
        configureNavigation();
        configureToggleMenu();



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);  // Inflar el archivo de menú
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about_menu) {
            // Acción para el botón de about
            showDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showDialog() {
        // Crear un AlertDialog Builder
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setTitle(getText(R.string.sobre))
                .setMessage(getText(R.string.txtSobre))
                .setCancelable(true);  // El diálogo puede ser cerrado tocando fuera de él

        // Creamos y mostramos el diálogo
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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

    private void configureToggleMenu() {
        // Configurar el ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.openDrawer,
                R.string.closeDrawer
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configureNavigation() {
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Manejar la selección de elementos del menú
        binding.navView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.mainFragment); // Navegar al fragmento de inicio
            }
            if (menuItem.getItemId() == R.id.nav_settings) {
                navController.navigate(R.id.settingsFragment); // Navegar al fragmento de inicio
            }
            binding.drawerLayout.closeDrawers(); // Cerrar el menú
            return true;
        });


    }
}