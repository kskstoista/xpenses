package gyakorlas.penz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Kzfot on 2018. 03. 05..
 */

public class TranzakcioAdapter extends RecyclerView.Adapter<TranzakcioAdapter.ViewHolder> {
    private final CopyOnWriteArrayList<Tranzakcio> mDataset;
    private View v;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tipus;
        private TextView megjegyzes;
        private TextView kategoria;
        private TextView osszeg;


        ViewHolder(final View v) {
            super(v);

            // tipus = (TextView) v.findViewById(R.id.lista_osszeg);
            megjegyzes = (TextView) v.findViewById(R.id.lista_megjegyzes);
            kategoria = (TextView) v.findViewById(R.id.lista_kategoria);
            osszeg = (TextView) v.findViewById(R.id.lista_osszeg);
        }
    }
    public void refressDateSet(ArrayList<Tranzakcio> data){
        mDataset.clear();
        mDataset.addAll(data);
        notifyDataSetChanged();
    }


    public TranzakcioAdapter(ArrayList<Tranzakcio> data) {

        mDataset = new CopyOnWriteArrayList<>();

        if (data != null) {
            mDataset.addAll(data);
        }
    }

    @Override
    public TranzakcioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new TranzakcioAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TranzakcioAdapter.ViewHolder holder, final int position) {

        Tranzakcio c = mDataset.get(position);
        if (c == null) {
            return;
        }
        holder.megjegyzes.setText(c.getMegjegy());
        holder.kategoria.setText(c.getKategoria());
        holder.osszeg.setText(c.getOsszeg() + " ");
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

