package com.example.hodeozshopping2.shopping2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TinderActivity extends AppCompatActivity implements Communicator, IswitchFragments {

    int e1, e2, e3, e4, e5, e6, e7, e8;
    int e1Max, e2Max;

    TinderDinnerFragment tinderDinnerFragment ;
    TinderDrinkFragment  tinderDrinkFragment  ;

    Boolean booleanTinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder);

        booleanTinder = true;

        Intent mIntent = getIntent();
        e1 = mIntent.getIntExtra("e1", e1);
        e2 = mIntent.getIntExtra("e2", e2);
        e3 = mIntent.getIntExtra("e3", e3);
        e4 = mIntent.getIntExtra("e4", e4);
        e5 = mIntent.getIntExtra("e5", e5);
        e6 = mIntent.getIntExtra("e6", e6);
        e7 = mIntent.getIntExtra("e7", e7);
        e8 = mIntent.getIntExtra("e8", e8);

        e1Max = e1;
        e2Max = e2;

        //Initialisation des fragment swipe
        tinderDinnerFragment = new TinderDinnerFragment();
        tinderDrinkFragment = new TinderDrinkFragment();

        //Lancement du premier fragment swipe
        switchFragment(ID.FRAG1);


        //Lancement de la languette résumer
        setTongue();

    }

    public void setTongue (){

        Bundle bundle = new Bundle();
        bundle.putInt("e1", e1);
        bundle.putInt("e2", e2);
        bundle.putInt("e3", e3);
        bundle.putInt("e4", e4);
        bundle.putInt("e5", e5);
        bundle.putInt("e6", e6);
        bundle.putInt("e7", e7);
        bundle.putInt("e8", e8);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        TongueFragment tongueFragment = new TongueFragment();
        tongueFragment.setArguments(bundle);
        ft.add(R.id.containerTongue, tongueFragment)
                //.addToBackStack("")
                .commit();
    }

    @Override
    public void respond1(String data) {
        FragmentManager fm = getFragmentManager();
        TongueFragment tongueFragment = (TongueFragment) fm.findFragmentById(R.id.containerTongue);
        tongueFragment.changeText1(data);
    }
    @Override
    public void respond2(String data) {
        FragmentManager fm = getFragmentManager();
        TongueFragment tongueFragment = (TongueFragment) fm.findFragmentById(R.id.containerTongue);
        tongueFragment.changeText2(data);
    }
    @Override
    public void respond3(String data) {
        FragmentManager fm = getFragmentManager();
        TongueFragment tongueFragment = (TongueFragment) fm.findFragmentById(R.id.containerTongue);
        tongueFragment.changeText3(data);
    }
    @Override
    public void respond4(String data) {
        FragmentManager fm = getFragmentManager();
        TongueFragment tongueFragment = (TongueFragment) fm.findFragmentById(R.id.containerTongue);
        tongueFragment.changeText4(data);
    }
    @Override
    public void respond5(String data) {
        FragmentManager fm = getFragmentManager();
        TongueFragment tongueFragment = (TongueFragment) fm.findFragmentById(R.id.containerTongue);
        tongueFragment.changeText5(data);
    }
    @Override
    public void respond6(String data) {
        FragmentManager fm = getFragmentManager();
        TongueFragment tongueFragment = (TongueFragment) fm.findFragmentById(R.id.containerTongue);
        tongueFragment.changeText6(data);
    }


    @Override
    public void switchFragment(ID id) {
        Bundle bundle = new Bundle();
        FragmentManager fm;
        FragmentTransaction ft;

        switch (id){
            case FRAG1:

                bundle.putInt("e1", e1);
                bundle.putInt("e2", e2);
                bundle.putInt("e3", e3);
                bundle.putInt("e4", e4);
                bundle.putInt("e5", e5);
                bundle.putInt("e6", e6);
                bundle.putInt("e7", e7);
                bundle.putInt("e8", e8);
                tinderDinnerFragment.setArguments(bundle);

                fm = getFragmentManager();
                ft = fm.beginTransaction();

                ft.replace(R.id.container, tinderDinnerFragment, "dinnerFragment")
                        .commit();
                break;

            case FRAG2:

                bundle.putInt("e1", e1);
                bundle.putInt("e2", e2);
                bundle.putInt("e3", e3);
                bundle.putInt("e4", e4);
                bundle.putInt("e5", e5);
                bundle.putInt("e6", e6);
                bundle.putInt("e7", e7);
                bundle.putInt("e8", e8);
                tinderDrinkFragment.setArguments(bundle);

                fm = getFragmentManager();
                ft = fm.beginTransaction();

                ft.replace(R.id.container, tinderDrinkFragment, "drinkFragment")
                        .commit();

                break;
            default:
                break;
        }
    }
}