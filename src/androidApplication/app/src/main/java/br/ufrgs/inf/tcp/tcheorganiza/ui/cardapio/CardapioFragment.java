package br.ufrgs.inf.tcp.tcheorganiza.ui.cardapio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentCardapioBinding;

public class CardapioFragment extends Fragment {

    private FragmentCardapioBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCardapioBinding.inflate(inflater, container, false);
        getActivity().setTitle("RU");
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}