package georgianhemant.com.imagegallery;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class Gallery extends AppCompatActivity  {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager mLayoutManager;
    public CustomItemClickListener listener;
    private View mProgressView;
     String[] urls ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mRecyclerView = (RecyclerView) findViewById(R.id.grid_recycler_view);
        mProgressView = findViewById(R.id.gallary_progress);

        final Activity activity = this;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        if(activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mLayoutManager = new GridLayoutManager(this,3);
//            mLayoutManager = new StaggeredGridLayoutManager(2,Configuration.ORIENTATION_PORTRAIT);

        }
        else{
            mLayoutManager = new GridLayoutManager(this,5);
//            mLayoutManager = new StaggeredGridLayoutManager(3,Configuration.ORIENTATION_LANDSCAPE);
        }
        urls = getIntent().getStringArrayExtra("files");
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        listener = new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent o = new Intent(Gallery.this, ImageTabsActivity.class);
                o.putExtra("files",urls);
                o.putExtra("index", position);
                startActivity(o);
            }
        };



    }

}
