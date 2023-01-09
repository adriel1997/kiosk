package com.example.adriealle.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {



    Button amenities,amenities1,amenities2,dining,dining1,dining2,amenities5,amenities6,amenities7,
            amenities8,amenities9,amenities10,dining3,search_category,category1,category2,category3,category4,category5,
            category6,category7,category8,category9,category10,category11,category13,home,floor1,floor2,floor,search_name,administrator,info,events;

    ImageView arrow1,arrow2,arrow7,arrow4;
    TextView result;
    Fragment fragmenttttt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/


       /* final View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/



        /*requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar*/


        setContentView(R.layout.activity_main);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        home=findViewById(R.id.Imageview_home);


        amenities=findViewById(R.id.amenities);
        amenities1=findViewById(R.id.amenities1);
        amenities2=findViewById(R.id.amenities2);

        amenities5=findViewById(R.id.amenities5);
        amenities6=findViewById(R.id.amenities6);
        amenities7=findViewById(R.id.amenities7);
        amenities8=findViewById(R.id.amenities8);
        amenities9=findViewById(R.id.amenities9);
        amenities10=findViewById(R.id.amenities10);


        dining=findViewById(R.id.dining);
        dining1=findViewById(R.id.dining1);
        dining2=findViewById(R.id.dining2);
        dining3=findViewById(R.id.dining3);


        search_category=findViewById(R.id.search_category);
        category1=findViewById(R.id.category1);
        category2=findViewById(R.id.category2);
        category3=findViewById(R.id.category3);
        category4=findViewById(R.id.category4);
        category5=findViewById(R.id.category5);
        category6=findViewById(R.id.category6);
        category7=findViewById(R.id.category7);
        category8=findViewById(R.id.category8);
        category9=findViewById(R.id.category9);
        category10=findViewById(R.id.category10);
        category11=findViewById(R.id.category11);

        category13=findViewById(R.id.category13);

        floor=findViewById(R.id.floors);
        floor1=findViewById(R.id.floor1);
        floor2=findViewById(R.id.floor2);




        arrow1=findViewById(R.id.arrow1);
        arrow2=findViewById(R.id.arrow2);
        arrow4=findViewById(R.id.arrow4);
        arrow7=findViewById(R.id.arrow7);

        search_name=findViewById(R.id.search_name);

        administrator=findViewById(R.id.admin);


        info=findViewById(R.id.info);
        events=findViewById(R.id.events);

        final LinearLayout amenities_layout=findViewById(R.id.amenities_layout);
        final LinearLayout dining_layout=findViewById(R.id.dining_layout);
        final LinearLayout search_by_category=findViewById(R.id.search_by_category);
        final LinearLayout text=findViewById(R.id.text);
        final LinearLayout image=findViewById(R.id.image);
        final LinearLayout floors_layout=findViewById(R.id.floors_category);
        final LinearLayout original=findViewById(R.id.original_fragment);









        final Animation showButton= AnimationUtils.loadAnimation(MainActivity.this,R.anim.show_button);
        final Animation hideButton= AnimationUtils.loadAnimation(MainActivity.this,R.anim.hide_button);
        final Animation showLayout= AnimationUtils.loadAnimation(MainActivity.this,R.anim.show_layout);
        final Animation hideLayout= AnimationUtils.loadAnimation(MainActivity.this,R.anim.hide_layout);



        amenities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);
