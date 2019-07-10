package com.enes.hextechsimulator;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterEnvanterOld {

    /*private ArrayList<Item> envanter;
    private Context context;
    private CustomItemClickListener listener;
    private ManagerSampiyon sm;
    private ManagerKostum km;
    private ManagerSandik cm;*/

    AdapterEnvanterOld(Activity activity, CustomItemClickListener listener) {
        /*
        this.listener = listener;
        context = activity;
        //db = database;
        sm = new ManagerSampiyon();
        km = new ManagerKostum();
        cm = new ManagerSandik();
        envanter = new ArrayList<>();
        envanterDuzenle();*/
    }

    public interface CustomItemClickListener {
        //void onItemClick(View v, Item item, int position);
    }

    void envanterDuzenle() {
        /*
        if (db.isEnvanterUpdated()) {
            envanter.clear();
            envanter.add(new Item(0, 11, context.getResources().getString(R.string.separator_malzeme), 1));
            if (db.getGem() != 0) {
                Item cevher = new Item(0, 3, "", 7);
                cevher.setMiktar(db.getGem());
                envanter.add(cevher);
            }
            HashMap<Integer, Integer> sandiklar = db.getSandiklar();
            for (int i : sandiklar.keySet()) {
                Sandik sandik = cm.getSandikById(i);
                sandik.setMiktar(sandiklar.get(i));
                envanter.add(sandik);
            }
            envanter.add(new Item(0, 11, context.getResources().getString(R.string.separator_samp), 1));
            HashMap<Integer, Integer> sampKristal = db.getSampKristal();
            for (int i : sampKristal.keySet()) {
                SampiyonKristali samp = sm.getSampById(i);
                samp.setMiktar(sampKristal.get(i));
                envanter.add(samp);
            }
            envanter.add(new Item(0, 11, context.getResources().getString(R.string.separator_kostum), 1));
            HashMap<Integer, Integer> kostumKristal = db.getKostumKristal();
            for (int i : kostumKristal.keySet()) {
                KostumKristali kostum = km.getKostumById(i);
                kostum.setMiktar(kostumKristal.get(i));
                envanter.add(kostum);
            }
            db.setEnvanterUpdate(false);
        }*/
    }
    /*
    @NonNull
    @Override
    public AdapterEnvanterOld.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final ViewHolder view_holder;
        if (viewType == 11) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_separator, parent, false);
            view_holder = new ViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_single_grid, parent, false);
            view_holder = new ViewHolder(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, envanter.get(view_holder.getPosition()), view_holder.getPosition());
                }
            });
        }

        return view_holder;
    }
*/
    /*@Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // TODO: Item öğeleri düzgün görüntülenmiyor
        // TODO: Öğeler düzgün update almıyor
        /*
        int itemTip = envanter.get(position).getItemTip();
        if (itemTip == 1) {
            holder.img.setImageResource(R.mipmap.samp_test);
            holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_shard));
        } else if (itemTip == 2) {
            holder.img.setImageResource(R.mipmap.kostum_test);
            holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_shard));
            KostumKristali kostum = db.getKostumKristalById(envanter.get(position).getId());
            switch (kostum.getNadirlikId()) {
                case 1:
                    holder.imgNadirlik.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    holder.imgNadirlik.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    holder.imgNadirlik.setImageResource(R.mipmap.badge_3);
                    break;
                case 4:
                    holder.imgNadirlik.setImageResource(R.mipmap.badge_4);
                    break;
                case 5:
                    holder.imgNadirlik.setImageResource(R.mipmap.badge_6);
                    break;
                case 6:
                    holder.imgNadirlik.setImageResource(R.mipmap.badge_6);
                    break;
                case 7:
                    if (kostum.isMevcutOlmayanIcerik()) {
                        holder.imgNadirlik.setImageResource(R.mipmap.badge_7_2);
                    } else holder.imgNadirlik.setImageResource(R.mipmap.badge_7);
                    break;
            }
            if (kostum.isHatiraIcerik()) {
                holder.imgLegacy.setVisibility(View.VISIBLE);
            } else holder.imgLegacy.setVisibility(View.INVISIBLE);

        } else if (itemTip == 3) {
            holder.img.setImageResource(R.mipmap.gem_test);
            holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_materials));
        } else if (itemTip == 6) {
            holder.img.setImageResource(R.mipmap.sandik_test);
            holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_materials));
        } else if (itemTip == 11) {
            holder.txtSeparator.setText(envanter.get(position).getIsim());
        } else {
            holder.img.setImageDrawable(null);
            holder.img.setBackground(null);
        }
        if (!isHeader(position)) {
            int miktar = envanter.get(position).getMiktar();
            if (miktar > 1) {
                holder.txtMiktar.setText(String.valueOf(miktar));
            } else {
                holder.txtMiktar.setVisibility(View.INVISIBLE);
            }
        }
    }

    /*boolean isHeader(int position) {
        //int tip = envanter.get(position).getItemTip();
        return tip == 11;
    }

    @Override
    public int getItemViewType(int position) {
        return envanter.get(position).getItemTip();
    }

    @Override
    public long getItemId(int position) {
        return envanter.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return envanter.size();
    }*/

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        ImageView imgNadirlik;
        ImageView imgLegacy;
        TextView txtSeparator;
        TextView txtMiktar;

        ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.adapter_grid_img);
            imgNadirlik = itemView.findViewById(R.id.adapter_badge);
            imgLegacy = itemView.findViewById(R.id.adapter_legacy);
            txtSeparator = itemView.findViewById(R.id.adapter_separator_text);
            txtMiktar = itemView.findViewById(R.id.adapter_grid_count);
        }
    }

    /*@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        /*View rowView = inflater.inflate(R.layout.adapter_single_grid, null);
        holder.img = (ImageView) rowView.findViewById(R.id.adapter_grid_img);
        if (envanter.get(position).getItemTip() == 1)
            holder.img.setImageResource(R.mipmap.samp_test);
        else if (envanter.get(position).getItemTip() == 2)
            holder.img.setImageResource(R.mipmap.kostum_test);
        else holder.img.setImageResource(R.mipmap.sandik_test);
        if (envanter.get(position).getItemTip() > 2) {
            holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_materials));
        } else holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_shard));
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Şuna dokunuldu: " + envanter.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        int itemTip = envanter.get(position).getItemTip();
        View rowView = inflater.inflate(R.layout.adapter_single_grid, null);
        holder.img = (ImageView) rowView.findViewById(R.id.adapter_grid_img);
        if (itemTip == 1) {
            holder.img.setImageResource(R.mipmap.samp_test);
            holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_shard));
        } else if (itemTip == 2) {
            holder.img.setImageResource(R.mipmap.kostum_test);
            holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_shard));
        } else if (itemTip == 3) {
            holder.img.setImageResource(R.mipmap.icon_gem);
            holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_materials));
        } else if (itemTip == 6) {
            holder.img.setImageResource(R.mipmap.sandik_test);
            holder.img.setBackground(context.getResources().getDrawable(R.drawable.frame_materials));
        } else {
            rowView = inflater.inflate(R.layout.adapter_separator, null);
            TextView sepText = rowView.findViewById(R.id.adapter_separator_text);
            sepText.setText(envanter.get(position).getIsim());
        }
        return rowView;
    }*/
}
