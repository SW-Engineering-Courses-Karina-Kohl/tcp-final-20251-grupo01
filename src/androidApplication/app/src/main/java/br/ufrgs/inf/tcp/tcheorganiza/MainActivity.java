package br.ufrgs.inf.tcp.tcheorganiza;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.ActivityMainBinding;
import br.ufrgs.inf.tcp.tcheorganiza.ui.disciplinas.DisciplinasFragment;
import br.ufrgs.inf.tcp.tcheorganiza.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_disciplinas, R.id.navigation_cardapio)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        binding.navView.setOnNavigationItemSelectedListener(this);
    }

    FragmentManager fragmentManager = getSupportFragmentManager();

    private void onHojeClicked(){
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, new HomeFragment()).commit();
    }
    private void onDiscplinasClicked(){
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, new DisciplinasFragment()).commit();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.nav_hoje){
            onHojeClicked();
            return true;
        } else if (item.getItemId() == R.id.nav_disciplinas) {
            onDiscplinasClicked();
            return true;
        } else {
            return false;
        }

    }
}