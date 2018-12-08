package shyam.ram.advance.fragment;

import android.app.Fragment;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;

import shyam.ram.advance.R;
import shyam.ram.advance.general.MyLocation;
import shyam.ram.advance.model.download.CustomerLocation;
import shyam.ram.advance.room.AppDataBase;
import shyam.ram.advance.room.ApplicationDataBase;


public class MapActivity extends Fragment {
    MapView mMapView;
    private GoogleMap googleMap;
    LocationManager locationManager;
    Location locations;
    private HashMap<Marker, Integer> mHashMap = new HashMap<Marker, Integer>();
    List<CustomerLocation.CustomerMasterBean.LocationMasterBean> locationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.map, container, false);
//        AppDataBase appDataBase= LocationData.class
        ApplicationDataBase applicationDataBase = AppDataBase.appDataBaseInstance(getActivity());
        locationList = applicationDataBase.locationData().getLocationList();
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        locationManager = (LocationManager)
                getActivity().getSystemService(Context.LOCATION_SERVICE);
        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                if (locationList != null)
                    setMarker();
                MyLocation.LocationResult locationResult = new MyLocation.LocationResult() {
                    @Override
                    public void gotLocation(Location location) {
                        locations = location;
                        googleMap.setMyLocationEnabled(true);
                        // For dropping a marker at a point on the Map
                        LatLng sydney = new LatLng(locations.getLatitude(), locations.getLongitude());
//                        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));
                        // For zooming automatically to the location of the marker
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(13).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                    }
                };
                MyLocation myLocation = new MyLocation();
                myLocation.getLocation(getActivity(), locationResult);
//                LocationListener locationListener = new MyLocationListener();
//                locationManager.requestLocationUpdates(
//                        LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
            }
        });

        return rootView;
    }

    MarkerOptions mo;

    private void setMarker() {
        mo = new MarkerOptions();
        if (locationList != null || locationList.size() != 0) {
            for (int i = 0; i < locationList.size(); i++) {
                mo.icon(BitmapDescriptorFactory.fromResource(R.drawable.green_dot));
                try {
                    CustomerLocation.CustomerMasterBean.LocationMasterBean cldo =
                            (CustomerLocation.CustomerMasterBean.LocationMasterBean)
                                    locationList.get(i);
                    String custName = "Not Found";
                    if (custName.length() != 0) {
                        mo.title(custName).position(new LatLng(Double.parseDouble(cldo.getLatitude()), Double.parseDouble(cldo.getLongitude())));
                        Marker market = googleMap.addMarker(mo);
                        mHashMap.put(market, i);
                        // gm.addMarker(mo);
                        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick(Marker mar) {
                                int pos = mHashMap.get(mar);
                                CustomerLocation.CustomerMasterBean.LocationMasterBean cldo =
                                        (CustomerLocation.CustomerMasterBean.LocationMasterBean) locationList.get(pos);
                                //Toast.makeText(MapViewCustomer.this,mar.getSnippet(),Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                } catch (Exception e) {
                }
            }
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
