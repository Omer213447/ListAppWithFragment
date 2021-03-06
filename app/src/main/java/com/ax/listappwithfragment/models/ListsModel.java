package com.ax.listappwithfragment.models;

import com.ax.listappwithfragment.R;

import java.util.ArrayList;

public class ListsModel {
    public static ArrayList<Integer> genders = new ArrayList<Integer>(){
        {
            add(R.drawable.maleicon);
            add(R.drawable.femaleicon);
            add(R.drawable.femaleicon);
            add(R.drawable.maleicon);
        }
    };
    public static ArrayList<Integer> statuses = new ArrayList<Integer>(){
        {
            add(R.drawable.tick);
            add(R.drawable.tick);
            add(R.drawable.cross);
            add(R.drawable.tick);
        }
    };
    public static ArrayList<String> names = new ArrayList<String>(){
        {
            add("Mehmet Uçar");
            add("Deniz Kurtaran");
            add("Melisa Ateş");
            add("Ahmet Terzi");
        }
    };
    public static ArrayList<String> descriptions = new ArrayList<String>(){
        {
            add("4. Sınıf Bilgisayar Mühendisliği Öğrencisi");
            add("3. Sınıf Sivil Mühendisliği Öğrencisi");
            add("1. Sınıf Ekonomi Öğrencisi");
            add("Bilgisayar Mühendisi, Android yazılım projelerinde bulundu");
        }
    };
    public static void add(Integer imageGender, Integer imageTicks, String name, String info){
        genders.add(imageGender);
        statuses.add(imageTicks);
        names.add(name);
        descriptions.add(info);
    }
    public static void remove(int position){
        genders.remove(position);
        statuses.remove(position);
        names.remove(position);
        descriptions.remove(position);
    }
}
