import java.util.Random;

public class Board {

    private int columns;
    private int rows;
    private int size;
    private Player first;
    private Random rand;  
    private int cont;
    
    public Board(int columns, int rows) {
    	this.columns = columns;
    	this.rows = rows;
    	size = columns * rows;
    	rand = new Random();
    	cont = 0;
    } // board constr
    
    public Player addPlayerToBoard(String name) {
    	
    	Player player = new Player(name);
    	
    	if (first==null) {
    		first = player;
    		
    	} else {
    		Player pointer = first;
            while(pointer.getNext()!=null){
                pointer = pointer.getNext();
            };
            pointer.setNext(player);
    		
    	} // ifelse
    	
    	return player;
    } // addPlayer
    
    public String play() {
   
    	String msg = "";
    	cont++;
    	int dice = rand.nextInt(1,7);
    	msg += "Dice: "+dice+"\n";
    	int position = dice;
    	
    	if (cont%2 != 0) {
    		
    		if (first!=null) {
    			position += first.getPosition();
    			first.setPosition(position);
    		} // if
    		
    	} else {
    		
    		if (first.getNext() != null) {
    			position += first.getNext().getPosition();
    			first.getNext().setPosition(position);
    		} // if
    		
    	} // ifelse
    	
    	msg += print();
    	
    	return msg;
    } // addPlayer
    
    public String print(){
    	
    	String board = "";
    	int cont = 0;
    	
    	if (first.getPosition()+1 >= size) {
    		
    		return "\nThe first player, "+first.getName()+" HAS WON THE GAME!!!\n";
    		
    	} else if(first.getNext().getPosition()+1 >= size) {
    		
    		return "\nThe second player, "+first.getNext().getName()+" HAS WON THE GAME!!!\n";
    		
    	} else {
    		
        	for (int i = 1; i<=size; i++) {
        		
        		if (first!=null || first.getNext()!=null) {
        			
        			if (first.getPosition()+1==i && first.getNext().getPosition()+1==i) {
            			board += "[ "+first.getName()+", "+first.getNext().getName()+" ]";
            			
            			cont++;
            			
            			
            		} else {
            			if (first.getNext().getPosition()+1==i) {
                			board += "[ "+first.getNext().getName()+" ]";
                			
                			cont++;
            			} 
            			
            			if (first.getPosition()+1==i) {
            				board += "[ "+first.getName()+" ]";
                			
                			cont++;
            			} // if	
            		} // ifelse
        		} // if
        			
        		
        		if (cont==0) {
        			board += "[ "+ (i) +" ]";
        		} // if
        		
        		cont = 0;
        	} // for
        	
        	return board;
    	}
    
    } // print
    
} // board