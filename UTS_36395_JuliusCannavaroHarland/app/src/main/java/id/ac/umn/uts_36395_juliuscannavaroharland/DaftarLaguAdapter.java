package id.ac.umn.uts_36395_juliuscannavaroharland;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarLaguAdapter extends RecyclerView.Adapter<DaftarLaguAdapter.ItemLaguViewHolder> {
    private LinkedList<SourceLagu> mDaftarLagu;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarLaguAdapter(Context context, LinkedList<SourceLagu> daftarLagu){
        this.mContext = context;
        this.mDaftarLagu = daftarLagu;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemLaguViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.lagu_item_layout, parent, false);
        return new ItemLaguViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLaguViewHolder holder, int position) {
        SourceLagu mSourceLagu = mDaftarLagu.get(position);
        holder.tvJudul.setText(mSourceLagu.getJudul());
        holder.tvKeterangan.setText(mSourceLagu.getKeterangan());
        holder.deleteLagu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDaftarLagu.remove(mSourceLagu);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDaftarLagu.size();
    }

    public class ItemLaguViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvJudul;
        private TextView tvKeterangan;
        private DaftarLaguAdapter mAdapter;
        private int mPosisi;
        private SourceLagu mSourceLagu;
        private ImageButton deleteLagu;

        public ItemLaguViewHolder(@NonNull View itemView, DaftarLaguAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
            deleteLagu = itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mPosisi = getLayoutPosition();
            mSourceLagu = mDaftarLagu.get(mPosisi);
            Intent detailInten = new Intent(mContext, DetailLaguActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetailLagu", mSourceLagu);
            detailInten.putExtras(bundle);
            String judullagu = tvJudul.getText().toString();
            detailInten.putExtra("Judul", judullagu);
            mContext.startActivity(detailInten);

        }
    }
}
