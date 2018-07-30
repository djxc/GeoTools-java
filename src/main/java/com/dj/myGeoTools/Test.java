package com.dj.myGeoTools;

import java.io.File;
import java.io.IOException;

import org.geotools.swing.data.JFileDataStoreChooser;

import com.csvreader.CsvReader;

public class Test {
	public static void main(String[] args) throws IOException {
		 //显示文件选择对话框
        File file = JFileDataStoreChooser.showOpenFile(new String[] {"shp","csv"}, null);
        if (file == null) {
            return;
        }
//        Showshp.showdata(file);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        CsvReader products = new CsvReader(file.getAbsolutePath());
		
		products.readHeaders();

		while (products.readRecord())
		{
			String productID = products.get("ProductID");
			String productName = products.get("ProductName");
			String supplierID = products.get("SupplierID");
			String categoryID = products.get("CategoryID");
			String quantityPerUnit = products.get("QuantityPerUnit");
			String unitPrice = products.get("UnitPrice");
			String unitsInStock = products.get("UnitsInStock");
			String unitsOnOrder = products.get("UnitsOnOrder");
			String reorderLevel = products.get("ReorderLevel");
			String discontinued = products.get("Discontinued");
			
			// perform program logic here
			System.out.println(productID + ":" + productName);
		}

		products.close();
	}
}
