package com.halfof73.halfof73;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.halfof73.halfof73.phone.PhoneFragment;
import com.halfof73.halfof73.team.MainFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int fragmentpage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent in = new Intent();
        in.setClass(MainActivity.this,CoverActivity.class);
        startActivity(in);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initfragment();
        initDrawerLayout();


    }


    private void initDrawerLayout() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initfragment() {
        fragmentArrayList.add(new MainFragment());
        fragmentArrayList.add(new PhoneFragment());
        fragmentArrayList.add(new PhoneFragment());
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content, fragmentArrayList.get(fragmentpage));
        fragmentTransaction.commit();
    }
    public void changefragement(int page){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragmentArrayList.get(page));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(fragmentArrayList.get(fragmentpage));
        if (id == R.id.menu_news) {
            fragmentpage=0;
        } else if (id == R.id.menu_supply) {
            fragmentpage=1;
        } else if (id == R.id.menu_donation) {
            fragmentpage=0;
        } else if (id == R.id.menu_volunteer) {
            fragmentpage=0;
        } else if (id == R.id.menu_charityAuction) {
            fragmentpage=0;
        }
        if(fragmentArrayList.get(fragmentpage).isAdded()) {
            fragmentTransaction.show(fragmentArrayList.get(fragmentpage));
        }else{
            fragmentTransaction.add(R.id.content, fragmentArrayList.get(fragmentpage));
        }
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialogFragment alertFragment = new AlertDialogFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            alertFragment.show(fragmentManager, "alert");
        }
    }

    public static class AlertDialogFragment
            extends DialogFragment implements DialogInterface.OnClickListener {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new android.app.AlertDialog.Builder(getActivity())
                    .setTitle(R.string.title)
                    .setIcon(R.drawable.alert)
                    .setMessage(R.string.msg_Alert)
                    .setPositiveButton(R.string.text_btYes, this)
                    .setNegativeButton(R.string.text_btNo, this)
                    .create();
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    getActivity().finish();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    dialog.cancel();
                    break;
                default:
                    break;
            }
        }
    }
}
