package com.kgom.binaryoptions.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.activities.FreeDemoActivity;

/**
 * Created by KJS on 1/6/2017.
 */
public class TipsFragment extends Fragment {
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static TipsFragment create(int pageNumber) {
        TipsFragment fragment = new TipsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public TipsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(getLayoutFromPageNumber(mPageNumber), container, false);

        // Set the title view to show the page number.
/*        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
                "test"+( mPageNumber + 1));
*/
        return rootView;
    }

    public void onClick(View v){

    }
    int getLayoutFromPageNumber(int mPageNumber){
        switch (mPageNumber){
            case 0:
                return R.layout.tip_fragment_1;

            case 1:
                return R.layout.tip_fragment_2;

            case 2:
                return R.layout.tip_fragment_3;

            case 3:
                return R.layout.tip_fragment_4;

            case 4:
                return R.layout.tip_fragment_5;

            case 5:
                return R.layout.tip_fragment_6;

            case 6:
                return R.layout.tip_fragment_7;

            case 7:
                return R.layout.tip_fragment_8;

            case 8:
                return R.layout.tip_fragment_9;

            case 9:
                return R.layout.tip_fragment_10;

            default:
                return R.layout.tip_fragment_1;

        }
    }
    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
