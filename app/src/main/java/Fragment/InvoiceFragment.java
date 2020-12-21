package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.foody.NotiSettingActivity;
import com.example.foody.R;
import com.example.foody.Search;
import com.google.android.material.tabs.TabLayout;

import Adapter.InvoiceAdapter;
import Adapter.NofiAdapter;

public class InvoiceFragment extends Fragment {

    View myFragment2;

    //    ViewPager viewPagertb;
//    TabLayout tabLayouttb;
    private ViewPager mviewPager2;
    public InvoiceFragment() {
        // Required empty public constructor
    }

    public static InvoiceFragment getInstance()    {
        return new InvoiceFragment();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment2=inflater.inflate(R.layout.fragment_invoice,container,false);
        InitView2();
        return myFragment2;
    }
    private void InitView2() {
        mviewPager2= (ViewPager) myFragment2.findViewById(R.id.viewPageriv);
        mviewPager2.setAdapter(new InvoiceAdapter(getChildFragmentManager()));
        TabLayout mtabLayout= (TabLayout) myFragment2.findViewById(R.id.tabLayoutiv);
        mtabLayout.setupWithViewPager(mviewPager2);
    }

}