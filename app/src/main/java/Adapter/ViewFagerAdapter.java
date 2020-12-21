package Adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import Fragment.BookmarkFragment;
import Fragment.HomeFragment;
import Fragment.InvoiceFragment;
import Fragment.NotiFragment;
import Fragment.ProfileFragment;

public class ViewFagerAdapter extends FragmentStatePagerAdapter {

    public ViewFagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new BookmarkFragment();
            case 2:
                return new InvoiceFragment();
            case 3:
                return new NotiFragment();
            case 4:
                return new ProfileFragment();
            default: new HomeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
