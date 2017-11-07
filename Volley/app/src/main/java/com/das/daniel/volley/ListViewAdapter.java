package com.das.daniel.volley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Daniel on 11/10/2017.
 */
public class ListViewAdapter extends ArrayAdapter<Libreria> {

    private List<Libreria> libreriaList;
    private Context mCtx;

    public ListViewAdapter(List<Libreria> libreriaList, Context mCtx) {
        super(mCtx, R.layout.list_items, libreriaList);
        this.libreriaList = libreriaList;
        this.mCtx = mCtx;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View listViewItem = inflater.inflate(R.layout.list_items, null, true);

        TextView _tvNombre = (TextView) listViewItem.findViewById(R.id.tvNombre);
        TextView _tvGithub = (TextView) listViewItem.findViewById(R.id.tvGithub);
        Libreria libreria = libreriaList.get(position);

        _tvNombre.setText(libreria.getNombre());
        _tvGithub.setText(libreria.getGithub());

        return listViewItem;
    }
}