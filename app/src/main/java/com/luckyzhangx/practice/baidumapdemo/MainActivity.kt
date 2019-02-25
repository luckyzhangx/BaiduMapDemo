package com.luckyzhangx.practice.baidumapdemo

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.baidu.mapapi.map.BitmapDescriptorFactory
import com.baidu.mapapi.map.MapStatusUpdateFactory
import com.baidu.mapapi.map.MarkerOptions
import com.baidu.mapapi.model.LatLng
import com.baidu.mapapi.model.LatLngBounds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loc1 = LatLng(39.407462, 115.738804)

        val icon = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888)
        val canvas = Canvas()
        canvas.setBitmap(icon)
        canvas.drawColor(Color.RED)

        val bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(icon)

        panWithPadding.setOnClickListener {

            val loc = LatLng(lat.text.toString().toDouble(), lng.text.toString().toDouble())

            val left = Integer.valueOf(left.text.toString())
            val top = Integer.valueOf(top.text.toString())
            val right = Integer.valueOf(right.text.toString())
            val bottom = Integer.valueOf(bottom.text.toString())

            mapView.map.clear()
            val bounds = LatLngBounds.Builder()
            bounds.include(loc)

            mapView.map.apply {
                val status = MapStatusUpdateFactory
                        .newLatLngBounds(bounds.build(),
                                left, top, right, bottom)

                val marker = MarkerOptions().position(loc).icon(bitmapDescriptor)
                mapView.map.addOverlay(marker)

                mapView.map.setMapStatus(status)

                Log.d("map", "$left;$top;$right;$bottom")

            }

        }

        panWithoutPadding.setOnClickListener {
            val loc = LatLng(lat.text.toString().toDouble(), lng.text.toString().toDouble())

            mapView.map.clear()
            val bounds = LatLngBounds.Builder()
            bounds.include(loc)

            mapView.map.apply {
                val status = MapStatusUpdateFactory
                        .newLatLngBounds(bounds.build())

                val marker = MarkerOptions().position(loc).icon(bitmapDescriptor)
                mapView.map.addOverlay(marker)

                mapView.map.setMapStatus(status)
                Log.d("map", "")
            }

        }
    }
}
