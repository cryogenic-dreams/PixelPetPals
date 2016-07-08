package com.cocoaandcoffee.pixelpetpals;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private final static int[][] drawables = new int[30][2];
    private ViewPager mViewPager;
    private int numberLists;
    private String name;
    private static ArrayList<String> names;

    private final int ACTIVITY_IDENTIFIER = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.numberLists = 3; //This will chage to a number saved in savedInstance
        names = new ArrayList<>();
        names.add(0,"");
        names.add(1,"");
        //We are using the var ARG_SECTION_NUMBER so no 0 and 1 is reserved for the main page
        names.add(2, "List 1"); //Still hardcoded to see how it works
        names.add(3, "List 2");

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //Alert this button action crashes when in page_section>2
        //Override onPause() and/or onDestroy()
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout2);
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), ListCreationActivity.class);
                startActivityForResult(intent, ACTIVITY_IDENTIFIER);
            }
        });

    }

    public void createButton (String name){
        //Note to self: this needs a list factory
        //Also make a template
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout2);
        Button myButton = new Button(this);
        myButton.setText(name);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.addView(myButton, lp);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (ACTIVITY_IDENTIFIER) : {
                if (resultCode == Activity.RESULT_OK) {
                    name = data.getStringExtra("name");
                    createButton(name);
                    numberLists++;
                    names.add(numberLists, name);
                    mSectionsPagerAdapter.notifyDataSetChanged();
                }
                break;
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {


        private int count = 0;
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static CountDownTimer timer;


        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView;

            //Save this in database jeez
            drawables[0][0] = R.drawable.pingurin1;
            drawables[0][1] = R.drawable.pingurin1_1;

            drawables[1][0] = R.drawable.pingurin2;
            drawables[1][1] = R.drawable.pingurin2_1;

            drawables[2][0] = R.drawable.pingurin3;
            drawables[2][1] = R.drawable.pingurin3_1;

            drawables[3][0] = R.drawable.pingurin4;
            drawables[3][1] = R.drawable.pingurin4_1;

            drawables[4][0] = R.drawable.hamon1;
            drawables[4][1] = R.drawable.hamon1_1;

            drawables[5][0] = R.drawable.hamon2;
            drawables[5][1] = R.drawable.hamon2_1;

            drawables[6][0] = R.drawable.hamon3;
            drawables[6][1] = R.drawable.hamon3_1;

            drawables[7][0] = R.drawable.hamon4;
            drawables[7][1] = R.drawable.hamon4_1;

            drawables[8][0] = R.drawable.gustav1;
            drawables[8][1] = R.drawable.gustav1_1;

            drawables[9][0] = R.drawable.gustav2;
            drawables[9][1] = R.drawable.gustav2_1;

            drawables[10][0] = R.drawable.gustav3;
            drawables[10][1] = R.drawable.gustav3_1;

            drawables[11][0] = R.drawable.gustav4;
            drawables[11][1] = R.drawable.gustav4_1;

            drawables[12][0] = R.drawable.tasma1;
            drawables[12][1] = R.drawable.tasma1_1;

            drawables[13][0] = R.drawable.tasma2;
            drawables[13][1] = R.drawable.tasma2_1;

            drawables[14][0] = R.drawable.tasma3;
            drawables[14][1] = R.drawable.tasma3_1;

            drawables[15][0] = R.drawable.tasma4;
            drawables[15][1] = R.drawable.tasma4_1;


            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                //This bulk is just to see how it works and looks
                rootView = inflater.inflate(R.layout.fragment_main, container, false);
                final ImageView iv = (ImageView) rootView.findViewById(R.id.imageView);
                iv.setPadding(0, 390, 0, 0);

                switchImages(iv, drawables[count][0], drawables[count][1]);
                count++;
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int paddingPixel = 0;
                        float density = rootView.getContext().getResources().getDisplayMetrics().density;
                        if (count % 4 == 0) {
                            timer.cancel();
                            paddingPixel = 130;
                            switchImages(iv, drawables[count%16][0], drawables[count%16][1]);
                            count++;
                        } else if (count % 4 == 1) {
                            timer.cancel();
                            paddingPixel = 105;
                            switchImages(iv, drawables[count%16][0], drawables[count%16][1]);
                            count++;
                        } else if (count % 4 == 2) {
                            timer.cancel();
                            paddingPixel = 80;
                            switchImages(iv, drawables[count%16][0], drawables[count%16][1]);
                            count++;
                        } else if (count % 4 == 3) {
                            timer.cancel();
                            paddingPixel = 30;
                            switchImages(iv, drawables[count%16][0], drawables[count%16][1]);
                            count ++;
                        }

                        final int paddingDp = (int) (paddingPixel * density);
                        Log.d("Padding", paddingDp + "");
                        iv.setPadding(0, paddingDp, 0, 0);
                    }
                });



            } else {
                rootView = inflater.inflate(R.layout.fragment_board, container, false);
                TextView textView = (TextView) rootView.findViewById(R.id.list_label);
                textView.setText(names.get(getArguments().getInt(ARG_SECTION_NUMBER)));
            }

            return rootView;
        }

        public void switchImages(final ImageView view, final Integer resId1, final Integer resId2) {
            final long time = 1000; //milis
            long imagePerSec = 500;

            this.timer = new CountDownTimer(time, imagePerSec) {
                boolean sw = true;

                public void onTick(long millisUntilFinished) {
                    if (sw) {
                        view.setImageResource(resId1);
                        sw = false;
                    } else {
                        view.setImageResource(resId2);
                        sw = true;
                    }
                }

                public void onFinish() {
                    start();
                }
            }.start();
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return numberLists;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "LIST 1";
                case 1:
                    return "LIST 2";
                case 2:
                    return name;
            }
            return null;
        }
    }
}
