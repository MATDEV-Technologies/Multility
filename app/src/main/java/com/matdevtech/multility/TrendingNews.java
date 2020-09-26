package com.matdevtech.multility;

// Imports
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.matdevtech.multility.api.ApiInterface;
import com.matdevtech.multility.api.ApiClient;
import com.matdevtech.multility.models.Article;
import com.matdevtech.multility.models.News;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import android.content.Intent;
//import android.net.Uri;
//import android.widget.TextView;
//import android.content.Context;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import android.content.Intent;
//import android.net.Uri;
//import android.view.Menu;
//import android.view.MenuInflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrendingNews#newInstance} factory method to
 * create an instance of this fragment.
 */
// Main class
public class TrendingNews extends Fragment {
    // Class vars and consts
    public static final String API_KEY = "102f8feadfc8432d8be96f4e4de5d43d";
    private RecyclerView recyclerView;
    @SuppressWarnings("FieldCanBeLocal")
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;
    @SuppressWarnings({"unused", "RedundantSuppression"})
    private Adapter.OnItemClickListener recyclerViewClickListener;
    @SuppressWarnings({"unused", "RedundantSuppression"})
    private String TAG = TrendingNews.class.getSimpleName();
    @SuppressWarnings({"unused", "RedundantSuppression"})
    private SwipeRefreshLayout swipeRefreshLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    @SuppressWarnings({"FieldCanBeLocal", "unused", "RedundantSuppression"})
    private String mParam1;
    @SuppressWarnings({"FieldCanBeLocal", "unused", "RedundantSuppression"})
    private String mParam2;

    public TrendingNews() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrendingNews.
     */
    // TODO: Rename and change types and number of parameters
    @SuppressWarnings({"unused", "RedundantSuppression"})
    public static TrendingNews newInstance(String param1, String param2) {
        TrendingNews fragment = new TrendingNews();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // Fragment init
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // TODO: add new titles to strings.xml
        Objects.requireNonNull(((NavigationBar) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Trending News");
    }

    // Fragment view init
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = Objects.requireNonNull(getView()).findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);

        LoadJson();
    }

    // Load JSON data from API
    public void LoadJson() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        String country = Utils.getCountry();

        Call<News> call;
        call = apiInterface.getNews(country, API_KEY);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(@NotNull Call<News> call, @NotNull Response<News> response) {
                assert response.body() != null; // DEBUG
                if (response.isSuccessful() && response.body().getArticle() != null) {
                    if (!articles.isEmpty()) {
                        articles.clear();
                    }
                    articles = response.body().getArticle();
                    adapter = new Adapter(articles, getContext());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "No Result!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<News> call, @NotNull Throwable t) {
                // pass
            }
        });
    }
}