package com.princedev.coddinggeek;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.princedev.coddinggeek.Adapter.ImageSliderAdapter;
import com.princedev.coddinggeek.Adapter.LanguageAdapter;
import com.princedev.coddinggeek.Model.Language;
import com.princedev.coddinggeek.Utils.Connection;
import com.princedev.coddinggeek.Utils.NodeJsAPI;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {
    Context mContext = HomeActivity.this;

    SliderView sliderView;
    private RecyclerView recyclerView;
    private CompositeDisposable compositeDisposable;
    private NodeJsAPI api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        api = Connection.getAPI();
        compositeDisposable = new CompositeDisposable();

        sliderView = findViewById(R.id.imageSlider);

        recyclerView = findViewById(R.id.recycle_language);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ImageSliderAdapter adapter = new ImageSliderAdapter(mContext);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(8); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        getLanguage();

    }

    private void getLanguage(){
        compositeDisposable.add(api.getDataLanguage()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<List<Language>>() {
                @Override
                public void accept(List<Language> languages) throws Exception {
                    Log.d("DATA LANGUAGE", "accept: " + languages.get(1).getName());
                    recyclerView.setAdapter(new LanguageAdapter(mContext, languages));
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    Toast.makeText(mContext, "Error Get Data", Toast.LENGTH_SHORT).show();
                }
            }));
    }

}
