package com.example.bazadanych;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ZwierzeDataBase zwierzetaDataBase;

    private EditText editTextGatunek, editTextWynik;
    private Spinner spinnerSrodowisko;
    private CheckBox checkBoxCzyroslinozerny;
    private Button button;
    private ListView listView;
    private ArrayAdapter<Zwierze> arrayAdapter;
    private List<Zwierze> zwierzeta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editTextGatunek = findViewById(R.id.editTextGatunek);
        editTextWynik = findViewById(R.id.editTextText2);
        spinnerSrodowisko = findViewById(R.id.spinner);
        checkBoxCzyroslinozerny =findViewById(R.id.checkBox);

        zwierzetaDataBase = Room.databaseBuilder(
                getApplicationContext(),
                ZwierzeDataBase.class,
                "zwierzeta_db"
        )
                .allowMainThreadQueries()
                .build();
        zwierzetaDataBase.zwrocZwierzeDao().wstawDoBazy(
                new Zwierze("sarna europejska", "ladowne", true, 12)
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Zwierze zwierze = new Zwierze(
                                editTextGatunek.getText().toString(),
                                spinnerSrodowisko.getSelectedItem().toString(),
                                checkBoxCzyroslinozerny.isChecked(),
                                Integer.parseInt(editTextWynik.getText().toString())

                        );
                        zwierzetaDataBase.zwrocZwierzeDao().wstawDoBazy(zwierze);
                    }
                }
        );
        listView = findViewById(R.id.listView);
        zwierzeta = zwierzetaDataBase.zwrocZwierzeDao().zwrocWszystkieZwierzeta();
        arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                zwierzeta);
        listView.setAdapter(arrayAdapter);
    }
}