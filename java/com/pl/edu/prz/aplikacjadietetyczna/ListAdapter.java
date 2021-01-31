//spakowao do folderu
package com.pl.edu.prz.aplikacjadietetyczna;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;//importujemy wsparcie v7
import android.view.LayoutInflater;// importowanie instalacji LayoutInflater
import android.view.View;// importowanie okna widokowego androida
import android.view.ViewGroup;//importowanie  grupy widoków  android
import android.widget.ImageView;// importowanie z panelu bocznego zasobów obrazu do aplikcji android
import android.widget.TextView;// importowanie z panelu bocznego pola tekstowego do aplikcji android
//klasa publiczna ListAdapter rozszerzenie działania adaptera RecyclerView
public class ListAdapter extends RecyclerView.Adapter{
    private final ListFragment.OnSelectedInterface mListener;
    public ListAdapter(ListFragment.OnSelectedInterface listener) { mListener = listener; }
    @NonNull
    @Override
    //ViewHolder opisuje widok elementu i metadane dotyczące jego miejsca w RecyclerView.
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //pobranie widoku layout z list_items
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items , viewGroup , false);
        //zwrócenie nowego widoku ListViewHolder
        return new ListViewHolder(view);
    }
        @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i){
            ((ListViewHolder) viewHolder).bindView(i);
    }
    @Override
    public int getItemCount(){return Diets.names.length;}
    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //prywatny widok tekstu
        private TextView mTextView;
        // prywatny widok obrazka
        private ImageView mImageView;
        private int mIndex;
        //publiczna lista ViewHolder
        public ListViewHolder(@NonNull View itemView){
            super(itemView);
            mTextView=(TextView)itemView.findViewById(R.id.itemText);
            mImageView=(ImageView)itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }
        public void bindView(int position){
            mIndex = position;
            mTextView.setText(Diets.names[position]);
            mImageView.setImageResource(Diets.resourceIds[position]);
        }

        @Override
        public void onClick(View view){mListener.onListSelected(mIndex); }

        }
    }
