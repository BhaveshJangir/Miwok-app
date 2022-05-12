package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<words> {

    int mResourceId;

    public WordAdapter(@NonNull Context context, int resource, @NonNull List<words> objects,int mResourceId) {
        super(context, resource, objects);
        this.mResourceId = mResourceId;
    }

    public WordAdapter(FamilyActivity context, ArrayList<words> word,int mResourceId) {
        super(context,0,word);
        this.mResourceId = mResourceId;
    }
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(ColorsActivity colorsActivity, ArrayList<words> word,int mResourceId) {
        super(colorsActivity,0,word);
        this.mResourceId = mResourceId;
    }

    public WordAdapter(Numbers numbers, ArrayList<words> word,int mResourceId) {
        super(numbers,0,word);
        this.mResourceId = mResourceId;
    }

    public WordAdapter(PhraseActivity phraseActivity, ArrayList<words> word,int mResourceId) {
        super(phraseActivity,0,word);
        this.mResourceId = mResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        words currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView mewokTranslation = (TextView) listItemView.findViewById(R.id.defalt_mewok_lang);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        mewokTranslation.setText(currentWord.getMiwokTranslation());

        // Find the TextgetView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.defalt_english_lang);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getDefaltTraslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
         ImageView iconView = (ImageView) listItemView.findViewById(R.id.icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if(currentWord.hasImage()){
            iconView.setImageResource(currentWord.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        }
        else{
            iconView.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
