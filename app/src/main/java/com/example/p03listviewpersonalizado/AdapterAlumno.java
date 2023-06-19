package com.example.p03listviewpersonalizado;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterAlumno extends ArrayAdapter<AlumnoItem> implements Filterable {
    private Activity context;
    private int groupId;
    private ArrayList<AlumnoItem> originalList;
    private ArrayList<AlumnoItem> filteredList;
    private LayoutInflater inflater;
    private ItemFilter filter;
    //Adapter Alumno
    public AdapterAlumno(Activity context, int groupId, int id, ArrayList<AlumnoItem> list) {
        super(context, id, list);
        this.context = context;
        this.groupId = groupId;
        this.originalList = list;
        this.filteredList = list;
        this.inflater = context.getLayoutInflater();
        this.filter = new ItemFilter();
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public AlumnoItem getItem(int position) {
        return filteredList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupId, parent, false);
        ImageView imagen = itemView.findViewById(R.id.imgAlumno);
        imagen.setImageResource(filteredList.get(position).getImageId());
        TextView txtNombre = itemView.findViewById(R.id.lblNombe);
        txtNombre.setText(filteredList.get(position).getTxtNombre());
        TextView txtMatricula = itemView.findViewById(R.id.lblMatricula);
        txtMatricula.setText(filteredList.get(position).getTxtMatricula());
        return itemView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                List<AlumnoItem> filteredItems = new ArrayList<>();
                for (AlumnoItem item : originalList) {
                    if (item.getTxtNombre().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredItems.add(item);
                    }
                }
                results.count = filteredItems.size();
                results.values = filteredItems;
            } else {
                results.count = originalList.size();
                results.values = originalList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (ArrayList<AlumnoItem>) results.values;
            notifyDataSetChanged();
        }
    }
}

