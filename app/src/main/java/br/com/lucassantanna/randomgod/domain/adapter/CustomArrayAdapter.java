package br.com.lucassantanna.randomgod.domain.adapter;

/**
 * Created by LucasSant'Anna on 24/04/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.lucassantanna.randomgod.R;
import br.com.lucassantanna.randomgod.domain.model.God;
import br.com.lucassantanna.randomgod.domain.util.Base64Util;

/**
 * Created by elcio on 02/12/15.
 */
public class CustomArrayAdapter extends ArrayAdapter<God> {
    protected LayoutInflater inflater;
    protected int layout;

    public CustomArrayAdapter(Activity activity, int resourceId, List<God> objects){
        super(activity, resourceId, objects);
        layout = resourceId;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(layout, parent, false);
        TextView tv = (TextView)v.findViewById(R.id.item_label);
        ImageView foto = (ImageView)v.findViewById(R.id.godImage);
        foto.setImageBitmap(Base64Util.decodeBase64(getItem(position).getImage()));
        tv.setText(getItem(position).getName() + "\n " + getItem(position).getReligion());
        return v;
    }
}