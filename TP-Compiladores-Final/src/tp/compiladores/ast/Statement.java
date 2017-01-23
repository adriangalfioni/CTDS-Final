package tp.compiladores.ast;

public abstract class Statement extends AST {
	private boolean isMethodStmt = false;
        private boolean isReturnStmt = false;
        private boolean isBreakStmt = false;
        private boolean isContinueStmt = false;
        
    /**
     * @return the isMethodStmt
     */
    public boolean getIsMethodStmt() {
        return isMethodStmt;
    }

    /**
     * @param isMethodStmt the isMethodStmt to set
     */
    public void setIsMethodStmt(boolean isMethodStmt) {
        this.isMethodStmt = isMethodStmt;
    }

    /**
     * @return the isReturnStmt
     */
    public boolean getIsReturnStmt() {
        return isReturnStmt;
    }

    /**
     * @param isReturnStmt the isReturnStmt to set
     */
    public void setIsReturnStmt(boolean isReturnStmt) {
        this.isReturnStmt = isReturnStmt;
    }

    /**
     * @return the isBreakStmt
     */
    public boolean getIsBreakStmt() {
        return isBreakStmt;
    }

    /**
     * @param isBreakStmt the isBreakStmt to set
     */
    public void setIsBreakStmt(boolean isBreakStmt) {
        this.isBreakStmt = isBreakStmt;
    }

    /**
     * @return the isContinueStmt
     */
    public boolean getIsContinueStmt() {
        return isContinueStmt;
    }

    /**
     * @param isContinueStmt the isContinueStmt to set
     */
    public void setIsContinueStmt(boolean isContinueStmt) {
        this.isContinueStmt = isContinueStmt;
    }
	
        
}
