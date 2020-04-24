package com.example.neverendingstory.ui;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.neverendingstory.R;
import com.example.neverendingstory.ui.home.HomeFragmentDirections;
import com.example.neverendingstory.ui.newf.NewFragment;
import com.example.neverendingstory.ui.newf.NewFragmentDirections;
import com.example.neverendingstory.ui.top.TopFragmentDirections;

public class FragmentButtonController {

    int navId;
    View root;
    Button home;
    Button top;
    Button newb;
    public FragmentButtonController(View v, int navId) {
        root = v;
        this.navId = navId;
        home = (Button) root.findViewById(R.id.text_home);
        top = (Button) root.findViewById(R.id.text_top);
        newb = (Button) root.findViewById(R.id.text_new);
    }
    public void ButtonControl() {
        // navId별로 네비게이션 전환 구현하기

        switch(navId) {
            case R.id.nav_home : {
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavDirections action = HomeFragmentDirections.actionNavHomeToNavTop();
                        Log.i("nav_home", Navigation.findNavController(v).getCurrentDestination().toString());
                        if (Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_home) {
                            Navigation.findNavController(v).navigate(action);
                        }

                    }
                });

                newb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavDirections action = HomeFragmentDirections.actionNavHomeToNavNew();
                        Log.i("nav_home", Navigation.findNavController(v).getCurrentDestination().toString());
                        if (Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_home) {
                            Navigation.findNavController(v).navigate(action);
                        }
                    }
                });
                break;
            }
            case R.id.nav_top : {
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavDirections action = TopFragmentDirections.actionNavTopToNavHome();
                        Log.i("nav_top", Navigation.findNavController(v).getCurrentDestination().toString());
                        if( Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_top) {
                            Navigation.findNavController(v).navigate(action);
                            Log.i("nav_top", Navigation.findNavController(v).getCurrentDestination().toString());
                        }

                    }
                });

                newb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        NavDirections action = TopFragmentDirections.actionNavTopToNavNew();
                        Log.i("nav_top", Navigation.findNavController(v).getCurrentDestination().toString());
                        if( Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_top) {
                            Navigation.findNavController(v).navigate(action);
                        }
                    }
                });
                break;
            }
            case R.id.nav_new : {
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavDirections action = NewFragmentDirections.actionNavNewToNavTop();
                        Log.i("nav_new", Navigation.findNavController(v).getCurrentDestination().toString());
                        if( Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_new) {
                            Navigation.findNavController(v).navigate(action);
                        }

                    }
                });

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavDirections action = NewFragmentDirections.actionNavNewToNavHome();
                        Log.i("nav_new", Navigation.findNavController(v).getCurrentDestination().toString());
                        if( Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_new) {
                            Navigation.findNavController(v).navigate(action);
                        }
                    }
                });
            }
            break;
        }


/*
        switch(navId) {
            case R.id.nav_home : {
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavDirections actionTop = TopFragmentDirections.actionNavTopToNavHome();
                        NavDirections actionNew = NewFragmentDirections.actionNavNewToNavHome();
                        Log.i("nav_top", Navigation.findNavController(v).getCurrentDestination().toString());
                        if( Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_top) {
                            Navigation.findNavController(v).navigate(actionTop);
                            Log.i("nav_top", Navigation.findNavController(v).getCurrentDestination().toString());
                        } else if(Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_new) {
                            Navigation.findNavController(v).navigate(actionNew);
                        }

                    }
                });

                break;
            }
            case R.id.nav_top : {
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavDirections actionHome = HomeFragmentDirections.actionNavHomeToNavTop();
                        NavDirections actionNew = NewFragmentDirections.actionNavNewToNavTop();
                        Log.i("nav_home", Navigation.findNavController(v).getCurrentDestination().toString());
                        if (Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_home) {
                            Navigation.findNavController(v).navigate(actionHome);
                        } else if (Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_new) {
                            Navigation.findNavController(v).navigate(actionNew);
                        }

                    }
                });

            }
            case R.id.nav_new : {
                newb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavDirections actionHome = HomeFragmentDirections.actionNavHomeToNavNew();
                        NavDirections actionTop = TopFragmentDirections.actionNavTopToNavNew();
                        Log.i("nav_home", Navigation.findNavController(v).getCurrentDestination().toString());
                        if (Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_home) {
                            Navigation.findNavController(v).navigate(actionHome);
                        } else if (Navigation.findNavController(v).getCurrentDestination().getId() == R.id.nav_top)
                            Navigation.findNavController(v).navigate(actionTop);
                    }
                });
            }
        }

 */
    }
}
