package com.enes.hextechsimulator.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.enes.hextechsimulator.Models.ModelSetting;
import com.enes.hextechsimulator.R;

import java.util.ArrayList;

public class SettingListViewAdapter extends ArrayAdapter<ModelSetting> {
    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<ModelSetting> settings;

    public SettingListViewAdapter(@NonNull Context context, ArrayList<ModelSetting> settings) {
        super(context, 0, settings);
        this.context = context;
        this.settings = settings;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return settings.size();
    }

    @Override
    public ModelSetting getItem(int position) {
        return settings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return settings.get(position).hashCode();
    }


    private static class ViewHolder {
        TextView title;
        TextView desc;
        Switch aSwitch;
        ImageView icon;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_settings, null);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.settings_title);
            holder.desc = convertView.findViewById(R.id.settings_desc);
            holder.aSwitch = convertView.findViewById(R.id.settings_switch);
            holder.icon = convertView.findViewById(R.id.settings_icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ModelSetting setting = getItem(position);
        if (setting != null) {
            holder.title.setText(setting.getTitle());
            holder.desc.setText(setting.getDesc());
            if (!setting.isSwitchEnabled()) holder.aSwitch.setVisibility(View.GONE);
            holder.icon.setImageResource(setting.getIconRef());
            if (setting.getIconColorRef() != 0)
                holder.icon.setColorFilter(context.getResources().getColor(setting.getIconColorRef()));
        }
        return convertView;
    }


}
