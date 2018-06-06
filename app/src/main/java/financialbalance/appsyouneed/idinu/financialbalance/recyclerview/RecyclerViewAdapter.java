package financialbalance.appsyouneed.idinu.financialbalance.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import financialbalance.appsyouneed.idinu.financialbalance.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private List<ItemModel> modelList;

    public RecyclerViewAdapter(List<ItemModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RecyclerViewHolder) holder).bindData(modelList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.item_recycler_view;
    }
}
