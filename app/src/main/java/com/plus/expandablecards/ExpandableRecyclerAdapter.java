package com.plus.expandablecards;

import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExpandableRecyclerAdapter extends RecyclerView.Adapter<ExpandableRecyclerAdapter.MyViewHolder> {

    private final List<ItemData> list;

    public ExpandableRecyclerAdapter(List<ItemData> list) {
        this.list = list;
    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(
                                R.layout.expandable_item,
                                parent,
                                false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemData itemData = list.get(position);
        holder.bind(position, itemData);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView desc;
        private final TextView serial;
        private final CardView cardView, titlecard;
        private final ImageView icon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titletext);
            desc = itemView.findViewById(R.id.description);
            serial = itemView.findViewById(R.id.serialtext);
            icon = itemView.findViewById(R.id.myicon);
            titlecard = itemView.findViewById(R.id.titleCard);
            cardView = itemView.findViewById(R.id.cardview);


            itemView.setOnClickListener(v -> {
//                TransitionManager.beginDelayedTransition(cardView, new Fade());
                ItemData itemData = list.get(getAdapterPosition());
                itemData.setExpanded(!itemData.isExpanded());
                notifyItemChanged(getAdapterPosition());
            });
        }

        public void bind(int position, ItemData itemData) {
            serial.setText(String.valueOf(position + 1));
            title.setText(itemData.getTitle());
            desc.setText(itemData.getDesc());
            boolean isExpanded = itemData.isExpanded();
            desc.setVisibility(isExpanded?View.VISIBLE:View.GONE);
            titlecard.setCardBackgroundColor(isExpanded?ContextCompat.getColor(itemView.getContext(), R.color.purple_200)
                    :ContextCompat.getColor(itemView.getContext(), R.color.white));
            icon.setImageResource(isExpanded?R.drawable.ic_baseline_minus_24:R.drawable.ic_baseline_add_24);
        }
    }
}
