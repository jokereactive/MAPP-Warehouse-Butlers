/* 
 * @author Sarthak Ahuja and Anchita Goel
 */
package com.ai.major;

public class Position {
	int butlerTarget;
	Butler butler;
	int type;
	int row;
	int column;
	boolean isItem;
	boolean isWall;
	boolean isButler;
	int heuristicCost = 0;
	int finalCost = 0;
	Position parent = null;
	
	public Position()
	{
		
	}
	
	public boolean isOthersTarget(int butler)
	{
		return this.isItem && (this.butlerTarget!=butler);
	}
	
	public boolean isOcuupied()
	{
		if (!isButler)
		{
			System.out.println("No butler at "+this);
		}
		return isWall || isButler ;
		
	}
	
	public Position(Position other)
	{
		this.butlerTarget = other.butlerTarget;
		this.isItem = other.isItem;
		this.isWall = other.isWall;
		this.isButler = other.isButler;
		this.butler = other.butler;
		this.row = other.row;
		this.column = other.column;
	}
	
	public Position(int row,int column)
	{
		this.row=row*16;
		this.column=column*16;
	}
	
	public void setType(int type){
		this.type=type;
		switch (this.type){
			case Map.WALL:
				isWall=true;
				break;
			case Map.ITEM:
				isItem=true;
				break;
		}
				
	}
	
	public int getType(){
		return this.type;
	}
	
	public void setRow(int x){
		this.row=x*16;
	}
	
	public void setColumn(int y){
		this.column=y*16;
	}
	
	public void setPixelRow(int ix){
		this.row=ix;
	}
	
	public void setPixelColumn(int iy){
		this.column=iy;
	}
	
	public int getRow(){
		return row/16;
	}
	
	public int getColumn(){
		return column/16;
	}
	
	public int  getPixelRow(){
		return row;
	}
	
	public int getPixelColumn(){
		return column;
	}
	
//	public boolean isOthersTarget(int butler)
//	{
//		return this.isTarget && (this.butlerTarget!=butler);
//	}
//	
//	public boolean isOcuupied()
//	{
//		if (!isButler)
//		{
//			System.out.println("No butler at "+this);
//		}
//		return isWall || isButler ;
//		
//	}
	
	
	@Override
    public boolean equals(Object o) {
 
         
        if (o == this) {
            return true;
        }
 
        
        if (!(o instanceof Position)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members 
        Position c = (Position) o;
         
        // Compare the data members and return accordingly 
        return this.getRow() == c.getRow()
                && this.getColumn() == c.getColumn();
    }
	
	/*@Override 
	public int hashCode() 
	{ 
		return this.x*10 + this.y;
	}
	*/
	@Override 
	public String toString()
	{
		return this.getRow()+","+this.getColumn();
		
	}

	
	
	

}
