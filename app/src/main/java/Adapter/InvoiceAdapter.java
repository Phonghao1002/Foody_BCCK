package Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import invoice.dandenFragment;
import invoice.lichsuFragment;
import invoice.donnhapFragment;

public class InvoiceAdapter extends FragmentPagerAdapter {
    private String listTab[] = {"Đang Đến", "Lịch Sử","Đơn Nháp"};
    private dandenFragment mdandenFragment;
    private lichsuFragment mlichsuFragment;
    private donnhapFragment mdonnhapFragment;

    public InvoiceAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mdandenFragment = new dandenFragment();
        mlichsuFragment = new lichsuFragment();
        mdonnhapFragment = new donnhapFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return mdandenFragment;
        } else if (position == 1) {
            return mlichsuFragment;
        }
        else if (position == 2) {
            return mdonnhapFragment;}
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