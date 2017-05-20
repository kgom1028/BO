package com.kgom.binaryoptions.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.models.MessageModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by KJS on 9/3/2016.
 */
public class NotificationAdapter extends BaseAdapter {
    private Context mContext;
    private List<MessageModel> mNotifications;

    public NotificationAdapter(Context context, List<MessageModel> notifications)
    {
        mContext = context;
        mNotifications = notifications ;

    }

    public void setEvents(List<MessageModel> notifications) {
        mNotifications = notifications;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mNotifications != null) {
            return mNotifications.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mNotifications != null) {
            return mNotifications.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (mNotifications != null)
        {
            long id = (long)mNotifications.get(position).mId;
            return id;
        }else
            return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_notification, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.txtContent = (TextView) view.findViewById(R.id.content);
            viewHolder.txtTime = (TextView) view.findViewById(R.id.time);
            viewHolder.container = (View) view.findViewById(R.id.container_view);
            view.setTag(viewHolder);
        }
        MessageModel model = (MessageModel) getItem(position);

        ViewHolder vwHolder = (ViewHolder)view.getTag();
        vwHolder.txtContent.setText(model.mContent);
        SimpleDateFormat sdf = new SimpleDateFormat( mContext.getString(R.string.notification_time_format));
        Date resultdate = new Date(model.mTime);
        vwHolder.txtTime.setText(sdf.format(resultdate));
        if(position % 2 == 0)
          vwHolder.container.setBackgroundColor(mContext.getResources().getColor(R.color.list_item_color_1));
        else
           vwHolder.container.setBackgroundColor(mContext.getResources().getColor(R.color.list_item_color_2));
        return view;
    }
    class ViewHolder{
        TextView txtContent;
        TextView txtTime;
        View container;
    }
}
