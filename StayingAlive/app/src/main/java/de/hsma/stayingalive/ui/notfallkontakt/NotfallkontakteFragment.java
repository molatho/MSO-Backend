package de.hsma.stayingalive.ui.notfallkontakt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import de.hsma.stayingalive.R;
import de.hsma.stayingalive.dto.BlutgruppenEnum;
import de.hsma.stayingalive.dto.KontaktartEnum;
import de.hsma.stayingalive.dto.NutzerDTO;
import de.hsma.stayingalive.manager.NutzerDTOManager;
import de.hsma.stayingalive.manager.StoredDataManager;

public class NotfallkontakteFragment extends Fragment {

    private NutzerDTO nutzerDto;
    private RecyclerView recyclerViewKontaktliste;
    private RecyclerView.Adapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notfallkontakte, container, false);

        NutzerDTOManager instance = NutzerDTOManager.getInstance();
        nutzerDto = instance.getNutzerDto();

        recyclerViewKontaktliste = root.findViewById(R.id.kontaktListe);
        recyclerViewKontaktliste.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter = new NotfallkontaktRecycleAdapter(nutzerDto);
        recyclerViewKontaktliste.setAdapter(mAdapter);
        fillSpinnerKontaktArt(root);


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        writeNutzerToSharedPreferences();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        writeNutzerToSharedPreferences();
    }

    private void fillSpinnerKontaktArt(View root) {
        // fill Spinner "Kontaktart"
        KontaktartEnum[] values = KontaktartEnum.values();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, KontaktartEnum.valuesAsString());
        Spinner kontaktartSpinner = root.findViewById(R.id.spinnerKontaktArt);
        kontaktartSpinner.setAdapter(adapter);

        kontaktartSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorBlack));
                writeNutzerToSharedPreferences();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nichts zu tun
            }
        });

    }

    private void writeNutzerToSharedPreferences() {
        StoredDataManager.writeStorageData(getActivity().getSharedPreferences(getString(R.string.shared_preferences_user_data), Context.MODE_PRIVATE), getString(R.string.shared_preferences_user_data_json), nutzerDto);
    }
}

