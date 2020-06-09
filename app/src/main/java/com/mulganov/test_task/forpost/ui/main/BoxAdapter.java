package com.mulganov.test_task.forpost.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mulganov.test_task.forpost.R;
import com.mulganov.test_task.forpost.user.User;

import java.util.ArrayList;

public class BoxAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<User> objects;
    MainPresent presenter;

    public BoxAdapter(Context context, ArrayList<User> elements, MainPresent presenter) {
        this.presenter = presenter;
        ctx = context;
        objects = elements;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item_user, parent, false);
        }

        final User p = getProduct(position);

        ((TextView)view.findViewById(R.id.iText)).setText(p.getName());
        ((ImageView)view.findViewById(R.id.iImage)).setImageBitmap(p.getBitmap());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickUser(p);
            }
        });

        return view;
    }

    // товар по позиции
    User getProduct(int position) {
        return ((User) getItem(position));
    }

}