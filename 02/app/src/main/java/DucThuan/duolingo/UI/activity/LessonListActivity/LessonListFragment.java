package DucThuan.duolingo.UI.activity.LessonListActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.io.File;

import DucThuan.duolingo.R;
import DucThuan.duolingo.UI.activity.WelcomeActivity;
import DucThuan.duolingo.UI.tasks.MutipleChoice;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LessonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LessonListFragment extends Fragment {

    Button basic1;
    Button buttonClose;
    private String FILE_NAME = "signin";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LessonListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LessonListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LessonListFragment newInstance(String param1, String param2) {
        LessonListFragment fragment = new LessonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_lesson_list, container, false);

        basic1 = v.findViewById(R.id.basic1);
        basic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MutipleChoice.class));
            }
        });

        buttonClose = v.findViewById(R.id.button_close);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(getActivity())
                        .title("Bạn có muốn đăng xuất")
                        .positiveText("ĐĂNG XUẤT")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                File file = new File(getContext().getFilesDir(), FILE_NAME);
                                getContext().deleteFile(FILE_NAME);

                                startActivity(new Intent(getActivity(), WelcomeActivity.class));
                            }
                        })
                        .negativeText("HỦY")
                        .show();
            }
        });

        return v;
    }
}