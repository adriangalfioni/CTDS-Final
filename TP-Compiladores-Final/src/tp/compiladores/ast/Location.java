package tp.compiladores.ast;

public abstract class Location extends Expression {
	protected String id;
        protected static int count;
        boolean isArrayLocation;
        
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
        
        public boolean getIsArrayLocation(){
            return isArrayLocation;
        }
        
        public void setIsArrayLocation(boolean isArray){
            isArrayLocation = isArray;
        }
}
