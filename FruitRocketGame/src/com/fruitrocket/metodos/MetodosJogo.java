package com.fruitrocket.metodos;


import com.fruitrocket.com.R;
import com.fruitrocket.telas.Tela;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MetodosJogo extends Tela {
	
	public Integer alturaTela, larguraTela;
	
	public int y1, y2, y3 = 0;
	
	public int posicaoCaixa, alturaToque, totalPontosx = 0;
	

	
	
	public int velocidadeQueda1 = 9;
	public int velocidadeQueda2 = 11;
	public int velocidadeQueda3 = 21;
			
	

	int alturaQueda1, alturaQueda2, alturaQueda3, alturaQueda4 = 0;
	int alturaQueda = 0;
	
	
	public Integer ajustaTamanhoFruta()
	{
		Integer tamanhoFruta = ( (alturaTela * 10) /100); 
		return  tamanhoFruta;
	} 
	
		
	public ImageView insereFruta(String refFruta)
	{
		
		ImageView image = new ImageView(this);
		
		Drawable imagemFruta;
		
		if (refFruta == "maca")
		{
			 imagemFruta = this.getResources().getDrawable(R.drawable.apple1);
			 image.setImageDrawable(imagemFruta);
			 image.setId(1);
			 return image;
		}
		
		
		
		if (refFruta == "limao")
		{
			 imagemFruta = this.getResources().getDrawable(R.drawable.lemon1);
			 image.setImageDrawable(imagemFruta);
			 image.setId(2);
			 return image;
		}
		
		
		if (refFruta == "pera")
		{
			 imagemFruta = this.getResources().getDrawable(R.drawable.peach);
			 image.setImageDrawable(imagemFruta);
			 image.setId(3);
			 return image;
		}
		
		if (refFruta == "panela")
		{
			 imagemFruta = this.getResources().getDrawable(R.drawable.bin);
			 image.setImageDrawable(imagemFruta);
			 image.setId(4);
			 return image;
			
		}
		
		return image;
	}

	
	public ImageView movimentaFruta(int codFruta, int distanciaChao, int distanciaEsquerda)
	{
	
						
		ImageView imgFruta = (ImageView)findViewById(codFruta);
		RelativeLayout.LayoutParams pos = new RelativeLayout.LayoutParams(ajustaTamanhoFruta(), ajustaTamanhoFruta());
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
			
			
			return null; 
	}


	public Integer controlaQuedaLateral(int x)
	{
		
			
			int distanciaEsquerda = (int) (Math.random() * ( larguraTela));
			distanciaEsquerda = (int)(distanciaEsquerda * 0.85)  ;
			//esq = distanciaEsquerda;
			if (distanciaEsquerda == x)
			{
				distanciaEsquerda = (int) (Math.random() * ( larguraTela));
				distanciaEsquerda = (int)(distanciaEsquerda * 0.85)  ;	
				//esq = distanciaEsquerda;
				
			}
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
			y3 = controlaQuedaLateral(y3);
		}
		
		movimentaFruta(3, controlaQueda(3), y3);
					
		movimentaCaixaFrutas(alturaToque);
		
		
	}
	
	public void movimentaCaixaFrutas(int alturaToque)
	{
		
		if (alturaToque > ((int)(alturaTela * 0.87)) || alturaToque == 0)
		{
			movimentaFruta(4,(int)(alturaTela * 0.9) , posicaoCaixa);
		}
		
	}
	
	public void marcaPonto(int posc, int posFruta, int altFruta)
	{
		
		if ( (posFruta > (posc + 1) || posFruta < (posc + 1)) && (altFruta > 840))
		{
			
			totalPontosx = totalPontosx + 2;
		}
		
	}
	
	public int marcaPontos(int v1, int v2, int v3)
	{
		
		if ( ((v2 < (v1 + 50)) && (v2 > (v1 - 50)) )  && (v3 > 840 ))
		{
			
			totalPontosx = totalPontosx + 1;
			mudaPlacar();
		}
		
		return totalPontosx;
	}
	
	public ImageView placar(int x, int z)
	{
		
		
		ImageView ponto = new ImageView(this);
		RelativeLayout.LayoutParams posicaoPontos = new RelativeLayout.LayoutParams(ajustaTamanhoFruta(), ajustaTamanhoFruta());
		posicaoPontos.setMargins(x, 10, 0, 0);
		ponto.setLayoutParams(posicaoPontos);
		
		
		Drawable imagemPonto;
			 imagemPonto = this.getResources().getDrawable(R.drawable.numero_0);
			 ponto.setImageDrawable(imagemPonto);
			 ponto.setId(z);
			 return ponto;
		
	}
	
	public ImageView mudaPlacar()
	{
		ImageView imagemNumero = (ImageView)findViewById(5);
		
		Drawable imagemDoPonto;
		 imagemDoPonto = this.getResources().getDrawable(R.drawable.numero_1);
		 imagemNumero.setImageDrawable(imagemDoPonto);
		
		return imagemNumero;
	}
}
