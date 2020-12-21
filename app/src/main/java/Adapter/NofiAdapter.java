package Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foody.R;

import Noti.CuatoiFragment;
import Noti.DichvuFragment;
import Noti.TinmoiFragment;

public class NofiAdapter extends FragmentPagerAdapter {
    private String listTab[] = {"Dịch Vụ", "Của Tôi","Tin Mới"};
    private DichvuFragment mdichvuFragment;
    private CuatoiFragment mcuatoiFragment;
    private TinmoiFragment mtinmoiFragment;

    public NofiAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mdichvuFragment = new DichvuFragment();
        mcuatoiFragment = new CuatoiFragment();
        mtinmoiFragment = new TinmoiFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return mdichvuFragment;
        } else if (position == 1) {
            return mcuatoiFragment;
        }
        else if (position == 2) {
            return mtinmoiFragment;}
        return null;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}