package com.example.aclass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.aclass.Activitys.R;
import com.example.aclass.S_Class.bean.StuInfoBean;
import com.example.aclass.S_List.ShowViewHolder;

import java.util.ArrayList;
import java.util.List;

public class StuListAdapter extends ArrayAdapter<StuInfoBean> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<StuInfoBean> beanList;
    private ShowViewHolder viewHolder;

    public StuListAdapter(Context context, ArrayList<StuInfoBean> beans) {
        super(context, 0, beans);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        StuInfoBean bean = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_info_item, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.stu_name_view);
        TextView tvId = (TextView) convertView.findViewById(R.id.stu_item_id_view);
        TextView tvClass = (TextView) convertView.findViewById(R.id.stu_classno_view);
        ImageView im=(ImageView) convertView.findViewById(R.id.student_tx);
        tvName.setText(bean.sname);
        tvId.setText(bean.sno);
        tvClass.setText(bean.classno);
        im.setImageResource(R.drawable.contact_head_icon);


        return convertView;
    }
}
