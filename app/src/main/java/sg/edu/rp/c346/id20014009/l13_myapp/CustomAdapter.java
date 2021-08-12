package sg.edu.rp.c346.id20014009.l13_myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<Shoe> al;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Shoe> al) {
        super(context, resource,al);

        this.context=context;
        this.resource=resource;
        this.al=al;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(resource,parent,false);




        Shoe currentVersion=al.get(position);



        TextView tvBlue=rowView.findViewById(R.id.tvBlue);
        TextView tvGrey=rowView.findViewById(R.id.tvGrey);
        TextView tvLightBlue=rowView.findViewById(R.id.tvLightBlue);

        RatingBar rb=rowView.findViewById(R.id.ratingBar);
        ImageView iv=rowView.findViewById(R.id.imageView);

        tvBlue.setText(currentVersion.getTitle());
        tvLightBlue.setText(currentVersion.getSingers());
        tvGrey.setText(String.valueOf(currentVersion.getYearReleased()));
        rb.setRating(currentVersion.getStars());

        if(currentVersion.getYearReleased()>4){
            iv.setImageResource(R.drawable.good);
        }else{
            iv.setVisibility(View.INVISIBLE);
        }







        return rowView;


    }
}
