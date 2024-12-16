package dam.pmdm.tarea01pmdmjgk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.Locale;

import dam.pmdm.tarea01pmdmjgk.databinding.CharacterDetailFragmentBinding;
import dam.pmdm.tarea01pmdmjgk.databinding.CharacterListFragmentBinding;
import dam.pmdm.tarea01pmdmjgk.databinding.SettingsFragmentBinding;

public class SettingsFragment extends Fragment {
    private SettingsFragmentBinding binding;
    public SettingsFragment() {
        // Requiere un constructor vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        binding = SettingsFragmentBinding.inflate(inflater,container,false);
        binding.languageRadioBtn.setOnCheckedChangeListener(this::onLanguagueSelected);

        return binding.getRoot();
    }

    private void onLanguagueSelected(RadioGroup radioGroup, int checkedId){
        if(checkedId == R.id.lngSettingEn){
            changeLanguage("en");
        }else if(checkedId == R.id.lngSettingEs){
            changeLanguage("es");
        }
    }

    private  void changeLanguage(String languageCode){
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        updateLanguageView();
    }

    private void updateLanguageView(){
        binding.textViewLng.setText(R.string.txtLanguage);
        binding.lngSettingEn.setText(R.string.txtLngSettingEn);
        binding.lngSettingEs.setText(R.string.txtLngSettingEs);

    }
    @Override
    public void onStart(){
        super.onStart();
        if(getActivity() != null){
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.txtSettings);
        }
    }
}
