package br.ufrgs.inf.tcp.tcheorganiza.ui.cardapio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufrgs.inf.tcp.tcheorganiza.R;

public class RUMealCardViewFragment extends Fragment {

    private List<String> lunchMeals = new ArrayList<>();
    private List<String> dinnerMeals = new ArrayList<>();

    public RUMealCardViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_r_u_meal_card_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        applyMealsToUI(view);
    }

    private List<TextView> getTableTextViews(TableLayout tableLayout) {
        List<TextView> textViews = new ArrayList<>();

        if (tableLayout == null) return textViews;

        // Ignora a primeira linha (header)
        for (int i = 1; i < tableLayout.getChildCount(); i++) {
            View rowView = tableLayout.getChildAt(i);
            if (rowView instanceof TableRow) {
                TableRow row = (TableRow) rowView;
                for (int j = 0; j < row.getChildCount(); j++) {
                    View cellView = row.getChildAt(j);
                    if (cellView instanceof TextView) {
                        textViews.add((TextView) cellView);
                    }
                }
            }
        }
        return textViews;
    }

    private void applyMealsToUI(View view) {
        TableLayout lunchTable = view.findViewById(R.id.lunchMeals);
        TableLayout dinnerTable = view.findViewById(R.id.dinnerMeals);

        List<TextView> lunchMealTextViews = getTableTextViews(lunchTable);
        List<TextView> dinnerMealTextViews = getTableTextViews(dinnerTable);

        // Preenche o lunchMeals (limitando ao tamanho da tabela)
        for (int i = 0; i < lunchMealTextViews.size() && i < lunchMeals.size(); i++) {
            lunchMealTextViews.get(i).setText(lunchMeals.get(i));
        }

        // Preenche o dinnerMeals (limitando ao tamanho da tabela)
        for (int i = 0; i < dinnerMealTextViews.size() && i < dinnerMeals.size(); i++) {
            dinnerMealTextViews.get(i).setText(dinnerMeals.get(i));
        }
    }

    public void setMeals(List<String> lunchMeals, List<String> dinnerMeals) {
        this.lunchMeals = lunchMeals != null ? lunchMeals : new ArrayList<>();
        this.dinnerMeals = dinnerMeals != null ? dinnerMeals : new ArrayList<>();
    }
}