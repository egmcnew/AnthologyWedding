package com.example.anthologywedding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] weddingPics = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
        R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9,
        R.drawable.pic10};
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.picLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext( ), "Wedding Photo " + (position + 1), Toast.LENGTH_SHORT).show( );
                pic.setImageResource(weddingPics[position]);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter {
        public Context context;
        public ImageAdapter (Context c) {
            context=c;
        }

        @Override
        public int getCount(){
            return weddingPics.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(weddingPics[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }
}
