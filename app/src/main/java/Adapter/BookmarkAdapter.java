package Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BookmarkAdapter extends FragmentPagerAdapter {
    private String listTab[] = {"Tất cả", "Địa điểm","Hình ảnh","Bài viết"};
    private TatcaFragment mtatcaFragment;
    private DiadiemFragment mdiadiemFragment;
    private HinhanhFragment mhinhanhFragment;
    private BaivietFragment mbaivietFragment;

    public BookmarkAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mtatcaFragment = new TatcaFragment();
        mdiadiemFragment = new DiadiemFragment();
        mhinhanhFragment = new HinhanhFragment();
        mbaivietFragment = new BaivietFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return mtatcaFragment;
        } else if (position == 1) {
            return mdiadiemFragment;
        }
        else if (position == 2) {
            return mhinhanhFragment;
        }
        else if (position == 3) {
            return mbaivietFragment;
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