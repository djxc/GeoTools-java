package com.dj.myGeoTools;

import java.io.File;
import java.io.IOException;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;

public class Showshp {
	
	/**
	 * 显示地理数据，传入要显示的文件
	 *1. 通过文件创建地理数据库
	 *2.根据库获得要素源
	 *3.创建MapContent，可以添加title
	 *4.创建layer，需要传入要素源和显示样式。将layer添加给MapContent
	 *5.调用showMap方法显示MapContent 
	 * @param file
	 * @throws IOException
	 */
	public static void showdata(File file) throws IOException {		
		FileDataStore store = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource featureSource = store.getFeatureSource();

        // Create a map content and add our shapefile to it
        MapContent map = new MapContent();
        map.setTitle("Quickstart");

        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Layer layer = new FeatureLayer(featureSource, style);
        map.addLayer(layer);
        // Now display the map
        JMapFrame.showMap(map);
	}
	
}
