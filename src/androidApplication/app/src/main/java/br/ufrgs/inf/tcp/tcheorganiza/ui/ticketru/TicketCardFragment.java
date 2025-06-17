package br.ufrgs.inf.tcp.tcheorganiza.ui.ticketru;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.ufrgs.inf.tcp.tcheorganiza.R;

public class TicketCardFragment extends Fragment {

    private String ticketNumber;
    private int remainingUsages, amountBought;
    private FloatingActionButton restoreButton, markAsUsedButton;
    private TextView textTicketNumber, textRemainingUsages;

    public TicketCardFragment() {
        // Default test data
        this.ticketNumber = "00000";
        this.remainingUsages = 5;
        this.amountBought = 5;
    }

    public TicketCardFragment(String ticketNumber, int remainingUsages, int amountBought) {
        this.ticketNumber = ticketNumber;
        this.remainingUsages = remainingUsages;
        this.amountBought = amountBought;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ticket_card, container, false);

        restoreButton = root.findViewById(R.id.buttonRestore);
        markAsUsedButton = root.findViewById(R.id.buttonMarkAsUsed);
        textTicketNumber = root.findViewById(R.id.ticketNumber);
        textRemainingUsages = root.findViewById(R.id.remainingUsages);

        // Inicializa textos
        textTicketNumber.setText(String.valueOf(ticketNumber));
        updateUI();

        // Listeners
        restoreButton.setOnClickListener(v -> showConfirmRestoreDialog());
        markAsUsedButton.setOnClickListener(v -> registerTicketUsage());

        return root;
    }

    private void updateUI() {
        textTicketNumber.setText(String.valueOf(ticketNumber));
        textRemainingUsages.setText(remainingUsages + " usos restantes");
    }

    private void showConfirmRestoreDialog() {
        if (remainingUsages < amountBought) {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Confirmar restauração")
                    .setMessage("Deseja restaurar um uso para o ticket " + ticketNumber + "?")
                    .setPositiveButton("Sim", (dialog, which) -> restoreTicketUsage())
                    .setNegativeButton("Cancelar", null)
                    .show();
        } else {
            Toast.makeText(requireContext(), "Ticket já está no máximo de usos", Toast.LENGTH_SHORT).show();
        }

    }

    private void restoreTicketUsage() {
        if (remainingUsages < amountBought) {
            remainingUsages++;
            updateUI();
            markAsUsedButton.setEnabled(true);
            Toast.makeText(requireContext(), "Uso restaurado com sucesso", Toast.LENGTH_SHORT).show();
        }
    }

    private void registerTicketUsage() {
        if (remainingUsages > 0) {
            remainingUsages--;
            
            updateUI();
            if (remainingUsages == 0) {
                markAsUsedButton.setEnabled(false);
            }
            Toast.makeText(requireContext(), "Uso registrado com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireContext(), "Sem usos restantes para este ticket", Toast.LENGTH_SHORT).show();
        }
    }
}