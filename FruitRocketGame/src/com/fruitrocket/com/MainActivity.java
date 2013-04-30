package com.fruitrocket.com;


import com.fruitrocket.metodos.MetodosJogo;


import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends MetodosJogo {
	
	TextView texto;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		capturaTamanhoTela();
		
			
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.container);
		
		layout.addView(insereFruta("maca"));
		layout.addView(insereFruta("limao"));
		layout.addView(insereFruta("pera"));
		layout.addView(insereFruta("panela"));
		
						
		texto  = (TextView)findViewById(R.id.texto);
		texto.setText("alt é" + alturaTela);
		
		final Handler controle = new Handler();
		
		Runnable acionaJogo = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				lancaObjetos();
				controle.postDelayed(this, 1);
				
				//texto.setText("altura é" + posicaoFruta(1, controlaQueda(1), y1) + "esq" + y1);
			}
		};
			controle.postDelayed(acionaJogo, 1);
	
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		
		
		if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
		posicaoCaixa = (int) event.getX();
		texto.setText("movimento" + posicaoCaixa );
		}
		
		return super.onTouchEvent(event);
		
		
		
	}
	
}

	
	
	
	


