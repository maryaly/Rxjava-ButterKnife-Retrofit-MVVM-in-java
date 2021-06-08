package com.example.vosuqjava.ui.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.vosuqjava.R;
import com.example.vosuqjava.ui.viewmodel.ItemViewModel;
import com.example.vosuqjava.ui.adapter.Adapter;
import com.example.vosuqjava.data.model.Item;
import com.example.vosuqjava.databinding.ActivityMainBinding;
import com.example.vosuqjava.data.repository.Repository;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mDataBinding;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();
    }

    private void init() {
        ItemViewModel itemViewModel = new ItemViewModel(Repository.getInstance());
        itemViewModel.getItems().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Item>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onSuccess(List<Item> items) {
                       doActionsForSuccess(items);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "error" + e.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void doActionsForSuccess(List<Item> items) {
        mDataBinding.recyclerView.setVisibility(View.VISIBLE);
        mDataBinding.progressBar.setVisibility(View.GONE);
        mDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        Adapter adapter = new Adapter(MainActivity.this, items);
        mDataBinding.recyclerView.setAdapter(adapter);
    }

}
