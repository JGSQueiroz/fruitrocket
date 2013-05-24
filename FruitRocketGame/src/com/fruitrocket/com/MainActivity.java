package com.fruitrocket.com;


import com.fruitrocket.metodos.MetodosJogo;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
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
		layout.addView(placar(10, 6));
		layout.addView(placar(70, 5));
						
		texto  = (TextView)findViewById(R.id.texto);
		texto.setText("alt é" + alturaTela );
	
		final ImageView fruta1 = (ImageView)findViewById(1);
		final ImageView fruta2 = (ImageView)findViewById(2);
		final ImageView fruta3 = (ImageView)findViewById(3);
		final ImageView caixa = (ImageView)findViewById(4);
		
		
		
		
		final Handler controle = new Handler();
		
		Runnable acionaJogo = new Runnable() {
			
			@SuppressLint("NewApi")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				lancaObjetos();  
			    movimentaCaixaFrutas(alturaToque);
				controle.postDelayed(this, 1);
				//texto.setText("Pontos" + totalPontosx + "altura" + altchao + "caixa" + posicaocaix + "esq" + esq);
				//texto.setText("maca" + fruta1.getX() + "caixa" + caixa.getX() + "tot" + totalPontosx);
			
				texto.setText("Total Pontos:" + totalPontosx);
				//marcaPontos((int)(fruta1.getX()), (int)(caixa.getX()), fruta1.getTop());
				
				//texto.setText("altura é" + posicaoFruta(1, controlaQueda(1), y1) + "esq" + y1);
			}
		};
			controle.postDelayed(acionaJogo, 1);
	
		Runnable somaPontos = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				controle.postDelayed(this, 1000);
				marcaPontos((int)(fruta1.getX()), (int)(caixa.getX()), fruta1.getTop());
				marcaPontos((int)(fruta2.getX()), (int)(caixa.getX()), fruta2.getTop());
				marcaPontos((int)(fruta3.getX()), (int)(caixa.getX()), fruta3.getTop());
				
			}
		};	
		controle.postDelayed(somaPontos, 1);
	}
	
	
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		
		
		if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
		posicaoCaixa = (int) event.getX();
		alturaToque = (int) event.getY();
		//texto.setText("movimento" + posicaoCaixa + " altura " + alturaToque  + "pontos" + totalPontos);
		

		}
		
		
		
		return super.onTouchEvent(event);
		
		
		
	}
	
}

	
	
	
	


