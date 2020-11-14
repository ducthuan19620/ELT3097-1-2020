package DucThuan.duolingo.UI.activity.SelectLanguageActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import DucThuan.duolingo.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectLanguageActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.back_button)
    ImageView backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_course);

        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

        LanguageAdapter languageAdapter = new LanguageAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RvDividerItemDecoration itemDecoration = new RvDividerItemDecoration(getDrawable(R.drawable.recycler_view_divider));

        recyclerView.setAdapter(languageAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
    }
}
