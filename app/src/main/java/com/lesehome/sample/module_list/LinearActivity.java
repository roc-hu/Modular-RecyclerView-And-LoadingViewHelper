package com.lesehome.sample.module_list;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lesehome.carrot.recycler.modularadapter.IAdapterItem;
import com.lesehome.carrot.recycler.decoration.LinearDividerItemDecoration;
import com.lesehome.sample.BaseActivity;
import com.lesehome.sample.module_list.adapter.LinearAdapter;
import com.lesehome.sample.model.entity.Gecko;
import com.lesehome.sample.model.entity.Snake;
import com.lesehome.sample.R;
import com.lesehome.sample.model.AnimalsDataSource;

public class LinearActivity extends BaseActivity implements
        IAdapterItem.OnItemClickListener, IAdapterItem.OnItemLongClickListener {

    private TextView textview;
    private RecyclerView recyclerView;

    private LinearAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_recycler_with_title);

        textview = findView(R.id.textView);
        textview.setText("RecyclerView 列表样式");


        recyclerView = findView(R.id.recyclerView);
//        initItemDecorationPaint();
        initItemDecorationDrawable();
//        initItemDecorationDimen();

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new LinearAdapter(this, AnimalsDataSource.getAnimalsSnakeAndGecko());
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    private void initItemDecorationPaint() {
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setPathEffect(new DashPathEffect(new float[]{25.0f, 25.0f}, 0));

        LinearDividerItemDecoration itemDecoration=new LinearDividerItemDecoration.Builder(this)
                .paint(paint)
                .showLastDivider()
                .build();

        recyclerView.addItemDecoration(itemDecoration);
    }

    private void initItemDecorationDrawable() {
        LinearDividerItemDecoration itemDecoration = new LinearDividerItemDecoration.Builder(this)
                .drawable(R.drawable.bg_back)
                .size(15)
                .build();

        recyclerView.addItemDecoration(itemDecoration);
    }

    private void initItemDecorationDimen() {
//        ListHorizontalDividerItemDecoration itemDecoration = new ListHorizontalDividerItemDecoration.Builder(this)
//                .color(Color.RED)
//                .sizeResId(R.dimen.default_divider_height)
//                .marginResId(R.dimen.default_divider_leftmargin, R.dimen.default_divider_rightmargin)
//                .build();
//
//        recyclerView.addItemDecoration(itemDecoration);


        LinearDividerItemDecoration itemDecoration = new LinearDividerItemDecoration.Builder(this)
                .color(Color.RED)
                .sizeResId(R.dimen.default_divider_height)
                .marginResId(R.dimen.default_divider_leftmargin, R.dimen.default_divider_rightmargin)
                .build();
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void onItemClick(View view, int position, int itemViewType) {
        String name = "";
        if (view.getTag() != null) {
            if (view.getTag() instanceof Snake) {
                name = ((Snake) view.getTag()).getName();
            } else if (view.getTag() instanceof Gecko) {
                name = ((Gecko) view.getTag()).getName();
                adapter.removeItem(position);
            }

        }
        Toast.makeText(view.getContext(), "onItemClick\n--->position:["
                + position + "]itemViewType:[" + itemViewType + "]\n"
                + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(View view, int position, int itemViewType) {
        Toast.makeText(view.getContext(), "onItemLongClick\n--->position:["
                + position + "]itemViewType:[" + itemViewType + "]", Toast.LENGTH_SHORT).show();
        adapter.addItem(position, new Snake("添加", "哈哈"));
        return true;
    }


}
