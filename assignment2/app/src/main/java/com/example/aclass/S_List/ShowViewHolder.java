package com.example.aclass.S_List;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.Activitys.R;


public class ShowViewHolder extends RecyclerView.ViewHolder {
    public ImageView icon;
    public TextView attribute;
    public TextView title;
    public TextView date;
    public TextView content;
    public TextView delete;
    public LinearLayout layout;
    public ShowViewHolder(View itemView) {
        super(itemView);

//        int[] customizedColors = itemView.getResources().getIntArray(R.array.customizedColors);
//        int customizedColor = customizedColors[new Random().nextInt(customizedColors.length)];
//        itemView.setBackgroundColor(customizedColor);

        icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        title = (TextView) itemView.findViewById(R.id.tv_title);
        date = (TextView) itemView.findViewById(R.id.tv_date);
        content = (TextView) itemView.findViewById(R.id.tv_content);
        delete = (TextView) itemView.findViewById(R.id.tv_delete);
        layout = (LinearLayout) itemView.findViewById(R.id.item_layout);
        attribute = (TextView) itemView.findViewById(R.id.tv_attribute);

    }
}
