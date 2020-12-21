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

import com.example.foody.R;
import com.example.foody.Search;
import com.google.android.material.tabs.TabLayout;

import Adapter.BookmarkAdapter;

public class BookmarkFragment extends Fragment {
    ImageView imageViewSearch;

    View myFragment;

//    ViewPager viewPagertb;
//    TabLayout tabLayouttb;
    private ViewPager mviewPager;
    public BookmarkFragment() {
        // Required empty public constructor
    }

    public static BookmarkFragment getInstance()    {
        return new BookmarkFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_bookmark,container,false);
        InitView();
        click();
        return myFragment;
    }
    private void InitView() {
        mviewPager= (ViewPager) myFragment.findViewById(R.id.viewPagertb);
        mviewPager.setAdapter(new BookmarkAdapter(getChildFragmentManager()));
        TabLayout mtabLayout= (TabLayout) myFragment.findViewById(R.id.tabLayouttb);
        mtabLayout.setupWithViewPager(mviewPager);
    }
    private void click(){

        imageViewSearch=(ImageView) myFragment.findViewById(R.id.imagesearch);

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(myFragment.getContext(), Search.class);
                startActivity(intent);
            }
        });
    }
}
