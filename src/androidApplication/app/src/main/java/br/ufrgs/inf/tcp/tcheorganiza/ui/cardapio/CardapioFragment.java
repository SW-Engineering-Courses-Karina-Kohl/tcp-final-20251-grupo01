package br.ufrgs.inf.tcp.tcheorganiza.ui.cardapio;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentCardapioBinding;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.Ticket;
import br.ufrgs.inf.tcp.tcheorganiza.persistence.TcheOrganizaPersistence;
import br.ufrgs.inf.tcp.tcheorganiza.ui.ticketru.RegisterTicket;
import br.ufrgs.inf.tcp.tcheorganiza.ui.ticketru.TicketCardFragment;

public class CardapioFragment extends Fragment {

    private FragmentCardapioBinding binding;

    private TcheOrganizaPersistence persistence = TcheOrganizaPersistence.getInstance();

    private FloatingActionButton registerTicketButton;
    private ViewGroup ticketList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCardapioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ticketList = root.findViewById(R.id.ticketList);
        registerTicketButton = root.findViewById(R.id.button_register_ticket);

        registerTicketButton.setOnClickListener(v -> showNewTicketIntent());

        for  (Ticket ticket :  persistence.registroTickets.getListaTickets()){
            addTicketFragment(ticket);
        }

        getActivity().setTitle("RU");

        return root;
    }

    public void addTicketFragment(Ticket ticket) {
        // Cria um novo container para o fragmento
        FrameLayout container = new FrameLayout(requireContext());
        int containerId = View.generateViewId();  // Gera ID único
        container.setId(containerId);
        ticketList.addView(container);

        // Adiciona o fragmento
        getChildFragmentManager()
                .beginTransaction()
                .add(containerId, new TicketCardFragment(ticket.getCodigo(), ticket.getQuantidade() - ticket.getNumUsos(), ticket.getQuantidade()))
                .commit();
    }

    private void showNewTicketIntent() {
        Intent intent = new Intent(getContext(), RegisterTicket.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}