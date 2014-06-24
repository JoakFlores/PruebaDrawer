package com.price.corporativa;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_login);
		//Hace el cursor visible cuando se le da tap
		final EditText empleado = (EditText)findViewById(R.id.numEmpleado);
		empleado.setOnFocusChangeListener(new View.OnFocusChangeListener() {
		      @Override
		      public void onFocusChange(View v, boolean hasFocus) {
		        empleado.setCursorVisible(true);
		      }
		});
		final EditText contrase–a = (EditText)findViewById(R.id.contrasena);
		contrase–a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
		      @Override
		      public void onFocusChange(View v, boolean hasFocus) {
		        contrase–a.setCursorVisible(true);
		      }
		});
	}
	
	 public void ingresar(View v){
	    	//Se obtienen los valores de Num.Empleado/Constrase–a
		   
	    	EditText empleado 	= (EditText)findViewById(R.id.numEmpleado);
	    	EditText contrase–a = (EditText)findViewById(R.id.contrasena);
	    	String strEmpleado = empleado.getText().toString();
	    	String strcontrase–a = contrase–a.getText().toString();
	    	if (strEmpleado.equals("") || strcontrase–a.equals("")) {
	    		AlertDialog.Builder AlertBox = new AlertDialog.Builder(Login.this);
	    		AlertBox.setTitle("Login");
	    		AlertBox.setMessage("Falta capturar alguno de los dos datos solicitados, favor de revisar");
	    		AlertBox.setNeutralButton("OK", null);
	    		AlertBox.show();
	    	}else{
	    		//Se invoca a la ventana de Menu
	    		startActivity(new Intent(this,MenuRaiz.class));
	    		//Con la sig. l’nea, se evita el regresar a esta ventana(Login)
	    		finish();
	    		//Para animar las transiciones
	    		//overridePendingTransition(R.anim.in_left, R.anim.out_left);
	    	}
	    }
	 
	//MŽtodo para ocultar el teclado
	    @Override
	    public boolean dispatchTouchEvent(MotionEvent ev) {
	            if (getCurrentFocus() != null) {
	                  InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	                  imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
	                }
	        return super.dispatchTouchEvent(ev);
	    }


}
