package br.ufrgs.inf.tcp.tcheorganiza.ui.ticketru;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import br.ufrgs.inf.tcp.tcheorganiza.R;

public class AddTicketFragment extends Fragment {

    private EditText ticketNumberEditText;
    private EditText ticketAmountEditText;
    private EditText boughtOnEditText;
    private MaterialButton saveButton;

    private Calendar selectedDate = Calendar.getInstance();

    public AddTicketFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_ticket, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ticketNumberEditText = view.findViewById(R.id.ticketNumber);
        ticketAmountEditText = view.findViewById(R.id.ticketAmount);
        boughtOnEditText = view.findViewById(R.id.boughtOn);
        saveButton = view.findViewById(R.id.saveButton);

        boughtOnEditText.setOnClickListener(v -> showDatePicker());

        saveButton.setOnClickListener(v -> saveTicket());
    }

    private void showDatePicker() {
        int year = selectedDate.get(Calendar.YEAR);
        int month = selectedDate.get(Calendar.MONTH);
        int day = selectedDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                (DatePicker view, int yearSelected, int monthSelected, int daySelected) -> {
                    selectedDate.set(yearSelected, monthSelected, daySelected);
                    boughtOnEditText.setText(String.format("%02d/%02d/%04d", daySelected, monthSelected + 1, yearSelected));
                },
                year, month, day
        );

        datePickerDialog.show();
    }

    private void saveTicket() {
        String ticketNumber = ticketNumberEditText.getText().toString();
        String ticketAmount = ticketAmountEditText.getText().toString();
        String boughtOn = boughtOnEditText.getText().toString();

        if (ticketNumber.isEmpty() || ticketAmount.isEmpty() || boughtOn.isEmpty()) {
            Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Aqui você pode salvar o ticket no banco ou onde quiser
        Toast.makeText(requireContext(), "Ticket salvo com sucesso!", Toast.LENGTH_SHORT).show();
    }
}