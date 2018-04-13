package gyakorlas.penz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    TranzakcioAdapter listAdapter;


    @OnClick(R.id.bt_bevetel)
    public void bevetel(){

        Intent i = new Intent(this, Rogzites_oldal.class);
        i.putExtra("tipus", "bevetel");
        startActivityForResult(i,0);
    }

    @OnClick(R.id.bt_kiadas)
    public void kiadas(){

        Intent i = new Intent(this, Rogzites_oldal.class);
        i.putExtra("tipus", "kiadas");
        startActivityForResult(i,0);
    }

    @OnClick(R.id.tw_reszletes_osszesito_tovabb_gomb)
    public void reszletes(){

        Intent i = new Intent(this, Reszletes_osszesito_oldal.class);
        i.putExtra("eredmeny", "elsŐ");
        startActivityForResult(i,0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppDatabase db = AppDatabase.getDatabase(getApplicationContext());

        ArrayList<Tranzakcio> tranzakcioslista = new ArrayList<Tranzakcio>(db.tranzakcioDao().getAllTranzakcio());

        listAdapter.refressDateSet(tranzakcioslista);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AppDatabase db = AppDatabase.getDatabase(getApplicationContext());

        ArrayList<Tranzakcio> tranzakcioslista = new ArrayList<Tranzakcio>(db.tranzakcioDao().getAllTranzakcio());

        listAdapter = new TranzakcioAdapter(tranzakcioslista);

        RecyclerView list = (RecyclerView) findViewById(R.id.rv_recycler_view);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);

        list.setLayoutManager(layoutManager);
        list.setAdapter(listAdapter);
        
        }
}
