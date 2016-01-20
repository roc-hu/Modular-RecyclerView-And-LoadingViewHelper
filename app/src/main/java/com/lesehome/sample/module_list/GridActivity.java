package com.lesehome.sample.module_list;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lesehome.carrot.recycler.modularadapter.IAdapterItem;
import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.carrot.recycler.decoration.GridDividerItemDecoration;
import com.lesehome.sample.BaseActivity;
import com.lesehome.sample.R;
import com.lesehome.sample.model.entity.Cat;
import com.lesehome.sample.model.entity.Dog;
import com.lesehome.sample.model.entity.Gecko;
import com.lesehome.sample.model.entity.Snake;
import com.lesehome.sample.module_list.adapter.GridAdapter;
import com.lesehome.sample.model.AnimalsDataSource;

public class GridActivity extends BaseActivity implements
        IAdapterItem.OnItemClickListener, IAdapterItem.OnItemLongClickListener {

    private GridAdapter adapter;
    private TextView textview;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_recycler_with_title);

        textview = findView(R.id.textView);
        textview.setText("RecyclerView 网格样式");

        recyclerView = findView(R.id.recyclerView);

        final GridLayoutManager manager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(manager);


        GridDividerItemDecoration itemDecoration = new GridDividerItemDecoration.Builder(this)
                .drawable(R.drawable.bg_back)
                .build();
        recyclerView.addItemDecoration(itemDecoration);

        adapter = new GridAdapter(this, AnimalsDataSource.getAnimals());
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
        recyclerView.setAdapter(adapter);


//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return (position == 0 && adapter.getItemViewType(position) == 0)
//                        ? manager.getSpanCount() : 1;
//            }
//        });


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
