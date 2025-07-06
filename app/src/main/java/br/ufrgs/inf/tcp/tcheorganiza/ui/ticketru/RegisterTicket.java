package br.ufrgs.inf.tcp.tcheorganiza.ui.ticketru;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.ufrgs.inf.tcp.tcheorganiza.MainActivity;
import br.ufrgs.inf.tcp.tcheorganiza.R;
import br.ufrgs.inf.tcp.tcheorganiza.ui.tasks.AddTasksActivity;

public class RegisterTicket extends AppCompatActivity {

    private Button registerButton, doneButton;
    private AddTicketFragment addTicketFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_ticket);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addTicketFragment = (AddTicketFragment) getSupportFragmentManager().findFragmentById(R.id.addTickerFragmentCV);
        registerButton = findViewById(R.id.button_add_ticket);
        doneButton = findViewById(R.id.button_concluido);

        registerButton.setOnClickListener(v -> addTicketFragment.saveTicket());
        doneButton.setOnClickListener(v -> {
            Intent mainActivity = new Intent(RegisterTicket.this, MainActivity.class);
            startActivity(mainActivity);
        });
    }
}