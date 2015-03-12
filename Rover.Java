public class Rover 
{    
    public Rover ()
    {            
    }

        public static final Integer N = 1;
    	public static final Integer E = 2;
    	public static final Integer S = 3;
    	public static final Integer W = 4;
        Integer x = 0;
        Integer y = 0;
        Integer Cardinalidad = N;
        Integer LimiteX;
        Integer LimiteY;  

    public void DefinirLimites(Integer  x, Integer  y)
    {
        LimiteX = x;
        LimiteY = y;        
    }
    public void Posicion(Integer  x, Integer  y, Integer  Cardinalidad)
    {           
        this.x = x;
        this.y = y;
        this.Cardinalidad = Cardinalidad;
    }   
    public void Leer(String Letras) {
	    Character Letra;
        for (Integer  i = 0; i < Letras.length(); i++)
        {
		    Letra=Letras.charAt(i);
            if (Letra.equals('L')){
            	Izquierda();
        	}
        	else if (Letra.equals('R')){
                Derecha();
        	}
       	        else if (Letra.equals('M')){
            	Mover();
        	}
		    else {
          		throw new IllegalArgumentException("Letra no valida.Letras Validas:L,R,M");
        	}
        }
    }
    
    private void Mover()
    {      

        if (Cardinalidad == N)
        {
            y++  ;
        }
        else if (Cardinalidad == S)
        {
            y--;
        }

        else if (Cardinalidad == E)
        {
            x++  ;
        }
       
        else if (Cardinalidad == W)
        {
            x--;
        }

        if (y > LimiteY)
        {
            throw new IllegalArgumentException("Limite Y Exedido,El Rover caera de la Plataforma.");
        }
        else if (x > LimiteX)
        {
            throw new IllegalArgumentException("Limite X Exedido,El Rover caera de la Plataforma.");
        }
    }
    private void Izquierda() {       
        if ((Cardinalidad - 1) < N)
        {
            Cardinalidad = W;
        }
        else {
            Cardinalidad--;
        }

    }
    private void Derecha() {       
        if ((Cardinalidad + 1) > W)
        {
            Cardinalidad = N;
        }
        else{
            Cardinalidad ++;
        }
    }
   public void MostrarPosicionActual() {
        char Vista = 'N';
        if (Cardinalidad == 1)
        {
            Vista = 'N';
        }
        else if (Cardinalidad == 2)
        {
            Vista = 'E';
        }
        else if (Cardinalidad == 3)
        {
            Vista = 'S';
        }
        else if (Cardinalidad == 4)
        {
            Vista = 'W';
        }
        System.out.println(x + " " + y + " " + Vista);        
    }
    public static void main(String args[]) {
            try
            {
		Rover rover = new Rover();
                rover.DefinirLimites(5, 5);

                rover.Posicion(1, 2, N);
                rover.Leer("LMLMLMLMM");
                rover.MostrarPosicionActual();//1 3 N

                rover.Posicion(3, 3, E);
                rover.Leer("MMRMMRMRRM");
                rover.MostrarPosicionActual();//5 1 E
            }
            catch(Exception ex) 
            {
                System.out.println(ex.getMessage());
            }
    }
}