*/
                if((dining_layout.getVisibility()==View.VISIBLE && arrow2.getVisibility()==View.VISIBLE) ||
                        (search_by_category.getVisibility()==View.VISIBLE && arrow7.getVisibility()==View.VISIBLE) ||
                        (floors_layout.getVisibility() == View.VISIBLE && arrow4.getVisibility()==View.VISIBLE)) {


                    dining1.setVisibility(View.GONE);
                    dining2.setVisibility(View.GONE);
                    dining3.setVisibility(View.GONE);
                    category1.setVisibility(View.GONE);
                    category2.setVisibility(View.GONE);
                    category3.setVisibility(View.GONE);
                    category4.setVisibility(View.GONE);
                    category5.setVisibility(View.GONE);
                    category6.setVisibility(View.GONE);
                    category7.setVisibility(View.GONE);
                    category8.setVisibility(View.GONE);
                    category9.setVisibility(View.GONE);
                    category10.setVisibility(View.GONE);
                    category11.setVisibility(View.GONE);

                    category13.setVisibility(View.GONE);
                    floor1.setVisibility(View.GONE);
                    floor2.setVisibility(View.GONE);
                    arrow4.setVisibility(View.GONE);
                    arrow7.setVisibility(View.GONE);
                    arrow2.setVisibility(View.GONE);


                }
                if (amenities_layout.getVisibility() == View.VISIBLE && arrow1.getVisibility()==View.VISIBLE) {

                    amenities1.setVisibility(View.GONE);
                    amenities2.setVisibility(View.GONE);

                    amenities5.setVisibility(View.GONE);
                    amenities6.setVisibility(View.GONE);
                    amenities7.setVisibility(View.GONE);
                    amenities8.setVisibility(View.GONE);
                    amenities9.setVisibility(View.GONE);
                    amenities10.setVisibility(View.GONE);

                    arrow1.setVisibility(View.GONE);


                    amenities_layout.startAnimation(hideLayout);
                    arrow1.startAnimation(hideButton);

                }

                else {

                    amenities1.setVisibility(View.VISIBLE);
                    amenities2.setVisibility(View.VISIBLE);

                    amenities5.setVisibility(View.VISIBLE);
                    amenities6.setVisibility(View.VISIBLE);
                    amenities7.setVisibility(View.VISIBLE);
                    amenities8.setVisibility(View.VISIBLE);
                    amenities9.setVisibility(View.VISIBLE);
                    amenities10.setVisibility(View.VISIBLE);

                    arrow1.setVisibility(View.VISIBLE);


                    amenities_layout.startAnimation(showLayout);
                    arrow1.startAnimation(showButton);


                }

            }
        });






        dining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((amenities_layout.getVisibility()==View.VISIBLE && arrow1.getVisibility()==View.VISIBLE)||
                        (search_by_category.getVisibility()==View.VISIBLE && arrow7.getVisibility()==View.VISIBLE) ||
                        (floors_layout.getVisibility() == View.VISIBLE && arrow4.getVisibility()==View.VISIBLE)) {


                    amenities1.setVisibility(View.GONE);
                    amenities2.setVisibility(View.GONE);

                    amenities5.setVisibility(View.GONE);
                    amenities6.setVisibility(View.GONE);
                    amenities7.setVisibility(View.GONE);
                    amenities8.setVisibility(View.GONE);
                    amenities9.setVisibility(View.GONE);
                    amenities10.setVisibility(View.GONE);
                    category1.setVisibility(View.GONE);
                    category2.setVisibility(View.GONE);
                    category3.setVisibility(View.GONE);
                    category4.setVisibility(View.GONE);
                    category5.setVisibility(View.GONE);
                    category6.setVisibility(View.GONE);
                    category7.setVisibility(View.GONE);
                    category8.setVisibility(View.GONE);
                    category9.setVisibility(View.GONE);
                    category10.setVisibility(View.GONE);
                    category11.setVisibility(View.GONE);

                    category13.setVisibility(View.GONE);
                    floor1.setVisibility(View.GONE);
                    floor2.setVisibility(View.GONE);
                    arrow4.setVisibility(View.GONE);
                    arrow7.setVisibility(View.GONE);
                    arrow1.setVisibility(View.GONE);



                }
                if (dining_layout.getVisibility() == View.VISIBLE && arrow2.getVisibility()==View.VISIBLE) {

                    dining1.setVisibility(View.GONE);
                    dining2.setVisibility(View.GONE);
                    dining3.setVisibility(View.GONE);
                    arrow2.setVisibility(View.GONE);

                    dining_layout.startAnimation(hideLayout);
                    arrow2.startAnimation(hideButton);



                }

                else  {

                    dining1.setVisibility(View.VISIBLE);
                    dining2.setVisibility(View.VISIBLE);
                    dining3.setVisibility(View.VISIBLE);

                    arrow2.setVisibility(View.VISIBLE);

                    dining_layout.startAnimation(showLayout);
                    arrow2.startAnimation(showButton);


                }


            }
        });






        floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((amenities_layout.getVisibility()==View.VISIBLE && arrow1.getVisibility()==View.VISIBLE) ||
                        (dining_layout.getVisibility()==View.VISIBLE && arrow2.getVisibility()==View.VISIBLE) || (search_by_category.getVisibility()==View.VISIBLE && arrow7.getVisibility()==View.VISIBLE)) {


                    amenities1.setVisibility(View.GONE);
                    amenities2.setVisibility(View.GONE);

                    amenities5.setVisibility(View.GONE);
                    amenities6.setVisibility(View.GONE);
                    amenities7.setVisibility(View.GONE);
                    amenities8.setVisibility(View.GONE);
                    amenities9.setVisibility(View.GONE);
                    amenities10.setVisibility(View.GONE);
                    dining1.setVisibility(View.GONE);
                    dining2.setVisibility(View.GONE);
                    dining3.setVisibility(View.GONE);
                    category1.setVisibility(View.GONE);
                    category2.setVisibility(View.GONE);
                    category3.setVisibility(View.GONE);
                    category4.setVisibility(View.GONE);
                    category5.setVisibility(View.GONE);
                    category6.setVisibility(View.GONE);
                    category7.setVisibility(View.GONE);
                    category8.setVisibility(View.GONE);
                    category9.setVisibility(View.GONE);
                    category10.setVisibility(View.GONE);
                    category11.setVisibility(View.GONE);

                    category13.setVisibility(View.GONE);
                    arrow1.setVisibility(View.GONE);
                    arrow2.setVisibility(View.GONE);
                    arrow7.setVisibility(View.GONE);
                }

                if (floors_layout.getVisibility() == View.VISIBLE && arrow4.getVisibility()==View.VISIBLE) {

                    floor1.setVisibility(View.GONE);
                    floor2.setVisibility(View.GONE);
                    arrow4.setVisibility(View.GONE);

                    floors_layout.startAnimation(hideLayout);
                    arrow4.startAnimation(hideButton);


                }

                else {

                    floor1.setVisibility(View.VISIBLE);
                    floor2.setVisibility(View.VISIBLE);
                    arrow4.setVisibility(View.VISIBLE);

                    floors_layout.startAnimation(showLayout);
                    arrow4.startAnimation(showButton);

                }

            }
        });






        search_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((amenities_layout.getVisibility()==View.VISIBLE && arrow1.getVisibility()==View.VISIBLE) ||
                        (dining_layout.getVisibility()==View.VISIBLE && arrow2.getVisibility()==View.VISIBLE) || (floors_layout.getVisibility() == View.VISIBLE && arrow4.getVisibility()==View.VISIBLE)) {


                    amenities1.setVisibility(View.GONE);
                    amenities2.setVisibility(View.GONE);

                    amenities5.setVisibility(View.GONE);
                    amenities6.setVisibility(View.GONE);
                    amenities7.setVisibility(View.GONE);
                    amenities8.setVisibility(View.GONE);
                    amenities9.setVisibility(View.GONE);
                    amenities10.setVisibility(View.GONE);
                    dining1.setVisibility(View.GONE);
                    dining2.setVisibility(View.GONE);
                    dining3.setVisibility(View.GONE);
                    floor1.setVisibility(View.GONE);
                    floor2.setVisibility(View.GONE);
                    arrow4.setVisibility(View.GONE);
                    arrow1.setVisibility(View.GONE);
                    arrow2.setVisibility(View.GONE);


                }
                if (search_by_category.getVisibility() == View.VISIBLE && arrow7.getVisibility()==View.VISIBLE) {

                    category1.setVisibility(View.GONE);
                    category2.setVisibility(View.GONE);
                    category3.setVisibility(View.GONE);
                    category4.setVisibility(View.GONE);
                    category5.setVisibility(View.GONE);
                    category6.setVisibility(View.GONE);
                    category7.setVisibility(View.GONE);
                    category8.setVisibility(View.GONE);
                    category9.setVisibility(View.GONE);
                    category10.setVisibility(View.GONE);
                    category11.setVisibility(View.GONE);

                    category13.setVisibility(View.GONE);
                    arrow7.setVisibility(View.GONE);

                    search_by_category.startAnimation(hideLayout);
                    arrow7.startAnimation(hideButton);



                }

                else  {

                    category1.setVisibility(View.VISIBLE);
                    category2.setVisibility(View.VISIBLE);
                    category3.setVisibility(View.VISIBLE);
                    category4.setVisibility(View.VISIBLE);
                    category5.setVisibility(View.VISIBLE);
                    category6.setVisibility(View.VISIBLE);
                    category7.setVisibility(View.VISIBLE);
                    category8.setVisibility(View.VISIBLE);
                    category9.setVisibility(View.VISIBLE);
                    category10.setVisibility(View.VISIBLE);
                    category11.setVisibility(View.VISIBLE);

                    category13.setVisibility(View.VISIBLE);

                    arrow7.setVisibility(View.VISIBLE);

                    search_by_category.startAnimation(showLayout);
                    arrow7.startAnimation(showButton);


                }

            }
        });








        amenities1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("medical"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        amenities2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);




                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);




                fragmentTransaction.replace(R.id.change,createCustom("kids"));

                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();



            }
        });


        amenities5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("courier"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        amenities6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("atm"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        amenities7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);

                fragmentTransaction.replace(R.id.change,createCustom("info"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        amenities8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("kidsplay"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        amenities9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("pharmacy"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        amenities10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("valet"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        dining1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("cafe"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        dining2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("foodcourt"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        dining3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("restraunt"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("automobile"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("beauty"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("books"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("electronic"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        category5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("entertainment"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        category6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("eyewear"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        category7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("foodcourt"));  //combine list in next fragment
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        category8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("footwear"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        category9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("home furnishing"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        category10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("hypermarket"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        category11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("jewellery"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


        category13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentManager fragmentManager=getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);



                fragmentTransaction.replace(R.id.change,createCustom("luggage"));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });








        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*


                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                final FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
                final FragmentTransaction fragmentTransaction6=getSupportFragmentManager().beginTransaction();
                final FragmentTransaction fragmentTransaction7=getSupportFragmentManager().beginTransaction();

                fragmentTransaction1.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);

                fragmentTransaction6.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);






                fragmentTransaction6.replace(R.id.map0_fragment,new original_fragment());
               */
/*fragmentTransaction1.replace(R.id.map0_fragment,new original_fragment());
               fragmentTransaction1.replace(R.id.map1_fragment,new original_fragment());*//*


                fragmentTransaction6.addToBackStack(null);

                fragmentTransaction6.commit();

                fragmentTransaction1.replace(R.id.fragment1,new original_fragment());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();

*/


                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);
                final FragmentTransaction fragmentTransaction2=getSupportFragmentManager().beginTransaction();

                fragmentTransaction2.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);

                fragmentTransaction2.replace(R.id.change,new original_fragment());
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();





            }
        });


        floor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);
                final FragmentTransaction fragmentTransaction2=getSupportFragmentManager().beginTransaction();

                fragmentTransaction2.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);

                fragmentTransaction2.replace(R.id.change,new map0_fragment());
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();


            }
        });


        floor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                text.setVisibility(View.GONE);
                image.setVisibility(View.GONE);
                final FragmentTransaction fragmentTransaction3=getSupportFragmentManager().beginTransaction();

                fragmentTransaction3.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);

                fragmentTransaction3.replace(R.id.change,new map1_fragment());
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();


            }
        });




        search_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((amenities_layout.getVisibility()==View.VISIBLE && arrow1.getVisibility()==View.VISIBLE) ||
                        (dining_layout.getVisibility()==View.VISIBLE && arrow2.getVisibility()==View.VISIBLE) || (floors_layout.getVisibility() == View.VISIBLE && arrow4.getVisibility()==View.VISIBLE) || (search_by_category.getVisibility()==View.VISIBLE && arrow7.getVisibility()==View.VISIBLE)) {


                    amenities1.setVisibility(View.GONE);
                    amenities2.setVisibility(View.GONE);

                    amenities5.setVisibility(View.GONE);
                    amenities6.setVisibility(View.GONE);
                    amenities7.setVisibility(View.GONE);
                    amenities8.setVisibility(View.GONE);
                    amenities9.setVisibility(View.GONE);
                    amenities10.setVisibility(View.GONE);
                    dining1.setVisibility(View.GONE);
                    dining2.setVisibility(View.GONE);
                    dining3.setVisibility(View.GONE);
                    floor1.setVisibility(View.GONE);
                    floor2.setVisibility(View.GONE);
                    category1.setVisibility(View.GONE);
                    category2.setVisibility(View.GONE);
                    category3.setVisibility(View.GONE);
                    category4.setVisibility(View.GONE);
                    category5.setVisibility(View.GONE);
                    category6.setVisibility(View.GONE);
                    category7.setVisibility(View.GONE);
                    category8.setVisibility(View.GONE);
                    category9.setVisibility(View.GONE);
                    category10.setVisibility(View.GONE);
                    category11.setVisibility(View.GONE);

                    category13.setVisibility(View.GONE);
                    arrow1.setVisibility(View.GONE);
                    arrow2.setVisibility(View.GONE);
                    arrow7.setVisibility(View.GONE);
                    arrow4.setVisibility(View.GONE);

                    text.setVisibility(View.GONE);
                    image.setVisibility(View.GONE);
                    final FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_from_right, R.anim.enter_from_right, R.anim.exit_from_right);
                    fragmentTransaction4.replace(R.id.change, new search_fragment());
                    fragmentTransaction4.addToBackStack(null);
                    fragmentTransaction4.commit();

                }



            }
        });

        administrator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent admins=new Intent(MainActivity.this, adminlogin.class);
                startActivity(admins);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if((amenities_layout.getVisibility()==View.VISIBLE && arrow1.getVisibility()==View.VISIBLE) ||
                        (dining_layout.getVisibility()==View.VISIBLE && arrow2.getVisibility()==View.VISIBLE) || (floors_layout.getVisibility() == View.VISIBLE && arrow4.getVisibility()==View.VISIBLE) || (search_by_category.getVisibility()==View.VISIBLE && arrow7.getVisibility()==View.VISIBLE)) {


                    amenities1.setVisibility(View.GONE);
                    amenities2.setVisibility(View.GONE);

                    amenities5.setVisibility(View.GONE);
                    amenities6.setVisibility(View.GONE);
                    amenities7.setVisibility(View.GONE);
                    amenities8.setVisibility(View.GONE);
                    amenities9.setVisibility(View.GONE);
                    amenities10.setVisibility(View.GONE);
                    dining1.setVisibility(View.GONE);
                    dining2.setVisibility(View.GONE);
                    dining3.setVisibility(View.GONE);
                    floor1.setVisibility(View.GONE);
                    floor2.setVisibility(View.GONE);
                    category1.setVisibility(View.GONE);
                    category2.setVisibility(View.GONE);
                    category3.setVisibility(View.GONE);
                    category4.setVisibility(View.GONE);
                    category5.setVisibility(View.GONE);
                    category6.setVisibility(View.GONE);
                    category7.setVisibility(View.GONE);
                    category8.setVisibility(View.GONE);
                    category9.setVisibility(View.GONE);
                    category10.setVisibility(View.GONE);
                    category11.setVisibility(View.GONE);

                    category13.setVisibility(View.GONE);
                    arrow1.setVisibility(View.GONE);
                    arrow2.setVisibility(View.GONE);
                    arrow7.setVisibility(View.GONE);
                    arrow4.setVisibility(View.GONE);

                    text.setVisibility(View.GONE);
                    image.setVisibility(View.GONE);
                    final FragmentTransaction fragmentTransaction4=getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right, R.anim.enter_from_right,R.anim.exit_from_right);
                    fragmentTransaction4.replace(R.id.change,new info_fragment());
                    fragmentTransaction4.addToBackStack(null);
                    fragmentTransaction4.commit();



                }



            }
        });



        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((amenities_layout.getVisibility()==View.VISIBLE && arrow1.getVisibility()==View.VISIBLE) ||
                        (dining_layout.getVisibility()==View.VISIBLE && arrow2.getVisibility()==View.VISIBLE) || (floors_layout.getVisibility() == View.VISIBLE && arrow4.getVisibility()==View.VISIBLE) || (search_by_category.getVisibility()==View.VISIBLE && arrow7.getVisibility()==View.VISIBLE)) {


                    amenities1.setVisibility(View.GONE);
                    amenities2.setVisibility(View.GONE);

                    amenities5.setVisibility(View.GONE);
                    amenities6.setVisibility(View.GONE);
                    amenities7.setVisibility(View.GONE);
                    amenities8.setVisibility(View.GONE);
                    amenities9.setVisibility(View.GONE);
                    amenities10.setVisibility(View.GONE);
                    dining1.setVisibility(View.GONE);
                    dining2.setVisibility(View.GONE);
                    dining3.setVisibility(View.GONE);
                    floor1.setVisibility(View.GONE);
                    floor2.setVisibility(View.GONE);
                    category1.setVisibility(View.GONE);
                    category2.setVisibility(View.GONE);
                    category3.setVisibility(View.GONE);
                    category4.setVisibility(View.GONE);
                    category5.setVisibility(View.GONE);
                    category6.setVisibility(View.GONE);
                    category7.setVisibility(View.GONE);
                    category8.setVisibility(View.GONE);
                    category9.setVisibility(View.GONE);
                    category10.setVisibility(View.GONE);
                    category11.setVisibility(View.GONE);

                    category13.setVisibility(View.GONE);
                    arrow1.setVisibility(View.GONE);
                    arrow2.setVisibility(View.GONE);
                    arrow7.setVisibility(View.GONE);
                    arrow4.setVisibility(View.GONE);

                    text.setVisibility(View.GONE);
                    image.setVisibility(View.GONE);


                    final FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_from_right, R.anim.enter_from_right, R.anim.exit_from_right);
                    fragmentTransaction4.replace(R.id.change, new info_fragment());
                    fragmentTransaction4.addToBackStack(null);
                    fragmentTransaction4.commit();
                }
            }
        });





    }

    private Fragment createCustom(String cat ) {

       /* final View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
*/
        fragmenttttt=new fragment1();
        Bundle bundle=new Bundle();
        bundle.putString("data",cat);
        fragmenttttt.setArguments(bundle);
        return fragmenttttt;
    }


}


