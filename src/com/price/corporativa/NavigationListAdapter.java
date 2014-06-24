package com.price.corporativa;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
import java.util.List;
 
//import com.price,corporativa.menu_drawer_layout.app.R;
 
public class NavigationListAdapter extends ArrayAdapter<NavigationItem> {
 
    private Context context;
 
    public NavigationListAdapter(Context context, int resourceId, List<NavigationItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }
 
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        NavigationItem navigationItem = getItem(position);
 
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_drawer_layout, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
 
        holder.txtTitle.setText(navigationItem.getTitle());
        holder.imageView.setImageResource(navigationItem.getImageId());
 
        return convertView;
    }
}
