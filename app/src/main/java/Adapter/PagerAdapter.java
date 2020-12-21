package Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.foody.F1;
import com.example.foody.F2;

import Noti.CuatoiFragment;
import Noti.DichvuFragment;
import Noti.TinmoiFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private String listTab[] = {"Xem Gần Đây", "Gần Tôi"};
    private F1 mF1;
    private F2 mF2;

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mF1 = new F1();
        mF2 = new F2();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return mF1;
        } else if (position == 1) {
            return mF2;
        }
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