package com.example.popularmovies;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        ImageView poster = findViewById(R.id.poster_image);
        TextView rating = findViewById(R.id.mRating);
        TextView title = findViewById(R.id.mTitle);
        TextView description = findViewById(R.id.mDescription);


        Bundle bundle = getIntent().getExtras();


        String mTitle = Objects.requireNonNull(bundle).getString("title");
        String mPoster = bundle.getString("poster");
        String mOverview = bundle.getString("overview");
        Double mRating = bundle.getDouble("rating");

        Picasso.get().load(mPoster).into(poster);
        rating.setText(Double.toString(mRating));
        title.setText(mTitle);
        description.setText(mOverview);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}