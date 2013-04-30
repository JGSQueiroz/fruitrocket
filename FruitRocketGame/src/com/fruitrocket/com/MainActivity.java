package com.fruitrocket.com;

import com.fruitrocket.frutas.Fruta;
import com.fruitrocket.metodos.MetodosJogo;
import com.fruitrocket.telas.Tela;


import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends MetodosJogo {
	
	TextView texto;
	int posx;
	
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
		
		Runnable derrubaFruta1 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if (controlaQueda(1) == 0)
				{
					y1 = controlaQuedaLateral(y1);
				}
				movimentaFruta(1, controlaQueda(1), y1);
				
				if (controlaQueda(2) == 0)
				{
					y2 = controlaQuedaLateral(y1);
				}
				movimentaFruta(2, controlaQueda(2), y2);
				
				if (controlaQueda(3) == 0)
				{
					y3 = controlaQuedaLateral(y1);
				}
				
				movimentaFruta(3, controlaQueda(3), y3);
				movimentaFruta(4,(int)(alturaTela * 0.9) , posx);
				
				controle.postDelayed(this, 1);
				//texto.setText("altura é" + posicaoFruta(1, controlaQueda(1), y1) + "esq" + y1);
			}
		};
			controle.postDelayed(derrubaFruta1, 1);
	
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		
		
		if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
		posx = (int) event.getX();
		texto.setText("movimento" + posx );
		}
		
		return super.onTouchEvent(event);
		
		
		
	}
	
}

	
	
	
	


