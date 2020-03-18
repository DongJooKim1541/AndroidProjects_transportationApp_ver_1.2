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

public class RouteNumberListSearchViewModelAdapter extends ArrayAdapter<BusItems>implements AdapterView.OnItemClickListener{

    private Context context;
    private ArrayList<BusItems> list;
    private BusItems bi;
    private int resource;
    private ListView myListView;


    public RouteNumberListSearchViewModelAdapter(Context context,int resource,ArrayList<BusItems> objects,ListView myListView){
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
            TextView cityCode=(TextView) convertView.findViewById(R.id.cityCode);
            TextView routeId = (TextView) convertView.findViewById(R.id.routeId);
            TextView routeNo = (TextView) convertView.findViewById(R.id.routeNo);
            TextView routeTp = (TextView) convertView.findViewById(R.id.routeTp);
            TextView endNodeNm = (TextView) convertView.findViewById(R.id.endNodeNm);
            TextView startNodeNm = (TextView) convertView.findViewById(R.id.startNodeNm);
            TextView endVehicleTime = (TextView) convertView.findViewById(R.id.endVecicleTime);
            TextView startVehicleTime = (TextView) convertView.findViewById(R.id.startVecicleTime);

            if (cityCode != null) {
                cityCode.setText("도시코드: " + bi.getCityCode());
            }
            if (routeId != null) {
                routeId.setText("노선 ID: " + bi.getRouteId());
            }
            if (routeNo != null) {
                routeNo.setText("노선 번호: " + bi.getRouteNo());
            }
            if (routeTp != null) {
                routeTp.setText("노선 유형: " + bi.getRouteTp());
            }
            if (endNodeNm != null) {
                endNodeNm.setText("종점: " + bi.getEndNodeNm());
            }
            if (startNodeNm != null) {
                startNodeNm.setText("기점: " + bi.getStartNodeNm());
            }
            if (endVehicleTime != null) {
                endVehicleTime.setText("막차 시간: " + bi.getEndVehicleTime());
            }
            if (startVehicleTime != null) {
                startVehicleTime.setText("첫차 시간: " + bi.getStartVehicleTime());
            }
        }

        return convertView;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
