package com.example.busappver12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListOfBusLocationsByRouteViewModelAdapter extends ArrayAdapter<BusItems> implements AdapterView.OnItemClickListener {

    private Context context;
    private ArrayList<BusItems> list;
    private BusItems bi=new BusItems();
    private int resource;
    private ListView myListView;

    public ListOfBusLocationsByRouteViewModelAdapter(Context context,int resource,ArrayList<BusItems> objects,ListView myListView){
        super(context,resource,objects);
        list=objects;
        this.context=context;
        this.resource=resource;
        this.myListView=myListView;
        this.myListView.setOnItemClickListener(this);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater linf=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView=linf.inflate(resource,null);
        bi=list.get(position);

        if(bi!=null) {
            TextView routeNm = (TextView) convertView.findViewById(R.id.routeNm);
            TextView nodeNm = (TextView) convertView.findViewById(R.id.nodeNm);
            TextView nodeId = (TextView) convertView.findViewById(R.id.nodeId);
            TextView routeTp = (TextView) convertView.findViewById(R.id.routeTp);
            TextView vehicleNo = (TextView) convertView.findViewById(R.id.vehicleNo);

            if (routeNm != null) {
                routeNm.setText("노선 번호: " + bi.getRouteNm());
            }
            if (nodeNm != null) {
                nodeNm.setText("정류소: " + bi.getNodeNm());
            }
            if (nodeId != null) {
                nodeId.setText("정류소 ID: " + bi.getNodeId());
            }
            if (routeTp != null) {
                routeTp.setText("노선 유형: " + bi.getRouteTp());
            }
            if (vehicleNo != null) {
                vehicleNo.setText("차량 번호: " + bi.getVehicleNo());
            }
        }

        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
