package br.ufrgs.inf.tcp.tcheorganiza.ui.cardapio;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.databinding.FragmentCardapioBinding;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.DiaDaSemana;
import br.ufrgs.inf.tcp.tcheorganiza.model.ru.Ru;
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

        for (Ticket ticket : persistence.registroTickets.getListaTickets()) {
            addTicketFragment(ticket);
        }

        populateMealData();

        getActivity().setTitle("RU");

        return root;
    }

    public void addTicketFragment(Ticket ticket) {
        FrameLayout container = new FrameLayout(requireContext());
        int containerId = View.generateViewId();
        container.setId(containerId);
        ticketList.addView(container);

        getChildFragmentManager()
                .beginTransaction()
                .add(containerId, new TicketCardFragment(ticket.getCodigo(), ticket.getQuantidade() - ticket.getNumUsos(), ticket.getQuantidade()))
                .commit();
    }

    private void showNewTicketIntent() {
        Intent intent = new Intent(getContext(), RegisterTicket.class);
        startActivity(intent);
    }

    private void populateMealData() {
        DiaDaSemana todayWeekDay = getTodayWeekDay();

        LinearLayout mealScrollView = binding.RUList;
        mealScrollView.removeAllViews();

        List<Ru> allRUs = persistence.RUOrganizer.getRus();
        for (Ru ru : allRUs) {
            List<String> todaysLunch = ru.getCardapioAlmoco().getItens().get(todayWeekDay);
            List<String> todaysDinner = ru.getCardapioJanta().getItens().get(todayWeekDay);

            // Só adiciona fragmento se tiver almoço ou jantar
            if ((todaysLunch != null && !todaysLunch.isEmpty()) || (todaysDinner != null && !todaysDinner.isEmpty())) {
                // Título separado
                MaterialTextView titleView = new MaterialTextView(requireContext());
                titleView.setText(ru.getNome() + " - " + todayWeekDay.name());
                titleView.setTextSize(18);
                titleView.setPadding(16, 16, 16, 8);
                mealScrollView.addView(titleView);

                // Container para o fragment
                FrameLayout container = new FrameLayout(requireContext());
                int containerId = View.generateViewId();
                container.setId(containerId);
                mealScrollView.addView(container);

                // Fragmento com as refeições
                RUMealCardViewFragment fragment = new RUMealCardViewFragment();
                fragment.setMeals(todaysLunch, todaysDinner);

                getChildFragmentManager()
                        .beginTransaction()
                        .add(containerId, fragment)
                        .commit();
            }
        }
    }
    private DiaDaSemana getTodayWeekDay() {
        int day = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_WEEK);
        switch (day) {
            case java.util.Calendar.MONDAY:
                return DiaDaSemana.SEGUNDA;
            case java.util.Calendar.TUESDAY:
                return DiaDaSemana.TERCA;
            case java.util.Calendar.WEDNESDAY:
                return DiaDaSemana.QUARTA;
            case java.util.Calendar.THURSDAY:
                return DiaDaSemana.QUINTA;
            case java.util.Calendar.FRIDAY:
                return DiaDaSemana.SEXTA;
            default:
                return DiaDaSemana.SEGUNDA;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}