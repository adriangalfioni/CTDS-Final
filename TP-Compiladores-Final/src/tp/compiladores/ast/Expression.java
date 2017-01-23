package tp.compiladores.ast;

public abstract class Expression extends AST {
	protected Expression expr;
	protected Type type;
        private boolean isMethod = false;
        private boolean isExternInvk = false;
	
	public Type getType() {
		return this.type;
	}
	
	public void setType(Type t) {
		this.type = t;
	}
        
        public String getId(){
            return "";
        }
        
        public boolean getIsMethod(){
            return isMethod;
        }
        
        public void setIsMethod(boolean setM){
            isMethod=setM;
        }

    /**
     * @return the getExternInvk
     */
    public boolean getIsExternInvk() {
        return isExternInvk;
    }

    /**
     * @param isExternInvk the isExternInvk to set
     */
    public void setIsExternInvk(boolean isExternInvk) {
        this.isExternInvk = isExternInvk;
    }
        
}
