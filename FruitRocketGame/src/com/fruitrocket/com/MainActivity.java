package com.fruitrocket.com;


import com.fruitrocket.metodos.MetodosJogo;


import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends MetodosJogo {
	
	TextView texto;
	ImageView tempoLabel, pontosLabel;

	 SoundPool ssp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ssp = new SoundPool(5, AudioManager.STREAM_MUSIC, 1);
		int ponto = ssp.load(this, R.raw.beep, 1); 
		ssp.play(ponto, 1, 1, 0, 0, 1);
		
		
		capturaTamanhoTela();
			
		texto  = (TextView)findViewById(R.id.texto);
		texto.setText("alt é" + alturaTela );
	
		final ImageView fruta1 = (ImageView)findViewById(R.id.maca);
		final ImageView fruta2 = (ImageView)findViewById(R.id.limao);
		final ImageView fruta3 = (ImageView)findViewById(R.id.pera);
		final ImageView caixa = (ImageView)findViewById(R.id.panela);
		
		
		
		
		final Handler controle = new Handler();
		
		Runnable acionaJogo = new Runnable() {
			
			@SuppressLint("NewApi")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				lancaObjetos();  
			    movimentaCaixaFrutas(alturaToque);
				controle.postDelayed(this, 1);
							}
		};
			controle.postDelayed(acionaJogo, 1);
	
		Runnable somaPontos = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				controle.postDelayed(this, 1000);
				
				marcaPontos((int)(fruta1.getLeft()), (int)(caixa.getLeft()), fruta1.getTop());
				//marcaPontos((int)(fruta2.getLeft()), (int)(caixa.getLeft()), fruta2.getTop());
				//marcaPontos((int)(fruta3.getLeft()), (int)(caixa.getLeft()), fruta3.getTop());
				
				
			}
		};	
		controle.postDelayed(somaPontos, 1);
		
		Runnable tempoCorrido  = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				controle.postDelayed(this, 1000);
				//texto.setText("Tempo:" + cronometro() + "" + xf + " o id " + frutaImg(1) );
				texto.setText("Altura Tempo" + larguraTela );
				cronometro();
				
			}
		};controle.postDelayed(tempoCorrido, 1000); 
	}
	
	
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		
		
		if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
		posicaoCaixa = (int) event.getX();
		alturaToque = (int) event.getY();
		somAlertaxxx();

		}
		
		
		
		return super.onTouchEvent(event);
		
		
		
	}
	public void somAlertaxxx()
	{
		
		soundp = new SoundPool(5, AudioManager.STREAM_MUSIC, 1);
		int ponto = soundp.load(this, R.raw.beep, 1); 
		soundp.play(ponto, 1, 1, 0, 0, 1);
		
	}
	
}

	
	
	
	


