public class Event
{
    private String type;
    private boolean terminal;
    private Execution execution;
    private CashDirection cashDirection;

    public String getType() { return this.type; }
    public void setType(String type) { this.type = type; }

    public boolean getTerminal() { return this.terminal; }
    public void setTerminal(boolean terminal) { this.terminal = terminal; }

    public Execution getExecution() { return this.execution; }
    public void setExecution(Execution execution) { this.execution = execution; }

    public CashDirection getCashDirection() { return this.cashDirection; }
    public void setCashDirection(CashDirection cashDirection) { this.cashDirection = cashDirection; }
}
