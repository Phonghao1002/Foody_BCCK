package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.foody.NotiSettingActivity;
import com.example.foody.R;
import com.example.foody.Search;
import com.google.android.material.tabs.TabLayout;

import Adapter.NofiAdapter;
import Adapter.ViewFagerAdapter;

public class NotiFragment extends Fragment {
    ImageView imageViewSetting;
    ImageView imageViewSearch;

    View myFragment;

//    ViewPager viewPagertb;
//    TabLayout tabLayouttb;
    private ViewPager mviewPager;
    public NotiFragment() {
        // Required empty public constructor
    }

    public static NotiFragment getInstance()    {
        return new NotiFragment();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment=inflater.inflate(R.layout.fragment_noti,container,false);
        InitView();
        click();
        return myFragment;
    }
    private void InitView() {
        mviewPager= (ViewPager) myFragment.findViewById(R.id.viewPagertb);
        mviewPager.setAdapter(new NofiAdapter(getChildFragmentManager()));
        TabLayout mtabLayout= (TabLayout) myFragment.findViewById(R.id.tabLayouttb);
        mtabLayout.setupWithViewPager(mviewPager);
    }
    private void click(){
        imageViewSetting=(ImageView) myFragment.findViewById(R.id.imagesetting);
        imageViewSearch=(ImageView) myFragment.findViewById(R.id.imagesearch);
        imageViewSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(myFragment.getContext(), NotiSettingActivity.class);
                startActivity(intent);
            }
        });
        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(myFragment.getContext(), Search.class);
                startActivity(intent);
            }
        });
    }
}

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        setUpViewFager(viewPagertb);
//        tabLayouttb.setupWithViewPager(viewPagertb);
//        tabLayouttb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
//
//    private void setUpViewFager(ViewPager viewPagertb) {
//
//        NofiAdapter adapter = new NofiAdapter(getChildFragmentManager());
//        adapter.addFragment(new DichvuFragment(), "Dịch Vụ ");
//        adapter.addFragment(new CuatoiFragment(), "Của Tôi");
//        adapter.addFragment(new TinmoiFragment(),"Tin Mới");
//
//        viewPagertb.setAdapter(adapter);
//
//    }

