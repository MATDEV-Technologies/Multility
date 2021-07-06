package com.matdevtech.multility;

// Imports
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.matdevtech.multility.models.Article;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

// Main Class
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    // Class vars
    private List<Article> articles;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public Adapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view, onItemClickListener);
    }

    @SuppressLint({"CheckResult", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
        final MyViewHolder holder = holders;
        Article model = articles.get(position);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(new ColorDrawable(Color.parseColor("#30d179")));
        requestOptions.error(new ColorDrawable(Color.parseColor("#30d179")));
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();

        Glide.with(context)
                .load(model.getUrlToImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE); // If load failed, set progress bar to invisible
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE); // If load failed, set progress bar to invisible
                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.imageView);

        holder.title.setText(model.getTitle());
        holder.author.setText(model.getAuthor());
        holder.desc.setText(model.getDescription());
        holder.source.setText(model.getSource().getName());
        holder.author.setText(model.getAuthor());
    }

    @Override
    public int getItemCount() { return articles.size(); }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, desc, author, published_at, source;
        ImageView imageView;
        ProgressBar progressBar;
        OnItemClickListener onItemClickListener;

        @SuppressLint("CutPasteId")
        public MyViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);

            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            author = itemView.findViewById(R.id.author);
            published_at = itemView.findViewById(R.id.publishedAt);
            source = itemView.findViewById(R.id.source);
            imageView = itemView.findViewById(R.id.img);
            progressBar = itemView.findViewById(R.id.progress_load_photo);

            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            Article article = articles.get(getAdapterPosition());
            String articleURL = article.getUrl();

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(articleURL));
            context.startActivity(intent);
        }
    }
}