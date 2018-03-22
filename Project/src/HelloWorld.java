import java.util.Scanner;

public class HelloWorld
{

private static boolean busted;	
public static char tabuleiro[][]=
{
     	{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
		{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
		{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
		{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
		{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
		{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }
};
private static boolean equipado;
private static boolean ganhou;

public static void imprime()
{
	
	for (int i = 0; i < tabuleiro.length; i++)
	{
		for (int j = 0; j < tabuleiro[i].length; j++)
		{
			System.out.print(tabuleiro[i][j] + " ");
		}
		System.out.println();
	}
}

public static void consola()
{

boolean jogas=true;
char movimento;

Scanner sc = new Scanner(System.in);

while(jogas)
{
System.out.println("Insira um comando :");
movimento=sc.next().charAt(0);

switch (movimento) {
case 'a':mov(1);
         break;
case 'd':mov(2);
         break;
case 's':mov(3);
         break;
case 'w':mov(4);
         break;
case 'z':
	System.out.println("desligar");
	jogas=false;
    break;
default: 
	System.out.println("tecla invalida ");
	break;
}
imprime();
}

}
public static int[] encontra(char ch)
{
	
  int[] retornado =new int[2];
	for (int i = 0; i < tabuleiro.length; i++)
	{
		retornado[1]=i;
		for (int j = 0; j < tabuleiro[i].length; j++)
		{
			retornado[0]=j;
			if(tabuleiro[i][j]== ch)  return retornado;
		}
	}
	return retornado;
	
}
public static void altera(int y, int x,int mov)
{
	switch (tabuleiro[y][x]) {
	case 'I':
		if(verificasaida()) {ganhou=true;break;}
	case 'k':
		{equipado=true; break;}
	case  'G':
		{busted=true; break;}
		
{
if(mov==0) tabuleiro[y][x]= ' ';
if(mov==1) tabuleiro[y][x]= 'H';

}



private static boolean verificasaida() {
	if(equipado==true) return equipado;
	return false;
}

public static void verifica(int[] pos, int mov)
{//trocado x e y
int y=pos[0];
int x=pos[1];

switch (mov) {
case 3  :
	if(tabuleiro[x+1][y]=='X') System.out.println("Mov Invalido");
	else 
	{
		altera(x,y,0);
		altera(x+1,y,1);
		
	}
	
break;

case 4:
	if(tabuleiro[x-1][y]=='X') System.out.println("Mov Invalido");
	else 
	{
		altera(x,y,0);
		altera(x-1,y,1);
		
	}
break;

case 1:
	if(tabuleiro[x][y-1]=='X') System.out.println("Mov Invalido");
	else 
	{
		altera(x,y,0);
		altera(x,y-1,1);
		
	}
break;

case 2:
	if(tabuleiro[x][y+1]=='X') System.out.println("Mov Invalido");
	else 
	{
		altera(x,y,0);
		altera(x,y+1,1);
		
	}
         break;
default: 
	System.out.println("tecla invalida ");
	break;
}
}

public static void mov(int move)
{
int[] pesquisa;
pesquisa=encontra('H');
verifica(pesquisa,move);	
}

public static void main(String[] args)
{
	imprime();
	consola();
}
	}
/*
"Dungeon Keep"
"Unfairly captured by the tyrant ruler of your Realm,"
+ " you have been thrown into a dark, damp and ghastly"
+ " dungeon, left there to rot into forgetfulness..."
+ " You keep yelling for the Guard, but he seems oblivious"
+ " to your calls...You need to escape...wait...but...in the"
+ " midst of all the fuss that was your capture, they forgot to"
+ " lock your cell door...there is hope...but the task is not"
+ " simple...will you have it in you to elude your jailers"
+ " and make your way back to freedom?"
*/