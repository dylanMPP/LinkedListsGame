
public class Player {

    private String name;
    private int position;
    private Player next;

    public Player(String name){
        this.name = name;
        position = 0;
    } // player constr

    public String getName(){
        return this.name;
    }// get

    public void SetName(String name){
        this.name = name;
    } // set

    public int getPosition() {
    	return position;
    } // getposition
    
    public void setPosition(int position) {
    	this.position = position;
    } // setposition
    
    public Player getNext(){
        return this.next;
    } // getnext

    public void setNext(Player next){
        this.next = next;
    } // setnext
} // player
