package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.foody.R;
import com.example.foody.activity_gr;
import com.google.android.material.tabs.TabLayout;

import Adapter.PagerAdapter;

public class HomeFragment extends Fragment {
    View myFragment2;
    ImageButton imageButton1,imageButton2,imageButton3;

    private ViewPager mviewPager2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment2=inflater.inflate(R.layout.fragment_home,container,false);
        imageButton1=myFragment2.findViewById(R.id.btn1);
        InitView2();
        clImageButton();

        return myFragment2;
    }
    private void InitView2() {
        mviewPager2= (ViewPager) myFragment2.findViewById(R.id.viewp);
        mviewPager2.setAdapter(new PagerAdapter(getChildFragmentManager())) ;
        TabLayout mtabLayout= (TabLayout) myFragment2.findViewById(R.id.tab);
        mtabLayout.setupWithViewPager(mviewPager2);
    }
    private void clImageButton() {
        imageButton1 = (ImageButton) myFragment2.findViewById(R.id.btn1);
        imageButton2 = (ImageButton) myFragment2.findViewById(R.id.btn2);
        imageButton3 = (ImageButton) myFragment2.findViewById(R.id.btn3);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent INTENT_01 = new Intent(getActivity(), activity_gr.class ) ;
                startActivity( INTENT_01 ) ;
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent INTENT_02 = new Intent(getActivity(), activity_gr.class ) ;
                startActivity( INTENT_02 ) ;
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent INTENT_03 = new Intent(getActivity(), activity_gr.class ) ;
                startActivity( INTENT_03 ) ;
            }
        });
    }
}