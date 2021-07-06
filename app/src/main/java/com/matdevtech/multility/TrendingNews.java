package com.matdevtech.multility;

// Imports
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import java.util.Locale;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Main class
public class TrendingNews extends Fragment {
    // Class vars and consts
    public static final String API_KEY = System.getenv("MULTILITY_NEWS_API_KEY");
    private RecyclerView recyclerView;
    @SuppressWarnings("FieldCanBeLocal")
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;

    public TrendingNews() {
        // Required empty public constructor
    }

    // Fragment init
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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

        // Gets the country by the user's locale
        String country = Locale.getDefault().getCountry();

        Call<News> call = apiInterface.getNews(country.toLowerCase(), API_KEY);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(@NotNull Call<News> call, @NotNull Response<News> response) {
                if (response.isSuccessful() && Objects.requireNonNull(response.body()).getArticles() != null) {
                    if (!articles.isEmpty()) {
                        articles.clear();
                    }
                    articles = response.body().getArticles();
                    adapter = new Adapter(articles, getContext());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "No Result!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<News> call, @NotNull Throwable t) {
                Toast.makeText(getContext(), "No Result!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}