package financialbalance.appsyouneed.idinu.financialbalance.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import financialbalance.appsyouneed.idinu.financialbalance.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView descriptionTextView;
    private TextView amountTextView;
    private TextView dateTextView;

    public RecyclerViewHolder(final View itemView) {
        super(itemView);
        descriptionTextView = (TextView) itemView.findViewById(R.id.description_text_view);
        amountTextView = (TextView) itemView.findViewById(R.id.amount_text_view);
        dateTextView = (TextView) itemView.findViewById(R.id.date_text_view);
    }

    public void bindData(final ItemModel viewModel) {
        descriptionTextView.setText(viewModel.getDescription());
        if (viewModel.getType() == 0) {
            amountTextView.setTextColor(R.color.outcomeColor);
            amountTextView.setText("-" + viewModel.getAmount());
        } else {
            amountTextView.setTextColor(R.color.incomeColor);
            amountTextView.setText("+" + viewModel.getAmount());
        }
        dateTextView.setText(viewModel.getDate());
    }
}
