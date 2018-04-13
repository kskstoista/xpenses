package gyakorlas.penz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Rogzites_oldal extends AppCompatActivity {

    @BindView(R.id.et_kiegeszito_megjegy)
    EditText megjegy;
    EditText osszeg;
    TextView datum;

    private Boolean tranzakcioTipus;
    private Button button;
    public static final String prefName = "nev";
    public static final String prefTipus = "tipus";
    public static final String prefmegjegy = "megjegyzes";
    public static final String predatum = "datum";
    private static final String prefOsszeg = "osszeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rogzites_oldal);
        ButterKnife.bind(this);

        megjegy = (EditText)findViewById(R.id.et_kiegeszito_megjegy);
        datum = (TextView)findViewById(R.id.tw_datum);
        osszeg = (EditText) findViewById(R.id.et_osszeg);
        button = (Button) findViewById(R.id.bt_kuldes);
        final Spinner staticSpinner = (Spinner) findViewById(R.id.sp_spinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        staticSpinner.getSelectedItem().toString() + " " + megjegy.getText().toString() +
                                " " + osszeg.getText().toString(),  Toast.LENGTH_LONG).show();
                AppDatabase db = AppDatabase.getDatabase(getApplicationContext());

                Tranzakcio tr = new Tranzakcio(db.tranzakcioDao().getNumberoftransactions(),
                        tranzakcioTipus, megjegy.getText().toString(),
                        staticSpinner.getSelectedItem().toString(), datum.getText().toString(),
                        Integer.parseInt(osszeg.getText().toString()));

                db.tranzakcioDao().AddTranzakcio(tr);
            }
        });

        TextView fejlec = (TextView) findViewById(R.id.tv_oldal_fejlec);

        int lista = 0;
        Intent i = getIntent();
        if (i.getStringExtra("tipus").equals("bevetel")) {
           lista = R.array.bevetel_lista;
           fejlec.setText("Bevétel Rögzítés");
           tranzakcioTipus = Tranzakcio.BEVETEL;
        }else {
           lista = R.array.kiadas_lista;
            fejlec.setText("Kiadás Rögzítés");
            tranzakcioTipus = Tranzakcio.KIADAS;
        }

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, lista,
                        android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);
    }
}
