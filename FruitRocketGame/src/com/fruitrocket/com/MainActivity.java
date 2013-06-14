package com.fruitrocket.com;


import com.fruitrocket.metodos.MetodosJogo;


import android.annotation.SuppressLint;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends MetodosJogo {
	
	TextView texto;
	ImageView tempoLabel, pontosLabel;
	int tjogo = 10;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
		capturaTamanhoTela();
		carregaSom();
			
		texto  = (TextView)findViewById(R.id.texto);
		
	
		final ImageView fruta1 = (ImageView)findViewById(R.id.maca);
		final ImageView fruta2 = (ImageView)findViewById(R.id.limao);
		final ImageView fruta3 = (ImageView)findViewById(R.id.pera);
		final ImageView caixa = (ImageView)findViewById(R.id.panela);
		final ImageView foguete = (ImageView)findViewById(R.id.foguete);
		
		
		
		
		final Handler controle = new Handler();
		
		final Runnable acionaJogo = new Runnable() {
			
			@SuppressLint("NewApi")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				lancaObjetos(); 
				
			    		movimentaCaixaFrutas(alturaToque);
			    		controle.postDelayed(this, 1);
							}
		};
			
	
		final Runnable somaPontos = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				controle.postDelayed(this, 300);
				
				marcaPontos((int)(fruta1.getLeft()), (int)(caixa.getLeft()), fruta1.getTop(), 1);
				marcaPontos((int)(fruta2.getLeft()), (int)(caixa.getLeft()), fruta2.getTop(), 2);
				marcaPontos((int)(fruta3.getLeft()), (int)(caixa.getLeft()), fruta3.getTop(), 3);
				marcaPontos((int)(foguete.getLeft()), (int)(caixa.getLeft()), foguete.getTop(), 4);
				
				
			}
		};	
		
		
		
		
		final Runnable tempoCorrido  = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				controle.postDelayed(this, 1000);
				//texto.setText("fruta" + foguete.getLeft() +  "caixa" + caixa.getLeft() + "altura" + foguete.getTop()  );
				texto.setText("foguetes" + foguetesAtingidos);
				tjogo = cronometro();
				
			}
		};
		
		
		final Runnable checaStatusJogo = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				controle.postDelayed(this, 1);
				if ( (tjogo < 0 ) || (foguetesAtingidos == 2))
				{
					controle.removeCallbacks(tempoCorrido);
					controle.removeCallbacks(somaPontos);
					controle.removeCallbacks(acionaJogo);
					
				}
			}
		};
		
		
		final Runnable rodaJogo = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				controle.postDelayed(this, 100000);
				controle.postDelayed(somaPontos, 1000);
				controle.postDelayed(acionaJogo, 1);
				controle.postDelayed(tempoCorrido, 1000); 
				controle.postDelayed(checaStatusJogo, 1);
				
				
				
			}
		}; controle.postDelayed(rodaJogo, 3000);
		
			}
	
	
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		
		
		if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
		posicaoCaixa = (int) event.getX();
		alturaToque = (int) event.getY();
		

		}
		
		
		
		return super.onTouchEvent(event);
		
		
		
	}
	
}

	
	
	
	


