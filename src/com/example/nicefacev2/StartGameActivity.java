package com.example.nicefacev2;

import java.io.File;
import java.io.IOException;

import org.apache.http.ParseException;

import client.Client;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Toast;

public class StartGameActivity extends Activity {
	
	Client c = new Client("b06da00689e96bb8c8eecfcbbbbe4778", "PVWeWimndNqxMS5kHLXDvTAZzRdSUKbM"); 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_game);
		
		Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);  
		startActivityForResult(intent, 0); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_game, menu);
		return true;
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
	       super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

	       switch(requestCode) {
	       case 0:
	           if(resultCode == RESULT_OK){
	           Uri selectedImage = imageReturnedIntent.getData();
	                String[] filePathColumn = {MediaStore.Images.Media.DATA};

	                   Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
	                   cursor.moveToFirst();

	                   int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	                  //file path of captured image
	                   String filePath = cursor.getString(columnIndex); 
	                   //file path of captured image
	                   File f = new File(filePath);
	                   String filename= f.getName();
	                   
	                   try {
	                	   c.detect(f);
	                   } catch (ParseException e) {
	                	   // TODO Auto-generated catch block
	                	   e.printStackTrace();
	                   } catch (IOException e) {
	                	   // TODO Auto-generated catch block
	                	   e.printStackTrace();
	                   } 
	                   
	                   cursor.close();

	                 //Convert file path into bitmap image using below line.
	                  // yourSelectedImage = BitmapFactory.decodeFile(filePath);


	                  //put bitmapimage in your imageview
	                  //yourimgView.setImageBitmap(yourSelectedImage);
	      }
	       break;
	   }
	} 

}
