package com.fruitrocket.metodos;


import com.fruitrocket.com.R;
import com.fruitrocket.telas.Tela;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MetodosJogo extends Tela {
	
	public Integer alturaTela, larguraTela;
	
	public int y1, y2, y3, y4, p1, p2 = 0;
	
	public int foguetesAtingidos = 0;
	
	public int posicaoCaixa, alturaToque, totalPontosx = 0;
	
	public int tempoJogo = 30;

	
	
	public int velocidadeQueda1 = 9;
	public int velocidadeQueda2 = 9;
	public int velocidadeQueda3 = 11;
	public int velocidadeQueda4 = 11;
			
	public SoundPool soundp;
	public int som1, som2, som3;

	int alturaQueda1, alturaQueda2, alturaQueda3, alturaQueda4 = 0;
	int alturaQueda = 0;
	
	 
	public void foguteAtingido(int ponto)
	{
		
		
		if  (ponto == 1)
		{
			ImageView foguete1 = (ImageView)findViewById(R.id.fogueteponto1);
			Drawable fogueteAtivado = getResources().getDrawable(R.drawable.imgfogueteativado);
			foguete1.setImageDrawable(fogueteAtivado);
		}	
		if (ponto == 2)
		{
			ImageView foguete2 = (ImageView)findViewById(R.id.fogueteponto2);
			Drawable fogueteAtivado = getResources().getDrawable(R.drawable.imgfogueteativado);
			foguete2.setImageDrawable(fogueteAtivado);
			
		}
		
		 
	}
	

	public Integer frutaImg(int z)
	{
		Integer zx = 0;
		if (z == 1)
		{	
		ImageView ff = (ImageView)findViewById(R.id.maca);
		zx = ff.getId();
		}
		
		if (z == 2)
		{	
		ImageView ff = (ImageView)findViewById(R.id.limao);
		zx = ff.getId();
		}
		
		if (z == 3)
		{	
		ImageView ff = (ImageView)findViewById(R.id.pera);
		zx = ff.getId();
		}
		
		if (z == 4)
		{
			
		ImageView ff = (ImageView)findViewById(R.id.foguete);
		zx = ff.getId();	
		}
		
		if (z == 5)
		{
			
		ImageView ff = (ImageView)findViewById(R.id.panela);
		zx = ff.getId();	
		}
		
		
	
		return zx;
	}
	
	public ImageView movimentaFruta(int codFruta, int distanciaChao, int distanciaEsquerda)
	{
	
						
		ImageView imgFruta = (ImageView)findViewById(codFruta);
		RelativeLayout.LayoutParams pos = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		
		pos.setMargins(distanciaEsquerda, distanciaChao, 0, 0);
		imgFruta.setLayoutParams(pos);
		
		return imgFruta;
		
	}

	
	public Integer posicaoFruta(int codFruta, int distanciaChao, int distanciaEsquerda)
	{
		ImageView x = movimentaFruta(codFruta, distanciaChao, distanciaEsquerda);
		int z = x.getTop();
		return z;
	}
	
	
	public Integer controlaQueda(int fruta)
	{
			
			if (fruta == 1 )
			{
				alturaQueda1 = alturaQueda1 + velocidadeQueda1;
				
				if (alturaQueda1 >= alturaTela)
					{
						alturaQueda1 = 0;
					
					}
			
				return alturaQueda1;	
			}
			
			if (fruta == 2)
			{
				alturaQueda2 = alturaQueda2 + velocidadeQueda2;
				
				if (alturaQueda2 >= alturaTela)
				{
					alturaQueda2 = 0;
				
				}
			
				return alturaQueda2;	
			}
			
			
			if (fruta == 3)
			{
				alturaQueda3 = alturaQueda3 + velocidadeQueda3;
				
				if (alturaQueda3 >= alturaTela)
				{
					alturaQueda3 = 0;
				
				}
			
				return alturaQueda3;	
			}
			
			if (fruta == 4)
			{
				alturaQueda4 = alturaQueda4 + velocidadeQueda4;
				
				if (alturaQueda4 >= alturaTela)
				{
					alturaQueda4 = 0;
				
				}
			
				return alturaQueda4;	
			}
			
			return null; 
	}


	public Integer controlaQuedaLateral()
	{
		
			
			int distanciaEsquerda = (int) (Math.random() * ( (int) (larguraTela * 0.85)));
			return distanciaEsquerda;
		
	}
	
	
	
	public void capturaTamanhoTela()
	{
		larguraTela = getWindowManager().getDefaultDisplay().getWidth();
		alturaTela =  getWindowManager().getDefaultDisplay().getHeight();
	
	}
	
	public void lancaObjetos()
	{
		
		if (controlaQueda(1) == 0)
		{
			y1 = controlaQuedaLateral();
		}
		else
		{
			movimentaFruta(frutaImg(1), controlaQueda(1), y1);
		}
		
		
		
		if (controlaQueda(2) == 0)
		{
			y2 = controlaQuedaLateral();
		}
		else
		{	
		movimentaFruta(frutaImg(2), controlaQueda(2), y2);
		}
		
		
		if (controlaQueda(3) == 0)
		{
			y3 = controlaQuedaLateral();
		}
		else
		{
			movimentaFruta(frutaImg(3), controlaQueda(3), y3);
		}			
		
		

		if (controlaQueda(4) == 0)
		{
			y4 = controlaQuedaLateral();
		}
		else
		{
			movimentaFruta(frutaImg(4), controlaQueda(4), y4);
		}			
		
		
		movimentaCaixaFrutas(alturaToque);
		
		
	}
	
	public void movimentaCaixaFrutas(int alturaToque)
	{
		
		if (alturaToque > ((int)(alturaTela * 0.87)) || alturaToque == 0)
		{
			movimentaFruta(frutaImg(5),(int)(alturaTela * 0.9) , posicaoCaixa);
			
		}
		
	}
	
	
	
	public int marcaPontos(int posicaoFruta, int caixa, int alturaFruta, int refFruta)
	{
		
		if ( ((caixa < ( posicaoFruta + (larguraTela * 0.1))) && (caixa > (posicaoFruta - (larguraTela * 0.1))) )  && (alturaFruta > (alturaTela * 0.8) ))
		{
			
			
				if (refFruta == 1 || refFruta == 2)
				{
				totalPontosx = totalPontosx + 1;
				somPonto(refFruta);
				mudaPontos(totalPontosx);
				}
				else if (refFruta == 3)
				{
					
					totalPontosx = totalPontosx + 3;
					somPonto(refFruta);
					mudaPontos(totalPontosx);
					
					
				}
				else if (refFruta == 4)
				{
					foguetesAtingidos = foguetesAtingidos + 1;
					somPonto(refFruta);
					foguteAtingido(foguetesAtingidos);
					
					
					
				}
		}
		
		return totalPontosx;
	}
	

	public Integer cronometro()
	{
		
		mudaTempo(tempoJogo);
		tempoJogo = tempoJogo - 1;
		return tempoJogo;
	}
	
	
	public void mudaPontos(int parametroPontos)
	{
		
		
		String refPts = Integer.toString(parametroPontos);
		
		String refPontos1 = refPts.substring(0,1);
		p1 = Integer.parseInt(refPontos1);
		
		
		
		ImageView pontoUm = (ImageView)findViewById(R.id.pontos1);
		ImageView pontoDois = (ImageView)findViewById(R.id.pontos2);
		
		Integer numeros[] = new Integer[10];
		
		numeros[0] = R.drawable.numero_0;
		numeros[1] = R.drawable.numero_1;
		numeros[2] = R.drawable.numero_2;
		numeros[3] = R.drawable.numero_3;
		numeros[4] = R.drawable.numero_4;
		numeros[5] = R.drawable.numero_5;
		numeros[6] = R.drawable.numero_6;
		numeros[7] = R.drawable.numero_7;
		numeros[8] = R.drawable.numero_8;
		numeros[9] = R.drawable.numero_9;
		
		
		Drawable imagem = this.getResources().getDrawable(numeros[p1]);
		pontoUm.setImageDrawable(imagem);
		
		if (parametroPontos > 9)
		{
			String refPontos2 = refPts.substring(1,2);
			p2 = Integer.parseInt(refPontos2);
			
			Drawable imagem2 = this.getResources().getDrawable(numeros[p2]);
			pontoDois.setImageDrawable(imagem2);
			
			
		}
		
		
	}
	
	public void mudaTempo(int parametroTempo)
	{
		
		Integer numeros[] = new Integer[10];
		
		numeros[0] = R.drawable.numero_0;
		numeros[1] = R.drawable.numero_1;
		numeros[2] = R.drawable.numero_2;
		numeros[3] = R.drawable.numero_3;
		numeros[4] = R.drawable.numero_4;
		numeros[5] = R.drawable.numero_5;
		numeros[6] = R.drawable.numero_6;
		numeros[7] = R.drawable.numero_7;
		numeros[8] = R.drawable.numero_8;
		numeros[9] = R.drawable.numero_9;
		

		ImageView tempoUm = (ImageView)findViewById(R.id.tempo1);
		ImageView tempoDois = (ImageView)findViewById(R.id.tempo2);
		
		if (parametroTempo > 9)
		{
			
			String refTempo = Integer.toString(parametroTempo);
			
			String refTempo1 = refTempo.substring(0,1);
			p1 = Integer.parseInt(refTempo1);
			
			Drawable imagem = this.getResources().getDrawable(numeros[p1]);
			tempoUm.setImageDrawable(imagem);
			
			String refPontos2 = refTempo.substring(1,2);
			p2 = Integer.parseInt(refPontos2);
			
			Drawable imagem2 = this.getResources().getDrawable(numeros[p2]);
			tempoDois.setImageDrawable(imagem2);
			
		}
		
		else
		{

			String refTempo = Integer.toString(parametroTempo);
			
			String refTempo1 = refTempo.substring(0,1);
			p1 = Integer.parseInt(refTempo1);
			
			
			Drawable imagem = this.getResources().getDrawable(numeros[p1]);
			tempoUm.setImageDrawable(imagem);
			tempoDois.setVisibility(View.GONE);
			
		}	
		
	}
	
		
	public void carregaSom()
	{
		
		soundp = new SoundPool(5, AudioManager.STREAM_MUSIC, 1);
		som2 = soundp.load(this, R.raw.yeah, 1); 
		som1 = soundp.load(this, R.raw.ponto, 1); 
		som3 = soundp.load(this, R.raw.bomba, 1);
		
		
	}
	
	
	public void somPonto(int refFruta)
	{
		
		if (refFruta == 1 || refFruta == 2)
		{
			soundp.play(som1, 1, 1, 0, 0, 1);
		}
		else if (refFruta == 3)
		{
			
			soundp.play(som2, 1, 1, 0, 0, 1);
		}
		else
		{
			soundp.play(som3, 1, 1, 0, 0, 1);
			
		}	
		
	}
}
