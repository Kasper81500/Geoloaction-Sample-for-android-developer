package pf.paranoidfan.com.paranoidfan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import pf.paranoidfan.com.paranoidfan.Helper.MapPinControl;

public class EmoticonsGridAdapter extends BaseAdapter{

    private ArrayList<String> paths;
    private int pageNumber;
    Context mContext;

    KeyClickListener mListener;

    public EmoticonsGridAdapter(Context context, ArrayList<String> paths, int pageNumber, KeyClickListener listener) {
        this.mContext = context;
        this.paths = paths;
        this.pageNumber = pageNumber;
        this.mListener = listener;
    }
    public View getView(int position, View convertView, ViewGroup parent){

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.emoticons_item, null);
        }

        final String path = paths.get(position);

        ImageView image = (ImageView) v.findViewById(R.id.item);
        image.setImageBitmap(getImage(path));

        image.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mListener.keyClickedIndex(path);
            }
        });

        return v;
    }

    @Override
    public int getCount() {
        return paths.size();
    }

    @Override
    public String getItem(int position) {
        return paths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getPageNumber () {
        return pageNumber;
    }

    private Bitmap getImage (String path) {
        Drawable drawable = MapPinControl.getStickImageFromResource(path, mContext);
        Bitmap temp = ((BitmapDrawable) drawable).getBitmap();
        return temp;
    }

    public interface KeyClickListener {

        public void keyClickedIndex(String index);
    }
}
