package DucThuan.duolingo.UI.activity.LessonListActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.MenuItem;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import DucThuan.duolingo.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonListActivity extends AppCompatActivity {

    @BindView(R.id.bottom_nav_lesson_list)
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        ButterKnife.bind(this);
        selectNav();
    }

    private void selectNav() {
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_lesson_list, new LessonListFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.lessonListFragment:
                            selectedFragment = new LessonListFragment();
                            break;
                        case R.id.infoFragment:
                            selectedFragment = new InfoFragment();
                            break;
                        case R.id.rankFragment:
                            selectedFragment = new RankFragment();
                            break;
                        case R.id.shopFragment:
                            selectedFragment = new ShopFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_lesson_list, selectedFragment).commit();

                    return true;
                }
            };

    @Override
    public void onBackPressed() {
        new MaterialDialog.Builder(this)
                .title("Bạn có muốn đóng ứng dụng")
                .positiveText("THOÁT")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(0);

                    }
                })
                .negativeText("HỦY")
                .show();
    }
}