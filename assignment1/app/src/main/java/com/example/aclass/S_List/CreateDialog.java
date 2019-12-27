package com.example.aclass.S_List;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.aclass.Activitys.R;


public class CreateDialog extends DialogFragment {

    private EditText editText;
    private EditText editText2;
    private TextView TVSubmit;
    private ImageView IVCancel;
    private Button databtn;
    private OnCreateTaskListener listener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_create, container);

        editText = (EditText) view.findViewById(R.id.ret_content);
        editText2 = (EditText) view.findViewById(R.id.title_edit);
        databtn=(Button)view.findViewById(R.id.data_btn);
        TVSubmit = (Button) view.findViewById(R.id.submit_btn);
        IVCancel = (ImageView) view.findViewById(R.id.iv_cancel);
        TVSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                写入数据库
                 */
//                DBManager.getInstance().insertToInfoTable(editText.getText().toString());
                dismiss();
                listener.onCreateTask();
            }
        });
        IVCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        databtn.setOnClickListener(new View.OnClickListener() {
            int m_year = 2012;
            int m_month = 1;
            int m_day = 1;
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener dateListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String y=String.valueOf(year);
                        String m=String.valueOf(monthOfYear);
                        String d=String.valueOf(dayOfMonth);
                        databtn.setText(y+"-"+m+"-"+d);
                    }
                };

                DatePickerDialog date=new DatePickerDialog(view.getContext(),
                        dateListener,m_year,m_month,m_day);
                date.setTitle("日期对话框");
                date.show();


            }
        });

        return view;
    }

    public void setOnCreateTaskListener(OnCreateTaskListener listener) {
        this.listener=listener;
    }
}
