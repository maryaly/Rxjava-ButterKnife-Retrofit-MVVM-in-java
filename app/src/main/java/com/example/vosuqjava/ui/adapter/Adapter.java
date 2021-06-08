package com.example.vosuqjava.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vosuqjava.R;
import com.example.vosuqjava.ui.base.BaseViewHolder;
import com.example.vosuqjava.data.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private List<Item> items;

    public Adapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
            return 0;
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.container)
        ConstraintLayout container;

        @BindView(R.id.textViewSymbolDate)
        TextView textViewSymbolDate;

        @BindView(R.id.textViewBaseCurrencyShortNameData)
        TextView textViewBaseCurrencyShortNameData;

        @BindView(R.id.textViewQuoteCurrencyShortNameData)
        TextView textViewQuoteCurrencyShortNameData;

        @BindView(R.id.textViewQuantityIncrementData)
        TextView textViewQuantityIncrementData;

        @BindView(R.id.textViewTickSizeData)
        TextView textViewTickSizeData;

        @BindView(R.id.textViewTakeLiquidityRateData)
        TextView textViewTakeLiquidityRateData;

        @BindView(R.id.textViewProvideLiquidityRateData)
        TextView textViewProvideLiquidityRateData;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

        public void onBind(int position) {
            super.onBind(position);
            textViewSymbolDate.setText(items.get(position).getSymbol());
            textViewBaseCurrencyShortNameData.setText(items.get(position).getBaseCurrencyShortName());
            textViewQuoteCurrencyShortNameData.setText(items.get(position).getQuoteCurrencyShortName());
            textViewQuantityIncrementData.setText(""+items.get(position).getQuantityIncrement());
            textViewTickSizeData.setText(""+items.get(position).getTickSize());
            textViewTakeLiquidityRateData.setText(""+items.get(position).getTakeLiquidityRate());
            textViewProvideLiquidityRateData.setText(""+items.get(position).getProvideLiquidityRate());
            setContainerBackground(items.get(position),container);
        }

        private void setContainerBackground(Item item, ConstraintLayout container) {
            if (item.getFeeSide()==0)
                container.setBackgroundColor(context.getResources().getColor(R.color._E8E8E8));
            else
                container.setBackgroundColor(context.getResources().getColor(R.color._FFFFFF));
        }

        @Override
        protected void clear() {

        }
    }

}
