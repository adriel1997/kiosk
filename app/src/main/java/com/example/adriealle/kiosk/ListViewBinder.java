package com.example.adriealle.kiosk;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListViewBinder implements SimpleCursorAdapter.ViewBinder{
    @Override
    public boolean setViewValue(View view, Cursor cursor, int i) {

    int viewId=view.getId();
    switch (viewId)
    {
        case R.id.name:
            TextView text =(TextView) view;
        text.setText(cursor.getString(cursor.getColumnIndex("name")));
break;
            case R.id.img:
                ImageView imge =(ImageView) view;
                byte[] imagesbytes= cursor.getBlob(cursor.getColumnIndex("img"));

if (imagesbytes!=null) {
    imge.setImageBitmap(BitmapFactory.decodeByteArray(imagesbytes, 0, imagesbytes.length));
}
else{


}
    break;
    }
        return true;
    }
}
