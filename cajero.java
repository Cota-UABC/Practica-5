import java.util.*;

public class cajero {
    public static void main(String args[]){
		int f=0,num,pin,c=0,i,confirm;
		float saldo;
		String nombre,user;

	banco client = new banco(); 	//Arreglo de clase banco
	client.inicializar();	
		
	Scanner sc= new Scanner(System.in);
	Scanner scan= new Scanner(System.in);
		
		do{
			System.out.print("\n-----------------"+
							 "\nQue deseas hacer:"+ //menu
							 "\n1.Crear cuenta nueva"+
							 "\n2.Usar cuenta existente"+
							 "\n3.Salir"+
							 "\n\nIngresa numero: ");
							 num = sc.nextInt();
								
								switch(num){//switch case para el menu
									case 1: if(c<50){
											client.setNombre(client.mensjNombre(),c);							
																				
											client.setPin(client.mensjPin(),c);										
											
											client.setSaldo(client.mensjSaldo(),c);																					
											
										c++;
										}
										else System.out.println("\nSe sobrepaso el limite de usuarios");
										break;
									case 2: user = client.usuario();											
											i = client.buscarU(user);
											if(i!=-1){
												confirm = client.confirmarPin(i);
												if(confirm==1) {
													client.dinero(i);
												}
												else System.out.println("\nPIN incorrecto");
											}
											else System.out.println("\nNo se encontro el usuario.");
											
										break;
									case 3: f=1;
										break;
									default: System.out.println("\n--Ingresa una de las opciones--\n");
								}
		}while(f==0); //bandera de salida
	
	}
}
class cuenta {
	int i,exist,pin2,num,f=0;
	float cant;
	//String us;
	private int[] pin = new int[50];
	private float[] saldo = new float[50];
	private String[] nombre = new String[50];
	
	public cuenta(){
	}
	
	public void inicializar(){
		for(i=0;i<50;i++){
		pin[i]=0;
		saldo[i]=0;
		nombre[i]="";		
		}
	}
		
	public void setPin(int pin, int c){
		this.pin[c] = pin;
	}
	
	public int getPin(int c){
		//pin[c]= pin[c]+1;
		return pin[c];
	}
	
	public void setSaldo(float saldo,int c){
		this.saldo[c] = saldo;
	}
	
	public float getSaldo(int c){
		return saldo[c];
	}
	
	public void setNombre(String nombre,int c){
		this.nombre[c] = nombre;
	}
	
	public String getNombre(int c){
		return nombre[c];
	}

	public int buscarU(String user){
		exist=0;
		i=0;
		//nombre[0]="cota";
		//user="cota";
	
			do{
			
			if(nombre[i].equals(user) ) exist=1;
			//System.out.println("\n"+exist+nombre[i]+user);
	
			i++;
		}while(exist==0 && i<50);
		
		if(exist==1) return(i-1);
		else return(-1);
	}
	
	public int confirmarPin(int i){
		Scanner scan= new Scanner(System.in);
		System.out.println("\nIngrese el PIN: ");
		pin2 = scan.nextInt();
		//System.out.println("\n"+i+pin[i]+pin2);
		if(pin[i]==pin2) return(1);
		else return(0);
	}
	
	
	public void dinero(int i){
		Scanner scan= new Scanner(System.in);
		do{
			f=0;
		System.out.println("\nQue desea hacer"+
						   "\n1.Depositar"+
						   "\n2.Retirar"+
						   "\n3.Consultar saldo"+
						   "\n4.Salir"+
						   "\nIngrese un numero:");
							num = scan.nextInt();
		
								switch(num){//switch case para el menu
									case 1:System.out.println("\nIngrese la cantidad a depositar: ");
										   cant = scan.nextFloat(); 
										   saldo[i]=saldo[i]+cant;
										   System.out.println("\nSaldo actual: "+saldo[i]);
										break;
									case 2:System.out.println("\nIngrese la cantidad a Retrar: ");
										   cant = scan.nextFloat(); 
										   if(cant>saldo[i]) System.out.println("\nNo es posible retirar esa cantidad.");
										   else saldo[i]=saldo[i]-cant;
										   System.out.println("\nSaldo actual: "+saldo[i]);
										break;
									case 3:System.out.println("\nSaldo actual: "+saldo[i]);
										break;
									case 4:  f=1;
										break;
									default: System.out.println("\n--Ingresa una de las opciones--\n");
								}
		}while(f==0); //bandera de salida
	}
}

class banco extends cuenta{
		
	Scanner scan= new Scanner(System.in);
		
	public banco(){
	}
	
	public int mensjPin(){
		Scanner scan= new Scanner(System.in);
		System.out.println("\nIngrese su PIN que se usara para entrar a la cuenta: ");
		return( scan.nextInt() );
	}
	
	public float mensjSaldo(){
		Scanner scan= new Scanner(System.in);
		System.out.println("\nIngrese el Deposito que desee: ");
		return( scan.nextFloat() );
	}
	
	public String mensjNombre(){
		Scanner scan= new Scanner(System.in);
		System.out.println("\nIngrese su nombre: ");
		return( scan.nextLine() );
	}
	
	public String usuario(){
		Scanner scan= new Scanner(System.in);
		System.out.println("\nIngrese el nombre al que esta registrada la cuenta: ");
		return( scan.nextLine() );
	}
}
