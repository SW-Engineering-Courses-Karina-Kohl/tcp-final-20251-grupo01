package br.ufrgs.inf.tcp.tcheorganiza.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Button newCourseButton = root.findViewById(R.id.newCourseButton);

        newCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your action here
                Toast.makeText(getContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}