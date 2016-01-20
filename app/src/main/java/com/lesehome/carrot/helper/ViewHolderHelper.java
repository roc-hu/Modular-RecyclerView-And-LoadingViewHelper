package com.lesehome.carrot.helper;

import android.util.SparseArray;
import android.view.View;

/**
 * BaseAdapter getView的ViewHolder辅助类用法
 * <pre>
 * public View getView(int position, View convertView, ViewGroup parent) {
 *     if (convertView == null) {
 *          convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
 *     }
 *
 *     ImageView ivIcon = ViewHolder.get(convertView, R.id.iv_icon);
 *     ivIcon.setImageResource(R.mipmap.ic_launcher);
 *
 *     TextView tvTitle =ViewHolder.get(convertView,R.id.tv_title);
 *     tvTitle.setText("标题");
 *
 *     return convertView;
 * }
 * </pre>
 * Created by hcp on 16/1/12.
 */
public class ViewHolderHelper {
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
