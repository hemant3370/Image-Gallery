package georgianhemant.com.imagegallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

/**
 * Created by HemantSingh on 25/10/16.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private List<String> mFileset;
    private final Context context;

    CustomItemClickListener listener;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mItemView;
        public ImageView imgageView;

        public ViewHolder(View v) {
            super(v);
            mItemView = v;
            imgageView = (ImageView) v.findViewById(R.id.ivgallery);
        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public GridAdapter(Context context, List<String> fileSet, CustomItemClickListener listener) {

        this.listener = listener;
        this.context = context;
        this.mFileset = fileSet;
        Collections.reverse(mFileset);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view

            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.griditem, parent, false);
            // set the view's size, margins, paddings and layout parameters

            final GridAdapter.ViewHolder vh = new GridAdapter.ViewHolder(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, vh.getAdapterPosition());
                }
            });
            return vh;
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
            Glide.with(context).load(mFileset.get(position)).into(holder.imgageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mFileset.size();
    }


}



