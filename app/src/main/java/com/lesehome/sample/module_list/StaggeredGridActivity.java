package com.lesehome.sample.module_list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lesehome.carrot.recycler.modularadapter.IAdapterItem;
import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.decoration.SpacingDecoration;
import com.lesehome.sample.BaseActivity;
import com.lesehome.sample.module_list.adapter.StaggeredGridAdapter;
import com.lesehome.sample.model.entity.Cat;
import com.lesehome.sample.model.entity.Dog;
import com.lesehome.sample.model.entity.Gecko;
import com.lesehome.sample.model.entity.Snake;
import com.lesehome.sample.R;
import com.lesehome.sample.model.AnimalsDataSource;

public class StaggeredGridActivity extends BaseActivity implements
        IAdapterItem.OnItemClickListener, IAdapterItem.OnItemLongClickListener {

    private StaggeredGridAdapter adapter;
    private TextView textview;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_recycler_with_title);

        textview = findView(R.id.textView);
        textview.setText("RecyclerView 瀑布流样式");

        recyclerView = findView(R.id.recyclerView);

        final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);


        recyclerView.addItemDecoration(new SpacingDecoration(this, R.dimen.activity_horizontal_margin));

        adapter = new StaggeredGridAdapter(this, AnimalsDataSource.getAnimals());
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(View view, int position, int itemViewType) {
        String name = "";
        if (view.getTag() != null) {
            if (view.getTag() instanceof Snake) {
                name = ((Snake) view.getTag()).getName();
            } else if (view.getTag() instanceof Cat) {
                name = ((Cat) view.getTag()).getName();
            } else if (view.getTag() instanceof Dog) {
                name = ((Dog) view.getTag()).getName();
            } else if (view.getTag() instanceof Gecko) {
                name = ((Gecko) view.getTag()).getName();
            } else if (view.getTag() instanceof IItemEntity) {
                name = "IItemEntity";
            }

        }
        Toast.makeText(view.getContext(), "onItemClick\n--->position:["
                + position + "]itemViewType:[" + itemViewType + "]\n"
                + name, Toast.LENGTH_SHORT).show();
        adapter.removeItem(position);
    }

    @Override
    public boolean onItemLongClick(View view, int position, int itemViewType) {
        Dog dog = new Dog("小🐶🐶");
        adapter.addItem(position, dog);
        return true;
    }
}
