package andrekabelim.br.projetomaxmilhas.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import andrekabelim.br.projetomaxmilhas.R;
import andrekabelim.br.projetomaxmilhas.ui.models.Airport;

public class AirportAdapter extends ArrayAdapter<String> {

    private Map<String, String> mMap = new HashMap<>();
    private String[] mKeys;
    private Context mContext;

    public AirportAdapter(Context context, int resourceId, Map<String, String> data) {
        super(context, resourceId);
        mMap = data;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mMap.size();
    }

    @Override
    public String getItem(int i) {
        return mMap.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View result;
        if (view == null) {
            result = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.autocomplete_item, viewGroup, false);
        } else {
            result = view;
        }

        String item = getItem(i);

        ((TextView) result.findViewById(R.id.txt_item_autocomplete)).setText(item);

        return result;
    }
}
